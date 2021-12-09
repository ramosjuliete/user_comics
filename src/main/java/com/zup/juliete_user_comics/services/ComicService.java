package com.zup.juliete_user_comics.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.juliete_user_comics.entities.Comic;
import com.zup.juliete_user_comics.entities.User;
import com.zup.juliete_user_comics.repositories.ComicRepository;
import com.zup.juliete_user_comics.services.exceptions.ResourceNotFoundException;

@Service 
public class ComicService {
	@Autowired
	private ComicRepository repository;
	
	public List<Comic> findAll(){
		return repository.findAll();
	}
	
	public Comic findById(Long id) {
		Optional<Comic> c = repository.findById(id);
		return c.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public Comic insert(Comic c) {
		return repository.save(c);
	}
	
	public Comic calculateDiscount(String day, Comic c) {
		switch (day) {
		case "SEG":
			if (c.getIBSN().endsWith("0") || c.getIBSN().endsWith("1")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "TER":
			if (c.getIBSN().endsWith("2") || c.getIBSN().endsWith("3")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "QUA":
			if (c.getIBSN().endsWith("4") || c.getIBSN().endsWith("5")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "QUI":
			if (c.getIBSN().endsWith("6") || c.getIBSN().endsWith("7")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "SEX":
			if (c.getIBSN().endsWith("8") || c.getIBSN().endsWith("9")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		default:
			return c;
		}
		return c;
	}	
}
