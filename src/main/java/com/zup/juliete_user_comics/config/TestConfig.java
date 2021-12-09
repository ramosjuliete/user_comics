package com.zup.juliete_user_comics.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.zup.juliete_user_comics.entities.Comic;
import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.repositories.ComicRepository;
import com.zup.juliete_user_comics.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	//injentando dependencia 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ComicRepository comicRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null,"Juliete", "ramos.juliete@gmail.com","08335234655","03/05/1989");
		User u2 = new User(null,"Carlos", "carlos@gmail.com","42959425618","29/10/1990");
				
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		
		Comic c1 = new Comic(null, "Exemplo Comic 1", 90.5, "Autor 1", "XXXXXXXX1", "Descricao 1");
		Comic c2 = new Comic(null, "Exemplo Comic 2", 40.5, "Autor 2", "XXXXXXXX3", "Descricao 2");
		Comic c3 = new Comic(null, "Exemplo Comic 3", 100.25, "Autor 3", "XXXXXXXX5", "Descricao 3");
		Comic c4 = new Comic(null, "Exemplo Comic 4", 200.5, "Autor 4", "XXXXXXXX7", "Descricao 4");
		Comic c5 = new Comic(null, "Exemplo Comic 5", 31.5, "Autor 5", "XXXXXXXX9", "Descricao 5");
		
		comicRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
		c1.getUsers().add(u1);
		c2.getUsers().add(u1);
		c2.getUsers().add(u2);
		c3.getUsers().add(u2);
		c4.getUsers().add(u2);
		c5.getUsers().add(u2);
		
		comicRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
		
	}
	
	
	
}
