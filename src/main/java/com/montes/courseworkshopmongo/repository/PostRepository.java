package com.montes.courseworkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.montes.courseworkshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}