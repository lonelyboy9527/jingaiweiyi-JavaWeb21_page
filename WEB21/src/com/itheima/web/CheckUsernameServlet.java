package com.itheima.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService;

public class CheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckUsernameServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得要校验的用户名
		String username = request.getParameter("username");
		System.out.println("username:" + username);
		//传递到service层
		UserService service = new UserService();
		boolean isExist = false;
		try {
			isExist = service.checkUsername(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//写给ajax引擎 
		response.getWriter().write("{\"isExist\": "+ isExist +"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}
}
