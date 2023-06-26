package com.iemr.mcts.data.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class CallDetailsReport {

	private Integer userID;
	
	private String campaignID;
	
	private Timestamp callTime;
	
	private String motherDistrict = "";
	
	private String childDistrict = "";
	
	private String phoneNumber = "";
	
	private Long motherID;
	
	private Long childID;
	
	private String status;
	
	private String remarks;
	
	private Integer count;
	
	private Integer countVerified;
	
	@Override
	public String toString()
	{

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}
}
