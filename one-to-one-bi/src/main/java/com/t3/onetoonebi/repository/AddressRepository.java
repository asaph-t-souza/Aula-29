package com.t3.onetoonebi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t3.onetoonebi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
