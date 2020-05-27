package com.lectureforum.lectureforum.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class ThreadComments {
	

	private int ID;
	private String postedBy;
	private LocalDateTime postedOn;
	private Character status='A';
	private int threadId;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	public LocalDateTime getPostedOn() {
		return postedOn;
	}
	public void setPostedOn(LocalDateTime postedOn) {
		this.postedOn = postedOn;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
	}
	public int getThreadId() {
		return threadId;
	}
	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

}
