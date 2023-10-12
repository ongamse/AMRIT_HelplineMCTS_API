/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
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
