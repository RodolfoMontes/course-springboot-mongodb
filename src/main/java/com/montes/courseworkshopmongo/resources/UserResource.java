package com.montes.courseworkshopmongo.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.montes.courseworkshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User rodolfo = new User("1", "rodolfo", "rodolfo@gmail.com");
		User maria = new User("2", "maria", "maria@gmail.com");
		return ResponseEntity.ok().body(Arrays.asList(rodolfo, maria));
	}
}
