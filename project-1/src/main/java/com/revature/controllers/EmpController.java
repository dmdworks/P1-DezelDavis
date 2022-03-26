package com.revature.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.Reimb;

public class EmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmpController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String desc = request.getParameter("desc");
		
		Reimb reimb = new Reimb();
		reimb.setAmount(amount);
		reimb.setDesc(desc);
		reimb.setType(Reimb.reimbType.valueOf(type));
		reimb.setStatus(Reimb.reimbStatus.PENDING);
		reimb.setSubmitted();
		
		File imgFile = new File(request.getParameter("recipt"));
		FileInputStream fs = new FileInputStream(imgFile);
		byte[] rImg = new byte[(int)imgFile.length()];
		fs.read(rImg);
		fs.close();
		reimb.setRecImg(rImg);
		
		System.out.println(reimb);
		System.out.println(reimb.getRecImg().length);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
