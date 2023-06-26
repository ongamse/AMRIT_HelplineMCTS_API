package com.iemr.mcts.model.beneficiary;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UpdateBenDemographicsModel {

	private Long beneficiaryRegID;
	
	private Integer cityID;
	private String cityName;
	private Integer stateID;
	private String stateName;
	private Integer districtID;
	private String districtName;
	
	private Integer blockID;
	private String blockName;
	
	private Integer districtBranchID;
	private String districtBranchName;
	
	private String createdBy;
	private Timestamp createdDate;

}
