package com.example.reCapProject.business.abstracts;

import java.util.List;

import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Color;
import com.example.reCapProject.entities.request.CreateColorRequest;

public interface ColorService {
	
	DataResult<List<Color>> getAll();
	
	DataResult<Color> getById(int colorId);
	
	Result add(CreateColorRequest createColorRequest);
	
	Result update(Color color);
	
	Result delete(Color color);

}
 