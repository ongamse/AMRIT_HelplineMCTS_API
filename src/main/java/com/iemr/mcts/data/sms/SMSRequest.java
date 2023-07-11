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
package com.iemr.mcts.data.sms;

import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Data
public class SMSRequest
{
	private Integer providerServiceMapID;
	private Integer smsTemplateTypeID;
	private Integer smsTemplateID;
	private Long beneficiaryRegID;
	private Integer stateID;
	private Integer districtID;
	private Integer blockID;
	private Boolean is1097 = false;
	private Long userID;
	private Integer InstituteID;
	private Long feedbackID;
	private String createdBy;
	private String alternateNo;
	private String smsText;
	private Long obCallID;
	
	/**
	 * OutputMapper
	 */
	private static OutputMapper outputMapper = new OutputMapper();
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return outputMapper.gson().toJson(this);
	}
}
