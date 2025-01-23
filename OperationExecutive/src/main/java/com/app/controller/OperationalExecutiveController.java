package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.CibilScoreData;
import com.app.model.EnquiryDetails;

@RestController
@RequestMapping("/oe")
public class OperationalExecutiveController {

	@Autowired
	JavaMailSender sender;

	@Value("${spring.mail.username}")
	private static String SEND_FROM;
	@Autowired
	RestTemplate rs;

	@GetMapping("/getenquirydata/{customerID}")
	public ResponseEntity<EnquiryDetails> getenquirydata(@PathVariable int customerID) {
		String urlToGetEnquiryData = "http://localhost:8080/app/api/enquiry/" + customerID;
		EnquiryDetails enq = rs.getForObject(urlToGetEnquiryData, EnquiryDetails.class);
		String urlToGetCibilData = "http://localhost:9090/api/cibil/get";
		CibilScoreData cibil = rs.getForObject(urlToGetCibilData, CibilScoreData.class);
		enq.setCibilScoreData(cibil);
		sentMailToCusotmer(enq);
		return new ResponseEntity<EnquiryDetails>(enq, HttpStatus.OK);
	}

	public void sentMailToCusotmer(EnquiryDetails enquiryDetails) {
		String cibilRemark = enquiryDetails.getCibilScoreData().getCibilRemark();
		String email = enquiryDetails.getEmail();
		System.out.println(email);
		System.out.println(cibilRemark);
		if ("Applicable".equals(cibilRemark)) {
			System.out.println(cibilRemark);
			SimpleMailMessage simple = new SimpleMailMessage();
			simple.setTo(email);
			simple.setFrom(SEND_FROM);
			simple.setSubject("Your Loan Request is Approved!");
			simple.setText("Thank you!");
			sender.send(simple);
		}
	}
}
