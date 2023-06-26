package com.iemr.mcts.model.feedback;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.institute.Institute;
import com.iemr.mcts.model.institute.InstituteType;
import com.iemr.mcts.model.user.ProviderServiceMappingModel;
import com.iemr.mcts.model.user.UserModel;
import com.iemr.mcts.model.userbeneficiary.DesignationModel;
import com.iemr.mcts.model.userbeneficiary.District;
import com.iemr.mcts.model.userbeneficiary.DistrictBlock;
import com.iemr.mcts.model.userbeneficiary.DistrictBranchMapping;
import com.iemr.mcts.model.userbeneficiary.EmailStatus;
import com.iemr.mcts.model.userbeneficiary.StateModel;

import lombok.Data;

@Data
public class FeedbackDetailsModel
{
	private Long feedbackID;
	private List<FeedbackRequestModel> feedbackRequests;
	private List<FeedbackResponseModel> feedbackResponses;
	private List<FeedbackRequestModel> consolidatedRequests;
	private Long institutionID;
	private Institute institute;
	private String instituteName = "";
	private Integer designationID;
	private DesignationModel designationModel;
	private String designationName = "";
	private Integer severityID;
	private FeedbackSeverity severity;
	private String severityTypeName = "";
	private Integer feedbackTypeID;
	private FeedbackType feedbackType;
	private String feedbackTypeName = "";
	private Long beneficiaryRegID;
	private BeneficiaryModel beneficiary;
	private String beneficiaryName;
	private Integer serviceID;
	private ProviderServiceMappingModel mservicemaster;
	private String serviceName = "";
	private Integer userID;
	private UserModel mUser;
	private String userName;
	private String sMSPhoneNo;
	private Timestamp serviceAvailDate;
	private Boolean deleted;
	private String createdBy;
	private Timestamp createdDate;
	private String modifiedBy;
	private Timestamp lastModDate;
	private Integer feedbackStatusID;
	private FeedbackStatus feedbackStatus;
	private String feedbackStatusName;
	private String feedback;
	private Integer emailStatusID;
	private EmailStatus emailStatus;
	private String emailStatusName;
	private Long benCallID;
	private Integer subServiceID;
	private Timestamp startDate = new Timestamp(0);
	private Timestamp endDate = new Timestamp(Calendar.getInstance().getTimeInMillis());
	private Integer stateID;
	private StateModel stateModel;
	private Integer districtID;
	private District district;
	private Integer blockID;
	private DistrictBlock districtBlock;
	private Integer districtBranchID;
	private DistrictBranchMapping districtBranchMapping;
	private Integer instituteTypeID;
	private InstituteType instituteType;
	private Integer feedbackNatureID;
	private FeedbackNatureDetail feedbackNatureDetail;
}
