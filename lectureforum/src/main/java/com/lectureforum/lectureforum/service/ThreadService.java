package com.lectureforum.lectureforum.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lectureforum.lectureforum.model.ThreadComments;
import com.lectureforum.lectureforum.model.ThreadCommentsEntity;
import com.lectureforum.lectureforum.model.ThreadDiscussion;
import com.lectureforum.lectureforum.model.ThreadDiscussionEntity;
import com.lectureforum.lectureforum.repository.IThreadCommentsRepo;
import com.lectureforum.lectureforum.repository.IThreadDiscussionRepo;

@Service
public class ThreadService implements IThreadService {
	
	@Autowired
	private IThreadCommentsRepo iThreadCommentsRepo;
	
	@Autowired
	private IThreadDiscussionRepo iThreadDiscussionRepo;

	@Override
	public List<ThreadDiscussion> getAllThreads()
	{
		List<ThreadDiscussionEntity> discussionEntities= (List<ThreadDiscussionEntity>) iThreadDiscussionRepo.findAll();
		List<ThreadDiscussion> discussions=new ArrayList<>();
		discussionEntities.forEach(ent->
		{
			ThreadDiscussion threadDiscussion=new ThreadDiscussion();
			threadDiscussion.setId(ent.id);
			threadDiscussion.setCreatedBy(ent.createdBy);
			threadDiscussion.setCreatedOn(ent.updatedOn);
			threadDiscussion.setSubject(ent.subject);
			threadDiscussion.setUpdatedBy(ent.updatedBy);
			threadDiscussion.setUpdatedOn(ent.updatedOn);
			threadDiscussion.setMessage(ent.message);
			threadDiscussion.setName(ent.name);
			discussions.add(threadDiscussion);
		}
		);
		return discussions;
	}
	@Override
	public List<ThreadComments> getAllThreadComments(int threadId) {
		// TODO Auto-generated method stub
		List<ThreadCommentsEntity> commentsEntities = (List<ThreadCommentsEntity>) iThreadCommentsRepo.findAll();
		List<ThreadComments> discussions=new ArrayList<>();
		return discussions;
	}
	@Override
	public ThreadComments saveThreadComments(ThreadCommentsEntity threadComments) {
		ThreadCommentsEntity commentsEntity=iThreadCommentsRepo.save(threadComments);
		ThreadComments threadComment=new ThreadComments();
		return threadComment;
		
	}
	@Override
	public ThreadComments updateThreadComments(int threadId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean deleteThreadComments(int threadId) {
		// TODO Auto-generated method stub
		return false;
	}

}
