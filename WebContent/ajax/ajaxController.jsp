<%@page import="com.google.gson.JsonObject"%>
<%@page import="java.util.List"%>
<%@page import="com.naaptol.netmeds.utility.JsonParser"%>
<%@page import="com.naaptol.netmeds.helper.Helper"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.LinkedHashMap"%>
<%!
	private String execute(HttpServletRequest req,HttpServletResponse res)
	{
	  String requestIdentifier = req.getParameter("requestIdentifier");
	  
	  if("addToCartRequest".equals(requestIdentifier))
	  {		
		  String productId = req.getParameter("productId");
		  String whoLoggedIn = req.getParameter("whoLoggedIn");
		  return JsonParser.getJsonString((Helper.getAddToCartProduct(productId, whoLoggedIn)));
	  }
	  else if("removeFromCartRequest".equals(requestIdentifier))
	  {
		  String cartId = req.getParameter("cartId");
		  String whoLoggedIn = req.getParameter("whoLoggedIn");
		  return Helper.removeFromCart(cartId, whoLoggedIn);
	  }
	  else if("getProductsByCategoryRequest".equals(requestIdentifier))
	  {
		  String categoryId = req.getParameter("categoryId");
		  return JsonParser.getJsonString(Helper.getProductsByCategories(categoryId));
	  }
	  else if("getSubCategoryRequest".equals(requestIdentifier))
	  {
		  String categoryId = req.getParameter("categoryId");
		  Long number = Long.valueOf(categoryId);
		  List li = (List ) Helper.getCategories(number);
		  return JsonParser.getJsonString(li);
	  }
	  else if("checkCategoryRequest".equals(requestIdentifier))
	  {
		  String category = req.getParameter("category");
		  return Helper.checkCategory(category);
	  }
	  else if("checkCityRequest".equals(requestIdentifier))
	  {
		  String city = req.getParameter("city");
		  return Helper.checkCity(city);
	  }
	  else if("checkStateRequest".equals(requestIdentifier))
	  {
		  String state = req.getParameter("state");
		  return Helper.checkState(state);
	  }
	  else if("checkSubCategoryRequest".equals(requestIdentifier))
	  {
		  String subcategory = req.getParameter("subcategory");
		  return Helper.checkSubCategory(subcategory);
	  }
	  else if("getProductsByCategoryNameRequest".equals(requestIdentifier))
	  {
		  String productName = req.getParameter("productName");
		  return JsonParser.getJsonString(Helper.getProductsByName(productName));
	  }
	  else if("getCityNameByStateRequest".equals(requestIdentifier))
	  {
		  String stateName = req.getParameter("stateName");
		  return JsonParser.getJsonString(Helper.getAllCities(stateName));
	  }
	  else if("placeOrderRequest".equals(requestIdentifier))
	  {
		  String whoLoggedIn = req.getParameter("whoLoggedIn"); 
		  String modeOfPayment = req.getParameter("modeOfPayment");
		  return JsonParser.getJsonString(Helper.placeOrder(whoLoggedIn, modeOfPayment));
	  }
	  else if("addCategoryRequest".equals(requestIdentifier))
	  {
		  String category = req.getParameter("category");
		  return JsonParser.getJsonString(Helper.addCategory(category));
	  }
	  else if("addSubCategoryRequest".equals(requestIdentifier))
	  {
		  String subcategory = req.getParameter("subcategory");
		  String mainCategory = req.getParameter("mainCategory");
		  return JsonParser.getJsonString(Helper.addCategory(subcategory, mainCategory));
	  }
	  else if("addStateRequest".equals(requestIdentifier))
	  {
		  String state = req.getParameter("state");
		  return JsonParser.getJsonString(Helper.addState(state));
	  }
	  else if("addCityRequest".equals(requestIdentifier))
	  {
		  String state = req.getParameter("state");
		  String city = req.getParameter("city");
		  return JsonParser.getJsonString(Helper.addCity(city, state));
	  }
	  else if("checkMailRequest".equals(requestIdentifier))
	  {
		  String emailId = req.getParameter("emailId");
		  return JsonParser.getJsonString(Helper.checkEmailId(emailId));
	  }
	  
	  return "";
	}
%>
<%= execute(request,response) %>
	
