package com.manager.controller;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.model.Customermodel;
@WebServlet(urlPatterns = { "/Filter" })
public class Filter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
		String jdbcUrl = "jdbc:mysql://localhost:3306/CHECK_PROJECT?useUnicode=true&characterEncoding=UTF-8";
		String user = "root";
		String password = "123456";
		int check = 0;
		try {
			String sql = "SELECT customer.id_customer, customer.name_customer, customer.phone_number,"
					+ " customer.add_customer,  customer.id_card, room.id_room "
	        + "FROM customer " + " JOIN room ON customer.id_customer = room.id_customer " ;
			String kq = "";
			String name_customer = request.getParameter("name_customer");
			System.out.println("name_customer = " + name_customer);
			if (name_customer !=  null && !name_customer.isEmpty()) {
			    kq += (kq.isEmpty() ? "" : " AND ") + "name_customer LIKE '%" + name_customer + "%'";
			}
			String phone_number = request.getParameter("phone_number");
			if (phone_number != null && !phone_number.isEmpty()) {
			    kq += (kq.isEmpty() ? "" : " AND ") + "phone_number LIKE '%" + phone_number + "%'";
			}
			String add_customer = request.getParameter("add_customer");
			if (add_customer != null && !add_customer.isEmpty()) {
			    kq += (kq.isEmpty() ? "" : " AND ") + "add_customer LIKE '%" + add_customer + "%'";
			}
			String id_room = request.getParameter("id_room");
			if (id_room != null && !id_room.isEmpty()) {
			    kq += (kq.isEmpty() ? "" : " AND ") + "id_room LIKE '%" + id_room + "%'";
			}
			if (!kq.isEmpty()) {
			    sql += " WHERE " + kq;
			}
			Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
			List<Customermodel> customers = new ArrayList<>();
			while (rs.next()) {
				Customermodel customer = new Customermodel();
				// Lấy các giá trị từ ResultSet và gán vào đối tượng Customer
				customer.setId_customer(rs.getInt("id_customer"));
				customer.setName_customer(rs.getString("name_customer"));
				customer.setPhone_number(rs.getString("phone_number"));
				customer.setAdd_customer(rs.getString("add_customer"));
				customer.setId_card(rs.getString("id_card"));
				customer.setId_room(rs.getInt("id_room"));
				System.out.println("----------\n" + customer);
				check = 1;
				customers.add(customer);
			}
			rs.close();
			pstmt.close();
			conn.close();
			request.setAttribute("customers", customers);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("----toi da bi loi exception----");
		}
		System.out.println("Check = " + check);
		System.out.println("----toi da bi loi ----");
		request.setAttribute("check", check);
		String url = "/views/web/list_guest.jsp";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		rd.forward(request, response);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}
