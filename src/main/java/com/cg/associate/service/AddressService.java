package com.cg.associate.service;

import java.util.List;

import com.cg.associate.entity.Address;

public interface AddressService {

	public Address addAddress(Address address);
	public List<Address> viewAddress();
	public String deleteAddress(long aid);
}
