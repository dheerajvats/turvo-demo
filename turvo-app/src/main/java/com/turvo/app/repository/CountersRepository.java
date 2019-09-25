package com.turvo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.turvo.app.entity.Counters;

public interface CountersRepository extends MongoRepository<Counters, String>{

}
