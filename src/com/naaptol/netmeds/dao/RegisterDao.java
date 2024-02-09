package com.naaptol.netmeds.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.naaptol.netmeds.pojo.HbmNetmedsAddress;
import com.naaptol.netmeds.pojo.HbmNetmedsCustomer;

public class RegisterDao 
{
	public static boolean RegisterQuery(Map map)
	{
		SessionFactory factory = null;
		Session session = null;
		Transaction transaction = null;
		try 
		{
			 factory = new Configuration().configure().buildSessionFactory();
	 		 session = factory.openSession();
	 		 transaction = session.beginTransaction();
	 		 
	 		 HbmNetmedsCustomer hbmNetmedsCustomer = new HbmNetmedsCustomer();
	 		 hbmNetmedsCustomer.setFirstName((String)map.get("first-name"));
	 		 hbmNetmedsCustomer.setLastName((String)map.get("last-name"));
	 		 hbmNetmedsCustomer.setEmail((String)map.get("emailId"));
	 		 hbmNetmedsCustomer.setMobileNumber((String)map.get("mobile-number"));
	 		 
	 		 hbmNetmedsCustomer.setPassword((String)map.get("password"));  
	 		 hbmNetmedsCustomer.setCreatedDate(new Date());
	 		 hbmNetmedsCustomer.setCreatedBy("1");
	 		 hbmNetmedsCustomer.setIsAdmin("N");
	 		 hbmNetmedsCustomer.setIsActive("Y");
	         session.save(hbmNetmedsCustomer);
	         
	         HbmNetmedsAddress hbmNetmedsAddress = new HbmNetmedsAddress();
	         hbmNetmedsAddress.setAddress((String) map.get("address"));
	         hbmNetmedsAddress.setCity((String) map.get("city-r"));
	         hbmNetmedsAddress.setState((String) map.get("state"));
	         hbmNetmedsAddress.setPincode((String) map.get("pincode"));
	         hbmNetmedsAddress.setCustomer(hbmNetmedsCustomer);
	         hbmNetmedsAddress.setCreatedDate(new Date());
	         hbmNetmedsAddress.setCreatedBy("1");
	         hbmNetmedsAddress.setIsActive("Y");
	 		 
	         session.save(hbmNetmedsAddress);
	         transaction.commit();
	         return true;
	    } 
		catch (Throwable ex) 
		{ 
			if(transaction != null)
				transaction.rollback();
			
	        System.err.println("Failed to create sessionFactory object." + ex);
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
}
