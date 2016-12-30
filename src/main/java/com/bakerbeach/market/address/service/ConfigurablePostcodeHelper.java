package com.bakerbeach.market.address.service;

import java.util.Map;
import java.util.regex.Pattern;

public class ConfigurablePostcodeHelper implements PostcodeHelper {
	
	Map<String,String> countries;
	
	private final static String itaFiscalCodeRegex = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";

	public Map<String, String> getCountries() {
		return countries;
	}

	public void setCountries(Map<String, String> countries) {
		this.countries = countries;
	}

	@Override
	public boolean checkPostcode(String postcode, String country) {
		if(countries.containsKey(country)){
			if(Pattern.matches(countries.get(country), postcode))
				return true;
			else
				return false;
		}else
			return true;
	}

	@Override
	public boolean checkItaFiscalCode(String code) {			
		return Pattern.matches(itaFiscalCodeRegex, code);
	}
}
