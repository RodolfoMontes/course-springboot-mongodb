package com.montes.courseworkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.montes.courseworkshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
