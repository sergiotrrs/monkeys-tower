package com.mkstower.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Address;
import com.mkstower.repository.AddressRepository;
import com.mkstower.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address createAddress(Address address) {		
		return addressRepository.save(address);
	}

	@Override
	public Address getAddressById(long id) {
		return addressRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException ("Address does not exist with id: " + id));		
	}

	@Override
	public List<Address> getAllAddresss() {
		return addressRepository.findAll();
	}

	@Override
	public List<Address> getAllActiveAddresss() {
		//return addressRepository.findAll();
		List<Address> addresses = new ArrayList<>();
		addresses.add(new Address());
		return addresses;
	}

	@Override
	public Address updateAddress(Address address, long id) {
		Address existingAddress = getAddressById(id);
		existingAddress.setStreet( address.getStreet());		
		return createAddress(existingAddress);
	}

	@Override
	public void deleteAddress(long id) {
		Address existingAddress = getAddressById(id);
		existingAddress.setActive(false);		
	}

}
