package com.naaptol.netmeds.dao;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.naaptol.netmeds.pojo.HbmNetmedsAddress;
import com.naaptol.netmeds.pojo.HbmNetmedsCustomer;

public class LoginDao 
{
	public static Map LoginQuery(String userId)
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

	 		String hql = "SELECT c, a FROM HbmNetmedsCustomer c INNER JOIN c.address a WHERE c.email = :username and c.isActive = :isActive";
	 		
	 		Query query = session.createQuery(hql);
	 		query.setParameter("username", userId);
	 		query.setParameter("isActive", "Y");
	 		List<Object[]> results = query.list();
	 		
	 		for (Object[] result : results)
	 		{
	 			HbmNetmedsCustomer hbmNetmedsCustomer = (HbmNetmedsCustomer) result[0] ; 
	 			HbmNetmedsAddress hbmNetmedsAddress = (HbmNetmedsAddress) result[1] ; 
	 			
	            map.put("email", (String) hbmNetmedsCustomer.getEmail()); 
	            map.put("password", (String) hbmNetmedsCustomer.getPassword()); 
	            map.put("customerId", Long.toString(hbmNetmedsCustomer.getCustomerId()));
	            map.put("first-name", hbmNetmedsCustomer.getFirstName());
	            map.put("last-name", hbmNetmedsCustomer.getLastName());
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
	
	public static Map LoginAsAdmin(String userId)
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
	 		Query query = session.createQuery("FROM HbmNetmedsCustomer WHERE email = :username and isAdmin = :isAdmin and isActive = :isActive");
	 		query.setParameter("username", userId);
	 		query.setParameter("isAdmin", "Y");
	 		query.setParameter("isActive", "Y");
	 		List result = query.list();
	 		Iterator iterator = result.iterator();
	 		
	 		while (iterator.hasNext())
	 		{
	 			HbmNetmedsCustomer hbmNetmedsCustomer = (HbmNetmedsCustomer) iterator.next(); 
	            map.put("admin_userId", hbmNetmedsCustomer.getEmail());
	            map.put("admin_password", hbmNetmedsCustomer.getPassword());
	            map.put("first-name", "Admin");
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
}
