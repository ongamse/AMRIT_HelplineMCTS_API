package com.iemr.mcts.model.user;

import java.sql.Timestamp;

import com.iemr.mcts.model.userbeneficiary.Language;

import lombok.Data;

public @Data class UserLangMappingModel
{
	private Integer userLangID;
	private Integer userID;
	private UserModel m_user;
	private Integer languageID;
	private Language m_language;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Boolean canRead;
	private Boolean canWrite;
	private Boolean canSpeak;
}
