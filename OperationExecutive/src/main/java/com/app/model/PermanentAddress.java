package com.app.model;


import lombok.Data;


@Data
public class PermanentAddress {
	
	
	private int permanentAddressId;
	
	private String areaName;
	
	private String cityName;
	
	private String district;
	
	private String state;
	
	private	long pincode;
	
	private	int houseNumber;
	
	private	String streetName;

}