package com.app.model;


import lombok.Data;


@Data
public class AllPersonalDocs {

	
	private int documentID ;
	private byte[] addressProof;
	private byte[]panCard;
	private byte[] incomeTax;
	private byte[] addharCard;
	private byte[] photo;
	private byte[] signature;
	private byte[] bankCheque;
	private byte[] salarySlips;

}


