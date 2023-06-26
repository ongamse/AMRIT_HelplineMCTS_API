package com.iemr.mcts.data.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Identity {
	private String identityNo;
	private Integer identityNameId;
	private String identityName;//
	private Integer identityTypeId;
	private String identityType;//
	private Timestamp issueDate;
	private Timestamp expiryDate;
	private Boolean isVerified;
	private String identityFilePath;
	
	
}
