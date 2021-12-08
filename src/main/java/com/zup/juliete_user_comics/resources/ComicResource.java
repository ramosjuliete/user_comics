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
import com.zup.juliete_user_comics.services.ComicService;
import com.zup.juliete_user_comics.services.UserService;

@RestController
@RequestMapping(value="/comics")
public class ComicResource {
	
	//injentando dependencia para objeto do tipo ComicService
	@Autowired
	private ComicService serviceComic;
	
	@Autowired
	private UserService serviceUser;
		
	//EndPoint tipo GET para buscar todos os Comics
	@GetMapping
	public ResponseEntity<List<Comic>> findAll(){
		List<Comic> list = serviceComic.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	//EndPoint tipo GET para buscar comic por id
	@GetMapping(value="/{id}/dia/{day}")
	public ResponseEntity<Comic> findById(@PathVariable Long id,@PathVariable String day){
		Comic c = serviceComic.findById(id);
		c = c.calculateDiscount(day, c);
		return ResponseEntity.ok().body(c);
	}
	
	//EndPoint do tipo POST do Comic, deve-se passar o comic e o usuário ??? 
	@PostMapping(value="/{iduser}")
	public ResponseEntity<Comic> insert(@RequestBody Comic c, Long iduser){
		//User u = findUserById(iduser);
		//c.getUsers().add(u);
		return ResponseEntity.ok().body(c);
	}

	/*@GetMapping(value="/{iduser}")
	private User findUserById(Long iduser) {
		// TODO Auto-generated method stub
		User u = serviceUser.findById(iduser);
		return u;
	}*/
	
}
