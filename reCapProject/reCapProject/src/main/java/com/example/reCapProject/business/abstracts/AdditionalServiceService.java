package com.example.reCapProject.business.abstracts;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.AdditionalService;
import com.example.reCapProject.entities.request.create.CreateAdditionalServiceRequest;
import com.example.reCapProject.entities.request.delete.DeleteAdditionalServiceRequest;
import com.example.reCapProject.entities.request.update.UpdateAdditionalServiceRequest;

public interface AdditionalServiceService {
	
	DataResult<AdditionalService> getById(int additionalId);
    Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest);
	
	Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest);
	
	Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest);

}
