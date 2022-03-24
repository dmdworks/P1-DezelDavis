package com.revature.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.User;

public class UserDaoJDBC implements UserDAO{
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public UserDaoJDBC() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankapp", "root", "SomeQuestionsL@st4");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User u) {
		String query = "INSERT INTO users (username, pass, fname, lname, email, role) VALUES (?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6, u.getRole().toString());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String username, String pass) {
		String query = "SELECT * FROM users WHERE username='"+username+"'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("pass"));
				user.setFirstName(rs.getString("fname"));
				user.setLastName(rs.getString("lname"));
				user.setEmail(rs.getString("email"));
				user.setRole(User.userRole.valueOf(rs.getString("role")));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		
	}

}
