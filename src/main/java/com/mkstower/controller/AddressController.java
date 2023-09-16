package com.mkstower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.mkstower.entity.Address;
import com.mkstower.service.AddressService;

@RestController
@RequestMapping("api/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping
	public ResponseEntity<Address> createAddress(@Validated @RequestBody Address address) {
		Address savedAddress = addressService.createAddress(address);
		return new ResponseEntity<>(savedAddress, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable long id) {
		Address address = addressService.getAddressById(id);
		return new ResponseEntity<>(address, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Address>> getAllAddresss() {
		List<Address> addresss = addressService.getAllAddresss();
		return new ResponseEntity<>(addresss, HttpStatus.OK);
	}

	@GetMapping("active")
	public ResponseEntity<List<Address>> getAllActiveAddresss() {
		List<Address> addresses = addressService.getAllActiveAddresss();		
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}
	
	@GetMapping("inactive")
	public ResponseEntity<List<Address>> getAllInactiveAddresss() {
		List<Address> addresses = addressService.getAllInactiveAddresss();		
		return new ResponseEntity<>(addresses, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable long id, @Validated @RequestBody Address address) {
		Address updateAddress = addressService.updateAddress(address, id);
		return new ResponseEntity<>(updateAddress, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable long id) {
		addressService.deleteAddress(id);
		return new ResponseEntity<>("Address id " + id + " successfully deleted", HttpStatus.OK);
	}

}
