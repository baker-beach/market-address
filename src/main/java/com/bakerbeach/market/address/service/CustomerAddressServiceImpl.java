package com.bakerbeach.market.address.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.bakerbeach.market.address.api.service.CustomerAddressService;
import com.bakerbeach.market.address.api.service.CustomerAdressServiceException;
import com.bakerbeach.market.address.api.service.CustomerAdressServiceException.InvalidDataException;
import com.bakerbeach.market.core.api.model.Customer;
import com.bakerbeach.market.core.api.model.CustomerAddress;
import com.bakerbeach.market.core.api.model.Text;
import com.bakerbeach.market.sequence.service.SequenceService;

public class CustomerAddressServiceImpl implements CustomerAddressService {

	private CustomerAddressDao customerAddressDao;

	private SequenceService sequenceService;

	private String sequenceKey = "customer_address";
	
	private List<AddressValidator> addressValidator = new ArrayList<AddressValidator>();;

	@Override
	public void saveOrUpdate(CustomerAddress address) throws CustomerAdressServiceException {
		try {
			if (StringUtils.isNotEmpty(address.getCustomerId())) {
				if (!address.getTags().isEmpty()) {
					removeCurrentTags(address.getCustomerId(), address.getTags().toArray(new String[0]));
				}
				if (!StringUtils.isNotEmpty(address.getId())) {
					address.setId(sequenceService.generateId(sequenceKey).toString());
					address.setCreatedAt(new Date());
					address.setUpdatedAt(new Date());
					customerAddressDao.save(address);
				} else {
					address.setUpdatedAt(new Date());
					customerAddressDao.update(address);
				}
			} else {
				throw new InvalidDataException(new Text("error.address.data"));
			}
		} catch (Exception e) {
			throw new CustomerAdressServiceException(e);
		}

	}
	
	private void removeCurrentTags(String customerId, String ...tags){
		try{
			List<CustomerAddress> customerAddressList = customerAddressDao.findByCustomerAndTags(customerId, tags);
			for(CustomerAddress ca : customerAddressList){
				for(String tag : tags){
					ca.getTags().remove(tag);
				}
				ca.setUpdatedAt(new Date());
				customerAddressDao.update(ca);
			}
		}catch(Exception e){}
	}

	@Override
	public List<CustomerAddress> findByCustomer(Customer customer) throws CustomerAdressServiceException {
		try {
			return customerAddressDao.findByCustomer(customer.getId());
		} catch (Exception e) {
			throw new CustomerAdressServiceException(e);
		}
	}

	@Override
	public Map<String, CustomerAddress> findDefaultsByCustomer(Customer customer)
			throws CustomerAdressServiceException {
		try {
			List<CustomerAddress> addresses = customerAddressDao.findByCustomerAndTags(customer.getId(),CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS,CustomerAddress.TAG_DEFAULT_SHIPPING_ADDRESS);
			Map<String, CustomerAddress> result = new HashMap<String, CustomerAddress>();
			for(CustomerAddress ca:addresses){
				if(ca.getTags().contains(CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS))
					result.put(CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS,ca);
				if(ca.getTags().contains(CustomerAddress.TAG_DEFAULT_SHIPPING_ADDRESS))
					result.put(CustomerAddress.TAG_DEFAULT_SHIPPING_ADDRESS,ca);
			}
			return result;
		} catch (Exception e) {
			throw new CustomerAdressServiceException(e);
		}
	}

	@Override
	public CustomerAddress findBillingDefaultByCustomer(Customer customer) throws CustomerAdressServiceException {
		try {
			List<CustomerAddress> addresses = customerAddressDao.findByCustomerAndTags(customer.getId(),CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS);
			for(CustomerAddress ca:addresses){
				if(ca.getTags().contains(CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS))
					return ca;
			}
			throw new CustomerAdressServiceException(new Text("errror.address.default"));
		} catch (Exception e) {
			throw new CustomerAdressServiceException(e);
		}
	}

	@Override
	public CustomerAddress findShippingDefaultByCustomer(Customer customer) throws CustomerAdressServiceException {
		try {
			List<CustomerAddress> addresses = customerAddressDao.findByCustomerAndTags(customer.getId(),CustomerAddress.TAG_DEFAULT_SHIPPING_ADDRESS);
			for(CustomerAddress ca:addresses){
				if(ca.getTags().contains(CustomerAddress.TAG_DEFAULT_BILLING_ADDRESS))
					return ca;
			}
			throw new CustomerAdressServiceException(new Text("errror.address.default"));
		} catch (Exception e) {
			throw new CustomerAdressServiceException(e);
		}
	}

	/**
	 * @return the sequenceService
	 */
	public SequenceService getSequenceService() {
		return sequenceService;
	}

	/**
	 * @param sequenceService
	 *            the sequenceService to set
	 */
	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

	/**
	 * @return the customerAddressDao
	 */
	public CustomerAddressDao getCustomerAddressDao() {
		return customerAddressDao;
	}

	/**
	 * @param customerAddressDao the customerAddressDao to set
	 */
	public void setCustomerAddressDao(CustomerAddressDao customerAddressDao) {
		this.customerAddressDao = customerAddressDao;
	}

}
