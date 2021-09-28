package com.example.reCapProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.ColorService;
import com.example.reCapProject.business.constants.Messages;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.ColorDao;
import com.example.reCapProject.entities.concretes.Color;
import com.example.reCapProject.entities.request.create.CreateColorRequest;
import com.example.reCapProject.entities.request.delete.DeleteColorRequest;
import com.example.reCapProject.entities.request.update.UpdateColorRequest;

@Service
public class ColorManager implements ColorService{
	

	private ColorDao colorDao;
	
	@Autowired
	public ColorManager(ColorDao colorDao) {
		super();
		this.colorDao = colorDao;
	}

	@Override
	public Result add(CreateColorRequest createColorRequest) {
		
		Color color=new Color();
		color.setColorName(createColorRequest.getColorName());
		
		this.colorDao.save(color);
		return new SuccessResult(Messages.COLORADD);
		
	}

	@Override
	public DataResult<List<Color>> getAll() {
		
		
		return new SuccessDataResult<List<Color>>
		(this.colorDao.findAll(),Messages.COLORLIST);
	 
	}

	@Override
	public DataResult<Color> getById(int colorId) {
		return new SuccessDataResult<Color> 
		(this.colorDao.getById(colorId),Messages.COLORLIST);
	
	}

	
	@Override
	public Result update(UpdateColorRequest updateColorRequest) {
		
		Color color = new Color();
		color.setColorName(updateColorRequest.getColorName());
		
		this.colorDao.save(color);
		return new SuccessResult(Messages.COLORUPDATE);
		
	}

	@Override
	public Result delete(DeleteColorRequest deleteColorRequest) {
		
		Color color = new Color();
		color.setColorId(this.colorDao.getByColorName(deleteColorRequest.getColorName()).getColorId());
		
		this.colorDao.deleteById(color.getColorId());
		return new SuccessResult(Messages.COLORDELETE);
		
	}

	@Override
	public DataResult<List<Color>> getByCarId(int carId) {
		return new SuccessDataResult<List<Color>>
		(this.colorDao.findAll(),Messages.COLORLIST);
	}
	

}
