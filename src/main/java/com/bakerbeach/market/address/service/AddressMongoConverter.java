package com.bakerbeach.market.address.service;

import java.util.Date;

import com.bakerbeach.market.address.model.AddressImpl;
import com.bakerbeach.market.core.api.model.Address;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class AddressMongoConverter {	
	public static String KEY_TAGS = "tags";
	public static String KEY_ID = "id";
	public static String KEY_PREFIX = "prefix";
	public static String KEY_FIRST_NAME = "first_name";
	public static String KEY_LAST_NAME = "last_name";
	public static String KEY_MIDDLE_NAME = "middle_name";
	public static String KEY_SUFFIX = "suffix";
	public static String KEY_STREET1 = "street1";
	public static String KEY_STREET2 = "street2";
	public static String KEY_POSTCODE = "postcode";
	public static String KEY_CITY = "city";
	public static String KEY_REGION = "region";
	public static String KEY_COUNTRY_CODE = "country_code";
	public static String KEY_EMAIL = "email";
	public static String KEY_TELEPHONE = "telephone";
	public static String KEY_FAX = "fax";
	public static String KEY_COMPANY = "company";
	public static String KEY_CREATED_AT = "created_at";
	public static String KEY_UPDATED_AT = "updated_at";
		
	public static Address decode(DBObject dbo){
		return decode(new AddressImpl(), dbo);
	}

	public static <T extends Address> T decode(T address, DBObject dbo){
		address.setId((String)dbo.get(KEY_ID));
		address.setEmail((String)dbo.get(KEY_EMAIL));
		address.setFirstName((String)dbo.get(KEY_FIRST_NAME));
		address.setLastName((String)dbo.get(KEY_LAST_NAME));
		address.setMiddleName((String)dbo.get(KEY_MIDDLE_NAME));
		address.setCreatedAt((Date)dbo.get(KEY_CREATED_AT));
		address.setUpdatedAt((Date)dbo.get(KEY_UPDATED_AT));
		address.setPrefix((String)dbo.get(KEY_PREFIX));
		address.setSuffix((String)dbo.get(KEY_SUFFIX));
		address.setCompany((String)dbo.get(KEY_COMPANY));
		address.setTelephone((String)dbo.get(KEY_TELEPHONE));
		address.setFax((String)dbo.get(KEY_FAX));
		address.setCountryCode((String)dbo.get(KEY_COUNTRY_CODE));
		address.setRegion((String)dbo.get(KEY_REGION));
		address.setCity((String)dbo.get(KEY_CITY));
		address.setStreet1((String)dbo.get(KEY_STREET1));
		address.setStreet2((String)dbo.get(KEY_STREET2));
		address.setPostcode((String)dbo.get(KEY_POSTCODE));
		
		if (dbo.containsField(KEY_TAGS)) {
			for (Object item : ((BasicDBList) dbo.get(KEY_TAGS))) {
				address.getTags().add((String)item);
			}			
		}

		return address;
	}
	
	public static DBObject encode(Address address){
		
		DBObject dbo = new BasicDBObject();
		
		dbo.put(KEY_ID, address.getId());
		dbo.put(KEY_EMAIL, address.getEmail());
		dbo.put(KEY_FIRST_NAME, address.getFirstName());
		dbo.put(KEY_LAST_NAME, address.getLastName());
		dbo.put(KEY_MIDDLE_NAME, address.getMiddleName());
		dbo.put(KEY_CREATED_AT, address.getCreatedAt());
		dbo.put(KEY_UPDATED_AT, address.getUpdatedAt());
		dbo.put(KEY_PREFIX, address.getPrefix());
		dbo.put(KEY_SUFFIX, address.getSuffix());
		dbo.put(KEY_COMPANY,address.getCompany());
		dbo.put(KEY_TELEPHONE,address.getTelephone());
		dbo.put(KEY_FAX,address.getFax());
		dbo.put(KEY_COUNTRY_CODE,address.getCountryCode());
		dbo.put(KEY_REGION,address.getRegion());
		dbo.put(KEY_CITY,address.getCity());
		dbo.put(KEY_STREET1,address.getStreet1());
		dbo.put(KEY_STREET2,address.getStreet2());
		dbo.put(KEY_POSTCODE,address.getPostcode());
		dbo.put(KEY_TAGS,address.getTags());
		
		return dbo;
	}

}
