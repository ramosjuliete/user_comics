package com.zup.juliete_user_comics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.juliete_user_comics.entities.Comic;
import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.repositories.ComicRepository;

@Service //registrando como Serviço do spring
public class ComicService {
	
	//injentando dependencia para objeto do tipo ComicRepository
	@Autowired
	private ComicRepository repository;
	
	public List<Comic> findAll(){
		return repository.findAll();
	}
	
	public Comic findById(Long id) {
		Optional<Comic> u = repository.findById(id);
		return u.get();
	}
	
	public Comic insert(Comic c, Long iduser) {
		return repository.save(c);
	}
	
}
