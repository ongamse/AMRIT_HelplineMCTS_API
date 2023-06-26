package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryDemographicsModel;
import com.iemr.mcts.model.user.NotificationModel;
import com.iemr.mcts.model.user.UserLangMappingModel;

import lombok.Data;

public @Data class Language
{
	private Integer languageID;
	private List<BeneficiaryDemographicsModel> beneficiariesDemographics;
	private List<UserLangMappingModel> userLangMappingModels;
	private List<NotificationModel> notificationModels;
	private String languageName;
	private String languageDesc;
	private String propertyFilePath;
	private String ivrFilePath;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
