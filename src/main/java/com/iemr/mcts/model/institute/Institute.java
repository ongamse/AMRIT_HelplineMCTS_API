package com.iemr.mcts.model.institute;

import java.sql.Timestamp;
import java.util.List;

import com.iemr.mcts.model.feedback.FeedbackDetailsModel;
import com.iemr.mcts.model.userbeneficiary.District;
import com.iemr.mcts.model.userbeneficiary.DistrictBlock;
import com.iemr.mcts.model.userbeneficiary.DistrictBranchMapping;
import com.iemr.mcts.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class Institute
{
	private Integer institutionID;
	private List<InstituteDirectoryMapping> instituteDirectory;
	private List<FeedbackDetailsModel> feedbackDetailsModel;
	private String institutionName;
	private Integer stateID;
	private StateModel stateModels;
	private Integer districtID;
	private District district;
	private Integer blockID;
	private DistrictBlock districtBlock;
	private Integer districtBranchMappingID;
	private DistrictBranchMapping m_districtbranchmapping;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private String govtInstituteID;
	private String address;
	private String contactPerson1;
	private String contactPerson1_Email;
	private String contactNo1;
	private String contactPerson2;
	private String contactPerson2_Email;
	private String contactNo2;
	private String contactPerson3;
	private String contactPerson3_Email;
	private String contactNo3;
	private String website;
	private Integer providerServiceMapID;
}
