package com.t3.onetoonebi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t3.onetoonebi.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{
    
}
