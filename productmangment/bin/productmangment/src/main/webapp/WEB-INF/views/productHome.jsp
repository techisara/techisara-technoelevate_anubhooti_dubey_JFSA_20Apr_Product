<%@page import="com.te.productmangment.bean.Products"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%

List<Products> product = (List) request.getAttribute("infos");
%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
</head>
<body>

	<fieldset>
		<h1 style="color: lime; text-decoration: underline;">
			Welcome Admin
			</h1>
	</fieldset>
	

	<%
		if (product != null) {
	%>
	<fieldset>
		<legend>All Records</legend>
		<table  border="1" style="width:100%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Date of manufacture</th>
				<th>Date of expire</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<%
				for (Products pro : product) {
			%>
			<tr>
				<td><%=pro.getPid()%></td>
				<td><%=pro.getPname()%></td>
				<td><%=pro.getMgDate()%></td>
				<td><%=pro.getExDate()%></td>
				<td><%=pro.getPrice()%></td>
				<td><%=pro.getQuantity()%></td>
				
			</tr>
			<%
				}
			%>
		</table>

	</fieldset>
	<%
		}
	%>
</body>
</html>