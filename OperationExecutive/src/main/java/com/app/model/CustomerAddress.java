package com.app.model;


import lombok.Data;


@Data
public class CustomerAddress {
	
	
	private int customerAddressId;
	
	
	private PermanentAddress permanentAddress;
	
	
	private LocalAddress localAddress;

}

