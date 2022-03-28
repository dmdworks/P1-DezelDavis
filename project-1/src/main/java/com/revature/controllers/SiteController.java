package com.revature.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.revature.DAO.ReimbDAO;
import com.revature.DAO.ReimbDaoHibernate;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDaoHibernate;
import com.revature.beans.Reimb;
import com.revature.beans.User;

/**
 * Servlet implementation class SiteController
 */
@MultipartConfig(maxFileSize=16177215)
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SiteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("action");
		
		switch(act) {
			case "home":
				User currU = (User)request.getSession().getAttribute("user");
				if(currU.getRole().equals(User.userRole.MANAGER)) {
					request.getRequestDispatcher("/mgr-portal.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/emp-portal.jsp").forward(request, response);
				}
				break;
			case "logout":
				request.getSession().setAttribute("user", null);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
				break;
			case "makeRequest":
				request.getRequestDispatcher("/reimb-form.jsp").forward(request, response);
				break;
			case "userPendReimbs":
				ReimbDaoHibernate reimbDao = new ReimbDaoHibernate();
				User cu = (User)request.getSession().getAttribute("user");
				
				List<Reimb> penList = reimbDao.getReimbsByPending(cu.getUser_id());
				
				for(Reimb r: penList) {
					File outFile = new File("C:\\Users\\Dezel\\Desktop\\Revature Projects\\P1-DezelDavis\\project-1\\src\\main\\webapp\\temp\\recpic"+r.getReimb_id()+".jpg");
					outFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(outFile);
					fOut.write(r.getRecImg());
					fOut.close();
				}
				request.setAttribute("rList", penList);
				request.getRequestDispatcher("/veiw-user-reimbs.jsp").forward(request, response);
				break;
			case "userResReimbs":
				ReimbDaoHibernate reiDao = new ReimbDaoHibernate();
				User crru = (User)request.getSession().getAttribute("user");
				
				List<Reimb> resList = reiDao.getReimbsByResolved(crru.getUser_id());
				
				for(Reimb r: resList) {
					File outFile = new File("C:\\Users\\Dezel\\Desktop\\Revature Projects\\P1-DezelDavis\\project-1\\src\\main\\webapp\\temp\\recpic"+r.getReimb_id()+".jpg");
					outFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(outFile);
					fOut.write(r.getRecImg());
					fOut.close();
				}
				request.setAttribute("rList", resList);
				request.getRequestDispatcher("/veiw-user-reimbs.jsp").forward(request, response);
				break;
			case "profile":
				request.getRequestDispatcher("/update-user.jsp").forward(request, response);
				break;
			case "appDenReimbs":
				ReimbDaoHibernate rDao = new ReimbDaoHibernate();
				
				List<Reimb> rList = rDao.getReimbsByPending();
				
				for(Reimb r: rList) {
					File outFile = new File("C:\\Users\\Dezel\\Desktop\\Revature Projects\\P1-DezelDavis\\project-1\\src\\main\\webapp\\temp\\recpic"+r.getReimb_id()+".jpg");
					outFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(outFile);
					fOut.write(r.getRecImg());
					fOut.close();
				}
				
				request.setAttribute("rList", rList);
				request.getRequestDispatcher("/view-mgr-reimbs.jsp").forward(request, response);
				break;
			case "resReimbs":
				ReimbDaoHibernate rosDao = new ReimbDaoHibernate();
				
				List<Reimb> rosList = rosDao.getReimbsByResolved();
				
				for(Reimb r: rosList) {
					File outFile = new File("C:\\Users\\Dezel\\Desktop\\Revature Projects\\P1-DezelDavis\\project-1\\src\\main\\webapp\\temp\\recpic"+r.getReimb_id()+".jpg");
					outFile.createNewFile();
					FileOutputStream fOut = new FileOutputStream(outFile);
					fOut.write(r.getRecImg());
					fOut.close();
				}
				
				request.setAttribute("rList", rosList);
				request.getRequestDispatcher("/mgr-resovled.jsp").forward(request, response);
				break;
			case "viewEmplyees":
				UserDaoHibernate userDao= new UserDaoHibernate();
				
				request.setAttribute("uList", userDao.getAllEmp());
				request.getRequestDispatcher("/view-employees.jsp").forward(request, response);
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
				UserDaoHibernate userDao= new UserDaoHibernate();
				user = userDao.getUser(username, pass);
				if(user==null) {
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
				request.getSession().setAttribute("user", user);
				if(user.getRole().equals(User.userRole.MANAGER)) {
					request.getRequestDispatcher("/mgr-portal.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/emp-portal.jsp").forward(request, response);
				}
				break;
			case "createReimb":
				String type = request.getParameter("type");
				String amnt = request.getParameter("amnt");
				String desc = request.getParameter("desc");
				User cu = (User)request.getSession().getAttribute("user");
				double amount = Double.parseDouble(amnt);
				
				ReimbDaoHibernate reimbDao = new ReimbDaoHibernate();
				Reimb reimb = new Reimb();
				reimb.setAuthor(cu);
				reimb.setAmount(amount);
				reimb.setDescript(desc);
				reimb.setType(Reimb.reimbType.valueOf(type));
				reimb.setStatus(Reimb.reimbStatus.PENDING);
				reimb.setSubmitted();
				
				
				Part part = request.getPart("recipt");
				byte[] rImg = new byte[(int)part.getSize()];
				part.getInputStream().read(rImg);
				reimb.setRecImg(rImg);
				
				reimbDao.addReimb(reimb);
				request.getRequestDispatcher("/emp-portal.jsp").forward(request, response);
				break;
			case "appReimb":
				int id = Integer.parseInt(request.getParameter("id"));
				ReimbDaoHibernate reiDao = new ReimbDaoHibernate();
				
				Reimb uRei = reiDao.getReimb(id);
				uRei.setStatus(Reimb.reimbStatus.APPROVED);
				uRei.setResolved();
				uRei.setResolver((User)request.getSession().getAttribute("user"));
				
				reiDao.updateReimb(uRei);
				request.setAttribute("rList", reiDao.getReimbsByPending());
				request.getRequestDispatcher("/view-mgr-reimbs.jsp").forward(request, response);
				break;
			case "denReimb":
				int reid = Integer.parseInt(request.getParameter("id"));
				ReimbDaoHibernate rDao = new ReimbDaoHibernate();
				
				Reimb dRei = rDao.getReimb(reid);
				dRei.setStatus(Reimb.reimbStatus.DENIED);
				dRei.setResolved();
				dRei.setResolver((User)request.getSession().getAttribute("user"));
				
				rDao.updateReimb(dRei);
				request.setAttribute("rList", rDao.getReimbsByPending());
				request.getRequestDispatcher("/view-mgr-reimbs.jsp").forward(request, response);
				break;
			case "appdenUserReimb":
				int uid = Integer.parseInt(request.getParameter("id"));
				ReimbDaoHibernate reDao = new ReimbDaoHibernate();
				
				request.setAttribute("rList", reDao.getReimbsByPending(uid));
				request.getRequestDispatcher("/view-mgr-reimbs.jsp").forward(request, response);
				break;
			case "updateUser":
				String fName = request.getParameter("fName");
				String lName = request.getParameter("lName");
				String uName = request.getParameter("username");
				String email = request.getParameter("email");
				String pWord = request.getParameter("pass");
				UserDaoHibernate uDao= new UserDaoHibernate();
				User updateU = (User)request.getSession().getAttribute("user");
				
				if(!fName.equals("")) {
					updateU.setFirstName(fName);
				}
				if(!lName.equals("")) {
					updateU.setLastName(lName);
				}
				if(!uName.equals("")) {
					updateU.setUsername(uName);
				}
				if(!email.equals("")) {
					updateU.setEmail(email);
				}
				if(!pWord.equals("")) {
					updateU.setPassword(pWord);
				}
				uDao.updateUser(updateU);
				if(updateU.getRole().equals(User.userRole.MANAGER)) {
					request.getRequestDispatcher("/mgr-portal.jsp").forward(request, response);
				}else {
					request.getRequestDispatcher("/emp-portal.jsp").forward(request, response);
				}
				break;
		}
		
	}

}

