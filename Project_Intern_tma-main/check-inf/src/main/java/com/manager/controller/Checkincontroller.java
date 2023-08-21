package com.manager.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.Customerdao;
import com.manager.dao.Roomdao;
import com.manager.model.Customermodel;
import com.manager.model.Roommodel;
@WebServlet(urlPatterns = { "/check-in" })
public class Checkincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
	     response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Customerdao customerDao = new Customerdao();
		List<Roommodel> availableRooms = customerDao.findAvailableRoomModels();
		request.setAttribute("lists", availableRooms);
		Roomdao roomDao = new Roomdao();
		List<Roommodel> allRooms = roomDao.findRoomModels();
		request.setAttribute("availableRooms", allRooms);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/check-in.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
	     response.setCharacterEncoding("utf-8");
		
	     int id_room1 = Integer.parseInt(request.getParameter("idroom"));
	     Roomdao roomdao1 = new Roomdao();
	     if (roomdao1.isRoomExists(id_room1)) {
	    	    request.setAttribute("error", "Phòng đã tồn tại. Vui lòng chọn phòng khác.");
	    	    RequestDispatcher rd = request.getRequestDispatcher("/views/web/check-in.jsp");
	    	    rd.forward(request, response);
	    	    return; 
	    	} 
		System.out.println("ok");
		String name_customer = request.getParameter("name");
		String phone_number = request.getParameter("phone");
		String add_customer = request.getParameter("add");//Địa chỉ
		String id_card = request.getParameter("inputIdcard");//CCCD
		System.out.println("Danh sach:\t"+name_customer+"\t"+phone_number+"\t"+add_customer+"\t"+id_card);
		request.setAttribute("check", "1");
		System.out.println("CCCD="+id_card);
		int id_room = Integer.parseInt(request.getParameter("idroom"));
		System.out.println(id_room);
		// gọi phương thức insertCustomer
		Customerdao customerdao = new Customerdao();
		System.out.println(customerdao.insertCustomer(name_customer, phone_number, add_customer, id_card));
		// gọi phương thức insertRoom
			String name_apartment =  "Lammer";
			List<Customermodel> li = customerdao.findALLCustomer();
			System.out.println(li.size());
			int dem = 0;
			int id_customer = 0;
			for (Customermodel customermodel : li) {
				System.out.println(customermodel);
				dem++;
				if(dem == li.size()) id_customer = customermodel.getId_customer();
			}
			System.out.println(id_customer);
			Roomdao roomdao = new Roomdao();
			System.out.println(roomdao.insertRoom(name_apartment,id_customer ,id_room));

		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}