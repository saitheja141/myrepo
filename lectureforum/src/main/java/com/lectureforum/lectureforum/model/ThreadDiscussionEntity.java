package com.lectureforum.lectureforum.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ThreadDiscussion")
public class ThreadDiscussionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	public String name;
	public String subject;
	public String message;
	public LocalDateTime createdOn;
	public String createdBy;
	public LocalDateTime updatedOn;
	public String updatedBy;
	@Transient
	public byte[] file;
	
	

}
