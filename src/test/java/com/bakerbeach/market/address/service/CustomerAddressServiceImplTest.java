package com.bakerbeach.market.address.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bakerbeach.market.address.api.service.CustomerAddressService;
import com.bakerbeach.market.address.api.service.CustomerAdressServiceException;
import com.bakerbeach.market.address.model.CustomerAddressImpl;
import com.bakerbeach.market.core.api.model.CustomerAddress;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/customer_address_service.xml","classpath:spring/sequence_service.xml","classpath:spring/resources.xml"})
public class CustomerAddressServiceImplTest {
	
	@Autowired
	private CustomerAddressService customerAdressSerice; 

	@Test
	public void test() {
		CustomerAddressImpl ca = new CustomerAddressImpl();
		
		ca.setFirstName("Mark");
		ca.setLastName("Hoja");
		ca.setMiddleName("");
		ca.setPrefix("Herr");
		ca.setCustomerId("1");
		ca.setCountryCode("DE");
		ca.setCity("München");
		ca.setStreet1("Freischützstrasse 71");
		ca.setPostcode("81927");
		ca.getTags().add(CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS);
		//ca.getTags().add(CustomerAddress.TAG_DEFAULT_SHIPPING_ADDRESS);
		
		try {
			customerAdressSerice.saveOrUpdate(ca);
		} catch (CustomerAdressServiceException e) {
			fail("save crash");
		}
	}

}
