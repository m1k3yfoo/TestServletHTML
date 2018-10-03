package com.tcs.ilp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.bean.Customer;
import com.tcs.ilp.service.CustomerService;

/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String source = request.getParameter("source");
		if (source.equals("add")) {
			response.sendRedirect("addCustomer.html");
		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
//		if (action == null) {
//			request.getRequestDispatcher("error.jsp").forward(request, response);
//			return;
//		}
		
		if (action.equals("search")) {
			String city = request.getParameter("city");
			CustomerService custService = new CustomerService();
			List<Customer> customers = custService.searchCustomer(city);
			HttpSession session = request.getSession();
			session.setAttribute("customersList", customers);
			
			request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
		} else if (action.equals("show_details")) {
			
		}
		
		String source = request.getParameter("source");
		if (source.equals("addCustomer")) {
		
			char isMarried;
			Customer customer = new Customer();
			CustomerService customerService = new CustomerService();
			String firstName = (String) request.getParameter("txtFirstName");
			String lastName = (String) request.getParameter("txtLastName");
			String contact = (String) request.getParameter("txtContact");
			String gender = (String) request.getParameter("radGender");
			String city = (String) request.getParameter("city");
			String married = (String) request.getParameter("chkMarried");
			List<String> hobbies = new ArrayList<>(Arrays.asList(request.getParameterValues("selHobbies")));
			
			if ("on".equalsIgnoreCase(married)) {
				isMarried = 'Y';
			} else {
				isMarried = 'N';
			}
			
			customer.setFirstName(firstName);
			customer.setLastName(lastName);
			customer.setContact(contact);
			customer.setGender(gender);
			customer.setCity(city);
			customer.setGender(gender);
			customer.setIsMarried(isMarried);
			customer.setHobbies(hobbies);
			int customerId = 0;
			
			// Add customer to database
			try {
				customerId = customerService.createCustomer(customer);
				customer.setCustomerId(customerId);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			PrintWriter out = response.getWriter();
			out.println("Registration is successful.");
			out.println("Your Customer Id is: " + customerId);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstName = (String) request.getParameter("txtFirstName");
		String lastName = (String) request.getParameter("txtLastName");
		String gender = (String) request.getParameter("radGender");
		String city = (String) request.getParameter("city");
//		String[] hobbies = (String[]) request.getParameterValues("selHobbies");
		
		PrintWriter out = response.getWriter();
		out.println("<table border=1>");
		
		out.println("<tr>");
		out.println("<td>First Name: </td><td>" + firstName + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Last Name: </td><td>" + lastName + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>Gender: </td><td>" + gender + "</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>City: </td><td>" + city + "</td>");
		out.println("</tr>");
	}**/
}
