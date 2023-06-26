package com.iemr.mcts.model.userbeneficiary;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;
import com.iemr.mcts.model.user.ServiceProvider;
import com.iemr.mcts.model.user.UserModel;
import com.iemr.mcts.model.user.UserServiceRoleMappingModel;

import lombok.Data;

public @Data class Status
{
	private Integer statusID;
	private List<UserModel> m_Users;
	private List<BeneficiaryModel> beneficiaryModels;
	private List<ServiceProvider> serviceProviders;
	private List<ProviderServiceMappingModel> providerServiceMappingModels;
	private List<UserServiceRoleMappingModel> userServiceRoleMappingModels;
	private String status;
	private String statusDesc;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
}
