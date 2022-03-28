package com.revature;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.revature.DAO.ReimbDAO;
import com.revature.DAO.ReimbDaoHibernate;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDaoHibernate;
import com.revature.beans.Reimb;
import com.revature.beans.User;

public class Driver {

	public static void main(String[] args) {
		//Testing User creation and retrieval
		UserDaoHibernate userDao = new UserDaoHibernate();
		/*
		User newUser = new User();
		newUser.setUsername("DDavis76");
		newUser.setPassword("Dogzrule");
		newUser.setFirstName("Dezel");
		newUser.setLastName("Davis");
		newUser.setEmail("dogz@gmail.com");
		newUser.setRole(User.userRole.EMPLOYEE);
		
		userDao.addUser(newUser);
		
		*/
		User newUser = new User();
		newUser.setUsername("FJPlayer3");
		newUser.setPassword("123");
		newUser.setFirstName("Fred");
		newUser.setLastName("Joseph");
		newUser.setEmail("fjplayer@gmail.com");
		newUser.setRole(User.userRole.MANAGER);
		
		userDao.addUser(newUser);
		
		//User currUser = userDao.getUser(1);
		//System.out.println(currUser);
		
		//Test reimb creation
		//ReimbDaoHibernate reimbDao = new ReimbDaoHibernate();
		/*
		Reimb reimb = new Reimb();
		reimb.setAmount(34);
		reimb.setDescript("Ate at Wendy's for lunch.");
		reimb.setType(Reimb.reimbType.FOOD);
		reimb.setStatus(Reimb.reimbStatus.PENDING);
		reimb.setAuthor(currUser);
		reimb.setSubmitted();
		
		File imgFile = new File("C:\\Users\\Dezel\\Documents\\Goddess.jpg");
		byte[] rImg = new byte[(int)imgFile.length()];
		FileInputStream fs;
		try {
			fs = new FileInputStream(imgFile);
			fs.read(rImg);
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		reimb.setRecImg(rImg);
		
		reimbDao.addReimb(reimb);
		*/
		//List<Reimb> curReimb=reimbDao.getReimbsByPending(1);
		//System.out.println(curReimb);
		//System.out.println(currUser.getReimbList());
	}
}
