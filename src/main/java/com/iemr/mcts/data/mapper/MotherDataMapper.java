package com.iemr.mcts.data.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.mcts.data.domain.Address;
import com.iemr.mcts.data.domain.Contact;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;
import com.iemr.mcts.model.beneficiary.BenPhoneMapModel;
import com.iemr.mcts.model.beneficiary.BeneficiaryModel;

@Mapper(componentModel = "spring", imports = {Address.class, Contact.class, BenPhoneMapModel.class})
public interface MotherDataMapper {

	MotherDataMapper INSTANCE = Mappers.getMapper(MotherDataMapper.class);
	
	@Mappings({@Mapping(source = "mctsDataReaderDetail.name", target = "firstName"),
		@Mapping(source = "mctsDataReaderDetail.husband_Name", target = "spouseName"),
		@Mapping(source = "mctsDataReaderDetail.state_Name", target = "i_bendemographics.stateName"),
		@Mapping(source = "mctsDataReaderDetail.district_Name", target = "i_bendemographics.districtName"),
		@Mapping(source = "mctsDataReaderDetail.taluka_Name", target = "i_bendemographics.districtBranchName"),
		@Mapping(source = "mctsDataReaderDetail.block_Name", target = "i_bendemographics.blockName"),
		@Mapping(expression = "java(BenPhoneMapModel.getBenPhoneMapModelList(mctsDataReaderDetail.getPhoneNo_Of_Whom(), "
				+ "mctsDataReaderDetail.getWhom_PhoneNo(), createdBy))", target = "benPhoneMaps"),
		@Mapping(source = "mctsDataReaderDetail.age", target = "age"),
		@Mapping(source = "mctsDataReaderDetail.caste", target = "i_bendemographics.communityName"),
		@Mapping(source = "mctsDataReaderDetail.remarks", target = "remarks"),
		@Mapping(source = "mctsDataReaderDetail.status", target = "status.status"),
		@Mapping(source = "mctsDataReaderDetail.createdBy", target = "createdBy"),
		@Mapping(expression = "java(mctsDataReaderDetail.getCreatedDateInTimestamp(mctsDataReaderDetail))", target = "createdDate")
	})

	BeneficiaryModel MctsDataReaderDetailToRequest(MctsDataReaderDetail mctsDataReaderDetail, String createdBy);
	
	@Mappings({@Mapping(target = "name", source = "request.firstName"),
		@Mapping(target = "husband_Name", source = "request.spouseName"),
		@Mapping(target = "state_Name", source = "request.i_bendemographics.stateName"),
		@Mapping(target = "district_Name", source = "request.i_bendemographics.districtName"),
		@Mapping(target = "taluka_Name", source = "request.i_bendemographics.districtBranchName"),
		@Mapping(target = "block_Name", source = "request.i_bendemographics.blockName"),
		@Mapping(target = "age", source = "request.age"),
		@Mapping(target = "caste", source = "request.i_bendemographics.communityName"),
		@Mapping(target = "remarks", source = "request.remarks"),
		@Mapping(target = "status", source = "request.status.status"),
		@Mapping(target = "createdBy", source = "request.createdBy"),
		@Mapping(expression = "java(request.getJavaSqlData(request.getDOB()))", target = "birth_Date"),
		@Mapping(expression = "java(request.getJavaSqlData(request.getCreatedDate()))", target = "createdDate")
	})
	MctsDataReaderDetail RequestToMctsDataReaderDetail(BeneficiaryModel request);
	
	List<MctsDataReaderDetail> RequestListToMctsDataReaderDetailList(List<BeneficiaryModel> requests);
}
