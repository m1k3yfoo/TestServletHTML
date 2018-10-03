package com.tcs.ilp.service;

import java.util.ArrayList;
import java.util.List;

import com.tcs.ilp.bean.Customer;
import com.tcs.ilp.dao.CustomerDAO;
import com.tcs.ilp.dao.CustomerDAOImpl;

public class CustomerService {
	public int createCustomer(Customer customer) throws Exception {
		CustomerDAO customerdao = new CustomerDAOImpl();
		return customerdao.addCustomerDetails(customer);
	}

	public List<Customer> searchCustomer(String city) {
		// TODO Auto-generated method stub
		CustomerDAO custDAO = new CustomerDAOImpl();
		List<Customer> customers = custDAO.searchCustomer(city);
		return customers;
		
	}
	
	public List<Customer> retrieveCustomerDetails(String[] custIDs, List<Customer> customers) {
		List<Customer> customerDetails = new ArrayList<>();
		for (String strID : custIDs) {
			int id = Integer.parseInt(strID);
			System.out.println(id);
			for (Customer cust : customers) {
				if (id == cust.getCustomerId()) {
					customerDetails.add(cust);
					break;
				}
			}
		}
		return customerDetails;
	}
}
