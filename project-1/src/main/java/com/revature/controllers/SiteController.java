package com.revature.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDaoHibernate;
import com.revature.beans.User;

/**
 * Servlet implementation class SiteController
 */
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SiteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		User user;
		UserDAO userDao= new UserDaoHibernate();
		user = userDao.getUser(username, pass);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/EmpPage.jsp").forward(request, response);
	}

}

/*
Cookie[] cookies = request.getCookies();
for(Cookie c : cookies) {
	if(c.getName().equals("username")){
		request.getSession().setAttribute("username", c.getValue());
	}
}
*/
