package com.naaptol.netmeds.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.naaptol.netmeds.pojo.HbmNetmedsAddToCart;
import com.naaptol.netmeds.pojo.HbmNetmedsAddress;
import com.naaptol.netmeds.pojo.HbmNetmedsCategory;
import com.naaptol.netmeds.pojo.HbmNetmedsCity;
import com.naaptol.netmeds.pojo.HbmNetmedsCustomer;
import com.naaptol.netmeds.pojo.HbmNetmedsOrder;
import com.naaptol.netmeds.pojo.HbmNetmedsOrdersDetail;
import com.naaptol.netmeds.pojo.HbmNetmedsProduct;
import com.naaptol.netmeds.pojo.HbmNetmedsState;

public class DisplayDao 
{
	public static List getMainCategories()
	{
		List li = new ArrayList();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCategory where fkCategoryId = :fkCategoryId and isActive = :isActive");
	 		query.setParameter("fkCategoryId", Long.valueOf(0));
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
			
	 		int i = 0;
	 		while (iterator.hasNext())
	 		{
	 			Map map = new LinkedHashMap();
	 			HbmNetmedsCategory hbmNetmedsCategory = (HbmNetmedsCategory) iterator.next();
	 			map.put("categoryId", hbmNetmedsCategory.getCategoryId());
	            		map.put("categoryName", hbmNetmedsCategory.getCategoryName());
	 			li.add(map);
	        	}
			
	 		transaction.commit();
	        	return li;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return li;
	}
	
	public static List getSubCategories()
	{
		List li = new ArrayList();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCategory where fkCategoryId != :fkCategoryId and isActive = :isActive");
	 		query.setParameter("fkCategoryId", Long.valueOf(0));
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
			
	 		int i = 0;
	 		while (iterator.hasNext())
	 		{
	 			Map map = new LinkedHashMap();
	 			HbmNetmedsCategory hbmNetmedsCategory = (HbmNetmedsCategory) iterator.next();
	 			map.put("categoryId", hbmNetmedsCategory.getCategoryId());
	            		map.put("categoryName", hbmNetmedsCategory.getCategoryName()); 
	 			li.add(map);
	        	}
			
	 		transaction.commit();
	        	return li;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            	factory.close();
		}
		
		return li;
	}
	
	public static Map getStates()
	{
		Map OuterMap = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsState where isActive = :isActive");
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		int i = 0;
	 		while (iterator.hasNext())
	 		{
	 			HbmNetmedsState hbmNetmedsState = (HbmNetmedsState) iterator.next();
	 			
	 			Map map = new LinkedHashMap();
				map.put("stateId", hbmNetmedsState.getStateId());
				map.put("stateName", hbmNetmedsState.getStateName()); 
				OuterMap.put(Integer.toString(i++), map);
	        	}
			
	 		transaction.commit();
	        	return OuterMap;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return OuterMap;
	}
	
	public static Map getCities(String stateName)
	{
		Map OuterMap = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsState where stateName = :stateName and isActive = :isActive");
	 		query.setParameter("stateName", stateName);
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		HbmNetmedsState hbmNetmedsState = null;
	 		
	 		while (iterator.hasNext())
	 		{
	 			hbmNetmedsState = (HbmNetmedsState) iterator.next();
	 			System.out.println(hbmNetmedsState.getStateId());
	        	}
			
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
	 		Query query2 = session.createQuery("FROM HbmNetmedsCity where hbmNetmedsState = :state and isActive = :isActive");
	 		query2.setParameter("state", hbmNetmedsState);
	 		query2.setParameter("isActive", "Y");
 			List result2 = query2.list();
	 		Iterator iterator2 = result2.iterator();
	 		
	 		int i = 0;
	 		while (iterator2.hasNext())
	 		{
	 			HbmNetmedsCity hbmNetmedsCity = (HbmNetmedsCity) iterator2.next();
	 			Map map = new LinkedHashMap();
	 			map.put("cityId", hbmNetmedsCity.getCityId());
	 			map.put("cityName", hbmNetmedsCity.getCityName()); 
	 			System.out.println(hbmNetmedsCity.getCityName());
				OuterMap.put(Integer.toString(i++), map);
	        	}
			
	 		transaction.commit();
	        	return OuterMap;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return OuterMap;
	}
	
	public static Map getAddressLoginedUser(String customerId)
	{
		Map OuterMap = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsAddress where categoryId = :id and isActive = :isActive");
	 		query.setParameter("id", Long.parseLong(customerId));
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		int i = 0;
	 		while (iterator.hasNext())
	 		{
	 			HbmNetmedsAddress hbmNetmedsAddress = (HbmNetmedsAddress) iterator.next();
	 			
	 			Map map = new LinkedHashMap();
				OuterMap.put(Integer.toString(i++), map);
	        	}
			
	 		transaction.commit();
	        	return OuterMap;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	   	 }
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return OuterMap;
	}
	
	public static List getAllProducts()
	{
		List result = new ArrayList();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsProduct where isActive = :isActive");
	 		query.setParameter("isActive", "Y");
	 		result = query.list();

	 		transaction.commit();
	        	return result;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	   	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return result;
	}
	
	public static Map getProductsByCategory(String categoryId)
	{
		Map OuterMap = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCategory where categoryId = :id and isActive = :isActive");
	 		query.setParameter("id", Long.parseLong(categoryId));
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		int i = 0;
	 		while (iterator.hasNext())
	 		{
	 			HbmNetmedsCategory hbmNetmedsCategory = (HbmNetmedsCategory) iterator.next();
	 			
	 			Set<HbmNetmedsProduct> products =  hbmNetmedsCategory.getHbmNetmedsProductsByCategoryId();
	 			for (HbmNetmedsProduct hbmNetmedsProduct : products) 
	 			{
	 				 Map map = new LinkedHashMap();
	 				 map.put("productId", hbmNetmedsProduct.getProductId());
	 				 map.put("product_name", hbmNetmedsProduct.getProductName()); 
	 				 map.put("description", hbmNetmedsProduct.getDescription()); 
	 				 map.put("manufacturer", hbmNetmedsProduct.getManufacturer());
	 				 map.put("product_image", hbmNetmedsProduct.getProductImages()); 
	 				 map.put("mrp", hbmNetmedsProduct.getMrp()); 
	 				 map.put("price", hbmNetmedsProduct.getPrice());
	 				 map.put("stock", hbmNetmedsProduct.getStock()); 
	 				 map.put("price", hbmNetmedsProduct.getPrice());
	 
	 				 OuterMap.put(Integer.toString(i++), map);
	 			}
	        	}
			
	 		transaction.commit();
	        	return OuterMap;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return OuterMap;
	}
	
	public static Map getProductsByName(String productName) 
	{
	    	Map outerMap = new LinkedHashMap();
	    	SessionFactory factory = null;
	    	Session session = null;
	    	Transaction transaction = null;
	    	try 
	    	{
			factory = new Configuration().configure().buildSessionFactory();
		        session = factory.openSession();
		        transaction = session.beginTransaction();
		        Query query = session.createQuery("FROM HbmNetmedsProduct WHERE productName LIKE :productName");
		        query.setParameter("productName", "%" + productName + "%");
		        List<HbmNetmedsProduct> results = query.list();

		        for (HbmNetmedsProduct hbmNetmedsProduct : results)
		        {
		            	Map map = new LinkedHashMap();
		            	map.put("productId", hbmNetmedsProduct.getProductId());
		            	map.put("product_name", hbmNetmedsProduct.getProductName());
		            	map.put("description", hbmNetmedsProduct.getDescription());
		            	map.put("manufacturer", hbmNetmedsProduct.getManufacturer());
		            	map.put("product_image", hbmNetmedsProduct.getProductImages());
		            	map.put("mrp", hbmNetmedsProduct.getMrp());
		            	map.put("price", hbmNetmedsProduct.getPrice());
		            	map.put("stock", hbmNetmedsProduct.getStock());
		            	outerMap.put(Integer.toString(i++), map);
		        }
			
		        System.out.println("-----------"+outerMap);
		        transaction.commit();
		        return outerMap;
	    	}
	    	catch (Throwable ex) 
	    	{
		   	if (transaction != null)
	            		transaction.rollback();

			System.err.println("Failed to create sessionFactory object.." + ex);
	    	} 
	    	finally 
	    	{
	        	if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
	    	}
		
	    	return outerMap;
	}
	
	public static Map getOrderDetails(String whoLoggedIn)
	{
		Map map = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();

	 		String hql = "SELECT a, d, c FROM HbmNetmedsCustomer c INNER JOIN c.hbmNetmedsOrdersByCustomerId a INNER JOIN a.hbmNetmedsOrdersDetailsByOrderId d WHERE c.customerId = :customerId and c.isActive = :isActive";
	 		Query query = session.createQuery(hql);
	 		query.setParameter("customerId", Long.parseLong(whoLoggedIn));
	 		query.setParameter("isActive", "Y");
	 		List<Object[]> results = query.list();
	 		
	 		for (Object[] result : results)
	 		{ 
	 			HbmNetmedsOrder hbmNetmedsOrder = (HbmNetmedsOrder) result[0] ; 
	 			HbmNetmedsOrdersDetail hbmNetmedsOrdersDetail = (HbmNetmedsOrdersDetail) result[1];
	 			HbmNetmedsCustomer hbmNetmedsCustomer = (HbmNetmedsCustomer) result[2];
	 			map.put("name", hbmNetmedsCustomer.getFirstName()+" "+hbmNetmedsCustomer.getLastName());
	            		map.put("orderId", hbmNetmedsOrder.getOrderId()); 
	            		map.put("totalCost", hbmNetmedsOrder.getTotalCost()); 
	            		map.put("orderDate", hbmNetmedsOrder.getOrdersDate());
	            		map.put("shippingAddress", hbmNetmedsOrdersDetail.getShippingAddress());
	        	}
			
	 		transaction.commit();
	        	return map;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return map;
	}
	
	public static List getCategories(Long productId)
	{
		List li = new ArrayList();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCategory where fkCategoryId = :fkCategoryId and isActive = :isActive");
	 		query.setParameter("fkCategoryId", productId);
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		int i = 0;
	 		while (iterator.hasNext())
	 		{
	 			Map map = new LinkedHashMap();
	 			HbmNetmedsCategory hbmNetmedsCategory = (HbmNetmedsCategory) iterator.next();
	 			map.put("categoryId", hbmNetmedsCategory.getCategoryId());
	            		map.put("categoryName", hbmNetmedsCategory.getCategoryName()); 
	 			li.add(map);
	        	}
			
	 		transaction.commit();
	        	return li;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return li;
	}
	
	public static String getCategories(String category)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCategory where categoryName = :category and fkCategoryId = :fkCategoryId and isActive = :isActive");
	 		query.setParameter("category", category);
	 		query.setParameter("isActive", "Y");
	 		query.setParameter("fkCategoryId", Long.valueOf(0));
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		while (iterator.hasNext())
	 		{
	 			transaction.commit();
	 			return "Already Present";
	        	}
			
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	   	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String addCategory(String category)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		HbmNetmedsCategory hbmNetmedsCategory = new HbmNetmedsCategory();
	 		hbmNetmedsCategory.setCategoryName(category);
	 		hbmNetmedsCategory.setCreatedBy("1");
	 		hbmNetmedsCategory.setCreatedDate(new Date());
	 		hbmNetmedsCategory.setFkCategoryId(Long.parseLong(Integer.toString(0)));
	 		hbmNetmedsCategory.setIsActive("Y");
	 		session.save(hbmNetmedsCategory);
	 		transaction.commit();
			
	 		return "Sucessfully Added..!";
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String addState(String state)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		HbmNetmedsState hbmNetmedsState = new HbmNetmedsState();
	 		hbmNetmedsState.setStateName(state);
	 		hbmNetmedsState.setCreatedBy("1");
	 		hbmNetmedsState.setCreatedDate(new Date());
	 		hbmNetmedsState.setIsActive("Y");
	 		session.save(hbmNetmedsState);
	 		transaction.commit();
			
	 		return "Sucessfully Added..!";
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String addCity(String city, String state)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query1 = session.createQuery("FROM HbmNetmedsState where stateName = :stateName and isActive = :isActive");
	 		query1.setParameter("stateName", state);
	 		query1.setParameter("isActive", "Y");
	 		List result = query1.list();
	 		
	 		Iterator iterator = result.iterator();
	 		HbmNetmedsState hbmNetmedsState = null;
			
	 		while (iterator.hasNext())
	 		{
	 			hbmNetmedsState = (HbmNetmedsState) iterator.next(); 
	 		}
			
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
	 		HbmNetmedsCity hbmNetmedsCity = new HbmNetmedsCity();
	 		hbmNetmedsCity.setCityName(city);
	 		hbmNetmedsCity.setHbmNetmedsState(hbmNetmedsState);
	 		hbmNetmedsCity.setCreatedBy("1");
	 		hbmNetmedsCity.setCreatedDate(new Date());
	 		hbmNetmedsCity.setIsActive("Y");
			
	 		session.save(hbmNetmedsCity);
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String getSubCategories(String category)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCategory where categoryName = :category and fkCategoryId != :fkCategoryId and isActive = :isActive");
	 		query.setParameter("category", category);
	 		query.setParameter("fkCategoryId", Long.valueOf(0));
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		while (iterator.hasNext())
	 		{
	 			transaction.commit();
	 			return "Already Present";
	        	}
			
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String addSubCategories(String category, String mainCategory)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		HbmNetmedsCategory hbmNetmedsCategory = new HbmNetmedsCategory();
	 		hbmNetmedsCategory.setCategoryName(category);
	 		hbmNetmedsCategory.setFkCategoryId(Long.parseLong(mainCategory));
	 		hbmNetmedsCategory.setCreatedBy("1");
	 		hbmNetmedsCategory.setCreatedDate(new Date());
	 		hbmNetmedsCategory.setIsActive("Y");
	 		
	 		session.save(hbmNetmedsCategory);
	 		transaction.commit();
			
	 		return "Sucessfully Added..!";
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String getState(String state)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsState where stateName = :state and isActive = :isActive");
	 		query.setParameter("state", state);
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		while (iterator.hasNext())
	 		{
	 			transaction.commit();
	 			return "Already Present";
	        	}
			
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String checkEmail(String emailId)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCustomer where email = :email and isActive = :isActive");
	 		query.setParameter("email", emailId);
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		while (iterator.hasNext())
	 		{
	 			transaction.commit();
	 			return "Already Present";
	        	}
			
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	   	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static String getCity(String city)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsCity where cityName = :city and isActive = :isActive");
	 		query.setParameter("city", city);
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		while (iterator.hasNext())
	 		{
	 			transaction.commit();
	 			return "Already Present";
	        	}
			
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	   	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return "";
	}
	
	public static Map addToCartProducts(String productId, String whoLoggedIn)
	{
		Map map = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		
	 		Query query1 = session.createQuery("FROM HbmNetmedsCustomer where customerId = :whoLoggedIn and isActive = :isActive");
	 		query1.setParameter("whoLoggedIn", Long.parseLong(whoLoggedIn));
	 		query1.setParameter("isActive", "Y");
	 		List result1 = query1.list();
	 		
	 		HbmNetmedsCustomer hbmNetmedsCustomer = null;
	 		Iterator iterator1 = result1.iterator();
	 		
	 		while (iterator1.hasNext())
	 		{
	 			hbmNetmedsCustomer = (HbmNetmedsCustomer) iterator1.next();
	 		}
			
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("FROM HbmNetmedsProduct where productId = :productId and isActive = :isActive");
	 		query.setParameter("productId", Long.parseLong(productId));
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		
	 		Iterator iterator = result.iterator();
	 		HbmNetmedsProduct hbmNetmedsProduct = null;
			
	 		while (iterator.hasNext())
	 		{
	 			hbmNetmedsProduct = (HbmNetmedsProduct) iterator.next(); 
	 			
	 			HbmNetmedsAddToCart hbmNetmedsAddToCart = new HbmNetmedsAddToCart();
		 		hbmNetmedsAddToCart.setSpecificItemQuantity((long) 1);
		 		hbmNetmedsAddToCart.setSpecificItemPrice(hbmNetmedsProduct.getPrice());
		 		hbmNetmedsAddToCart.setHbmNetmedsProductByProductId(hbmNetmedsProduct);
		 		hbmNetmedsAddToCart.setCreatedBy("1");
		 		hbmNetmedsAddToCart.setCreatedDate(new Date());
		 		hbmNetmedsAddToCart.setHbmNetmedsCustomerByCustomerId(hbmNetmedsCustomer);
		 		hbmNetmedsAddToCart.setIsActive("Y");
		 		session.save(hbmNetmedsAddToCart);
	        	}
	 		
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
	 		Query query2 = session.createQuery("SELECT COUNT(*) FROM HbmNetmedsAddToCart c INNER JOIN c.hbmNetmedsCustomerByCustomerId d WHERE d.customerId = :customerId and c.isActive = :isActive");
	 		query2.setParameter("customerId", Long.parseLong(whoLoggedIn));
	 		query2.setParameter("isActive", "Y");
	 		Long count = (Long) query2.uniqueResult();
	 		map.put("count", count);
	 		System.out.println(count);
	 		transaction.commit();
			
	        	return map;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return map;
	}
	
	public static boolean removeFromCartProducts(String cartId, String whoLoggedIn)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query1 = session.createQuery("FROM HbmNetmedsCustomer where customerId = :whoLoggedIn and isActive = :isActive");
	 		query1.setParameter("whoLoggedIn", Long.parseLong(whoLoggedIn));
	 		query1.setParameter("isActive", "Y");
	 		List result = query1.list();
	 		
	 		Iterator iterator = result.iterator();
	 		HbmNetmedsCustomer hbmNetmedsCustomer = null;
			
	 		while (iterator.hasNext())
	 		{
	 			hbmNetmedsCustomer = (HbmNetmedsCustomer) iterator.next(); 
	 		}
			
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("UPDATE HbmNetmedsAddToCart SET isActive = :newValue WHERE cartItemsId = :cartId and hbmNetmedsCustomerByCustomerId = :whoLoggedIn and isActive = :isActive");
	 		query.setParameter("cartId", Long.valueOf(cartId));
	 		query.setParameter("newValue", "N");
	 		query.setParameter("whoLoggedIn", hbmNetmedsCustomer);
	 		query.setParameter("isActive", "Y");
	 		query.executeUpdate();
	 		
	 		transaction.commit();
	 		
			return true;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return false;
	}
	
	public static Map getAddress(String whoesLogin)
	{
		Map map = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();

	 		String hql = "SELECT c, a FROM HbmNetmedsCustomer c INNER JOIN c.address a WHERE c.customerId = :customerId and c.isActive = :isActive";
	 		
	 		Query query = session.createQuery(hql);
	 		query.setParameter("customerId", Long.parseLong(whoesLogin));
	 		query.setParameter("isActive", "Y");
	 		List<Object[]> results = query.list();
	 		
	 		for (Object[] result : results)
	 		{
	 			HbmNetmedsCustomer hbmNetmedsCustomer = (HbmNetmedsCustomer) result[0] ; 
	 			HbmNetmedsAddress hbmNetmedsAddress = (HbmNetmedsAddress) result[1] ; 
	 			
	 			map.put("first-name", hbmNetmedsCustomer.getFirstName());
	            		map.put("last-name", hbmNetmedsCustomer.getLastName());
	            		map.put("customerId", Long.toString(hbmNetmedsCustomer.getCustomerId()));
	            		map.put("number", hbmNetmedsCustomer.getMobileNumber());
	            		map.put("address", hbmNetmedsAddress.getAddress());
	            		map.put("city", hbmNetmedsAddress.getCity());
	            		map.put("state", hbmNetmedsAddress.getState());
	            		map.put("pincode", hbmNetmedsAddress.getPincode());
	            		map.put("landmark", hbmNetmedsAddress.getLandmark());
	        	}
			
	 		transaction.commit();
	        	return map;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return map;
	}
	
	public static boolean changeAddress(HbmNetmedsCustomer hbmNetmedsCustomer, HbmNetmedsAddress hbmNetmedsAddress) 
	{
	    	SessionFactory factory = null;
	    	Session session = null;
	    	Transaction transaction = null;
	    	try
	    	{
		        factory = new Configuration().configure().buildSessionFactory();
		        session = factory.openSession();
		        transaction = session.beginTransaction();
	
		        // Retrieve the customer object
		        Query query = session.createQuery("FROM HbmNetmedsCustomer WHERE firstName = :whoLoggedIn and isActive = :isActive");
		        query.setParameter("whoLoggedIn", hbmNetmedsCustomer.getFirstName());
		        query.setParameter("isActive", "Y");
		        List<HbmNetmedsCustomer> result = query.list();
	
		        if (!result.isEmpty()) 
		        {
		            	HbmNetmedsCustomer hbmNetmedsCustomer1 = result.get(0);

			        // Update the mobile number
			        Query query2 = session.createQuery("UPDATE HbmNetmedsCustomer SET mobileNumber = :mobileNumber WHERE firstName = :whoLoggedIn and isActive = :isActive");
			        query2.setParameter("mobileNumber", hbmNetmedsCustomer.getMobileNumber());
			        query2.setParameter("whoLoggedIn", hbmNetmedsCustomer.getFirstName());
			        query2.setParameter("isActive", "Y");
			        query2.executeUpdate();
		
			        // Update the address
			        Query query1 = session.createQuery("UPDATE HbmNetmedsAddress SET address = :address, city = :city, state = :state WHERE customer = :customer and isActive = :isActive");
			        query1.setParameter("address", hbmNetmedsAddress.getAddress());
			        query1.setParameter("city", hbmNetmedsAddress.getCity());
			        query1.setParameter("state", hbmNetmedsAddress.getState());
			        query1.setParameter("customer", hbmNetmedsCustomer1);
			        query1.setParameter("isActive", "Y");
			        query1.executeUpdate();
		
			        transaction.commit();
			        return true;
	        	}
	    	} 
	    	catch (Throwable ex) 
	    	{
	        	if (transaction != null)
	            		transaction.rollback();

	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	} 
	    	finally
	    	{
	        	if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
	    	}
		
	    	return false;
	}
	
	public static boolean addProductsByAdmin(Map map, String mainCategory, String subCategory)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;

		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		
	 		Query query1 = session.createQuery("FROM HbmNetmedsCategory where categoryId = :categoryId and fkCategoryId = :fkCategoryId and isActive = :isActive");
	 		query1.setParameter("categoryId", Long.parseLong(subCategory));
	 		query1.setParameter("fkCategoryId", Long.parseLong(mainCategory));
	 		query1.setParameter("isActive", "Y");
	 		List result = query1.list();
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
	 		Iterator iterator = result.iterator();
	 		HbmNetmedsCategory hbmNetmedsCategory = null;
	 		
	 		while (iterator.hasNext()) 
	 		{
	 			hbmNetmedsCategory = (HbmNetmedsCategory) iterator.next(); 
	 		}
	 		
	 		HbmNetmedsProduct hbmNetmedsProduct = new HbmNetmedsProduct();
	 		hbmNetmedsProduct.setProductName((String) map.get("product-name"));
			hbmNetmedsProduct.setManufacturer((String) map.get("manufacturer"));
			hbmNetmedsProduct.setProductImages((String) map.get("product-image"));
			hbmNetmedsProduct.setMrp( (BigDecimal) map.get("product-mrp"));
			hbmNetmedsProduct.setPrice((BigDecimal)  map.get("product-price"));
			hbmNetmedsProduct.setStock((Integer) map.get("stock"));
	 		hbmNetmedsProduct.setHbmNetmedsCategoryByCategoryId(hbmNetmedsCategory);
	 		hbmNetmedsProduct.setCreatedBy("1");
	 		hbmNetmedsProduct.setCreatedDate(new Date());
	 		hbmNetmedsProduct.setIsActive("Y");
	 		session.save(hbmNetmedsProduct);
	 		
	 		transaction.commit();
	 		
	      		return true;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return false;
	}
	
	public static Long addToCartProductsCount(String customerId)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		Long count = null;
		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		
	 		transaction = session.beginTransaction();
	 		Query query2 = session.createQuery("SELECT COUNT(*) FROM HbmNetmedsAddToCart c INNER JOIN c.hbmNetmedsCustomerByCustomerId d WHERE d.customerId = :customerId and c.isActive = :isActive");
	 		query2.setParameter("customerId", Long.valueOf(customerId));
	 		query2.setParameter("isActive", "Y");
	 		count = (Long) query2.uniqueResult();
	 		transaction.commit();
			
	        	return count;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return count;
	}
	
	public static Map addToCartProductsDetails(String customerId)
	{
		Map map = new LinkedHashMap();
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		BigDecimal originalPrice = new BigDecimal("0");
 		BigDecimal discountedPrice = new BigDecimal("0");
 		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		Query query = session.createQuery("SELECT C, A, P FROM HbmNetmedsCustomer C JOIN C.hbmNetmedsAddToCartsByCustomerId A JOIN A.hbmNetmedsProductByProductId P WHERE C.customerId = :customerId and A.isActive = :isActive");
	 		query.setParameter("customerId", Long.parseLong(customerId));
	 		query.setParameter("isActive", "Y");
	 		List<Object[]> result = query.list();
	 		
	 		int i = 1;
	 		
	 		for (Object[] results : result)
	 		{
	 			Map innerMap = new LinkedHashMap();
	 			HbmNetmedsProduct hbmNetmedsProduct = (HbmNetmedsProduct) results[2];
	 			innerMap.put("productId",  hbmNetmedsProduct.getProductId());
	 			innerMap.put("product_name", hbmNetmedsProduct.getProductName()); 
	 			innerMap.put("description", hbmNetmedsProduct.getDescription()); 
	 			innerMap.put("manufacturer", hbmNetmedsProduct.getManufacturer());
	 			innerMap.put("product_image", hbmNetmedsProduct.getProductImages()); 
	 			innerMap.put("mrp", hbmNetmedsProduct.getMrp()); 
	 			innerMap.put("price", hbmNetmedsProduct.getPrice());
	 			innerMap.put("stock", hbmNetmedsProduct.getStock()); 
	 			innerMap.put("price", hbmNetmedsProduct.getPrice());
				
	 			HbmNetmedsAddToCart hbmNetmedsAddToCart = (HbmNetmedsAddToCart) results[1];
	            		innerMap.put("cartId", hbmNetmedsAddToCart.getCartItemsId());
	            		map.put(Integer.toString(i++), innerMap);
	            
	            		originalPrice = originalPrice.add((BigDecimal) hbmNetmedsProduct.getMrp());
	            		discountedPrice = discountedPrice.add((BigDecimal) hbmNetmedsProduct.getPrice());
	        	}
	 		
	 		Map innerMapSecond = new LinkedHashMap();
	 		innerMapSecond.put("orignalPrice", originalPrice);
	 		innerMapSecond.put("save", originalPrice.subtract(discountedPrice));
	 		innerMapSecond.put("discountPrice", discountedPrice);
	 		System.out.println("discountPrice : "+originalPrice.subtract(discountedPrice));
	 		
	 		map.put("secondMap", innerMapSecond);
	 		
	 		transaction.commit();
	 		System.out.println(map);
			
	        	return map;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return map;
	}

	public static boolean placeOrderDetails(String whoLoggedIn, String modeOfPayment) 
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		BigDecimal originalPrice = new BigDecimal("0");
 		BigDecimal discountedPrice = new BigDecimal("0");
		
		try    
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();

		 	String hql = "SELECT c, a, s, p FROM HbmNetmedsCustomer c INNER JOIN c.address a INNER JOIN c.hbmNetmedsAddToCartsByCustomerId s INNER JOIN s.hbmNetmedsProductByProductId p WHERE c.customerId = :customerId and s.isActive = :isActive";
		 	Query query = session.createQuery(hql);
		 	query.setParameter("customerId", Long.valueOf(whoLoggedIn));
		 	query.setParameter("isActive", "Y");
		 	List<Object[]> results = query.list();
		 	HbmNetmedsCustomer hbmNetmedsCustomer = null;
		 	HbmNetmedsAddress hbmNetmedsAddress = null;
		 	HbmNetmedsProduct hbmNetmedsProduct = null;
		 	
		 	for (Object[] result : results)
		 	{
		 		hbmNetmedsCustomer = (HbmNetmedsCustomer) result[0] ; 
		 		hbmNetmedsAddress = (HbmNetmedsAddress) result[1] ;
		 		HbmNetmedsAddToCart hbmNetmedsAddToCart = (HbmNetmedsAddToCart) result[2];
		 		hbmNetmedsProduct = (HbmNetmedsProduct) result[3];
		 		
		 		originalPrice = originalPrice.add((BigDecimal) hbmNetmedsProduct.getMrp());
	            		discountedPrice = discountedPrice.add((BigDecimal) hbmNetmedsProduct.getPrice());
		 	}
	 		
		 	BigDecimal totalPay = (new BigDecimal("40")).add((BigDecimal) discountedPrice);
		 	String shippingAddress = hbmNetmedsAddress.getAddress()+", ";
			
		 	if(hbmNetmedsAddress.getLandmark() != null)
		 		shippingAddress += hbmNetmedsAddress.getLandmark();
			
		 	shippingAddress += ", "+hbmNetmedsAddress.getCity();
		 	shippingAddress += ", "+hbmNetmedsAddress.getState();
		 	shippingAddress += " - "+hbmNetmedsAddress.getPincode();
		 			
		 	// customerId, total cost in order
		 	HbmNetmedsOrder hbmNetmedsOrder = new HbmNetmedsOrder();
		 	hbmNetmedsOrder.setHbmNetmedsCustomerByCustomerId(hbmNetmedsCustomer);
		 	hbmNetmedsOrder.setTotalCost(totalPay);
		 	hbmNetmedsOrder.setOrdersDate(new Date());
		 	hbmNetmedsOrder.setCreatedBy("1");
		 	hbmNetmedsOrder.setCreatedDate(new Date());
		 	hbmNetmedsOrder.setIsActive("Y");
		 	session.save(hbmNetmedsOrder);
		 	
		 	//price , shippping address , productId, OrderId in OrderDetails
		 	HbmNetmedsOrdersDetail hbmNetmedsOrdersDetail = new HbmNetmedsOrdersDetail();
		 	hbmNetmedsOrdersDetail.setPrice(totalPay);
		 	hbmNetmedsOrdersDetail.setHbmNetmedsOrderByOrderId(hbmNetmedsOrder);
		 	hbmNetmedsOrdersDetail.setHbmNetmedsProductByProductId(hbmNetmedsProduct);
		 	hbmNetmedsOrdersDetail.setShippingAddress(shippingAddress);
		 	hbmNetmedsOrdersDetail.setPaymentType(modeOfPayment);
		 	hbmNetmedsOrdersDetail.setCreatedBy("1");
		 	hbmNetmedsOrdersDetail.setCreatedDate(new Date());
		 	hbmNetmedsOrdersDetail.setIsActive("Y");
	 		session.save(hbmNetmedsOrdersDetail);
	 		
	 		transaction.commit();
	 		
	 		transaction = session.beginTransaction();
			
	 		for (Object[] result : results)
		 	{
	 			HbmNetmedsProduct hbmNetmedsProducts = (HbmNetmedsProduct) result[3];
	 			Query query1 = session.createQuery("UPDATE HbmNetmedsAddToCart SET isActive = :newValue WHERE hbmNetmedsProductByProductId = :hbmNetmedsProductByProduct");
		 		query1.setParameter("newValue", "N");
		 		query1.setParameter("hbmNetmedsProductByProduct", hbmNetmedsProducts);
		 		query1.executeUpdate();
		 	}
			
	 		transaction.commit();
	 		
	      		return true;
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
		
		return false;
	}
	
	public static  void addProduct(HbmNetmedsProduct netmedsProduct)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
 		
		try 
		{
			factory = new Configuration().configure().buildSessionFactory();
	 		session = factory.openSession();
	 		transaction = session.beginTransaction();
	 		session.save(netmedsProduct);
	 		transaction.commit();
	    	} 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        	System.err.println("Failed to create sessionFactory object.." + ex);
	    	}
		finally
		{
			if (session != null)
	            		session.close();
	        	if (factory != null)
	            		factory.close();
		}
	}
}
