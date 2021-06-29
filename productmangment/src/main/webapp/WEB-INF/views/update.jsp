<%@page import="com.te.productmangment.bean.Products"%>
<%@page import="org.jboss.jandex.TypeTarget.Usage"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
Products pro = (Products) request.getAttribute("proData");
%>
<%@ include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data</title>
</head>
<body>

<fieldset>
		<legend>Search Product to update</legend>
		<form action="./updateid">
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
	<%if(pro!=null) { %>
	<fieldset>
		<legend>Add Details </legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Product ID</td>
					<td>:</td>
					<td><%=pro.getPid()%></td>
					<td><input type="hidden" name="pid" value=<%=pro.getPid()%>></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>:</td>
					<td><input type="text" name="pname"
						value=<%=pro.getPname()%>></td>
				</tr>
				<tr>
					<td> Date of manufacture</td>
					<td>:</td>
					<td><input type="date" name="mgDate"
						value=<%= pro.getMgDate() %>></td>
				</tr>
			
				<tr>
					<td> Date of expire</td>
					<td>:</td>
					<td><input type="date" name="exDate"
						value=<%= pro.getExDate() %>></td>
				</tr>
			
				<tr>
					<td> Price</td>
					<td>:</td>
					<td><input type="number" name="price"
						value=<%= pro.getPrice()%>></td>
				</tr>
			
				<tr>
					<td> Quantity</td>
					<td>:</td>
					<td><input type="number" name="quantity"
						value=<%= pro.getQuantity() %>></td>
				</tr>
			
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</fieldset>
	<%} %>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: magenta;"><%=msg%>
	</h1>
	<%
		}
	%>

</body>
</html>