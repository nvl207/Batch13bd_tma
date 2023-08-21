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
import com.manager.model.Customermodel;

@WebServlet(urlPatterns = { "/trang-chu"})
public class Homecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

			Customerdao dao = new Customerdao();
			
			List<Customermodel> results = dao.findCustomerModels();

			request.setAttribute("lists", results);
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/list_guest.jsp"); // day len trang list
																								// guest
			rd.forward(request, response);
		}
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
	super.doPost(req, resp);
		// lấy thông tin lọc từ form
	}
}
