<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.auction.web.jdbc.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserted Auctions</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<%
	// get the items from the request object (sent by the servlet)
	List<Item> theItems = (List<Item>) request.getAttribute("ITEM_LIST");
%>
<body>

<div class="wrapper">
	<div class="header">
		<h2>Added items</h2>
		<form action="AuctionControllerServlet" method="GET">
		<div class="formDiv">
		  <input name="searchBy" type="text" value="<%=request.getParameter("searchBy")%>"> <button type="submit">Search</button>
		</div>
	</form>
	</div>
	
</div>
<div class="container">
	<div class="content">
		<table>
			<tr>
				<th>Name</th>
				<th>Category</th>
				<th>Minimum Bid</th>
				<th>Date Added</th>
			</tr>
			<c:forEach var="tempItem" items="${ITEM_LIST}">
				<tr>
					<td>${tempItem.getName()}</td>
					<td>${tempItem.getCategory()}</td>
					<td>${tempItem.getMinBid()}</td>
					<td>${tempItem.getDateAdded()}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>
</body>
</html>