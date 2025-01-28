package com.app.model;


import lombok.Data;


@Data
public class CustomerLoanApplication {

	
	private int customerLoanID;
	
	private String customerName;
	
	
	private String customerDateOfBirth;
	
	
	private int customerAge;
	
	private int requiredTenure;
	
	private String customerGender;
	
	
	private String customerEmail;
	
	
	private double customerMobileNumber;
	

	private double customerAdditionalMobileNumber;
	
	private double customerAmountPaidForHome;
	
	private double customerTotalLoanRequired;
	
	private String loanStatus;
	
	private AllPersonalDocs allPersonalDocument;
	
	private DependentInfo familyDependentInfo;

	private CustomerAddress customerAddress;
	
	private CibilScoreData cibilScoreData;

	private AccountDetails accountDetails;

	private GuarantorDetails gurantorDetails;
	
}
