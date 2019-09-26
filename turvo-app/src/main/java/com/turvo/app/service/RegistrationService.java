package com.turvo.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.ICountersDataService;
import com.turvo.app.dao.IFlashSaleDataService;
import com.turvo.app.dao.IRegistrationDataService;
import com.turvo.app.dao.utils.RegistrationStatus;
import com.turvo.app.entity.FlashSale;
import com.turvo.app.entity.Registration;
import com.turvo.app.pojo.RegistrationRequest;

@Service
public class RegistrationService implements IRegistrationService {
	
	@Autowired
	IRegistrationDataService regDataService;
	
	@Autowired
	ICountersDataService countersDataService;
	
	@Autowired
	IFlashSaleDataService flashSaleDataService;

	@Override
	public Double registerForSale(RegistrationRequest request) {
		Double regId = 0d;
		if(checkRegistrationActive(request.getSaleId())) {
			Registration registration = registrationDAOConvertor(request);
			regId = regDataService.registerForSale(registration);
		}
		return regId;
	}
	
	private Registration registrationDAOConvertor(RegistrationRequest request) {
		Registration registration = new Registration();
		registration.setCustomerId(request.getCustomerId());
		registration.setFlashSaleId(request.getSaleId());
		registration.setRegStatus(RegistrationStatus.REGISTERED);
		registration.setRegistrationId(countersDataService.getNextValue("registrationid"));
		return registration;
	}
	
	private Boolean checkRegistrationActive(String saleId) {
		FlashSale sale = flashSaleDataService.findBySaleId(saleId);
		return sale.getRegistrationOpen();
	}
	
}