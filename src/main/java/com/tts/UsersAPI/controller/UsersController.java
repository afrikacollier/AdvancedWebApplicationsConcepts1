package com.tts.UsersAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tts.UsersAPI.model.UserProfile;
import com.tts.UsersAPI.repository.UsersRepository;

@RestController
public class UsersController {
	
	@Autowired
	UsersRepository repository;
	
	//findAll returns all instances of the type (returns an Iterable<UserProfile>
	//in this case they decided to cast it to a list
	//this isn't the recommended way but oh well.
	@GetMapping("/users")
	public List<UserProfile> getUsers(){
		return (List<UserProfile>) repository.findAll();
	}
	
	@GetMapping("/users/{id}")
		public Optional<UserProfile> getUserById(@PathVariable(value="id") Long id){
		return repository.findById(id);
	}
	
	@PostMapping("/users")
		public void createUser(@RequestBody UserProfile user){
		repository.save(user);
	}
	
	@PutMapping("/users/{id}")
	public void createUser(@PathVariable(value="id") Long id, @RequestBody UserProfile user){
		repository.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void createUser(@PathVariable(value="id") Long id){
		repository.deleteById(id);
	}
	
//	@SuppressWarnings("unchecked")
//	@GetMapping("/users")
//	public List<UserProfile> getUsers(@RequestParam(value="state", required=false) String state){
//		if (state != null) {
//			return (List<UserProfile>) repository.findByState(state);
//		}
//		return (List<UserProfile>) repository.findAll();
//	}

}
