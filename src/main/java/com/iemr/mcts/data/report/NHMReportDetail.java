package com.iemr.mcts.data.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class NHMReportDetail {

	private Timestamp date;
	
	private String district;
	
	private String beneficiaryID;
	
	private String name;
	
	private String healthBlock;

	private String phc;
	
	private String subCenterName;

	private String facilityName;
	
	private String category;
	
	private String displayCallType;
	
	private String phoneNumber;
	
	private String callDuration;
	
	private String remark;
	
	@Override
	public String toString()
	{
		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}

}
