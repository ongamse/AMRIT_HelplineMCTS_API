package com.iemr.mcts.data.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.model.beneficiary.BenPhoneMapModel;
import com.iemr.mcts.model.beneficiary.BeneficiaryModel;

@Mapper(componentModel = "spring", imports = {BenPhoneMapModel.class})
public interface ChildDataMapper {

	ChildDataMapper INSTANCE = Mappers.getMapper(ChildDataMapper.class);
	
	@Mappings({@Mapping(source = "childValidDataHandler.child_Name", target = "firstName"),
		@Mapping(source = "childValidDataHandler.father_Name", target = "fatherName"),
		@Mapping(source = "childValidDataHandler.mother_Name", target = "motherName"),
		@Mapping(expression = "java(ChildValidDataHandler.setDobForIdentity(childValidDataHandler))", target = "DOB"),
		@Mapping(source = "childValidDataHandler.state_Name", target = "i_bendemographics.stateName"),
		@Mapping(source = "childValidDataHandler.district_Name", target = "i_bendemographics.districtName"),
		@Mapping(source = "childValidDataHandler.taluka_Name", target = "i_bendemographics.districtBranchName"),
		@Mapping(source = "childValidDataHandler.block_Name", target = "i_bendemographics.blockName"),
		@Mapping(expression = "java(BenPhoneMapModel.getBenPhoneMapModelList(childValidDataHandler.getPhone_No_of(), "
				+ "childValidDataHandler.getPhone_No(), createdBy))", target = "benPhoneMaps"),
		@Mapping(source = "childValidDataHandler.gender", target = "genderName"),
		@Mapping(source = "childValidDataHandler.caste", target = "i_bendemographics.communityName"),
		@Mapping(source = "childValidDataHandler.createdBy", target = "createdBy"),
		@Mapping(source = "childValidDataHandler.remarks", target = "remarks"),
		@Mapping(source = "childValidDataHandler.status", target = "status.status"),
		@Mapping(expression = "java(childValidDataHandler.getCreatedDateInTimestamp(childValidDataHandler))", target = "createdDate")
	})
	BeneficiaryModel ChildValidDataHandlerToRequest(ChildValidDataHandler childValidDataHandler, String createdBy);
	
	@Mappings({@Mapping(target = "child_Name", source = "request.firstName"),
		@Mapping(target = "father_Name", source = "request.fatherName"),
		@Mapping(target = "mother_Name", source = "request.motherName"),
		@Mapping(target = "state_Name", source = "request.i_bendemographics.stateName"),
		@Mapping(target = "district_Name", source = "request.i_bendemographics.districtName"),
		@Mapping(target = "taluka_Name", source = "request.i_bendemographics.districtBranchName"),
		@Mapping(target = "block_Name", source = "request.i_bendemographics.blockName"),
		@Mapping(target = "gender", source = "request.genderName"),
		@Mapping(target = "caste", source = "request.i_bendemographics.communityName"),
		@Mapping(target = "createdBy", source = "request.createdBy"),
		@Mapping(target = "remarks", source = "request.remarks"),
		@Mapping(target = "status", source = "request.status.status"),
		@Mapping(expression = "java(request.getJavaSqlData(request.getDOB()))", target = "DOB"),
		@Mapping(expression = "java(request.getJavaSqlData(request.getCreatedDate()))", target = "createdDate")
	})
	ChildValidDataHandler RequestToChildValidDataHandler(BeneficiaryModel request);
	
	List<ChildValidDataHandler> RequestListToChildValidDataHandlerList(List<BeneficiaryModel> requests);
}
