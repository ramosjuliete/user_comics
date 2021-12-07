package com.zup.juliete_user_comics.resources;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zup.juliete_user_comics.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(null, "Juliete","ramos.juliete@gmail.com","08335234655",Instant.parse("03/05/1989"));
		return ResponseEntity.ok().body(u);
	}

}
