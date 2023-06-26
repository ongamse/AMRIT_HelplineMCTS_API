package com.iemr.mcts.data.report;

import java.sql.Timestamp;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;

@Data
public class ComplaintReportDetails {

	private Long motherIDchildID;
	
	private String beneficiaryCallerName;

	private String beneficiaryPhoneNumber;
	
	private String anotherContactNumber;
	
	private String districtName = "";
	
	private String block="";
	
	private String village="";
	
	private String callType="";
	
	private String displayCallType="";
	
	private String typeOfComplain = "";

	private String natureOfComplaint;

	private String instituteName;

	private String designation = "";

	private String complaintAgainst = "";
	
	private Timestamp dateOfComplaint;

	private String briefofComplaint = "";
	
	private String detailsofComplaint = "";
	
	@Override
	public String toString() {

		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy HH:mm:ss").create().toJson(this);

	}




}
