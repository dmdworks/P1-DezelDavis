package com.revature.DAO;

import com.revature.beans.User;

public interface UserDAO {
	public void addUser(User u);
	
	public User getUser(int id);
	
	public User getUser(String username, String pass);
	
	public void deleteUser(User u);
	
	public void updateUser(User u);
}
