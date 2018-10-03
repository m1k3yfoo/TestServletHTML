<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import ="com.tcs.ilp.bean.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div id="wrapper"></div>
		<div id="welcome" class="controller">
			<div class="title">
				<h2>Customer details as per location</h2>
				<br />
<%
	List<Customer> customerList = (List<Customer>) session.getAttribute("customersList");
%>
<table border="1" style="border-collapse: collapse;">
	<thead>
		<tr>
			<th>Select</th>
			<th>Customer ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Contact</th>
			<th>Gender</th>
		</tr>
	</thead>
	
	<tbody>
		<% if (customerList == null || customerList.size() == 0) { %>
			<tr><td colspan="4">NO RECORDS FOUND</td></tr>
		<% return; } %>
	
		<form action="CustomerController" method="post">
		<%
			for (Customer cust : customerList) {
		%>
			<tr>
				<td><input type="checkbox" name="selID" value="<%= cust.getCustomerId() %>" /></td>
				<td><%= cust.getCustomerId() %></td>
				<td><%= cust.getFirstName() %></td>
				<td><%= cust.getLastName() %></td>
				<td><%= cust.getContact() %></td>
				<td><%= cust.getGender() %></td>
			</tr>
		<% } %>
		</form>
	</tbody>

</table>
			</div>
		</div>
		<%@ include file="footer.jsp" %>
</body>
</html>