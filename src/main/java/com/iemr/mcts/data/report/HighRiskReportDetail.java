package com.iemr.mcts.data.report;

import java.sql.Date;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;


@Data
public class HighRiskReportDetail {

	private Long mctsIDNo;
	private String name;
	private String husbandName;
	private Long age;
	private String districtName;
	private String talukaName;
	private String blockName;
	private String phcID;
	private String phcName;
	private String subPhcID;
	private String subPhcName;
	private String phoneNoOfWhom; 
	private String whomPhoneNo;
	private Date birthDate;
	private Date lmpDate;
	private Date edd;
	private String highRiskReason;
	

	@Override
	public String toString()
	{
		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}
	
}
