package com.app.service;

import java.util.List;

import com.app.model.EnquiryDetails;

public interface OperationExecutiveService {

	void savaEnquiry(EnquiryDetails enq);

	List<EnquiryDetails> getAllenquiry();

}
