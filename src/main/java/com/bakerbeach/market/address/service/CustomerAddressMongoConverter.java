package com.bakerbeach.market.address.service;

import com.bakerbeach.market.address.model.CustomerAddressImpl;
import com.bakerbeach.market.core.api.model.CustomerAddress;
import com.mongodb.DBObject;

public class CustomerAddressMongoConverter {

	public static String KEY_ID = "id";
	public static String KEY_TAGS = "tags";
	public static String KEY_CUSTOMER_ID = "customer_id";

	public static CustomerAddress decode(DBObject dbo) {

		CustomerAddressImpl ca = AddressMongoConverter.decode(new CustomerAddressImpl(), dbo);
		ca.setCustomerId((String) dbo.get(KEY_CUSTOMER_ID));

		return ca;
	}

	public static DBObject encode(CustomerAddress ca) {

		DBObject dbo = AddressMongoConverter.encode(ca);
		dbo.put(KEY_CUSTOMER_ID, ca.getCustomerId());

		return dbo;
	}

}
