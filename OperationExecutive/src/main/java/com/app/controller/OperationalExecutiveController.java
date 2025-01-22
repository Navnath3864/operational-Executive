package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.CibilScoreData;
import com.app.model.EnquiryDetails;

@RestController
public class OperationalExecutiveController {
	@Autowired
	RestTemplate rs;
	@GetMapping("/getenquirydata/{customerID}")
	public ResponseEntity<EnquiryDetails> getenquirydata(@PathVariable int customerID) {
		String urlToGetEnquiryData="http://localhost:8080/app/api/enquiry/"+customerID;
		EnquiryDetails enq=rs.getForObject(urlToGetEnquiryData, EnquiryDetails.class) ;
		String urlToGetCibilData="http://localhost:9090/api/cibil/get";
		CibilScoreData cibil=rs.getForObject(urlToGetCibilData, CibilScoreData.class);
		enq.setCibilScoreData(cibil);
		return new ResponseEntity<EnquiryDetails>(enq,HttpStatus.OK);
 	}
}
