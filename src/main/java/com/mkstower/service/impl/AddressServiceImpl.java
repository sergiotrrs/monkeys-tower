package com.mkstower.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkstower.entity.Address;
import com.mkstower.repository.AddressRepository;
import com.mkstower.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address createAddress(Address address) {		
		return saveAddress(address);
	}

	public Address saveAddress(Address address) {
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
		return addressRepository.findAllByActive(true);
	}

	@Override
	public List<Address> getAllInactiveAddresss() {
		return addressRepository.findAllByActive(false);
	}
	
	@Override
	public Address updateAddress(Address address, long id) {
		Address existingAddress = getAddressById(id);
		existingAddress.setStreet( address.getStreet());		
		existingAddress.setCity( address.getCity());		
		existingAddress.setPostalCode( address.getPostalCode());						
		return createAddress(existingAddress);
	}

	@Override
	public void deleteAddress(long id) {
		Address existingAddress = getAddressById(id);
		existingAddress.setActive(false);	
		saveAddress(existingAddress);
		
	}

}
