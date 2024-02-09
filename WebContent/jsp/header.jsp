<%@page import="java.util.Map"%>
<%@page import="com.naaptol.netmeds.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    	<link rel="icon" href="<%= request.getContextPath() %>/images/Netmeds.png">
    	<title>Netmeds.com: Indian Online Pharmacy | Buy Medicines Online, Fast Delivery</title>
    	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/netmades.css">
</head>
<body>
	<% 	
		Map map = (Map) session.getAttribute("map");
		String loggedInUser = (map != null && map.containsKey("first-name")) ? (String) map.get("first-name") : null;
		Long count = Long.valueOf(0);

		if(loggedInUser != null)
		{
			count = Helper.getAddToCartProductsCount(map.get("customerId").toString());

			if(count == null || count == Long.valueOf(0))
				count = Long.valueOf(0);
		}
		else
		{
			response.sendRedirect(request.getContextPath()+"/jsp/netmeds.jsp");
		}
	%>
	<div class="main-container-header">
        	<header class="header">
			<nav class="upper-nav">
				<a href="<%= request.getContextPath() %>" id="logo">
					<div class="logo-container">
						<img src="<%= request.getContextPath() %>/images/logo.png" alt="image not found">
					</div>
				</a>
				<div class="search-bar-element" id="pincode">
					<p>Deliver to </p>
					<h4>410511</h4>
					<input type="text" placeholder="Search for medicine & wellness products..." id="search-bar" onkeydown="netmeds.searchBar()">
					<div class="clr"></div>
				</div>
				<div class="whoes-login">
					<h4>
					<% 	if (loggedInUser != null) 
						{ 
					%>
						Hi <%=	loggedInUser	%>
					<% 	} 	%>
					</h4>
				</div>
				<a href="<%= request.getContextPath() %>/jsp/addToCart.jsp">
					<div class="nav-element">
						<img src="<%= request.getContextPath() %>/images/cart_icon.png" alt="image not found">
						<p class="nav-label">Cart</p>
						<p class="card-item-count" id="card-item-count"><%= count %></p>
					</div>
				</a>
				<% 	if (loggedInUser == null) 
					{ 	
				%>
				<div class="sign-element">
					<div class="img-container">
						<img src="<%= request.getContextPath() %>/images/profile_icon.png" alt="image not found" id="profile-icon">
					</div>
					<div class="sign">
						<a href="<%= request.getContextPath() %>/jsp/signUp.jsp">Sign in</a>
						<p>/</p>
						<a href="<%= request.getContextPath() %>/jsp/signUp.jsp">Sign up</a>
						<div class="clr"></div>
					</div>
				</div>
				<% 	}
					else
					{ 	
				%>
				<a href="<%= request.getContextPath() %>/jsp/logout.jsp" class="logout-btn">
					Logout
				</a>
				<% 	} 	%>
				<div class="clr"></div>
			</nav>
		</header>
	</div>
    	<script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
    	<script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</body>
</html>
