package com.example.reCapProject.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;


import com.example.reCapProject.entities.concretes.Brand;



public interface BrandDao extends JpaRepository<Brand, Integer> {
	
	
	boolean existsBrandByBrandName(String brandName);

}
