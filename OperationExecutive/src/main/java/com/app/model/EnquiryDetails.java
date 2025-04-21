package com.app.model;

import lombok.Data;

@Data
public class EnquiryDetails {
	private int customerID;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private String password;
	private long mobileNo;
	private String enquiryStatus=null;
	private String pancardNo;
	private String role;
	private CibilScoreData cibilScoreData;

}
