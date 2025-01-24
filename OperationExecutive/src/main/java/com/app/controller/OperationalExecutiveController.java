package com.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.CibilScoreData;
import com.app.model.EnquiryDetails;

@RestController
@RequestMapping("/oe")
public class OperationalExecutiveController {



//	@Value("${spring.mail.username}")
//	private static String SEND_FROM;
	@Autowired
	RestTemplate rs;



	@Autowired
	JavaMailSender sender;
	private static final Logger LOGGER = LoggerFactory.getLogger(OperationalExecutiveController.class);
 	

	@GetMapping("/getenquirydata/{customerID}")
	public ResponseEntity<EnquiryDetails> getenquirydata(@PathVariable int customerID) {

//		String urlToGetEnquiryData = "http://localhost:8080/app/api/enquiry/" + customerID;
//		EnquiryDetails enq = rs.getForObject(urlToGetEnquiryData, EnquiryDetails.class);
//		String urlToGetCibilData = "http://localhost:9090/api/cibil/get";
//	CibilScoreData cibil = rs.getForObject(urlToGetCibilData, CibilScoreData.class);
		LOGGER.info("Received GET request for Enquiry Data with customerID : {}", customerID);
		String urlToGetEnquiryData="http://localhost:8080/app/api/enquiry/"+customerID;
		EnquiryDetails enq=rs.getForObject(urlToGetEnquiryData, EnquiryDetails.class) ;
		LOGGER.info("Received GET request for CIBIL Data");
		String urlToGetCibilData="http://localhost:9090/api/cibil/get";
		CibilScoreData cibil=rs.getForObject(urlToGetCibilData, CibilScoreData.class);
		sendMail(enq.getEmail(),cibil);

		enq.setCibilScoreData(cibil);

//		sentMailToCusotmer(enq);
		return new ResponseEntity<EnquiryDetails>(enq, HttpStatus.OK);
	}

//	public void sentMailToCusotmer(EnquiryDetails enquiryDetails) {
//		String cibilRemark = enquiryDetails.getCibilScoreData().getCibilRemark();
//		String email = enquiryDetails.getEmail();
//		System.out.println(email);
//		System.out.println(cibilRemark);
//		if ("Applicable".equals(cibilRemark)) {
//			System.out.println(cibilRemark);
//			SimpleMailMessage simple = new SimpleMailMessage();
//			simple.setTo(email);
//			simple.setFrom(SEND_FROM);
//			simple.setSubject("Your Loan Request is Approved!");
//			simple.setText("Thank you!");
//			sender.send(simple);
//			
//		}
//	}
//		return new ResponseEntity<EnquiryDetails>(enq,HttpStatus.OK);
// 	}
	
	public void sendMail(String tomail,CibilScoreData cibil){
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setFrom("navnathgutte20@gmail.com");
		simpleMailMessage.setTo(tomail);
		simpleMailMessage.setSubject("Loan Enquiry Details");
		simpleMailMessage.setText("your cibil details"+
				"\n Cibil score : "+cibil.getCibilScore()+
				"\n Cibil Status : "+cibil.getStatus()+
				"\n	Date : "+cibil.getCibilScoreDateTime()+
				"\n	Cibil Remark : "+cibil.getCibilRemark());
		sender.send(simpleMailMessage);
		System.out.println("Email send successfully!!!");
		
	}
	
	@PostMapping("/getpendingstatus")
	public ResponseEntity<List<EnquiryDetails>> getPendingEnquiriesFromEnquiryForm(@RequestBody List<EnquiryDetails> ls){
		for(EnquiryDetails enq : ls) {
			if(enq.getEnquiryStatus().equals("cibilpending")) {
				
				String urlToGetCibilData="http://localhost:9090/api/cibil/get";
				CibilScoreData cibil=rs.getForObject(urlToGetCibilData, CibilScoreData.class);
				enq.setCibilScoreData(cibil);
				String url ="http://localhost:8080/app/api/updateenquirydetails/"+enq.getCustomerID();
				rs.put(url, enq, EnquiryDetails.class);
				sendMail(enq.getEmail(),cibil);
			}
		}
		return new ResponseEntity<List<EnquiryDetails>>(ls,HttpStatus.OK);
	} 
}
