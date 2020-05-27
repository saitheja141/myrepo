package com.lectureforum.lectureforum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lectureforum.lectureforum.model.ThreadDiscussion;
import com.lectureforum.lectureforum.model.ThreadDiscussionEntity;

@Repository
public interface IThreadDiscussionRepo extends CrudRepository<ThreadDiscussionEntity,Integer>
{
 
}
