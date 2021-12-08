package com.zup.juliete_user_comics.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zup.juliete_user_comics.entities.Comic;
import com.zup.juliete_user_comics.services.ComicService;
import com.zup.juliete_user_comics.services.UserService;

@RestController
@RequestMapping(value="/comics")
public class ComicResource {
	
	@Autowired
	private ComicService serviceComic;
	
	@GetMapping
	public ResponseEntity<List<Comic>> findAll(){
		List<Comic> list = serviceComic.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Comic> findById(@PathVariable Long id){
		Comic c = serviceComic.findById(id);
		return ResponseEntity.ok().body(c);
	}
	
	@GetMapping(value="/{id}/dia/{day}")
	public ResponseEntity<Comic> findById(@PathVariable Long id,@PathVariable String day){
		Comic c = serviceComic.findById(id);
		c = serviceComic.calculateDiscount(day, c);
		return ResponseEntity.ok().body(c);
	}
	 
	@PostMapping
	public ResponseEntity<Comic> insert(@RequestBody Comic c){
		c = serviceComic.insert(c);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getComicId()).toUri();
		return ResponseEntity.created(uri).body(c);
	}

	/*@GetMapping(value="/{iduser}")
	private User findUserById(Long iduser) {
		// TODO Auto-generated method stub
		User u = serviceUser.findById(iduser);
		return u;
	}*/
	
}
