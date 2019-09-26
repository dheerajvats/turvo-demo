package com.turvo.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.turvo.app.dao.utils.RegistrationStatus;
import com.turvo.app.entity.Registration;
import com.turvo.app.repository.RegisterationRepository;

@Service
public class RegistrationDataService implements IRegistrationDataService {

	@Autowired
	RegisterationRepository repository;
	
	@Autowired
	MongoTemplate regTemplate;
	
	@Override
	public Double registerForSale(Registration registration) {
		Registration entry = repository.save(registration);
		return entry.getRegistrationId();
	}

	@Override
	public List<Registration> findByCustomerAndSaleId(String customerId, String saleId) {
		Query query = new Query();
		query.addCriteria(
		    new Criteria().andOperator(
		        Criteria.where("CustomerId").is(customerId),
		        Criteria.where("FlashSaleId").is(saleId),
		        Criteria.where("Status").is(RegistrationStatus.REGISTERED)
		    )
		);
		List<Registration> reg = regTemplate.find(query, Registration.class);
		return reg;
	}
}
