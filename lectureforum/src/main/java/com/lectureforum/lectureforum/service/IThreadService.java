package com.lectureforum.lectureforum.service;

import java.util.List;

import com.lectureforum.lectureforum.model.ThreadComments;
import com.lectureforum.lectureforum.model.ThreadCommentsEntity;
import com.lectureforum.lectureforum.model.ThreadDiscussion;

public interface IThreadService {
	
	public List<ThreadDiscussion> getAllThreads();
	public List<ThreadComments> getAllThreadComments(int threadId);
	public ThreadComments saveThreadComments(ThreadCommentsEntity threadComments);
	public ThreadComments updateThreadComments(int threadId);
	public boolean deleteThreadComments(int threadId);
	

}
