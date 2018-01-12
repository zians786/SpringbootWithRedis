package com.techprimers.cache.springredisexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCache {

	@Autowired
	OTPValidateImp otpValidateImp;
	
	@GetMapping("/verify/{id}/{value}")
	public String setKey(@PathVariable String id,@PathVariable String value){

		if(otpValidateImp.validate(id, value)) {
			return "Successfully Verified...";	
		}else {
			return "Invalid";
		}
		
	}
	
	@GetMapping("/getKey/{id}")
	public String getKey(@PathVariable String id) {
		return "Your Security Code: "+otpValidateImp.getValue(id);
	}
}
