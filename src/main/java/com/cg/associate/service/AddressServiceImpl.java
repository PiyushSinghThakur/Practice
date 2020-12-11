package com.cg.associate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.associate.dao.AddressRepository;
import com.cg.associate.entity.Address;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address addAddress(Address address) {
		addressRepository.save(address);
		return address;
	}

	@Override
	public List<Address> viewAddress() {
		return addressRepository.findAll();
	}

	
	@Override
	public String deleteAddress(long aid) {
		Optional<Address> address=addressRepository.findById(aid);
		if(address.isPresent()) {
			addressRepository.delete(address.get());
			return "address deleted";
		}else
			return "Address id not found";
	}
	
}
