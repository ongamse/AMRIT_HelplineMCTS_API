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
