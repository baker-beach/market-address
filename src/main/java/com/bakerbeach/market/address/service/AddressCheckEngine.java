package com.bakerbeach.market.address.service;

import com.bakerbeach.market.commons.Messages;
import com.bakerbeach.market.core.api.model.Address;

public class AddressCheckEngine {
	
	public boolean checkAddress(Address address, Messages messages){
//		if (!postcodeHelper.checkPostcode(addressForm.billingAddress.postcode,
//				addressForm.billingAddress.countryCode)) {
//			isValid = false;
//			if (messages.getFieldError("billingAddress.postcode") == null)
//				messages.addFieldError(new FieldMessageImpl("billingAddress.postcode", Message.TYPE_ERROR,
//						"address.error.postcode"));
//		}
//
//		if (!postcodeHelper.checkPostcode(addressForm.shippingAddress.postcode,
//				addressForm.shippingAddress.countryCode) && addressForm.isUseShipping()) {
//			isValid = false;
//			if (messages.getFieldError("shippingAddress.postcode") == null)
//				messages.addFieldError(new FieldMessageImpl("shippingAddress.postcode", Message.TYPE_ERROR,
//						"address.error.postcode"));
//		}
		
		return true;
	}

}
