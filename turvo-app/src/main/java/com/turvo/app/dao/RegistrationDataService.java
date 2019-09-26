package com.turvo.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.app.entity.Registration;
import com.turvo.app.repository.RegisterationRepository;

@Service
public class RegistrationDataService implements IRegistrationDataService {

	@Autowired
	RegisterationRepository repository;
	
	@Override
	public Double registerForSale(Registration registration) {
		Registration entry = repository.save(registration);
		return entry.getRegistrationId();
	}

}
