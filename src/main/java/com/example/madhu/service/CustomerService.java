package com.example.madhu.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.example.madhu.entity.Customer;

public interface CustomerService {
	
	List<Customer> findAll();
	
	ByteArrayInputStream export();

	
}
