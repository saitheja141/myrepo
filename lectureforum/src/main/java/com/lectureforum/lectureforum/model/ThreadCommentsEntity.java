package com.lectureforum.lectureforum.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ThreadComments")
public class ThreadCommentsEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ID;
	private String postedBy;
	private LocalDateTime postedOn;
	private Character status='A';
	private int threadId;

}
