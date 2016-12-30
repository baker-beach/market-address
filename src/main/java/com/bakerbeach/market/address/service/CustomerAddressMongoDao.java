package com.bakerbeach.market.address.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.bakerbeach.market.core.api.model.CustomerAddress;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.QueryBuilder;
import com.bakerbeach.market.address.service.CustomerAddressDaoException.CustomerAddressNotFoundException;

public class CustomerAddressMongoDao implements CustomerAddressDao {
	
	private MongoTemplate mongoTemplate;

	private String collectionName;

	@Override
	public void save(CustomerAddress address) throws CustomerAddressDaoException {
		try{
			getDBCollection().save(CustomerAddressMongoConverter.encode(address));
		}catch(Exception e){
			throw new CustomerAddressDaoException();
		}
		
	}

	@Override
	public void update(CustomerAddress address) throws CustomerAddressDaoException {
		try{
			QueryBuilder qb = QueryBuilder.start();
			qb.and(CustomerAddressMongoConverter.KEY_ID).is(address.getId());
			getDBCollection().update(qb.get(), CustomerAddressMongoConverter.encode(address));
		}catch(Exception e){
			throw new CustomerAddressDaoException();
		}
	}

	@Override
	public List<CustomerAddress> findByCustomer(String customerId) throws CustomerAddressDaoException {
		try{
			QueryBuilder qb = QueryBuilder.start();
			qb.and(CustomerAddressMongoConverter.KEY_CUSTOMER_ID).is(customerId);
			DBCursor cursor = getDBCollection().find(qb.get());
			List<CustomerAddress> resultList = new ArrayList<CustomerAddress>(); 
			while(cursor.hasNext()){
				resultList.add(CustomerAddressMongoConverter.decode(cursor.next()));
			}
			return resultList;
		}catch(Exception e){
			throw new CustomerAddressDaoException();
		}
	}

	@Override
	public CustomerAddress findByCustomerAndTag(String customerId, String tag) throws CustomerAddressDaoException {
		try{
			List<CustomerAddress> addressList = findByCustomerAndTags(customerId,tag);
			if(!addressList.isEmpty())
				return addressList.get(0);
			else
				throw new CustomerAddressNotFoundException();
		}catch(Exception e){
			throw new CustomerAddressNotFoundException();
		}
	}

	@Override
	public List<CustomerAddress> findByCustomerAndTags(String customerId, String... tags)
			throws CustomerAddressDaoException {
		try{
			QueryBuilder qb = QueryBuilder.start();
			qb.and(CustomerAddressMongoConverter.KEY_CUSTOMER_ID).is(customerId);
			qb.and(CustomerAddressMongoConverter.KEY_TAGS).in(tags);
			DBCursor cursor = getDBCollection().find(qb.get());
			List<CustomerAddress> resultList = new ArrayList<CustomerAddress>(); 
			while(cursor.hasNext()){
				resultList.add(CustomerAddressMongoConverter.decode(cursor.next()));
			}
			return resultList;
		}catch(Exception e){
			throw new CustomerAddressDaoException();
		}
	}
	
	private DBCollection getDBCollection() {
		return mongoTemplate.getCollection(collectionName);
	}

	/**
	 * @return the collectionName
	 */
	public String getCollectionName() {
		return collectionName;
	}

	/**
	 * @param collectionName the collectionName to set
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}


}
