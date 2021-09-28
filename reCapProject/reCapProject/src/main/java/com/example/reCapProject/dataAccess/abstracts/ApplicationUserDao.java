package com.example.reCapProject.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;


import com.example.reCapProject.entities.concretes.ApplicationUser;

public interface ApplicationUserDao extends JpaRepository<ApplicationUser, Integer>{
	
	boolean existsByEmail(String email);

	ApplicationUser getByEmail(String email);
	

}
