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
	private String enquiryStatus ="pending";
	private String pancardNo;
	

	private CibilScoreData cibilScoreData;

//	"firstName":"Harshada",
//	"lastName":"Thorat",
//	"age":25,
//	"email":"thoratharshada065@gmail.com",
//	"mobileno":7028763328,
//	"pancard":"harshada12"
}
