package com.turvo.app.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Counters")
public class Counters {
	
	@Id
	private String id;
	
	@Field(value = "sequence_number")
	private Double sequence_number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getSequence_number() {
		return sequence_number;
	}

	public void setSequence_number(Double sequence_number) {
		this.sequence_number = sequence_number;
	}

}
