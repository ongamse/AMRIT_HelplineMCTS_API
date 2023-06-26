package com.iemr.mcts.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.mcts.model.beneficiary.BenPhoneMapModel;
import com.iemr.mcts.model.beneficiary.BeneficiaryModel;
import com.iemr.mcts.model.beneficiary.BeneficiarySearchModal;

@Mapper(componentModel = "spring", imports = {BenPhoneMapModel.class})
public interface SearchDataMapper {
	
	SearchDataMapper INSTANCE = Mappers.getMapper(SearchDataMapper.class);
	
	@Mappings({@Mapping(source = "modal.firstName", target = "firstName"),
		@Mapping(source = "modal.lastName", target = "lastName"),
		@Mapping(source = "modal.stateName", target = "i_bendemographics.stateName"),
		@Mapping(source = "modal.stateID", target = "i_bendemographics.stateID"),
		@Mapping(source = "modal.districtName", target = "i_bendemographics.districtName"),
		@Mapping(source = "modal.districtID", target = "i_bendemographics.districtID"),
		@Mapping(source = "modal.districtBranchName", target = "i_bendemographics.districtBranchName"),
		@Mapping(source = "modal.districtBranchID", target = "i_bendemographics.districtBranchID"),
		@Mapping(source = "modal.blockName", target = "i_bendemographics.blockName"),
		@Mapping(source = "modal.blockID", target = "i_bendemographics.blockID"),
		@Mapping(source = "modal.genderID", target = "genderID"),
//		@Mapping(source = "modal.genderName", target = "genderName"),
		@Mapping(expression = "java(BenPhoneMapModel.getBenPhoneMapModelList(modal.getContactNumber()))", target = "benPhoneMaps"),
		@Mapping(source = "modal.createdBy", target = "createdBy")
	})
	BeneficiaryModel ModalToBeneficiaryModel(BeneficiarySearchModal modal);

}
