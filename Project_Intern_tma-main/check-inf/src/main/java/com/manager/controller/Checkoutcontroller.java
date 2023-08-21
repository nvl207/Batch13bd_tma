package com.manager.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.Customerdao;
import com.manager.dao.Roomdao;

@WebServlet(urlPatterns = { "/check-out" })
public class Checkoutcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		int id_cus = Integer.parseInt(request.getParameter("add"));
		int id_room = Integer.parseInt(request.getParameter("idroom"));
		System.out.println(id_room);
		Roomdao roomdao  = new Roomdao();
		System.out.println(roomdao.deleteRoom(id_room,id_cus));
		Customerdao customerdao = new Customerdao();
		System.out.println(customerdao.deleteCus(id_cus));
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}
}
