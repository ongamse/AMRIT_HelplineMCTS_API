package com.iemr.mcts.data.report;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.persistence.Transient;

import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;

import lombok.Data;


@Data
public class DailyReportDetail {
	
	private Timestamp date;
	
	private String districts;
	
	private Integer totalCalls;
	
	private Integer totalUniqueCalls;
	
	private Integer totalSelfNoCalls;
	
	private Integer totalOtherNoCalls;
	
	private Integer totalAnsweredCalls;

	private Integer totalVerifiedCalls;
	
	private Integer totalUnVerifiedCalls;
	

	
	
	
	@Override
	public String toString()
	{
		return new GsonBuilder().setLongSerializationPolicy(LongSerializationPolicy.STRING).serializeNulls()
				.setDateFormat("dd-MM-yyyy").create().toJson(this);

	}

}
