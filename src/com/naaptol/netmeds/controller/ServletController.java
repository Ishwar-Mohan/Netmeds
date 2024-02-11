package com.naaptol.netmeds.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naaptol.netmeds.helper.Helper;

public class ServletController extends HttpServlet 
{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		String reqestType = req.getParameter("requestType");
				
		if("loginRequest".equals(reqestType))
		{
			Helper.LoginCredentials(req, res);
		}
		else if("registerRequest".equals(reqestType))
		{		
			boolean flag = Helper.registerCredentials(req);
			
			if(flag == true)
			{
				res.sendRedirect(req.getContextPath()+"/jsp/signUp.jsp");
			}
		}
		else if("addProductRequest".equals(reqestType))
		{		
			boolean flag = Helper.addProductByAdmin(req);
			
			if(flag == true)
			{
				res.sendRedirect(req.getContextPath()+"/jsp/adminPanel.jsp");
			}
		}
		else if("changeAddressRequest".equals(reqestType))
		{		
			boolean flag = Helper.changeAddress(req);
			
			if(flag == true)
			{
				res.sendRedirect(req.getContextPath()+"/jsp/order.jsp");
			}
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		doPost(req, res);
	}
}
