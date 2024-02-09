<%@page import="java.util.Map"%>
<%@page import="com.naaptol.netmeds.pojo.HbmNetmedsProduct"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.naaptol.netmeds.helper.Helper"%>
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
	<input name="contextPath" id="contextPath" type="hidden" value="<%= request.getContextPath() %>">
    <div class="main-container">
    	<jsp:include page="/jsp/header.jsp"></jsp:include>
        <div class="lower-nav-container">
            <nav class="lower-nav">
                <a href="#" class="lower-nav-ele" id="medicine">
                    <div class="categary-img-container">
                        <img src="<%= request.getContextPath() %>/images/medicine.png" alt="image not found" class="categary-img">
                    </div>
                    <p class="categary-name">Medicines</p>
                    <div class="sub-categary-section">
                        <% 
            				List liMedicine = (List) Helper.getCategories(Long.valueOf(1)); 
            				for(int i=0; i < liMedicine.size(); i++){
            					Map map = (Map) liMedicine.get(i);
            			%>
            			<p onclick="ajaxRequest.getProducts(<%= map.get("categoryId") %>)" id="<%= map.get("categoryName") %>"><%= map.get("categoryName") %></p>
            			<%
            				}
            			%>
                    </div>
                    <div class="clr"></div>
                </a>
                <a href="#" class="lower-nav-ele" id="wellness">
                    <div class="categary-img-container">
                        <img src="<%= request.getContextPath() %>/images/storefront.png" alt="image not found" class="categary-img">
                    </div>
                    <p class="categary-name">Wellness</p>
                    <div class="sub-categary-section-w">
                        <% 
            				List liWellness = (List) Helper.getCategories(Long.valueOf(2)); 
            				for(int i=0; i < liWellness.size(); i++){
            					Map map = (Map) liWellness.get(i);
            			%>
            			<p onclick="ajaxRequest.getProducts(<%= map.get("categoryId") %>)" id="<%= map.get("categoryName") %>"><%= map.get("categoryName") %></p>
            			<%
            				}
            			%>
                    </div>
                    <div class="clr"></div>
                </a>
                <a href="#" class="lower-nav-ele" id="beauty">
                    <div class="categary-img-container">
                        <img src="<%= request.getContextPath() %>/images/wellness.png" alt="image not found" class="categary-img">
                    </div>
                    <p class="categary-name">Beauty</p>
                    <div class="sub-categary-section-b">
                        <% 
            				List liBeauty = (List) Helper.getCategories(Long.valueOf(3)); 
            				for(int i=0; i < liBeauty.size(); i++){
            					Map map = (Map) liBeauty.get(i);
            			%>
            			<p onclick="ajaxRequest.getProducts(<%= map.get("categoryId") %>)" id="<%= map.get("categoryName") %>"><%= map.get("categoryName") %></p>
            			<%
            				}
            			%>
                    </div>
                    <div class="clr"></div>
                </a>
                <div class="clr"></div>
            </nav>
        </div>
        <!-- header end -->
     <div class="netmeds-lower-container">
        <div class="categary-section">
            <div><H3>Categories</H3></div>
            <% 
            	List lih = (List) Helper.getSubCategories(); 
            	for(int i=0; i < lih.size(); i++){
            		Map map = (Map) lih.get(i);
            %>
            <div><H4 onclick="ajaxRequest.getProducts(<%= map.get("categoryId") %>)" id="<%= map.get("categoryName") %>"><%= map.get("categoryName") %></H4></div>
            <%
            	}
            %>
        </div>
        <div class="container">
            <div class="all-product-label">
                <h4 id="product-cat-heading">ALL PRODUCTS</h4>
            </div>
            <div class="all-product-container" id="all-product-container">
            <%
            	List result = Helper.getAllProductDetails();
				Iterator iterator = result.iterator();
	 		
	 			while (iterator.hasNext())
	 			{
	 				HbmNetmedsProduct hbmNetmedsProduct = (HbmNetmedsProduct) iterator.next();
            %>
                <div class="product-cart">
                	<%-- <input name="productId" id="productId" type="hidden" value="<%= hbmNetmedsProduct.getProductId() %>"> --%>
                    <div class="product-img-container">
                        <img src="<%= request.getContextPath() %>/images/<%= hbmNetmedsProduct.getProductImages() %>" alt="image not found">
                    </div>
                    <h4 class="product-name"><%= hbmNetmedsProduct.getProductName() %></h4>
                    <p class="mkt">MKT: <%= hbmNetmedsProduct.getManufacturer() %></p>
                    <div class="best-price">
                        <h4>Best price*</h4>
                        <h4 class="best-price-rs">Rs.<%= hbmNetmedsProduct.getPrice() %></h4>
                    </div>
                    <div class="mrp-container">
                        <p>MRP </p><p class="mrp">Rs. <%= hbmNetmedsProduct.getMrp() %></p>
                    </div>
                    <%
                    	Map SessionMap = (Map) session.getAttribute("map");
            			String loggedInUser = (SessionMap != null && SessionMap.containsKey("first-name")) ? (String) SessionMap.get("first-name") : null;
            			if (loggedInUser == null){
            		%>
            		<input type="button" value="ADD TO CART" class="btn" id="addToCart-btn">
            		<% 
            			}else{
                    %>
                    <input type="button" value="ADD TO CART" class="btn" id="addToCart-btn" onclick="ajaxRequest.addToCart(<%= hbmNetmedsProduct.getProductId() %>)">
                    <input type="hidden" value="<%= SessionMap.get("customerId") %>" name="whoLoggedIn" id="whoLoggedIn">
                    <% } %>
                </div>
             <%
	 			}
             %>
            </div>
        </div>
        <div class="clr"></div>
    </div>
    </div>
    <script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
    <script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</body>
</html>