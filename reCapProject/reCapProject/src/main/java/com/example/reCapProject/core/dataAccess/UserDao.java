package com.example.reCapProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.core.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
