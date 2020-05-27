package com.lectureforum.lectureforum.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lectureforum.lectureforum.model.ThreadComments;
import com.lectureforum.lectureforum.model.ThreadCommentsEntity;

@Repository
public interface IThreadCommentsRepo extends CrudRepository<ThreadCommentsEntity,Integer> {

}
