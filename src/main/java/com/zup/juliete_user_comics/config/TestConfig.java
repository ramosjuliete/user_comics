package com.zup.juliete_user_comics.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Juliete", "ramos.juliete@gmail.com","08335234655","03/05/1989");
		User u2 = new User(null,"Carlos", "carlos@gmail.com","42959425618","29/10/1990");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
	}
	
	
	
}
