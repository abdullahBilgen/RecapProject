package com.example.reCapProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reCapProject.core.entities.concretes.User;

public interface ApplicationUserDao extends JpaRepository<User, Integer> {

}
