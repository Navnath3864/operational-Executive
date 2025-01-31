package com.app.model;


import lombok.Data;

@Data
public class LocalAddress {

	private int localAddressId;
	
	private String areaName;

	private String cityName;
	
	private String district;

	private String state;
	
	private long pincode;
	
	private int houseNumber;
	
	private String streetName;

}

