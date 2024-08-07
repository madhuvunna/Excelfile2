package com.example.madhu.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.madhu.dao.CustomerRepository;
import com.example.madhu.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ByteArrayInputStream export() {
		ByteArrayOutputStream out = null;
		XSSFWorkbook workbook =null;
		try {

			List<Customer> obj = customerRepository.findAll();

			workbook = new XSSFWorkbook();

			XSSFSheet sheet = workbook.createSheet("Customer");

			XSSFRow row;

			String[] HEADERS = { "id", "firstName", "lastName" };

			row = sheet.createRow(0);
			//XSSFCellStyle style = workbook.createCellStyle();

			int cellId = 0;
			for (String string : HEADERS) {
				Cell cell = row.createCell(cellId++);
				cell.setCellValue(string);
			}

			int rowid = 1;

			for (Customer customer : obj) {
				row = sheet.createRow(rowid++);
				for (int i = 0; i < HEADERS.length; i++) {
					Cell cell = row.createCell(i);
					switch (i) {
					case 0:
						cell.setCellValue(customer.getId());
						break;
					case 1:
						cell.setCellValue(customer.getFirstName());
						break;
					case 2:
						cell.setCellValue(customer.getLastName());
						break;
					default:
						break;
					}
				}

			}
			out = new ByteArrayOutputStream();
			workbook.write(out);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(out.toByteArray());

	}

	@Override
	public List<Customer> findAll() {
		return null;
	}

}
