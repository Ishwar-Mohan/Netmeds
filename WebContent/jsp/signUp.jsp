<%@page import="java.util.Map"%>
<%@page import="com.naaptol.netmeds.helper.Helper"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="icon" href="<%= request.getContextPath() %>/images/Netmeds.png">
    <title>Netmeds Sign In / Sign Up</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/netmades.css">
</head>
<body>
	<input name="contextPath" id="contextPath" type="hidden" value="<%= request.getContextPath() %>">
	<jsp:include page="/jsp/header.jsp"></jsp:include>
	
    <div class="signUp-container">
        <div class="signupbg-img">
            <img src="<%= request.getContextPath() %>/images/signupbg.png" alt="image not found" id="signupbg-img">
        </div>
        <div id="registration-form">
            <form id="register-form" action="<%= request.getContextPath() %>/ServletController" method="post">
            	<input name="requestType" type="hidden" value="registerRequest">
                <label id="r-label">Sign In / Sign Up</label>
                <div class="chk-container">
                    <span id="r-chk-txt">Sign up or Sign in to access your orders, special offers, health tips and more!</span>
                </div>
                <div class="r-fields">
                	<label class="login-labels">First Name</label>
                    <input type="text" class="r-text-box" placeholder="First Name*" id="first-name" name="first-name" onblur="validateRegistration.firstName();" oninput="validateRegistration.firstNameRegEx();" maxlength="20">
                    <div class="error" id="errFirstName"></div>
                </div>
                <div class="r-fields">
                	<label class="login-labels">Last Name</label>
                    <input type="text" class="r-text-box" placeholder="Last Name*" id="last-name" name="last-name" onblur="validateRegistration.lastName();" oninput="validateRegistration.lastNameRegEx();" maxlength="20">
                    <div class="error" id="errLastName"></div>
                </div>
                <div class="r-fields">
                	<label class="login-labels">Email Id</label>
                    <input type="text" class="r-text-box" placeholder="EmailId*" id="emailId" name="emailId" onblur="validateRegistration.emailId();" oninput="validateRegistration.emailIdRegEx();" maxlength="30">
                    <div class="error" id="errEmailId"></div>
                </div>
                <div class="r-fields">
                	<label class="login-labels">Mobile Number</label>
                    <input type="text" class="r-text-box" placeholder="Mobile Number*" id="mobile-number" name="mobile-number" onblur="validateRegistration.mobileNumber();" oninput="validateRegistration.mobileNumberRegEx();" maxlength="10">
                    <div class="error" id="errMobNumber"></div>
                </div>
                <div class="r-fields">
                	<label class="login-labels">Address</label>
                    <input type="text" class="r-text-box" placeholder="Address*" id="address" name="address" onblur="validateRegistration.address();" maxlength="150">
                    <div class="error" id="errAddress"></div>
                </div>
                <div class="r-fields">
                    <div class="state-city">
                        <div>
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
                        <div class="error" id="errState"></div>
                    </div>
                    <div class="state-city">
                        <div>
                        	<label class="login-labels">City</label>
                            <select class="r-text-box-cs" id="city-r" name="city-r" onchange="validateRegistration.checkCity()">
                                <option value="0">Select City</option>
                            </select>
                        </div>
                        <div class="error" id="errCity"></div>
                    </div>
                    <div class="state-city">
                    	<label class="login-labels">Pincode</label>
                        <input type="text" class="r-text-box-cs" placeholder="Pincode*" id="pincode-r" name="pincode-r" onblur="validateRegistration.pincode();" maxlength="6">
                        <div class="error" id="errPincode"></div>
                    </div>
                    <div class="clr"></div>
                </div>
                <div class="r-fields">
                	<label class="login-labels">Password</label>
                    <input type="password" class="r-text-box" placeholder="Password*" id="password" name="password" onblur="validateRegistration.password();" oninput="validateRegistration.passwordRegEx();" maxlength="20">
                    <div class="error" id="errPassword"></div>
                </div>
                <div class="r-fields">
                	<label class="login-labels">Confirm Password</label>
                    <input type="password" class="r-text-box" placeholder="Confirm Password*" id="confirm-password" name="confirm-password" onblur="validateRegistration.confirmPasswordAfter();" oninput="validateRegistration.confirmPasswordRegEx();" maxlength="20">
                    <div class="error" id="errConfirmPassword"></div>
                </div>
                <input type="button" value="Register" class="btn" id="r-btn" onclick="validateRegistration.onSubmitValidate();">
                <hr>
                <a href="#" class="text-end" id="l-link">Login</a>
            </form>
        </div>
        <div class="login-form" id="login-form-container">
       		 <form id="login-form" action="<%= request.getContextPath() %>/ServletController" method="post">
				<input name="requestType" type="hidden" value="loginRequest">
                <label id="r-label">Sign In / Sign Up</label>
                <div class="l-fields">
                    <label class="login-labels">Login As</label><br>
					<select class="r-text-box" id="whoesLogin" name="whoesLogin">
						<option value="N">Customer</option>
						<option value="Y">Admin</option>
					</select>
                </div>
                <div class="l-fields">
                    <label class="login-labels">UserId</label>
                    <input type="text" class="r-text-box" placeholder="Enter your UserId*" id="userId" name="userId" onblur="validateLogin.userIdCheck();" maxlength="20">
                    <div class="error" id="errUserIdLogin"></div>
                </div>
                <div class="l-fields">
                    <label class="login-labels">Password</label>
                    <input type="password" class="r-text-box" placeholder="Enter your Password*" id="login-password" name="login-password" onblur="validateLogin.passwordCheck();" maxlength="20">
                    <div class="error" id="errPassLogin" maxlength="20"></div>
                </div>
                <input type="button" value="Login" class="btn" id="l-btn" onclick="validateLogin.loginCredential();">
                <hr>
                <a href="#" class="text-end" id="r-link">Register</a>
            </form>
        </div>
        <div class="clr"></div>
    </div>
    <script src="<%= request.getContextPath() %>/js/jQuery.js"></script>
    <script src="<%= request.getContextPath() %>/js/netmeds.js"></script>
</body>
</html>