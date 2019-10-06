package io.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.model.User;
import io.spring.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping(path="/{name}")
	public User findByName(@PathVariable final String name) {
		return userRepository.findByName(name);
	}
	
	@PostMapping
	public User insert(@RequestBody final User user) {
		userRepository.save(user);
		return findByName(user.getName());
	}
}
