package com.iemr.mcts.data.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class CallAnsweredDetail {
	
	private Long motherID;
	
	private String motherName;
	
	private Long childID;
	
	private String childName;
	
	private String phoneNo;
	
	private String anmName;
	 
	private String ashaName;
	
	private String phcName;
	
	private String outboundCallType;
	
	private String displayCallType;
	
	private Timestamp callDateAndTime;
	
	private String address;

	private String districtName;
	
	private String blockName;
	
	private String subCenterName;
	
	private String remark;
	
	private String reason;

	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}
}