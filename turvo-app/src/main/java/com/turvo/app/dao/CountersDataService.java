package com.turvo.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.turvo.app.entity.Counters;

@Service
public class CountersDataService implements ICountersDataService {
	
	@Autowired
	MongoTemplate countersTemplate;

	@Override
	public Double getNextValue(String counterKey) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(counterKey));
		
		Update update = new Update();
		update.inc("sequence_number", 1);
		
		Counters counter = countersTemplate.findAndModify(query, update, Counters.class);
		return counter.getSequence_number();
	}

}
