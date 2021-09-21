package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Brand;
import com.example.reCapProject.entities.request.CreateBrandRequest;


public interface BrandService {
	
	DataResult<List<Brand>> getAll();
	
	DataResult<Brand> getById(int brandId);

	DataResult<List<Brand>> getByCarId(int carId);
	
	Result add(CreateBrandRequest createBrandRequest);
	
	Result update(Brand brand);
	
	Result delete(Brand brand);
	

	

}
