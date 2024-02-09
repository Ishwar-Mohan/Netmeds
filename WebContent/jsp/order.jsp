<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.naaptol.netmeds.utility.JsonParser"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.naaptol.netmeds.helper.Helper"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		else{
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
            <h3 class="lc-heading">PRODUCTS</h3>
            <%
            	Map map = (Map) Helper.getAddToCartAllProducts((SessionMap.get("customerId").toString()));
          		for(int i = 1; i<= map.size()-1; i++)
          		{
          			Map innerMap = (Map) map.get(Integer.toString(i));
          	%>
            <div  class="cart-products">
                <div class="delivery-estimate">
                    <p>Delivery Estimate</p>
                    <h5>12-June-2023</h5>
                </div>
                <div class="cart-img-container">
                    <img src="<%= request.getContextPath() %>/images/<%= innerMap.get("product_image") %>" alt="image not found"
                        class="cart-product-img">
                </div>
                <div class="cart-product-details">
                    <h4 class="product-name-cart"><%= innerMap.get("product_name") %></h4>
                    <p class="mkt">MKT: <%= innerMap.get("manufacturer") %></p>
                    <div class="best-price">
                        <h4 class="best-price-rs-cart" id="price">Rs. <%= innerMap.get("price") %></h4>
                    </div>
                    <div class="mrp-container">
                        <p class="mrp">Rs. <%= innerMap.get("mrp") %></p>
                        <% 
                        	BigDecimal originalPrice = (BigDecimal) innerMap.get("mrp");
                        	BigDecimal discountPercentage = (BigDecimal) innerMap.get("price");
                        %>
                        <p>save Rs. <%= originalPrice.subtract(discountPercentage) %></p>
                    </div>
                </div>
                <div class="clr"></div>
            </div>
            <%
          		}
   			%>
        </div>
        <div  class="left-container-inner">
            <div class="dil-address-heading">
                <h3>DELIVERY ADDRESS</h3>
                <a href="#" class="select-address" id="select-address">SELECT ADDRESS</a>
            </div>
            <% Map addressMap = (Map) Helper.getAddressOfWhoesLogin((SessionMap.get("customerId").toString())); %>
            <h4 class="o-full-name"><%= addressMap.get("first-name") %> <%= addressMap.get("last-name") %></h4>
            <p class="o-address"><%= addressMap.get("address") %></p>
            <% if(addressMap.get("landmark") != null) { %>
            <p class="o-landmark"><%= addressMap.get("landmark") %></p>
            <% } %>
            <p class="o-city"><%= addressMap.get("city") %> - <%= addressMap.get("pincode") %>, <%= addressMap.get("state") %></p>
            <p class="o-number"><%= addressMap.get("number") %></p>
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
                <h4 class="rs" id="discountPrice">Rs <%= innerSecond.get("discountPrice") %></h4>
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
                    <a href="<%= request.getContextPath() %>/jsp/payment.jsp" class="proceed-btn" id="pay-btn">PROCEED</a>
                </div>
            </div>
        </div>
        <div class="clr"></div>
    </div>
    
    <div class="login-form" id="address-form">
    	 <a class="cros" id="cros">&times;</a>
        <form id="change-address-form" action="<%= request.getContextPath() %>/ServletController" method="post">
        	<input name="requestType" type="hidden" value="changeAddressRequest">
        	<input name="customerId" type="hidden" value="<%= SessionMap.get("") %>">
            <label id="r-label">Address</label>
            <div class="l-fields">
                <label class="login-labels">FIRST NAME</label>
                <input type="text" class="r-text-box" placeholder="Enter your First Name*" id="first-name" name="first-name" onblur="validateRegistration.firstName();" oninput="validateRegistration.firstNameRegEx();" maxlength="20" value="<%= SessionMap.get("first-name") %>">
                <div class="error" id="errFirstName"></div>
            </div>
            <div class="l-fields">
                <label class="login-labels">LAST NAME</label>
                <input type="text" class="r-text-box" placeholder="Enter your Last Name" id="last-name" name="last-name" onblur="validateRegistration.lastName();" oninput="validateRegistration.lastNameRegEx();" maxlength="20" value="<%= SessionMap.get("last-name") %>">
                <div class="error" id="errLastName" maxlength="20"></div>
            </div>
            <div class="l-fields">
                <label class="login-labels">ADDRESS</label>
                <input type="text" class="r-text-box" placeholder="Enter your Address" id="address" name="address" onblur="validateRegistration.address();" maxlength="60">
                <div class="error" id="errAddress" maxlength="20"></div>
            </div>
            <div class="l-fields">
                <label class="login-labels">State</label>
                <select class="r-text-box-cs" id="state" name="state" onchange="validateRegistration.checkState();ajaxRequest.getCityNameByState(this.value)">
                    <option value="0">Select State</option>
                    <%
                         Map stateMapO = (Map) Helper.getAllStates();
                         for(int i=0; i< stateMapO.size(); i++){
                             Map stateMap = (Map) stateMapO.get(Integer.toString(i));
                    %>
                    <option value="<%= stateMap.get("stateName") %>"><%= stateMap.get("stateName") %></option>
                    <% } %>
               </select>
            </div>
            <div class="l-fields">
                <label class="login-labels">City</label>
                <select class="r-text-box-cs" id="city-r" name="city-r" onchange="validateRegistration.checkCity()">
                     <option value="0">Select City</option>
                </select>
                <div class="error" id="errCity"></div>
            </div>
            <div class="l-fields">
                <label class="login-labels">LANDMARK</label>
                <input type="text" class="r-text-box" placeholder="Enter your Landmark" id="landmark" name="landmark" maxlength="20">
                <div class="error" id="errLandmark" maxlength="20"></div>
            </div>
            <div class="l-fields">
                <label class="login-labels">PHONE NUMBER</label>
                <input type="text" class="r-text-box" placeholder="Mobile Number*" id="mobile-number" name="mobile-number" onblur="validateRegistration.mobileNumber();" oninput="validateRegistration.mobileNumberRegEx();" maxlength="10">
                    <div class="error" id="errMobNumber"></div>
            </div>
            <input type="button" value="SAVE ADDRESS" class="btn" onclick="validateRegistration.onChangeAddress();">
        </form>
    </div>
    
    <div class="overlay"></div>
    <% } %>
    <script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
    <script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</body>
</html>