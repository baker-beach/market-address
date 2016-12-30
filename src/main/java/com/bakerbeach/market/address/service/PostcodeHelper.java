package com.bakerbeach.market.address.service;

public interface PostcodeHelper {
	
	boolean checkPostcode(String postcode, String country);
	
	boolean checkItaFiscalCode(String code);
}
