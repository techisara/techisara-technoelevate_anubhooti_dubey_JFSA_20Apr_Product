
<%@page import="com.te.productmangment.bean.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String errMsg = (String) request.getAttribute("errMsg");
Products product = (Products) request.getAttribute("proData");
%>

<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>

	<fieldset>
		<legend>Search Product</legend>
		<form action="./search">
			<table>
				<tr>
					<td>Product ID</td>
					<td>:</td>
					<td><input type="number" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	
	<%
	if(product != null) {
	%>

	<h3>
		Name :
		<%=product.getPname()%></h3>
	<h3>
		ID :
		<%=product.getPid()%></h3>
	<h3>
		Date of manufacture :
		<%=product.getMgDate()%></h3>
		
	<h3>Date of expire :
	<%= product.getExDate() %></h3>
	
	<h3>Price:
	<%= product.getPrice() %></h3>
	
	<h3>Quantity:
	<%= product.getQuantity() %></h3>

	<%
		}
	%>
	
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h2>
		<%=errMsg%></h2>
	<%
		}
	%>

</body>
</html>