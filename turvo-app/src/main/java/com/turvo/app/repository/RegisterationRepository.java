package com.turvo.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.turvo.app.entity.Registration;

@Repository
public interface RegisterationRepository extends MongoRepository<Registration, Double>{

}
