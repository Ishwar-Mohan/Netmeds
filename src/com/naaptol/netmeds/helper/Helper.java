package com.naaptol.netmeds.helper;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naaptol.netmeds.dao.DisplayDao;
import com.naaptol.netmeds.dao.LoginDao;
import com.naaptol.netmeds.dao.RegisterDao;
import com.naaptol.netmeds.pojo.HbmNetmedsAddress;
import com.naaptol.netmeds.pojo.HbmNetmedsCustomer;
import com.naaptol.netmeds.pojo.HbmNetmedsProduct;

public class Helper 
{
	public static void LoginCredentials(HttpServletRequest req, HttpServletResponse res) 
	{
		try
		{
			String loginAs = req.getParameter("whoesLogin");
			String userId = req.getParameter("userId");
			String password = req.getParameter("login-password");
			
			if("Y".equals(loginAs))
			{
				Map map = LoginDao.LoginAsAdmin(userId);
				
				if(map != null)
				{
					String DbUname = (String) map.get("admin_userId");
					String DbPassL = (String) map.get("admin_password");
					
					HttpSession session= req.getSession();
					
					if (userId.equals(DbUname) && password.equals(DbPassL)) 
					{
						session.setAttribute("map",map);
						res.sendRedirect("jsp/adminPanel.jsp");
						System.out.println("Login Sucessful Admin..!!");
					}
					else
					{
						res.sendRedirect("jsp/signUp.jsp");
					}
				}
			}
			else if("N".equals(loginAs))
			{
				Map map = LoginDao.LoginQuery(userId);
		
				if(map != null)
				{
					String DbUname = (String) map.get("email");
					String DbPassL = (String) map.get("password");
				
					HttpSession session= req.getSession();
				
					if (userId.equals(DbUname) && password.equals(DbPassL)) 
					{
						session.setAttribute("map",map);
						res.sendRedirect(req.getContextPath());
						System.out.println("Login Sucessful..!!");
					}
					else
					{
						res.sendRedirect(req.getContextPath()+"/jsp/signUp.jsp");
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static boolean registerCredentials(HttpServletRequest req) 
	{
		Map map = new LinkedHashMap();
		
		map.put("first-name", req.getParameter("first-name"));
		map.put("last-name", req.getParameter("last-name"));
		map.put("emailId", req.getParameter("emailId"));
		map.put("mobile-number", req.getParameter("mobile-number"));
		map.put("address", req.getParameter("address"));
		map.put("state", req.getParameter("state"));
		map.put("city", req.getParameter("city"));
		map.put("pincode", req.getParameter("pincode-r"));
		map.put("password", req.getParameter("password"));
		
		return RegisterDao.RegisterQuery(map);
	}
	
	public static List getAllProductDetails() 
	{
		return DisplayDao.getAllProducts();
	}
	
	public static List getMainCategory() 
	{
		return DisplayDao.getMainCategories();
	}
	
	public static Map getAddToCartProduct(String productId, String whoLoggedIn)
	{
		return DisplayDao.addToCartProducts(productId, whoLoggedIn);
	}
	
	public static Map getAddToCartAllProducts(String customerId)
	{
		return DisplayDao.addToCartProductsDetails(customerId);
	}
	
	public static List getSubCategories()
	{
		return DisplayDao.getSubCategories();
	}
	
	public static List getCategories(Long productId)
	{
		return DisplayDao.getCategories(productId);
	}
	
	public static Map getAllStates()
	{
		return DisplayDao.getStates();
	}
	
	public static Map getAllCities(String stateName)
	{
		return DisplayDao.getCities(stateName);
	}
	
	public static Map getProductsByCategories(String categoryId)
	{
		return DisplayDao.getProductsByCategory(categoryId);
	}
	
	public static Map getProductsByName(String productName)
	{
		return DisplayDao.getProductsByName(productName);
	}
	
	public static Map getAddressOfWhoesLogin(String whoesLogin)
	{
		return DisplayDao.getAddress(whoesLogin);
	}
	
	public static Long getAddToCartProductsCount(String customerId)
	{
		return DisplayDao.addToCartProductsCount(customerId);
	}
	
	public static String checkCategory(String category)
	{
		return DisplayDao.getCategories(category);
	}
	
	public static String checkSubCategory(String subCategory)
	{
		return DisplayDao.getSubCategories(subCategory);
	}
	
	public static String checkCity(String city)
	{
		return DisplayDao.getCity(city);
	}
	
	public static String checkState(String state)
	{
		return DisplayDao.getState(state);
	}
	
	public static String checkEmailId(String mail)
	{
		return DisplayDao.checkEmail(mail);
	}
	
	public static String addCategory(String category)
	{
		return DisplayDao.addCategory(category);
	}
	
	public static String addState(String state)
	{
		return DisplayDao.addState(state);
	}
	
	public static String addCategory(String category, String mainCategory)
	{
		return DisplayDao.addSubCategories(category, mainCategory);
	}
	
	public static String addCity(String city, String state)
	{
		return DisplayDao.addCity(city, state);
	}
	
	public static Map placeOrder(String whoLoggedIn, String modeOfPayment)
	{
		boolean flag = DisplayDao.placeOrderDetails(whoLoggedIn, modeOfPayment);
		if(flag == true){
			return DisplayDao.getOrderDetails(whoLoggedIn);
		}
		return null;
	}
	
	public static String removeFromCart(String cartId, String whoLoggedIn)
	{
		boolean flag = DisplayDao.removeFromCartProducts(cartId, whoLoggedIn);
		if(flag == true)
			return "sucess";
		return "";
	}

	public static boolean addProductByAdmin(HttpServletRequest req)
	{
		Map map = new LinkedHashMap();
		map.put("product-name", req.getParameter("product-name"));
		map.put("manufacturer", req.getParameter("manufacturer"));
		map.put("product-image", req.getParameter("product-image"));
		map.put("product-mrp", new BigDecimal(req.getParameter("product-mrp")));
		map.put("product-price", new BigDecimal(req.getParameter("product-price")));
		map.put("stock", Integer.valueOf(req.getParameter("stock")));
		
		return DisplayDao.addProductsByAdmin(map, req.getParameter("main-category"), req.getParameter("sub-category-p"));
	}

	public static boolean changeAddress(HttpServletRequest req) 
	{
		HbmNetmedsAddress hbmNetmedsAddress = new HbmNetmedsAddress();
		HbmNetmedsCustomer hbmNetmedsCustomer = new HbmNetmedsCustomer();
		
		hbmNetmedsCustomer.setFirstName(req.getParameter("first-name"));
		hbmNetmedsCustomer.setLastName(req.getParameter("last-name"));
		hbmNetmedsCustomer.setMobileNumber(req.getParameter("mobile-number"));
		
		hbmNetmedsAddress.setAddress(req.getParameter("address"));
		hbmNetmedsAddress.setState(req.getParameter("state"));
		hbmNetmedsAddress.setCity(req.getParameter("city-r"));
		hbmNetmedsAddress.setLandmark(req.getParameter("landmark"));
		return DisplayDao.changeAddress(hbmNetmedsCustomer, hbmNetmedsAddress);
	}
	
}
