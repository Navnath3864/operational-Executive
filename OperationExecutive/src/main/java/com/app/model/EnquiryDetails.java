package com.app.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class EnquiryDetails {
	@Id
	private int customerID;
	private String firstName;
	private String lastName;
	private int age;
	private String email;
	private long mobileNo;
	private String enquiryStatus ="pending";
	private String pancardNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cibil_id")
	private CibilScoreData cibilScoreData;

//	"firstName":"Harshada",
//	"lastName":"Thorat",
//	"age":25,
//	"email":"thoratharshada065@gmail.com",
//	"mobileno":7028763328,
//	"pancard":"harshada12"
}
