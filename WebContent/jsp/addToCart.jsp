<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Map"%>
<%@page import="com.naaptol.netmeds.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	Map SessionMap = (Map) session.getAttribute("map");
	String loggedInUser = (SessionMap != null && SessionMap.containsKey("first-name")) ? (String) SessionMap.get("first-name") : null;

	if (loggedInUser == null)
	{
		request.setAttribute("next", request.getContextPath()+"/jsp/addToCart.jsp");
		response.sendRedirect(request.getContextPath()+"/jsp/signUp.jsp");
	}
	else
	{
%>
	<input name="contextPath" id="contextPath" type="hidden" value="<%= request.getContextPath() %>">
	<input type="hidden" value="<%= SessionMap.get("customerId") %>" name="whoLoggedIn" id="whoLoggedIn">
  
  	<div class="main-container">
    		<jsp:include page="/jsp/header.jsp"></jsp:include>
    		<div class="add-to-cart-container">
        		<h2>Order Summery</h2>
        		<div class="left-container">
        			<div class="left-container-inner">
            				<h3 class="lc-heading">Products</h3>
            				<%
            					Map map = (Map) Helper.getAddToCartAllProducts((SessionMap.get("customerId").toString()));
          					for(int i = 1; i<= map.size()-1; i++)
          					{
          						Map innerMap = (Map) map.get(Integer.toString(i));
          				%>
            					<div class="cart-products">
                					<div class="cart-img-container">
                    						<img src="<%= request.getContextPath() %>/images/<%= innerMap.get("product_image") %>" alt="image not found" class="cart-product-img">
                					</div>
                					<div class="cart-product-details">
                    						<h4 class="product-name-cart"><%= innerMap.get("product_name") %></h4>
                    						<p class="mkt"><%= innerMap.get("manufacturer") %></p>
						                <div class="best-price">
						                	<h4 class="best-price-rs-cart">Rs. <%= innerMap.get("price") %></h4>
						                </div>
                    						<div class="mrp-container">
                        						<p class="mrp">Rs. <%= innerMap.get("mrp") %></p>
						                        <% 
						                        	BigDecimal originalPrice = (BigDecimal) innerMap.get("mrp");
						                        	BigDecimal discountPercentage = (BigDecimal) innerMap.get("price");
						                        %>
                        						<p>save Rs. <%= originalPrice.subtract(discountPercentage) %></p>
                    						</div>
                    						<h5>Delivery between June 10-June 11</h5>
                					</div>
                					<div>
                    						<input type="button" id="cart-remove" onclick="ajaxRequest.removeFromCart(<%= innerMap.get("cartId") %>)">
                					</div>
                					<div class="clr"></div>
            					</div>
	   					<%	}	%>
					        <a href="<%= request.getContextPath() %>" class="add-more-redirect">
							<div class="add-more">
					                	<h4>ADD MORE ITEMS</h4>
					                	<h4 class="add-more-right">+</h4>
					        	</div>
	            				</a>
	        			</div>
	        		</div>
	        
	      			<div class="right-container">
		      		<%
		      			Map innerSecond = (Map) map.get("secondMap");
		      		%>
			        <h3 class="lc-heading">PAYMENT DETAILS</h3>
			        <div class="payment-details">
			        	<h4>MRP Total</h4>
			                <h4 class="rs">Rs <%= innerSecond.get("orignalPrice") %></h4>
			        </div>
			        <div class="payment-details">
			                <h4>Additional Discount</h4>
			                <h4 class="rs">- Rs <%= innerSecond.get("save") %></h4>
			        </div>
			        <div class="payment-details">
			                <h4>Total Amount</h4>
			                <h4 class="rs">Rs <%= innerSecond.get("discountPrice") %></h4>
			        </div>
			        <div class="payment-details">
			                <h4>Shipping / Delivery Charges</h4>
			                <h4 class="rs">Rs 40.00</h4>
			        </div>
			    	<%
					BigDecimal totalPay = (new BigDecimal("40")).add((BigDecimal)innerSecond.get("discountPrice"));
			    	%>
			        <div class="payment-details" id="total-payable"> 
			                <h4>Total Payable</h4>
			                <h4 class="rs">Rs <%= totalPay %></h4>
			        </div>
			        <div class="payment-details" id="total-saving">
			                <h4>Total Savings</h4>
			                <h4 class="rs">Rs <%= innerSecond.get("save") %></h4>
			        </div>
			        <div class="pay-detail-footer">
			                <div>
			                    	<p>Total Payable</p>
			                    	<h2>Rs <%= totalPay %></h2>
			                </div>
			                <div id="proceed-btn-container">
			                    	<a href="<%= request.getContextPath() %>/jsp/order.jsp" class="proceed-btn">PROCEED</a>
			                </div>
			        </div>
			</div>
			<div class="clr"></div>
		</div>
	 </div>
	<% 	} 	%>
</body>
</html>
