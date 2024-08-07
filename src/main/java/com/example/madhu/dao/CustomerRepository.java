package com.example.madhu.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.madhu.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {


}
