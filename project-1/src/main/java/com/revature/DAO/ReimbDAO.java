package com.revature.DAO;

import java.util.List;

import com.revature.beans.Reimb;

public interface ReimbDAO {
	public void addReimb(Reimb r);
	
	public List<Reimb> getReimbsByUser(int id);
	
	public List<Reimb> getAllReimbs();
	
	public void deleteReimb(Reimb r);
	
	public void updateReimb(Reimb r);
}
