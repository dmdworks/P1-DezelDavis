package com.revature.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAO.ReimbDAO;
import com.revature.DAO.ReimbDaoHibernate;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDaoHibernate;
import com.revature.beans.Reimb;
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
		String act = request.getParameter("action");
		
		switch(act) {
			case "getReimbs":
				ReimbDAO reimbDao = new ReimbDaoHibernate();
				User cu = (User)request.getSession().getAttribute("user");
				
				List<Reimb> rList = reimbDao.getReimbsByUser(cu.getUser_id());
				
				for(Reimb r: rList) {
					File outFile = new File("C:\\Users\\Dezel\\Desktop\\Revature Projects\\P1-DezelDavis\\project-1\\src\\main\\webapp\\temp\\recpic"+r.getReimb_id()+".jpg");
					outFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(outFile);
					fOut.write(r.getRecImg());
					fOut.close();
				}
				request.setAttribute("rList", rList);
				request.getRequestDispatcher("/veiw-user-reimbs.jsp").forward(request, response);
				break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
		
		switch(act) {
			case "login":
				String username = request.getParameter("username");
				String pass = request.getParameter("pass");
				User user;
				UserDAO userDao= new UserDaoHibernate();
				user = userDao.getUser(username, pass);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("/EmpPage.jsp").forward(request, response);
				break;
			case "createReimb":
				String type = request.getParameter("type");
				double amount = Double.parseDouble(request.getParameter("amount"));
				String desc = request.getParameter("desc");
				User cu = (User)request.getSession().getAttribute("user");
				
				ReimbDAO reimbDao = new ReimbDaoHibernate();
				Reimb reimb = new Reimb();
				reimb.setAuthorId(cu.getUser_id());
				reimb.setAmount(amount);
				reimb.setDescript(desc);
				reimb.setType(Reimb.reimbType.valueOf(type));
				reimb.setStatus(Reimb.reimbStatus.PENDING);
				reimb.setSubmitted();
				
				File imgFile = new File(request.getParameter("recipt"));
				FileInputStream fs = new FileInputStream(imgFile);
				byte[] rImg = new byte[(int)imgFile.length()];
				fs.read(rImg);
				fs.close();
				reimb.setRecImg(rImg);
				
				reimbDao.addReimb(reimb);
				request.getRequestDispatcher("/EmpPage.jsp").forward(request, response);
				break;
		}
		
	}

}

