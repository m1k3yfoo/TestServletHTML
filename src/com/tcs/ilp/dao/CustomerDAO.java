package com.tcs.ilp.dao;

import java.util.List;

import com.tcs.ilp.bean.Customer;

public interface CustomerDAO {

	public int addCustomerDetails(Customer customer) throws Exception;

	public List<Customer> searchCustomer(String city);
}
