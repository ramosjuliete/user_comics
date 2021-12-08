package com.zup.juliete_user_comics.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.zup.juliete_user_comics.View;
import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	//injentando dependencia para objeto do tipo UserService
	@Autowired
	private UserService service;
	
	//EndPoint tipo GET para buscar todos os usuários
	@GetMapping
	@JsonView(View.Base.class)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//EndPoint tipo GET para buscar usuário por id
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	//EndPoint tipo Post para inserir usuário no BD
	@PostMapping
	public ResponseEntity<User> insert(@Valid @RequestBody User u){
		u = service.insert(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(u);
	}
}
