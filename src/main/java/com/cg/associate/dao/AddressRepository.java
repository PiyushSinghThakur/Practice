package com.cg.associate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.associate.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
