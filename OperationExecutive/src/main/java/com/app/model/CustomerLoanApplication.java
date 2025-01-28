package com.app.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
