<%@page import="java.util.Map"%>
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
	Map SessionMap = (Map) session.getAttribute("map");
	String loggedInUser = (SessionMap != null && SessionMap.containsKey("first-name")) ? (String) SessionMap.get("first-name") : null;

	if(loggedInUser == null)
		response.sendRedirect(request.getContextPath()+"/jsp/netmeds.jsp");
	else
	{
%>
	<input name="contextPath" id="contextPath" type="hidden" value="<%= request.getContextPath() %>">
	<input type="hidden" value="<%= SessionMap.get("customerId") %>" name="whoLoggedIn" id="whoLoggedIn">
	<div class="main-container-header">
		<header class="header">
		        <nav class="upper-nav">
		                <a href="<%= request.getContextPath() %>/jsp/netmeds.jsp" id="logo-o">
		                    	<div class="logo-container">
		                        	<img src="<%= request.getContextPath() %>/images/logo.png" alt="image not found">
		                    	</div>
		                </a>
		                <a href="<%= request.getContextPath() %>/jsp/logout.jsp" class="logout-btn">
		                	Logout
		                </a>
		        </nav>
	        </header>
     	</div>

    	<div class="add-to-cart-container">
        	<div class="order-review">
            		<h2 class="order-label">Order Review</h2>
            		<div class="right-header">
                		<a href="<%= request.getContextPath() %>/jsp/addToCart.jsp" class="redirect-order">
                    			<div class="left-header-ele">
                        			<img src="<%= request.getContextPath() %>/images/shopping-cart-added-white.png" alt="image not found" class="order-review-imgs">
                        			<p>Your Cart</p>
                    			</div>
                		</a>
                		<hr class="hr-order">
                		<a href="<%= request.getContextPath() %>/jsp/order.jsp" class="redirect-order">
                    			<div class="left-header-ele">
                        			<img src="<%= request.getContextPath() %>/images/order-in-process-white.png" alt="image not found" class="order-review-imgs">
                        			<p>Order Review</p>
                    			</div>
                		</a>
                		<hr class="hr-order">
                		<a href="<%= request.getContextPath() %>/jsp/payment.jsp"  class="redirect-order">
                    			<div class="left-header-ele">
                        			<img src="<%= request.getContextPath() %>/images/rupee_white_icon.png" alt="image not found" class="order-review-imgs">
                        			<p>Payment Details</p>
                    			</div>
                		</a>
                		<div class="clr"></div>
            		</div>
            		<div class="clr"></div>
        	</div>
        	<div class="left-container">
        		<div class="left-container-inner">
            			<label class="payment-labels">PREFERD PAYMENT</label>
            			<div  class="payment-modes">
                			<div class="pay">
                    			<img src="<%= request.getContextPath() %>/images/Paytm_logo.png" alt="image not found" class="pay-mode-imgs">
                		</div>
                		<p class="pay" id="pay-mode">Paytm</p>
                		<input type="radio" class="chk-box-pay" name="payment-mode-option" value="Paytm UPI">
                		<div class="clr"></div>
            		</div>
        	</div>

        	<div class="left-container-inner">
            		<label class="payment-labels">UPI</label>
            		<div  class="payment-modes">
                		<div class="pay">
                    			<img src="<%= request.getContextPath() %>/images/gpay_logo.png" alt="image not found" class="pay-mode-imgs">
                		</div>
                		<p class="pay" id="pay-mode">GPay</p>
                		<input type="radio" class="chk-box-pay" name="payment-mode-option" value="GPay UPI">
                		<div class="clr"></div>
            		</div>
        	</div>

        	<div class="left-container-inner">
            		<label class="payment-labels">UPI</label>
            		<div  class="payment-modes">
                		<div class="pay">
                    			<img src="<%= request.getContextPath() %>/images/Phone_Pay_logo.png" alt="image not found" class="pay-mode-imgs">
                		</div>
                		<p class="pay" id="pay-mode">PhonePe</p>
                		<input type="radio" class="chk-box-pay" name="payment-mode-option" value="PhonePe UPI">
                		<div class="clr"></div>
            		</div>
        	</div>

        	<div class="left-container-inner">
            		<label class="payment-labels">OTHER PAYMENTS</label>
            		<div  class="payment-modes">
                		<div class="pay">
                    			<img src="<%= request.getContextPath() %>/images/pay_cod.png" alt="image not found" class="pay-mode-imgs">
                		</div>
                		<p class="pay" id="pay-mode">Cash on Delivery</p>
                		<input type="radio" class="chk-box-pay" name="payment-mode-option" value="Cash on Delivery (COD)">
                		<div class="clr"></div>
            		</div>
        	</div>
    	</div>

        <div class="right-container">
            	<h3 class="lc-heading">PAYMENT DETAILS</h3>
            	<div class="payment-details">
                	<h4>MRP Total</h4>
                	<h4 class="rs">Rs 120.00</h4>
            	</div>
            	<div class="payment-details">
                	<h4>Additional Discount</h4>
                	<h4 class="rs">- Rs 6.00</h4>
            	</div>
            	<div class="payment-details">
                	<h4>Total Amount</h4>
                	<h4 class="rs">Rs 114.00</h4>
            	</div>
            	<div class="payment-details">
                	<h4>Shipping / Delivery Charges</h4>
                	<h4 class="rs">Rs 120.00</h4>
            	</div>
            	<div class="payment-details" id="total-payable">
                	<h4>Total Payable</h4>
                	<h4 class="rs">Rs 213.00</h4>
            	</div>
            	<div class="payment-details" id="total-saving">
                	<h4>Total Savings</h4>
                	<h4 class="rs">Rs 6.00</h4>
            	</div>
            	<div class="pay-detail-footer">
        		<div>
                    		<p>Total Payable</p>
                    		<h2>Rs 213.00</h2>
                	</div>
                	<div id="proceed-btn-container">
                    		<a href="#" class="proceed-btn" id="pay-btn" onclick='ajaxRequest.placeOrder()'>PAY</a>
                	</div>
            	</div>
        	<div class="clr"></div>
	</div>

	<div class="order-placed">
	    	<a class="cros" id="cros-order">&times;</a>
	        <div class="order-placed-img">
	            	<img src="<%= request.getContextPath() %>/images/orderPlaced.png" alt="image not found" id="placed-order-img"> 
	        </div>
	        <h2>Your Order has been Placed..!!</h2>
	        <div class="order-details">
	            	<div><label class="login-labels" id="order-n"></label></div>
	            	<div><label class="login-labels">Shipping Address</label><p id="address-shipping"></p></div>
	            	<div><label class="login-labels">Order Id</label><p id="order-id"></p></div>
	            	<div><label class="login-labels">Total Price</label><p id="total-price-order">41526</p></div>
	        </div>
	</div>
	
	<div class="overlay"></div>
	<% 	}	%>
	<script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
	<script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</body>
</html>
