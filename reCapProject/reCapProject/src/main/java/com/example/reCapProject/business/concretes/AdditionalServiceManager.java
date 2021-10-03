package com.example.reCapProject.business.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reCapProject.business.abstracts.AdditionalServiceService;
import com.example.reCapProject.core.utilities.business.BusinessRules;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.ErrorResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.core.utilities.result.SuccessDataResult;
import com.example.reCapProject.core.utilities.result.SuccessResult;
import com.example.reCapProject.dataAccess.abstracts.AdditionalServiceDao;
import com.example.reCapProject.entities.concretes.AdditionalService;
import com.example.reCapProject.entities.request.create.CreateAdditionalServiceRequest;
import com.example.reCapProject.entities.request.delete.DeleteAdditionalServiceRequest;
import com.example.reCapProject.entities.request.update.UpdateAdditionalServiceRequest;

@Service
public class AdditionalServiceManager implements AdditionalServiceService{

    AdditionalServiceDao additionalServiceDao;
	
	@Autowired
	public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao) {
		super();
		this.additionalServiceDao = additionalServiceDao;
	}

	@Override
	public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
		
		var result = BusinessRules.run(checkAdditionalServiceDupplicateName(createAdditionalServiceRequest.getAdditionalName()));
		
		if (result != null) {
			return result;
		}
		
		AdditionalService additionalService = new AdditionalService();
		additionalService.setAdditionalName(createAdditionalServiceRequest.getAdditionalName());
		additionalService.setAdditionalDescription(createAdditionalServiceRequest.getAdditionalDescription());
		additionalService.setAdditionalPrice(createAdditionalServiceRequest.getAdditionalPrice());
		
		this.additionalServiceDao.save(additionalService);
		return new SuccessResult();
	}

	@Override
	public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
		
	var result = BusinessRules.run(checkAdditionalServiceDupplicateName(updateAdditionalServiceRequest.getAdditionalName()));
		
		if (result != null) {
			return result;
		}

		AdditionalService additionalService = this.additionalServiceDao.getById(updateAdditionalServiceRequest.getAdditionalId());
		additionalService.setAdditionalName(updateAdditionalServiceRequest.getAdditionalName());
		additionalService.setAdditionalDescription(updateAdditionalServiceRequest.getAdditionalDescription());
		additionalService.setAdditionalPrice(updateAdditionalServiceRequest.getAdditionalPrice());
		
		this.additionalServiceDao.save(additionalService);
		return new SuccessResult();
	}

	@Override
	public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
		AdditionalService additionalService = this.additionalServiceDao.getById(deleteAdditionalServiceRequest.getAdditionalId());

       this.additionalServiceDao.delete(additionalService);
       return new SuccessResult();
	}
	
	private Result checkAdditionalServiceDupplicateName(String additionalName) {
       if(this.additionalServiceDao.existsAdditionalServiceByAdditionalName(additionalName)) {
           return new ErrorResult();
       }
       return new SuccessResult();
   }

	@Override
	public DataResult<AdditionalService> getById(int additionalId) {
		return new SuccessDataResult<AdditionalService>(this.additionalServiceDao.getById(additionalId));
	}

}
