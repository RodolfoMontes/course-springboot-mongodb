package com.montes.courseworkshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.montes.courseworkshopmongo.domain.Post;
import com.montes.courseworkshopmongo.domain.User;
import com.montes.courseworkshopmongo.dto.AuthorDTO;
import com.montes.courseworkshopmongo.repository.PostRepository;
import com.montes.courseworkshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("22/07/2022"), "Partiu viagem", "Vou viajar para São Paulo. Abraços",
				new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("04/07/2022"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}

}
