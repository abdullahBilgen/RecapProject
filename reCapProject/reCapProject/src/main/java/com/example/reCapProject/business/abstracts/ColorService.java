package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Color;
import com.example.reCapProject.entities.request.CreateColorRequest;
import com.example.reCapProject.entities.request.UpdateColorRequest;

public interface ColorService {
	
	DataResult<List<Color>> getAll();
	
	DataResult<Color> getById(int colorId);
	
	DataResult<List<Color>> getByCarId(int carId);
	
	Result add(CreateColorRequest createColorRequest);
	
	Result update(UpdateColorRequest updateColorRequest);
	
	Result delete(Color color);

}
 