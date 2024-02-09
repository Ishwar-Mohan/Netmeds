<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="<%= request.getContextPath() %>/images/Netmeds.png">
    <title>Netmeds.com: Indian Online Pharmacy | Buy Medicines Online, Fast Delivery</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/netmades.css">
    <script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
    <script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</head>
<body>
	<% 
		// Invalidate the current session
    	   session.invalidate();
    
    	// Redirect the user to the page after logout
    	   String contextPath = request.getContextPath();
    	   response.sendRedirect(contextPath);
    %>
</body>
</html>