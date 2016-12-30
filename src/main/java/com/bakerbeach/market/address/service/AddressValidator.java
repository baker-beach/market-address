package com.bakerbeach.market.address.service;

import com.bakerbeach.market.core.api.model.CustomerAddress;

public interface AddressValidator {
	
	boolean isValid(CustomerAddress customerAddress); 

}
