package com.zup.juliete_user_comics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.juliete_user_comics.entities.Comic;

public interface ComicRepository  extends JpaRepository<Comic, Long>{

}