package com.tts.UsersAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.UsersAPI.model.UserProfile;

@Repository
public interface UsersRepository extends CrudRepository<UserProfile, Long>{
	//I probably need to fix the first one
	UserProfile findByState(String state);
}
