package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
