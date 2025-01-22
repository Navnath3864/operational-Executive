package com.app.model;

import lombok.Data;

@Data
public class EnquiryDetails {
	private int customerID;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private long mobileNo;
	private String pancardNo;
	
	private CibilScoreData cibilScoreData;

}
