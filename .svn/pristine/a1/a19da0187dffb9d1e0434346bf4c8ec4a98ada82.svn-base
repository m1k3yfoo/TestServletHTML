package com.tcs.ilp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.tcs.ilp.bean.Customer;
import com.tcs.ilp.util.DBConnection;

public class CustomerDAOImpl implements CustomerDAO {
	
	private int numberOfRowsInserted = 0;
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	private Statement stat = null;
	private String query = null;
	
	@Override
	public int addCustomerDetails(Customer customer) throws Exception {
		int customerId = 0;
		con = DBConnection.getConnection();
	
		// Add new customer to database
		query = "INSERT INTO TBL_CUSTOMER_1579349 VALUES(CUSTOMER_REG_SEQ.nextval,?,?,?,?,?,?)";
		ps = con.prepareStatement(query);
		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getLastName());
		ps.setString(3, customer.getContact());
		ps.setString(4, customer.getGender());
		ps.setString(5, customer.getCity());
		ps.setString(6, String.valueOf(customer.getIsMarried()));
		
		numberOfRowsInserted = ps.executeUpdate();
		con.commit();
		
		// Fetch last added customer id from database
		query = "SELECT MAX(CUSTOMER_ID) FROM TBL_CUSTOMER_1579349";
		stat = con.createStatement();
		rs = stat.executeQuery(query);
		
		// Fetch customer id from result set
		while (rs.next()) {
			customerId = (Integer) rs.getInt(1);
			System.out.println("Customer Id: " + customerId);
		}
		
		List<String> hobbies = customer.getHobbies();
		// Insert values in Hobby table using the same customer id
		for (int i = 0; i < hobbies.size(); i++) {
			query = "INSERT INTO TBL_HOBBIES_1579349 VALUES(?,?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, customerId);
			ps.setString(2, hobbies.get(i));
			numberOfRowsInserted = ps.executeUpdate();
			System.out.println("Number of rows inserted into Hobbies table: " + numberOfRowsInserted);
			con.commit();
		}
		
		DBConnection.closeConnection(con);
		return customerId;
	}

	@Override
	public List<Customer> searchCustomer(String city) {
		List<Customer> customers = new ArrayList<>();
		con = DBConnection.getConnection();
		query = "SELECT CUSTOMER_ID, FIRST_NAME, LAST_NAME, CONTACT, GENDER, CITY "
				+ "FROM TBL_CUSTOMER_1579349 "
				+ "WHERE CITY=?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, city);
			rs = ps.executeQuery();
			
			int prevCustId = -1, currCustId = 0;
			Customer cust = null;
			while (rs.next()) {
				currCustId = rs.getInt("CUSTOMER_ID");
				if (prevCustId != currCustId) {
					String firstName = rs.getString("FIRST_NAME");
					String lastName = rs.getString("LAST_NAME");
					String contact = rs.getString("CONTACT");
					String gender = rs.getString("GENDER");
//					System.out.println(rs.getString("IS_MARRIED").charAt(0));
//					String married = rs.getString("IS_MARRIED");
					cust = new Customer(currCustId, firstName, lastName, contact, gender, city);
					customers.add(cust);
					prevCustId = currCustId;
				}
				System.out.println(customers.toString());
//				String hobby = rs.getString("HOBBY");
//				cust.getHobbies().add(hobby);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(con);
		}
		return customers;
	}
}
