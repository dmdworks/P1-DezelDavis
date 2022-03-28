package com.revature.beans;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reimbs")
public class Reimb {
	public static enum reimbType{
		LODGING, TRAVEL, FOOD, OTHER
	}
	
	public static enum reimbStatus{
		PENDING, APPROVED, DENIED
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reimb_id;
	@Column
	private double amount;
	@Column
	private LocalDateTime submitted;
	@Column
	private LocalDateTime resolved;
	@Column
	private String descript;
	@Column(columnDefinition="mediumblob")
	private byte[] recImg;
	@ManyToOne
	@JoinColumn(name="user_id")
	User author;
	@ManyToOne
	User resolver;
	@Column
	private reimbType type;
	@Column
	private reimbStatus status;
	
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int id) {
		this.reimb_id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getSubmitted() {
		return submitted;
	}
	public void setSubmitted(LocalDateTime submitted) {
		this.submitted = submitted;
	}
	public void setSubmitted() {
		this.submitted = LocalDateTime.now();
	}
	public LocalDateTime getResolved() {
		return resolved;
	}
	public void setResolved(LocalDateTime resolved) {
		this.resolved = resolved;
	}
	public void setResolved() {
		this.resolved = LocalDateTime.now();
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public reimbType getType() {
		return type;
	}
	public void setType(reimbType type) {
		this.type = type;
	}
	public reimbStatus getStatus() {
		return status;
	}
	public void setStatus(reimbStatus status) {
		this.status = status;
	}
	public byte[] getRecImg() {
		return recImg;
	}
	public void setRecImg(byte[] recImg) {
		this.recImg = recImg;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	public User getResolver() {
		return resolver;
	}
	public void setResolver(User resolver) {
		this.resolver = resolver;
	}
	
	@Override
	public String toString() {
		return "Reimb [reimb_id=" + reimb_id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", descript=" + descript + ", author=" + author + ", resolver=" + resolver + ", type=" + type
				+ ", status=" + status + "]";
	}
	
}
