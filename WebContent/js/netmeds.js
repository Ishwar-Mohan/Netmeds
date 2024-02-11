// registration
var validateRegistration = new ValidateRegistration();

function ValidateRegistration()
{
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.mobileNumber = mobileNumber;
	this.password = password;
	this.address = address;
	this.confirmPasswordAfter = confirmPasswordAfter;
	this.checkState = checkState;
	this.checkCity = checkCity;
	this.landmark = landmark;
	this.onReset = onReset;
	this.pincode = pincode;
	this.onSubmitValidate = onSubmitValidate;
	this.onChangeAddress = onChangeAddress;

	this.firstNameRegEx = firstNameRegEx;
	this.lastNameRegEx = lastNameRegEx;
	this.emailIdRegEx = emailIdRegEx;
	this.mobileNumberRegEx = mobileNumberRegEx;
	this.passwordRegEx = passwordRegEx;
	this.confirmPasswordRegEx = confirmPasswordRegEx;

	var firstNameBool = false;
	var lastNameBool = false;
	var emailIdBool = false;
	var mobileNumberBool = false;
	var passwordBool = false;
	var confirmPasswordBool = false;
	var checkStateBool = false;
        var checkCityBool = false;
	var addressBool = false;
	var pincodeBool = false;
	var landmarkBool = false;

	function firstName()
    	{
		var firstName = $('#first-name');
		if(firstName.val() == "")
       		{
			$('#errFirstName').text("Please enter the First name.");
			firstNameBool = false;
		}
		else
		{
			firstNameBool = true;
		}
	};

	function firstNameRegEx()
    	{
		var firstName = $('#first-name');
		var regExN = /^[a-zA-Z]+[^\d]$/gm;
		var regExD = /[0-9!$%^&*\()_+|@#~=`{$\s}\-[\]:\";\'<>?,.\/\\[\]]/gm;
		
		firstName.val(firstName.val().replace(regExD,""));

		if(firstName.val() == "")
        	{
			$('#errFirstName').text("Please enter the first name.");
			firstNameBool = false;
		}
        	else if(regExN.test(firstName.val()))
        	{
			$('#errFirstName').text("");
			firstNameBool = true;
		}
        	else
        	{
			$('#errFirstName').text("Please Enter proper first name");
			firstNameBool = false;
		}
	};

	function lastName()
	{
		var lastName = $('#last-name');

		if(lastName.val() == "")
		{
			$('#errLastName').text("Please enter your Last Name.");
			lastNameBool = false;
		}
		else
		{
			lastNameBool = true;
		}
	};

	function lastNameRegEx()
	{
		var lastName = $('#last-name');
		var regExN = /^[a-zA-Z]+[^\d]$/gm;
		var regExD = /[0-9!$%^&*\()_+|@#~=`{$\s}\-[\]:\";\'<>?,.\/\\[\]]/gm;
		
		lastName.val(lastName.val().replace(regExD,""));

		if(lastName.val() == "")
        	{
			$('#errLastName').text("Please enter the last name.");
			lastNameBool = false;
		}
        	else if(regExN.test(lastName.val()))
        	{
			$('#errLastName').text("");
			lastNameBool = true;
		}
       		else
        	{
			$('#errLastName').text("Please Enter proper last name");
			lastNameBool = false;
		}
	};

	function emailId()
	{
		var emailId = $('#emailId');

		if(emailId.val() == "")
		{
			$('#errEmailId').text("Please enter your EmailId");
			emailIdBool = false;
		}
		else
		{
			emailIdBool = true;
		}
	};
	
	function emailIdRegEx()
	{
		var emailId = $('#emailId');
		var regExEmail = /^[a-z].+[\d]*@[a-z]+\.[a-z.]{2,6}$/g;
		var regExE = /[!%^()+|#~=`{}\[\]:\";\'<>?,\/\\[\s\]]/g;

		emailId.val(emailId.val().replace(regExE, ""));

		if(emailId.val() == "")
		{
			$('#errEmailId').text("Please enter your EmailId");
			emailIdBool = false;
		}
		else if(regExEmail.test(emailId.val())){
			$('#errEmailId').text("");
			emailIdBool = true;
		}
		else
		{
			$('#errEmailId').text("Please Enter proper EmailId");
			emailIdBool = false;
		}
	};
	
	function checkEmailId()
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					emailId : $('#emailId').val(),
					requestIdentifier : "checkMailRequest",
				},
				function(msg) 
				{
					if("Already Present" == msg){
						$('#errEmailId').text(msg);
						emailIdBool = false;
					}
					else
					{
						emailIdBool = true;
						$('#errEmailId').text(msg);
					}
				});
	};

	function mobileNumber()
	{
		var mobileNumber = $('#mobile-number');

		if(mobileNumber.val() == "")
		{
			$('#errMobNumber').text("Please Enter Mobile no.");
			mobileNumberBool = false;
		}
		else
		{
			mobileNumberBool = true;
		}
	};
	
	function mobileNumberRegEx()
	{
		var mobileNumber = $('#mobile-number');
		var regExMob = /^[7-9]{1}[\d]{9}$/g;
		var regExM = /[a-zA-Z!$%^&*\()_+|@#~=`{}\-[\]:\";\'<>?,.\/\\[\s\]]/;

		mobileNumber.val(mobileNumber.val().replace(regExM, ""));

		if(mobileNumber.val() == "")
		{
			$('#errMobNumber').text("Please Enter Mobile no.");
			mobileNumberBool = false;
		}
		else if(regExMob.test(mobileNumber.val()))
		{
			$('#errMobNumber').text("");
			mobileNumberBool = true;
		}
		else
		{
			$('#errMobNumber').text("Please Enter proper Mobile no.");
			mobileNumberBool = false;
		}
	};

	function address()
	{
		var address = $('#address');

		if(address.val() == "")
		{
			$('#errAddress').text("Please enter address.");
			addressBool = false;
		}
		else
		{
			$('#errAddress').text("");
			addressBool = true;
		}
	};

	function password()
	{
		var password = $('#password');

		if(password.val() == "")
		{
			$('#errPassword').text("Please..Enter Password");
			passwordBool = false;
		}
	};

	function passwordRegEx()
	{
		var password = $('#password');
		var regExPass = /(^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%&*]{6,12})$/g;

		if(password.val() == "")
		{
			$('#errPassword').text("Please..Enter Password");
			passwordBool = false;
		}
		else if(regExPass.test(password.val()))
		{
			$('#errPassword').text("");
			passwordBool = true;
		}
		else
		{
			$('#errPassword').text("Please..Enter proper Password");
			passwordBool = false;
		}
	};
		
	function confirmPasswordRegEx()
	{
		var confirmPassword = $('#confirm-password');
		var password = $('#password');
		var regExRpass = /(^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%&*]{6,15})$/g;

		if(confirmPassword.val() == "")
		{
			$('#errConfirmPassword').text("Please..Enter confirm password");
			confirmPasswordBool = false;
		}else if(password.val() == "")
		{
			$('#errConfirmPassword').text("Please..Enter password Firstly");
			confirmPasswordBool = false;
		}
		else if(confirmPassword.val() == password.val())
		{
			$('#errConfirmPassword').text("");
			confirmPasswordBool = true;
		}
		else if(confirmPassword.val() != password.val())
		{
			$('#errConfirmPassword').text("");
			confirmPasswordBool = false;
		}
		else if(regExRpass.test(confirmPassword.val()))
		{
			$('#errConfirmPassword').text("");
			confirmPasswordBool = false;
		}
		else
		{
			$('#errConfirmPassword').text("");
			confirmPasswordBool = false;
		}
	};

	function confirmPasswordAfter()
	{
		var confirmPassword = $('#confirm-password');
		var password = $('#password');

		if(confirmPassword.val() == "")
		{
			$('#errConfirmPassword').text("Please..Enter confirm password");
			confirmPasswordBool = false;
		}
		else if(confirmPassword.val() != password.val())
		{
			$('#errConfirmPassword').text("Password Missmatched");
			confirmPasswordBool = false;
		}
	};
	
	function landmark()
	{
		var landmark = $('#landmark').val();

		if(landmark == "" && landmark == null)
		{
			$('#errLandmark').text("Please enter Landmark.");
			landmarkBool = false;
		}
		else
		{
			$('#errLandmark').text("");
			landmarkBool = true;
		}
	};	

	function onReset()
	{
		$('#first-name').val("");
		$('#last-name').val("");
		$('#emailId').val("");
		$('#mobile-number').val("");
		$('#address').val("");
		$('#password').val("");
		$('#confirm-password').val("");
		$('#city-r').val("0");
		$('#state').val("0");
		$('#pincode-r').val("");
		$('#landmark').val("");
		
		$('#errFirstName').text("");
		$('#errLastName').text("");
		$('#errEmailId').text("");
		$('#errMobNumber').text("");
		$('#errAddress').text("");
        	$('#errState').text("");
        	$('#errCity').text("");
		$('#errPassword').text("");
		$('#errConfirmPassword').text("");
		$('#errPincode').text("");
		$('#errLandmark').text("");
	};

    	function checkState()
    	{
        	var state = $('#state').val();

        	if(state == null || state == 0)
        	{
            		$('#errState').text("select state");
			checkStateBool = false;
        	}
       		else
        	{
            		$('#errState').text("");
			checkStateBool = true;
        	}
    	};

    	function checkCity()
    	{
        	var city = $('#city-r').val();

        	if(city == null || city == 0)
        	{
            		$('#errCity').text("select city");
			checkCityBool = false;
        	}
        	else
        	{
           		$('#errCity').text("");
			checkCityBool = true;
        	}
    	};
    
    	function pincode()
    	{
    		var pincode = $('#pincode-r').val();

        	if(pincode == "")
        	{
            		$('#errPincode').text("Add pincode");
			pincodeBool = false;
        	}
        	else
        	{
            		$('#errPincode').text("");
            		pincodeBool = true;
        	}
    	};
    
    	function onChangeAddress()
    	{
    		if(mobileNumberBool == false)
			this.mobileNumber();
		else if(addressBool == false)
			this.address();
        	else if(checkStateBool == false)
            		this.checkState();
        	else if(checkCityBool == false)
            		this.checkCity();
		else if(mobileNumberBool && addressBool && checkStateBool && checkCityBool == true)
		{
			$('#change-address-form').submit();
			this.onReset();
		}
    	};
    
	function onSubmitValidate()
	{
		if(firstNameBool == false)
			this.firstNameRegEx();
		else if(lastNameBool == false)
			this.lastNameRegEx;
		else if(emailIdBool == false)
		{
			this.emailIdRegEx();
			this.checkEmailId();
		}
		else if(mobileNumberBool == false)
			this.mobileNumberRegEx();
		else if(addressBool == false)
			this.address();
        	else if(checkStateBool == false)
            		this.checkState();
        	else if(checkCityBool == false)
            		this.checkCity();
        	else if(pincodeBool == false)
            		this.pincode();
		else if(passwordBool == false)
			this.passwordRegEx();
		else if(confirmPasswordBool == false)
		{
			this.confirmPasswordRegEx();
			this.confirmPasswordAfter();
		}
		else if(firstNameBool && lastNameBool && emailIdBool && mobileNumberBool && addressBool && passwordBool && confirmPasswordBool && checkStateBool && checkCityBool && pincodeBool == true)
		{
			$('#register-form').submit();
			this.onReset();
		}
	};
};

//Login
var validateLogin = new validateLogin();

function validateLogin() 
{
	this.userIdCheck = userIdCheck;
	this.passwordCheck = passwordCheck;
	this.onReset = onReset;
	this.loginCredential = loginCredential;

	var userIdBool = false;
	var passlogBool = false;

	function loginCredential() 
	{
		if (userIdBool == false)
			this.userIdCheck();
		else if (passlogBool == false)
			this.passwordCheck();
		else if (userIdBool == true && passlogBool == true) 
		{
			$('#login-form').submit();
			this.onReset();
		}
	};

	function userIdCheck()
	{
		var userId = $('#userId');
		var regExM = /[a-zA-Z!$%^&*\()_+|@#~=`{}\-[\]:\";\'<>?,.\/\\[\s\]]/;

		if(userId.val() == "")
		{
			$('#errUserIdLogin').text("Please enter userId");
			userIdBool = false;
		}
		else
		{
			$('#errUserIdLogin').text("");
			userIdBool = true;
		}
	};

	function passwordCheck() 
	{
		var password = $('#login-password');

		if (password.val() == "") 
		{
			$('#errPassLogin').text("Please enter Password");
			passlogBool = false;
		} 
		else
		{
			$('#errPassLogin').text("");
			passlogBool = true;
		}
	};

	function onReset() 
	{
		$('#userId').val("");
		$('#login-password').val("");
		
		$('#errPassLogin').text("");
		$('#errUserIdLogin').text("");
	};
};

//Ajax Requests
var ajaxRequest = new ajaxRequest();

function ajaxRequest()
{
	this.addToCart = addToCart;
	this.removeFromCart = removeFromCart;
	this.changeAddress = changeAddress;
	this.getProducts = getProducts;
	this.getSubCategoryNames = getSubCategoryNames;
	this.checkCategory = checkCategory;
	this.checkState = checkState;
	this.checkCity = checkCity;
	this.checkSubCategory = checkSubCategory;
	this.searchedProduct = searchedProduct;
	this.getCityNameByState = getCityNameByState;
	this.placeOrder = placeOrder;
	this.addCategory = addCategory;
	this.addSubCategory = addSubCategory;
	this.addCity = addCity;
	this.addState = addState;
	
	function addToCart(productId)
	{	
		var contextPath = $('#contextPath').val();
		var whoLoggedIn = $('#whoLoggedIn').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					productId : productId,
					whoLoggedIn : whoLoggedIn,
					requestIdentifier : "addToCartRequest",
				},
				function(msg) 
				{
					var data = JSON.parse(msg);
					$('#card-item-count').text(data.count);
				});
	};
	
	var categoryBool = false;
	
	function checkCategory()
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					category : $('#category').val(),
					requestIdentifier : "checkCategoryRequest",
				},
				function(msg) 
				{
					if("Already Present" == msg)
					{
						$('#errCategoryPresent').text(msg);
						categoryBool = false;
					}
					else
					{
						categoryBool = true;
						$('#errCategoryPresent').text(msg);
					}
				});
	};
	
	function addCategory()
	{	
		checkCategory();
		var contextPath = $('#contextPath').val();
		if(categoryBool == true)
		{
			$.post(
					contextPath+"/ajax/ajaxController.jsp",
					{
						category : $('#category').val(),
						requestIdentifier : "addCategoryRequest",
					},
					function(msg) 
					{
						$('#errCategoryPresent').text(msg).css('color','green');
						$('#category').val("");
					});
		}
	};
	
	var subCategoryBool = false;
	
	function checkSubCategory()
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					subcategory : $('#sub-category').val(),
					requestIdentifier : "checkSubCategoryRequest",
				},
				function(msg) 
				{
					if("Already Present" == msg)
					{
						$('#errSubCategoryPresent').text(msg);
						subCategoryBool = false;
					}
					else
					{
						subCategoryBool = true;
						$('#errSubCategoryPresent').text(msg);
					}
				});
	};
	
	function addSubCategory()
	{	
		checkSubCategory();
		
		if($('#main-category-add').val() == null || $('#main-category-add').val() == "" || $('#main-category-add').val() == 0)
		{
			$('#errSubCategoryPresent').text("Select main Category First");
			subCategoryBool = false;
		}
			
		var contextPath = $('#contextPath').val();
		var mainCategory = $('#main-category-add').val();

		if(subCategoryBool == true)
		{
			$.post(
					contextPath+"/ajax/ajaxController.jsp",
					{
						mainCategory : mainCategory,
						subcategory : $('#sub-category').val(),
						requestIdentifier : "addSubCategoryRequest",
					},
					function(msg) 
					{
						$('#errSubCategoryPresent').text(msg).css('color','green');
						mainCategory.val("0");
						$('#sub-category').val("");
						
					});
		}
	};
	
	var cityBool = false;
	
	function checkCity()
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					city : $('#city').val(),
					requestIdentifier : "checkCityRequest",
				},
				function(msg) 
				{
					if("Already Present" == msg)
					{
						$('#errCityPresent').text(msg);
						cityBool = false;
					}
					else
					{
						cityBool = true;
						$('#errCityPresent').text(msg);
					}
				});
	};
	
	function addCity()
	{	
		checkSubCategory();
		
		if($('#state').val() == null || $('#state').val() == "" || $('#state').val() == 0)
		{
			$('#errCityPresent').text("Select main Category First");
			subCategoryBool = false;
		}
			
		var contextPath = $('#contextPath').val();
		if(cityBool == true)
		{
			$.post(
					contextPath+"/ajax/ajaxController.jsp",
					{
						city : $('#city').val(),
						state : $('#state').val(),
						requestIdentifier : "addCityRequest",
					},
					function(msg) 
					{
						$('#errCityPresent').text(msg).css('color','green');
						$('#state').val("0");
						$('#city').val("");
					});
		}
	};
	
	function placeOrder()
	{	
		var contextPath = $('#contextPath').val();
		var whoLoggedIn = $('#whoLoggedIn').val();
		var selectedPaymentMode = $('input[name="payment-mode-option"]:checked').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					whoLoggedIn : whoLoggedIn,
					requestIdentifier : "placeOrderRequest",
					modeOfPayment : selectedPaymentMode,
				},
				function(msg) 
				{
					var data = JSON.parse(msg);
					
					if(msg == null || "" == msg)
					{
						console.log("not placed");
					}
					else
					{
						$('#order-n').text(data.name);
						$('#address-shipping').text(data.shippingAddress);
						$('#order-id').text(data.orderId);
						$('#total-price-order').text(data.totalCost);
						
						$('.overlay').css('display','block');
						$('.order-placed').css('display','inline-block');
					}
				});
	};
	
	var stateBool = false;
	function checkState()
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					state : $('#state').val(),
					requestIdentifier : "checkStateRequest",
				},
				function(msg) 
				{
					if("Already Present" == msg)
					{
						$('#errStatePresent').text(msg);
						stateBool = false;
					}
					else
					{
						stateBool = true;
						$('#errStatePresent').text(msg);
					}
				});
	};
	
	function addState()
	{	
		checkState();
		var contextPath = $('#contextPath').val();
		if(categoryBool == true)
		{
			$.post(
					contextPath+"/ajax/ajaxController.jsp",
					{
						state : $('#state').val(),
						requestIdentifier : "addStateRequest",
					},
					function(msg) 
					{
						$('#errStatePresent').text(msg).css('color','green');
						$('#state').val("");
					});
		}
	};
	
	function removeFromCart(cartId)
	{	
		var contextPath = $('#contextPath').val();
		var whoLoggedIn = $('#whoLoggedIn').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					cartId : cartId,
					whoLoggedIn : whoLoggedIn,
					requestIdentifier : "removeFromCartRequest",
				},
				function(msg) 
				{
					if("sucess" == msg)
						window.location.reload();
					console.log(msg);
				});
	};
	
	function getProducts(categoryId)
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					categoryId : categoryId,
					requestIdentifier : "getProductsByCategoryRequest",
				},
				function(msg) 
				{
					var data = JSON.parse(msg);
					
					var str = "<div class=\"all-product-container\">";

					for (var itr in data) 
					{
						var product = data[itr];

						str += "<div class=\"product-cart\">";
					    	str += "<div class=\"product-img-container\">";
					    	str += "<img src=\"" + contextPath + "/images/" + product.product_image + "\" alt=\"image not found\">";
					    	str += "</div>";
						str += "<h4 class=\"product-name\">" + product.product_name + "</h4>";
						str += "<p class=\"mkt\">MKT: " + product.manufacturer + "</p>";
						str += "<div class=\"best-price\">";
					     	str += "<h4>Best price*</h4>";
					    	str += "<h4 class=\"best-price-rs\">Rs." + product.price + "</h4>";
					    	str += "</div>";
					    	str += "<div class=\"mrp-container\">";
					    	str += "<p>MRP </p><p class=\"mrp\">Rs. " + product.mrp + "</p>";
					    	str += "</div>";
					    	str += "<input type=\"button\" value=\"ADD TO CART\" class=\"btn\" id=\"addToCart-btn\" onclick=\"ajaxRequest.addToCart(" + product.productId + ")\">";
					    	str += "</div>";
					}
			
					str += "</div>";
					$('#all-product-container').html(str);
				});
	};
	
	function searchedProduct(productName)
	{
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					productName : productName,
					requestIdentifier : "getProductsByCategoryNameRequest",
				},
				function(msg) 
				{
					var data = JSON.parse(msg);
					var str = "<div class=\"all-product-container\">";

					for (var itr in data) 
					{
						var product = data[itr];

						str += "<div class=\"product-cart\">";
					    	str += "<div class=\"product-img-container\">";
					    	str += "<img src=\"" + contextPath + "/images/" + product.product_image + "\" alt=\"image not found\">";
					    	str += "</div>";
						str += "<h4 class=\"product-name\">" + product.product_name + "</h4>";
						str += "<p class=\"mkt\">MKT: " + product.manufacturer + "</p>";
						str += "<div class=\"best-price\">";
						str += "<h4>Best price*</h4>";
						str += "<h4 class=\"best-price-rs\">Rs." + product.price + "</h4>";
						str += "</div>";
						str += "<div class=\"mrp-container\">";
						str += "<p>MRP </p><p class=\"mrp\">Rs. " + product.mrp + "</p>";
						str += "</div>";
						str += "<input type=\"button\" value=\"ADD TO CART\" class=\"btn\" id=\"addToCart-btn\" onclick=\"ajaxRequest.addToCart(" + product.productId + ")\">";
						str += "</div>";
					}
			
					str += "</div>";
					$('#all-product-container').html(str);
				});
	};
	
	function getSubCategoryNames(categoryId)
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					categoryId : categoryId,
					requestIdentifier : "getSubCategoryRequest",
				},
				function(msg) 
				{
					var data = JSON.parse(msg);
					console.log(data);
					var str = '<option value="0">Select Sub-Category</option>';
					for (var itr in data) 
					{
						var catgeory = data[itr];
						str += '<option value="'+catgeory.categoryId+'">'+catgeory.categoryName+'</option>';
					}
					$('#sub-category-p').html(str);
				});
	};
	
	function getCityNameByState(stateName)
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					stateName : stateName,
					requestIdentifier : "getCityNameByStateRequest",
				},
				function(msg) 
				{
					var data = JSON.parse(msg);
					console.log(data);
					var str = '<option value="0">Select City</option>';
					for (var itr in data) 
					{
						var city = data[itr];
						str += '<option value="'+city.cityName+'">'+city.cityName+'</option>';
					}
					$('#city-r').html(str);
				});
	};
	
	function changeAddress()
	{	
		var contextPath = $('#contextPath').val();
		$.post(
				contextPath+"/ajax/ajaxController.jsp",
				{
					productId : productId,
					requestIdentifier : "changeAddressRequest",
				},
				function(msg) 
				{
					if("sucess" == msg)
						window.location.reload();
					console.log(msg);
				});
	};
}

//functional functions
var netmeds = new netmeds();

function netmeds()
{
	this.searchBar = searchBar;
	
	function searchBar()
	{
		if (event.key === "Enter")
		{
			var searchbarValue = $('#search-bar').val();
			
			if(searchbarValue.length > 3 )
				ajaxRequest.searchedProduct(searchbarValue);
		}
	};
};

//add product form
var validateProductAdd = new validateProductAdd();

function validateProductAdd() 
{
	this.checkProductName = checkProductName;
	this.checkProductMfg = checkProductMfg;
	this.checkProductMrp = checkProductMrp;
	this.checkProductPrice = checkProductPrice;
	this.checkProductStock = checkProductStock;
	this.checkCategory = checkCategory;
	this.checkSubCategory = checkSubCategory;
	this.onReset = onReset;
	this.addProductCredential = addProductCredential;
	this.checkregEx = checkregEx;

	var productNameBool = false;
	var manufacturerBool = false;
	var productMrpBool = false;
	var productPriceBool = false;
	var stockBool = false;
	var categoryBool = false;
	var subCategoryBool = false;
	
	function addProductCredential() 
	{
		if (productNameBool == false)
			this.checkProductName();
		else if (manufacturerBool == false)
			this.checkProductMfg();
		else if (productMrpBool == false)
			this.checkProductMrp();
		else if (productPriceBool == false)
			this.checkProductPrice();
		else if (stockBool == false)
			this.checkProductStock();
		else if (categoryBool == false)
			this.checkCategory();
		else if (subCategoryBool == false)
			this.checkCategory();
		else if (productNameBool && manufacturerBool && productMrpBool && productPriceBool && stockBool && categoryBool && subCategoryBool == true) 
		{
			$('#add-product-form').submit();
			this.onReset();
		}
	};

	function checkProductName()
	{
		var productName = $('#product-name');

		if(productName.val() == "")
		{
			$('#product-name-err').text("Please enter product name");
			productNameBool = false;
		}
		else
		{
			$('#product-name-err').text("");
			productNameBool = true;
		}
	};

	function checkProductMfg() 
	{
		var manufacturer = $('#manufacturer');

		if (manufacturer.val() == "") 
		{
			$('#manufacturer-err').text("Please enter manufacturer");
			manufacturerBool = false;
		} 
		else
		{
			$('#manufacturer-err').text("");
			manufacturerBool = true;
		}
	};
	
	function checkProductMrp() 
	{
		var productMrp = $('#product-mrp');

		if (productMrp.val() == "") 
		{
			$('#product-mrp-err').text("Please enter mrp");
			productMrpBool = false;
		} 
		else
		{
			$('#product-mrp-err').text("");
			productMrpBool = true;
		}
	};
	
	function checkProductPrice() 
	{
		var productPrice = $('#product-price');

		if (productPrice.val() == "") 
		{
			$('#product-price-err').text("Please enter price");
			productPriceBool = false;
		} 
		else
		{
			$('#product-price-err').text("");
			productPriceBool = true;
		}
	};
	
	function checkProductStock() 
	{
		var stock = $('#stock');

		if (stock.val() == "") 
		{
			$('#stock-err').text("Please enter price");
			stockBool = false;
		} 
		else
		{
			$('#stock-err').text("");
			stockBool = true;
		}
	};
	
	function checkCategory()
	{
        	var category = $('#main-category').val();

        	if(category == null || category == 0)
        	{
            		$('#cat-err').text("select category");
            		categoryBool = false;
        	}
        	else
        	{
            		$('#cat-err').text("");
            		categoryBool = true;
        	}
    	};

    	function checkSubCategory()
    	{
     		var subCategory = $('#sub-category-p').val();

        	if(subCategory == null || subCategory == 0)
        	{
            		$('#sub-cat-err').text("select sub-category");
            		subCategoryBool = false;
        	}
        	else
        	{
            		$('#sub-cat-err').text("");
            		subCategoryBool = true;
        	}
    	};
    
    	function checkregEx(validate)
    	{
    		var regExM = /[a-zA-Z!$%^&*\()_+|@#~=`{.}\-[\]:\";\'<>?,\.\/\\[\s\]]/;
    		$(validate).val($(validate).val().replace(regExM, ""));
    	};

	function onReset() 
	{
		$('#product-name').val("");
		$('#manufacturer').val("");
		$('#product-mrp').val("");
		$('#product-price').val("");
		$('#stock').val("");
		$('#main-category').val("0");
		$('#sub-category-p').val("0");
		
		$('#product-name-err').text("");
		$('#manufacturer-err').text("");
		$('#product-mrp-err').text("");
		$('#product-price-err').text("");
		$('#stock-err').text("");
		$('#cat-err').text("");
		$('#sub-cat-err').text("");
	};
};

$('#select-address').click(function(){
	$('#address-form').css('display','block');
	$('.overlay').css('display','block');
});

$('#cros').click(function(){
	$('#address-form').css('display','none');
	$('.overlay').css('display','none');
});

$('#cros-order').click(function(){
	$('.overlay').css('display','none');
	$('.order-placed').css('display','none');
	window.location.reload();
});

$('#r-link').click(function(){
	validateLogin.onReset();
   	$('#login-form-container').css('display','none');
   	$('#registration-form').css('display','inline-block');
});

$('#l-link').click(function(){
	validateRegistration.onReset();
    	$('#login-form-container').css('display','inline-block');
    	$('#registration-form').css('display','none');
    	validateRegistration.onReset();
})
