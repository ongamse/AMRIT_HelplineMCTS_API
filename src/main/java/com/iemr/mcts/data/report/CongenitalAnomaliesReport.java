package com.iemr.mcts.data.report;

import java.sql.Date;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class CongenitalAnomaliesReport {
	
	private Long motherID;
	
	private String motherName;
	
	private Long childID;
	
	private String childName;
	
	private Date dob;
	
	private String address;
	
	private String anmName;
	 
	private String ashaName;
	
	private String phoneNo;
	
	private String congenitalAnomalies;
	
	private String remarks;

	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}
}
