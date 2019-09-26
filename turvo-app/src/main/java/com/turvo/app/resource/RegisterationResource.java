package com.turvo.app.resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.app.dao.utils.Constants;
import com.turvo.app.dao.utils.Response;
import com.turvo.app.pojo.RegistrationRequest;
import com.turvo.app.pojo.RegistrationResponse;
import com.turvo.app.service.IRegistrationService;

@RestController
@CrossOrigin
public class RegisterationResource {
	
	@Autowired
	IRegistrationService regService;
	
	@PostMapping(value = "/registerForSale", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> register(@RequestBody RegistrationRequest regRequest, HttpServletRequest httpRequest) {
		
		Double regId = 0d;
		HttpStatus status;
		regId = regService.registerForSale(regRequest);
		RegistrationResponse response = new RegistrationResponse();
		if (!regId.equals(0d)) {			
			response.setMessage(Constants.REGISTRATION_SUCCESS_MESSAGE);
			response.setRegistrationId(regId);
			status = HttpStatus.OK;
		} else {
			response.setMessage(Constants.REGISTRATION_ERROR_MESSAGE);
			response.setRegistrationId(regId);
			status = HttpStatus.BAD_REQUEST;
		}
		return new ResponseEntity<Response>(response, status);
	}

}
