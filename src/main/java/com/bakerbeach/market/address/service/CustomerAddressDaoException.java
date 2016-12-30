package com.bakerbeach.market.address.service;

@SuppressWarnings("serial")
public class CustomerAddressDaoException extends Exception {
	
	public static class CustomerAddressNotFoundException extends CustomerAddressDaoException{
		
		public CustomerAddressNotFoundException(){
			super();
		}
	}

}
