package com.iemr.mcts.data.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class UniqueCallReport {

	private Integer userID;

	private Timestamp callTime;

	private Long motherID;
	
	private String status;
	
	private String remarks;
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}

	
}
