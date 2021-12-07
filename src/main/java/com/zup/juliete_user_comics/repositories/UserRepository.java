package com.zup.juliete_user_comics.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.juliete_user_comics.entities.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
