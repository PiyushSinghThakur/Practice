package com.cg.associate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.associate.entity.Address;
import com.cg.associate.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@PostMapping("/addAddress")
	public Address addAddress(@RequestBody Address address) {
		return addressService.addAddress(address);
	}
	@GetMapping("/viewAddress")
	public List<Address> viewAllAddress(){
		return addressService.viewAddress();
	}
	
}
