package com.example.madhu.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.madhu.entity.Customer;
import com.example.madhu.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/getCustomer")
	public void downloadExcelFile(HttpServletResponse response) throws IOException {
		ByteArrayInputStream bytearrayInputStream = customerService.export();
		response.setContentType("application");
		response.setHeader("Content-Disposition", "attachment; filename=customers.csv");
		IOUtils.copy(bytearrayInputStream, response.getOutputStream());
	}

}
