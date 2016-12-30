package com.bakerbeach.market.address.service;

import java.util.List;

import com.bakerbeach.market.core.api.model.CustomerAddress;

public interface CustomerAddressDao {
	
	void save(CustomerAddress address) throws CustomerAddressDaoException;
	
	void update(CustomerAddress address) throws CustomerAddressDaoException;
	
	List<CustomerAddress> findByCustomer(String customerId) throws CustomerAddressDaoException;
	
	CustomerAddress findByCustomerAndTag(String customerId, String tag) throws CustomerAddressDaoException;

	List<CustomerAddress> findByCustomerAndTags(String customerId, String ...tags) throws CustomerAddressDaoException;

}
