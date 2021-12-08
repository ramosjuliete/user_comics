package com.zup.juliete_user_comics.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.juliete_user_comics.entities.Comic;
import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.services.ComicService;

@RestController
@RequestMapping(value="/comics")
public class ComicResource {
	
	//injentando dependencia para objeto do tipo ComicService
	@Autowired
	private ComicService service;
	
	//EndPoint tipo GET para buscar todos os usuários
	@GetMapping
	public ResponseEntity<List<Comic>> findAll(){
		List<Comic> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//EndPoint tipo GET para buscar usuário por id
	@GetMapping(value="/{id}")
	public ResponseEntity<Comic> findById(@PathVariable Long id){
		Comic u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	//EndPoint do tipo POST do Comic, deve-se passar o comic (objeto) e o Id do usuário
	
	/*public ResponseEntity<User> insert(@Valid @RequestBody User u){
		u = service.insert(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).body(u);
	}*/
	@PostMapping(value="/{iduser}")
	public ResponseEntity<Comic> insert(@RequestBody Comic c, Long iduser){
		return ResponseEntity.ok().body(c);
	}
	
}
