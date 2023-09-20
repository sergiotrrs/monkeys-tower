package com.mkstower.service;

import java.util.List;

import com.mkstower.entity.Address;
import com.mkstower.entity.limits.AdressFieldLimits;

public interface AddressService extends AdressFieldLimits {

	Address createAddress(Address adress);
	
	Address getAddressById(long id);
	
	List<Address> getAllAddresss();
	
	List<Address> getAllActiveAddresss();
	
	List<Address> getAllInactiveAddresss();
	
	Address updateAddress(Address address, long id);
	
	void deleteAddress(long id);
	
}
