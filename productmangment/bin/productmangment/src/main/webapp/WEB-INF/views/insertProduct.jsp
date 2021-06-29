<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
</head>
<body>
	<fieldset>
		<legend>Add Details </legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Product ID</td>
					<td>:</td>
					<td><input type="number" name="pid"></td>
				</tr>
				<tr>
					<td>Product Name</td>
					<td>:</td>
					<td><input type="text" name="pname"></td>
				</tr>
				<tr>
					<td>Product Date of manufacture</td>
					<td>:</td>
					<td><input type="date" name="mgDate"></td>
				</tr>
				<tr>
					<td>Product Date of expire</td>
					<td>:</td>
					<td><input type="date" name="exDate"></td>
				</tr>
				<tr>
					<td>Product Price</td>
					<td>:</td>
					<td><input type="number" name="price"></td>
				</tr>
				<tr>
					<td>Product Quantity</td>
					<td>:</td>
					<td><input type="number" name="quantity"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add Product"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1 style="color: lime;"><%=msg%>
	</h1>
	<%
		}
	%>
</body>
</html>