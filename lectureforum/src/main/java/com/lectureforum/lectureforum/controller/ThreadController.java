package com.lectureforum.lectureforum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lectureforum.lectureforum.model.ThreadComments;
import com.lectureforum.lectureforum.model.ThreadCommentsEntity;
import com.lectureforum.lectureforum.model.ThreadDiscussion;
import com.lectureforum.lectureforum.service.ThreadService;

@RestController
public class ThreadController {
	
	@Autowired
	private ThreadService threadService;
	
	@RequestMapping(value = "threads",method = RequestMethod.GET)
	public ResponseEntity<List<ThreadDiscussion>> getAllThreads()
	{
	  return new ResponseEntity<List<ThreadDiscussion>>(threadService.getAllThreads(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "threadscomments/{commentId}",method = RequestMethod.GET)
	public ResponseEntity<List<ThreadComments>> getThreadComments(@PathVariable int commentId)
	{
		return new ResponseEntity<List<ThreadComments>>(threadService.getAllThreadComments(commentId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "threadscomments",method = RequestMethod.POST)
	public ResponseEntity<ThreadComments> saveThreadComments(@RequestBody ThreadCommentsEntity threadcomment)
	{
		return new ResponseEntity<ThreadComments>(threadService.saveThreadComments(threadcomment),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "threadscomments/{commentId}",method = RequestMethod.PUT)
	public ResponseEntity<ThreadComments> updateThreadComments(@PathVariable int commentId)
	{
		return new ResponseEntity<ThreadComments>(threadService.updateThreadComments(commentId),HttpStatus.OK);
	}
	
	@RequestMapping(value = "threadscomments/{commentId}",method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteThreadComments(@PathVariable int commentId)
	{
		return new ResponseEntity<Boolean>(threadService.deleteThreadComments(commentId),HttpStatus.OK);
	}
	

}
