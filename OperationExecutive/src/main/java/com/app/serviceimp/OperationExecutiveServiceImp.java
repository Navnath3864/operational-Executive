package com.app.serviceimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.EnquiryDetails;
import com.app.repositary.OperationExecutiveRepositary;
import com.app.service.OperationExecutiveService;

@Service
public class OperationExecutiveServiceImp implements OperationExecutiveService {

	@Autowired
	OperationExecutiveRepositary executiveRepositary;
	
	

	@Override
	public void savaEnquiry(EnquiryDetails enq) {
		executiveRepositary.save(enq);
		
	}



	@Override
	public List<EnquiryDetails> getAllenquiry() {
		
		return executiveRepositary.findAll();
	}
	
	

}
