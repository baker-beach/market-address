package com.bakerbeach.market.address.model;

import com.bakerbeach.market.core.api.model.CustomerAddress;

@SuppressWarnings("serial")
public class CustomerAddressImpl extends AddressImpl implements CustomerAddress {

	private String customerId;
    
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
