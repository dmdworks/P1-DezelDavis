package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import com.revature.beans.Reimb;

@Entity
@Table(name="users")
public class User {
	public static enum userRole {
		EMPLOYEE, MANAGER
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String email;
	@Column
	private userRole role;
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="author")
	private List<Reimb> reimbList;
	@OneToMany(fetch = FetchType.EAGER, mappedBy ="resolver")
	private List<Reimb> resList = new ArrayList<>();
	
	public User() {
	
	}
	
	public User(String username, String password, String firstName, String lastName, String email, userRole role) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int id) {
		this.user_id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public userRole getRole() {
		return role;
	}
	public void setRole(userRole role) {
		this.role = role;
	}
	public List<Reimb> getReimbList() {
		return reimbList;
	}

	public void setReimbList(List<Reimb> reimbList) {
		this.reimbList = reimbList;
	}

	public List<Reimb> getResList() {
		return resList;
	}

	public void setResList(List<Reimb> resList) {
		this.resList = resList;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", role=" + role + "]";
	}
	
}
