package com.zup.juliete_user_comics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.repositories.UserRepository;

@Service //registrando como Serviço do spring

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> u = repository.findById(id);
		return u.get();
	}
	
}
