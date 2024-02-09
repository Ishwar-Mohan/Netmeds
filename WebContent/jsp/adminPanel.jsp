<%@page import="java.util.List"%>
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
	<input name="contextPath" id="contextPath" type="hidden" value="<%= request.getContextPath() %>">
	<% 	
		Map map = (Map) session.getAttribute("map");
		String loggedInUser = (map != null && map.containsKey("first-name")) ? (String) map.get("first-name") : null;
		if(loggedInUser == null)
			response.sendRedirect(request.getContextPath()+"/jsp/netmeds.jsp");
		else
		{
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
		                    	<input type="text" placeholder="Search for medicine & wellness products..." id="search-bar">
		                    	<div class="clr"></div>
		                </div>
		                <div class="whoes-login">
		                    	<h4>
		                    	<% if (loggedInUser != null) { %>
		            			Hi <%= loggedInUser %>
		        		<% } %>
		                    	</h4>
		                </div>
		                <% if (loggedInUser == null) { %>
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
		                 <% }else{ %>
		                    	<a href="<%= request.getContextPath() %>/jsp/logout.jsp" class="logout-btn">
		                		Logout
		                	</a>
		                <% } %>
		                <div class="clr"></div>
		            </nav>
		</header>
	</div>
	<div class="admin-func-container">
		<div class="add-category-form">
			<label id="r-label">Add Category</label>
			<div class="l-fields">
				<label class="login-labels">Category Name</label>
				<input type="text" class="p-text-box" placeholder="Enter category name*" id="category" maxlength="20" oninput="ajaxRequest.checkCategory()">
				<div class="error" id="errCategoryPresent"></div>
			</div>
			<input type="button" value="Add Category" class="btn" id="c-btn" onclick="ajaxRequest.addCategory()">
			<hr>
		</div>
		<div class="add-category-form">
			<label id="r-label">Add Sub-Category</label>
			<div class="l-fields">
				<label class="login-labels">Category</label><br>
				<select class="r-text-box" id="main-category-add" onchange="ajaxRequest.getSubCategoryNames(this.value)">
					<option value="0">Select Category</option>
					<% 
						List mainCategoryList = (List) Helper.getMainCategory();
						for(int i=0; i < mainCategoryList.size(); i++){
							Map mainCategory = (Map) mainCategoryList.get(i);
					%>
					<option value="<%= mainCategory.get("categoryId") %>"><%= mainCategory.get("categoryName") %></option>
					<%
						}
					%>
				</select>
			</div>
			<div class="l-fields">
				<label class="login-labels">Sub-Category Name</label>
				<input type="text" class="p-text-box" placeholder="Enter sub-category name*" id="sub-category" maxlength="20" oninput="ajaxRequest.checkSubCategory()">
				<div class="error" id="errSubCategoryPresent"></div>
			</div>
			<input type="button" value="Add Sub-Category" class="btn" id="c-btn" onclick="ajaxRequest.addSubCategory()">
			<hr>
		</div>
		<div class="add-category-form">
			<label id="r-label">Add State</label>
			<div class="l-fields">
				<label class="login-labels">State Name</label>
				<input type="text" class="p-text-box" placeholder="Enter state name*" id="state" maxlength="20" oninput="ajaxRequest.checkState()">
				<div class="error" id="errStatePresent"></div>
			</div>
			<input type="button" value="Add State" class="btn" id="c-btn" onclick="ajaxRequest.addState()">
			<hr>
		</div>
		<div class="add-category-form">
				<label id="r-label">Add City</label>
				<div class="l-fields">
				<label class="login-labels">Select State</label>
				<select class="r-text-box" id="state-add" name="state" onchange="validateRegistration.checkState();ajaxRequest.getCityNameByState(this.value)">
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
				<label class="login-labels">City Name</label>
				<input type="text" class="p-text-box" placeholder="Enter city name*" id="city" maxlength="20" oninput="ajaxRequest.checkCity()">
				<div class="error" id="errCityPresent"></div>
			</div>
			<input type="button" value="Add City" class="btn" id="c-btn" onclick="ajaxRequest.addCity()">
			<hr>
		</div>
	</div>
	<div class="signUp-container" id="admin-product-add">
		<div class="signupbg-img">
			<img src="<%= request.getContextPath() %>/images/signupbg.png" alt="image not found" id="signupbg-img">
		</div>
		<div class="login-form" id="product-add-container">
			<form id="add-product-form" action="<%= request.getContextPath() %>/ServletController" method="post">
				<input name="requestType" type="hidden" value="addProductRequest">
				<input type="hidden" value="<%= map.get("customerId") %>" name="whoLoggedIn" id="whoLoggedIn">
				<label id="r-label">Add Product</label>
				<div class="l-fields">
					<label class="login-labels">Product Name</label>
					<input type="text" class="r-text-box" placeholder="Enter product name*" id="product-name" name="product-name" maxlength="20" onblur="validateProductAdd.checkProductName()">
					<div class="error" id="product-name-err"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Manufacturer</label>
					<input type="text" class="r-text-box" placeholder="Enter manufacturer*" id="manufacturer" name="manufacturer" maxlength="20" onblur="validateProductAdd.checkProductMfg()">
					<div class="error" id="manufacturer-err" maxlength="20"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Product Image</label>
					<input type="file" class="r-text-box" placeholder="Add Product name*" id="product-image" name="product-image" maxlength="20">
					<div class="error" id="product-image-err" maxlength="30"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Product MRP</label>
					<input type="text" class="r-text-box" placeholder="Enter MRP*" id="product-mrp" name="product-mrp" maxlength="20" onblur="validateProductAdd.checkProductMrp()" oninput="validateProductAdd.checkregEx(this)">
					<div class="error" id="product-mrp-err" maxlength="7"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Product Price</label>
					<input type="text" class="r-text-box" placeholder="Enter price*" id="product-price" name="product-price" maxlength="20" onblur="validateProductAdd.checkProductPrice()" oninput="validateProductAdd.checkregEx(this)">
					<div class="error" id="product-price-err" maxlength="7"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Stock</label>
					<input type="text" class="r-text-box" placeholder="Enter stock*" id="stock" name="stock" maxlength="3" onblur="validateProductAdd.checkProductStock()" oninput="validateProductAdd.checkregEx(this)">
					<div class="error" id="stock-err" maxlength="7"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Category</label><br>
					<select class="r-text-box" id="main-category" name="main-category" onchange="ajaxRequest.getSubCategoryNames(this.value)" onblur="validateProductAdd.checkCategory()">
						<option value="0">Select Category</option>
						<% 
							List mainCategoryList1 = (List) Helper.getMainCategory();
							for(int i=0; i < mainCategoryList1.size(); i++){
								Map mainCategory = (Map) mainCategoryList1.get(i);
						%>
						<option value="<%= mainCategory.get("categoryId") %>"><%= mainCategory.get("categoryName") %></option>
						<%
							}
						%>
					</select>
					<div class="error" id="cat-err" maxlength="20"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Sub-Category</label><br>
					<select class="r-text-box" id="sub-category-p" name="sub-category-p" onblur="validateProductAdd.checkSubCategory()">
						<option value="0">Select Sub-Category</option>
					</select>
					<div class="error" id="sub-cat-err" maxlength="20"></div>
				</div>
				<div class="l-fields">
					<label class="login-labels">Description</label>
					<input type="text" class="r-text-box" placeholder="Enter description*" id="desc" name="desc" maxlength="20">
					<div class="error" id="desc-err" maxlength="20"></div>
				</div>
				<input type="button" value="Add PRODUCT" class="btn" id="p-btn" onclick="validateProductAdd.addProductCredential()">
				<hr>
			</form>
		</div>
		<div class="clr"></div>
	</div>
	<% 	} 	%>
	<script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
	<script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</body>
</html>
