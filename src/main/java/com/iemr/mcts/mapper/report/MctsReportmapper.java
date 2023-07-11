/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.mapper.report;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.mcts.data.report.BenCallDetail;
import com.iemr.mcts.data.report.CallAnsweredDetail;
import com.iemr.mcts.data.report.CallDetailsReport;
import com.iemr.mcts.data.report.ComplaintReportDetails;
import com.iemr.mcts.data.report.CongenitalAnomalies;
import com.iemr.mcts.data.report.CongenitalAnomaliesReport;
import com.iemr.mcts.data.report.FeedbacksDetail;
import com.iemr.mcts.data.report.HighRisk;
import com.iemr.mcts.data.report.HighRiskReportDetail;
import com.iemr.mcts.data.report.NHMReportDetail;
import com.iemr.mcts.data.report.UniqueCallReport;

@Mapper(componentModel = "spring")
public interface MctsReportmapper {

	MctsReportmapper INSTANCE = Mappers.getMapper(MctsReportmapper.class);

	@Mappings({ @Mapping(target = "date", expression = "java(benCallDetail.getDate())"),
			@Mapping(target = "district", expression = "java(benCallDetail.getObdetail().getMotherDetail().getDistrictName())"),
			@Mapping(target = "beneficiaryID", expression = "java(benCallDetail.getObdetail().getMotherDetail().getIdentityDetail().getBeneficiaryID())"),
			@Mapping(target = "name", expression = "java(benCallDetail.getObdetail().getMotherDetail().getName())"),
			@Mapping(target = "healthBlock", expression = "java(benCallDetail.getObdetail().getMotherDetail().getBlockName())"),
			@Mapping(target = "phc", expression = "java(benCallDetail.getObdetail().getMotherDetail().getPHCName())"),
			@Mapping(target = "subCenterName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getSubCenterName())"),
			@Mapping(target = "facilityName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getFacilityName())"),
			@Mapping(target = "category", expression = "java(benCallDetail.getSubCategory())"),
			@Mapping(target = "displayCallType", expression = "java(benCallDetail.getObdetail().getDisplayOBCallType())"),
			@Mapping(target = "phoneNumber", expression = "java(benCallDetail.getPhoneNumber())"),
			@Mapping(target = "callDuration", expression = "java(benCallDetail.getCallDuration())"),
			@Mapping(target = "remark", expression = "java(benCallDetail.getRemark())")})
	NHMReportDetail mapNHMMotherReport(BenCallDetail benCallDetail);
	
	@Mappings({ @Mapping(target = "date", expression = "java(benCallDetail.getDate())"),
		@Mapping(target = "district", expression = "java(benCallDetail.getObdetail().getChildDetail().getDistrictName())"),
		@Mapping(target = "beneficiaryID", expression = "java(benCallDetail.getObdetail().getChildDetail().getIdentityDetail().getBeneficiaryID())"),
		@Mapping(target = "name", expression = "java(benCallDetail.getObdetail().getChildDetail().getChildName())"),
		@Mapping(target = "healthBlock", expression = "java(benCallDetail.getObdetail().getChildDetail().getBlockName())"),
		@Mapping(target = "phc", expression = "java(benCallDetail.getObdetail().getChildDetail().getPhcName())"),
		@Mapping(target = "subCenterName", expression = "java(benCallDetail.getObdetail().getChildDetail().getSubCenterName())"),
		@Mapping(target = "facilityName", expression = "java(benCallDetail.getObdetail().getChildDetail().getFacilityType())"),
		@Mapping(target = "category", expression = "java(benCallDetail.getSubCategory())"),
		@Mapping(target = "displayCallType", expression = "java(benCallDetail.getObdetail().getDisplayOBCallType())"),
		@Mapping(target = "phoneNumber", expression = "java(benCallDetail.getPhoneNumber())"),
		@Mapping(target = "callDuration", expression = "java(benCallDetail.getCallDuration())"),
		@Mapping(target = "remark", expression = "java(benCallDetail.getRemark())")})
	NHMReportDetail mapNHMChildReport(BenCallDetail benCallDetail);
	
	@Mappings({ @Mapping(target = "motherIDchildID", expression = "java(feedback.getBenCallDetails().getObdetail().getMotherDetail().getMctsIDNo())"),
		@Mapping(target = "beneficiaryCallerName", expression = "java(feedback.getBenCallDetails().getObdetail().getMotherDetail().getName())"),
		@Mapping(target = "beneficiaryPhoneNumber", expression = "java(feedback.getBenCallDetails().getObdetail().getMotherDetail().getWhomPhoneNo())"),
		@Mapping(target = "districtName", expression = "java(feedback.getBenCallDetails().getObdetail().getMotherDetail().getDistrictName())"),
		@Mapping(target = "callType", expression = "java(feedback.getBenCallDetails().getObdetail().getOutboundCallType())"),
		@Mapping(target = "displayCallType", expression = "java(feedback.getBenCallDetails().getObdetail().getDisplayOBCallType())"),
		@Mapping(target = "block", expression = "java(feedback.getBenCallDetails().getObdetail().getMotherDetail().getBlockName())"),
		@Mapping(target = "village", expression = "java(feedback.getBenCallDetails().getObdetail().getMotherDetail().getGPVillage())"),
		@Mapping(target = "typeOfComplain", expression = "java(feedback.getTypeOfComplain())"),
		@Mapping(target = "natureOfComplaint", expression = "java(feedback.getNatureOfComplaint())"),
		@Mapping(target = "instituteName", expression = "java(feedback.getInstituteName())"),
		@Mapping(target = "designation", expression = "java(feedback.getDesignation())"),
		@Mapping(target = "complaintAgainst", expression = "java(feedback.getComplaintAgainst())"),
		@Mapping(target = "dateOfComplaint", expression = "java(feedback.getCreatedDate())"),
		@Mapping(target = "briefofComplaint", expression = "java(feedback.getBriefofComplaint())")})
	ComplaintReportDetails mapMotherComplaint(FeedbacksDetail feedback);

	@Mappings({ @Mapping(target = "motherIDchildID", expression = "java(feedback.getBenCallDetails().getObdetail().getChildDetail().getMCTSIDnoChild_ID())"),
		@Mapping(target = "beneficiaryCallerName", expression = "java(feedback.getBenCallDetails().getObdetail().getChildDetail().getChildName())"),
		@Mapping(target = "beneficiaryPhoneNumber", expression = "java(feedback.getBenCallDetails().getObdetail().getChildDetail().getPhoneNo())"),
		@Mapping(target = "districtName", expression = "java(feedback.getBenCallDetails().getObdetail().getChildDetail().getDistrictName())"),
		@Mapping(target = "block", expression = "java(feedback.getBenCallDetails().getObdetail().getChildDetail().getBlockName())"),
		@Mapping(target = "village", expression = "java(feedback.getBenCallDetails().getObdetail().getChildDetail().getGpVillage())"),
		@Mapping(target = "callType", expression = "java(feedback.getBenCallDetails().getObdetail().getOutboundCallType())"),
		@Mapping(target = "displayCallType", expression = "java(feedback.getBenCallDetails().getObdetail().getDisplayOBCallType())"),
		@Mapping(target = "typeOfComplain", expression = "java(feedback.getTypeOfComplain())"),
		@Mapping(target = "natureOfComplaint", expression = "java(feedback.getNatureOfComplaint())"),
		@Mapping(target = "instituteName", expression = "java(feedback.getInstituteName())"),
		@Mapping(target = "designation", expression = "java(feedback.getDesignation())"),
		@Mapping(target = "complaintAgainst", expression = "java(feedback.getComplaintAgainst())"),
		@Mapping(target = "dateOfComplaint", expression = "java(feedback.getCreatedDate())"),
		@Mapping(target = "briefofComplaint", expression = "java(feedback.getBriefofComplaint())")})
	ComplaintReportDetails mapChildComplaint(FeedbacksDetail feedback);
	
	@Mappings({ 
		@Mapping(target = "userID", expression = "java(benCallDetail.getUserID())"),
		@Mapping(target = "campaignID", expression = "java(benCallDetail.checkOutbound())"),
		@Mapping(target = "callTime", expression = "java(benCallDetail.getDate())"),
		@Mapping(target = "phoneNumber", expression = "java(benCallDetail.getPhoneNumber())"),
		@Mapping(target = "count", expression = "java(benCallDetail.getObdetail().getCount())"),
		@Mapping(target = "status", expression = "java(benCallDetail.getCallSubTypeName())"),
		@Mapping(target = "motherDistrict", expression = "java((benCallDetail.getObdetail().getMotherDetail().getDistrictName() != null) ?  benCallDetail.getObdetail().getMotherDetail().getDistrictName() : null)"),
		@Mapping(target = "motherID", expression = "java((benCallDetail.getObdetail().getMotherDetail().getMctsIDNo() != null) ? benCallDetail.getObdetail().getMotherDetail().getMctsIDNo() : null)"),
		@Mapping(target = "remarks", expression = "java((benCallDetail.getRemark() != null) ? benCallDetail.getRemark() : null)")
		})
	CallDetailsReport mapMotherCallReport(BenCallDetail benCallDetail);
	
	@Mappings({ 
		@Mapping(target = "userID", expression = "java(benCallDetail.getUserID())"),
		@Mapping(target = "campaignID", expression = "java(benCallDetail.checkOutbound())"),
		@Mapping(target = "callTime", expression = "java(benCallDetail.getDate())"),
		@Mapping(target = "phoneNumber", expression = "java(benCallDetail.getPhoneNumber())"),
		@Mapping(target = "count", expression = "java(benCallDetail.getObdetail().getCount())"),
		@Mapping(target = "status", expression = "java(benCallDetail.getCallSubTypeName())"),
		@Mapping(target = "childDistrict", expression = "java((benCallDetail.getObdetail().getChildDetail().getDistrictName() != null) ? benCallDetail.getObdetail().getChildDetail().getDistrictName() : null)"),
		@Mapping(target = "childID", expression = "java((benCallDetail.getObdetail().getChildDetail().getMCTSIDnoChild_ID() != null) ? benCallDetail.getObdetail().getChildDetail().getMCTSIDnoChild_ID() : null)"),
		@Mapping(target = "remarks", expression = "java((benCallDetail.getRemark() != null) ? benCallDetail.getRemark() : null)")
		})
	CallDetailsReport mapChildCallReport(BenCallDetail benCallDetail);

	
	@Mappings({ @Mapping(target = "userID", expression = "java(benCallDetail.getUserID())"),
		@Mapping(target = "callTime", expression = "java(benCallDetail.getDate())"),
		@Mapping(target = "status", expression = "java(benCallDetail.getCallSubTypeName())"),
		@Mapping(target = "motherID", expression = "java((benCallDetail.getObdetail().getMotherDetail().getMctsIDNo() != null) ? benCallDetail.getObdetail().getMotherDetail().getMctsIDNo() : null)"),
		@Mapping(target = "remarks", expression = "java((benCallDetail.getRemark() != null) ? benCallDetail.getRemark() : null)")})
	UniqueCallReport mapUniqueCallReport(BenCallDetail benCallDetail);


		@Mappings({ @Mapping(target = "motherID", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getMotherID())"),
			@Mapping(target = "childID", expression = "java(congenitalAnomalies.getChildID())"),
			@Mapping(target = "congenitalAnomalies", expression = "java(congenitalAnomalies.getCongenitalAnomalies())"),
			@Mapping(target = "remarks", expression = "java(congenitalAnomalies.getRemarks())"),
			@Mapping(target = "childName", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getChildName())"),
			@Mapping(target = "phoneNo", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getPhoneNo())"),
			@Mapping(target = "anmName", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getAnmName())"),
			@Mapping(target = "ashaName", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getAshaName())"),
			@Mapping(target = "motherName", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getMotherName())"),
			@Mapping(target = "dob", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getDob())"),
			@Mapping(target = "address", expression = "java(congenitalAnomalies.getBenCallDetails().getObdetail().getChildDetail().getAddress())")})
		CongenitalAnomaliesReport mapCongenitalAnomaliesReport(CongenitalAnomalies congenitalAnomalies);
		
		@Mappings({ @Mapping(target = "mctsIDNo", expression = "java(motherDetail.getMctsIDNo())"),
			@Mapping(target = "name", expression = "java(motherDetail.getName())"),
			@Mapping(target = "husbandName", expression = "java(motherDetail.getHusbandName())"),
			@Mapping(target = "age", expression = "java(motherDetail.getAge())"),
			@Mapping(target = "districtName", expression = "java(motherDetail.getDistrictName())"),
			@Mapping(target = "talukaName", expression = "java(motherDetail.getTalukaName())"),
			@Mapping(target = "blockName", expression = "java(motherDetail.getBlockName())"),
			@Mapping(target = "phcID", expression = "java(motherDetail.getPHCID())"),
			@Mapping(target = "phcName", expression = "java(motherDetail.getPHCName())"),
			@Mapping(target = "subPhcID", expression = "java(motherDetail.getSUBPHCID())"),
			@Mapping(target = "subPhcName", expression = "java(motherDetail.getSUBPHCName())"),
			@Mapping(target = "phoneNoOfWhom", expression = "java(motherDetail.getPhoneNoOfWhom())"),
			@Mapping(target = "whomPhoneNo", expression = "java(motherDetail.getWhomPhoneNo())"),
			@Mapping(target = "birthDate", expression = "java(motherDetail.getBirthDate())"),
			@Mapping(target = "edd", expression = "java(motherDetail.getEdd())"),
			@Mapping(target = "highRiskReason", expression = "java(motherDetail.getHighRiskReason())"),
			@Mapping(target = "lmpDate", expression = "java(motherDetail.getLmpDate())")})
		HighRiskReportDetail mapHighRiskReport(HighRisk motherDetail);
		
		@Mappings({ @Mapping(target = "mctsIDNo", expression = "java(benCallDetail.getObdetail().getMotherDetail().getMctsIDNo())"),
			@Mapping(target = "name", expression = "java(benCallDetail.getObdetail().getMotherDetail().getName())"),
			@Mapping(target = "husbandName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getHusbandName())"),
			@Mapping(target = "age", expression = "java(benCallDetail.getObdetail().getMotherDetail().getAge())"),
			@Mapping(target = "districtName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getDistrictName())"),
			@Mapping(target = "talukaName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getTalukaName())"),
			@Mapping(target = "blockName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getBlockName())"),
			@Mapping(target = "phcID", expression = "java(benCallDetail.getObdetail().getMotherDetail().getPHCID())"),
			@Mapping(target = "phcName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getPHCName())"),
			@Mapping(target = "subPhcID", expression = "java(benCallDetail.getObdetail().getMotherDetail().getSUBPHCID())"),
			@Mapping(target = "subPhcName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getSUBPHCName())"),
			@Mapping(target = "phoneNoOfWhom", expression = "java(benCallDetail.getObdetail().getMotherDetail().getPhoneNoOfWhom())"),
			@Mapping(target = "whomPhoneNo", expression = "java(benCallDetail.getObdetail().getMotherDetail().getWhomPhoneNo())"),
			@Mapping(target = "birthDate", expression = "java(benCallDetail.getObdetail().getMotherDetail().getBirthDate())"),
			@Mapping(target = "edd", expression = "java(benCallDetail.getObdetail().getMotherDetail().getEdd())"),
			@Mapping(target = "highRiskReason", expression = "java(benCallDetail.getObdetail().getMotherDetail().getHighRiskReason())"),
			@Mapping(target = "lmpDate", expression = "java(benCallDetail.getObdetail().getMotherDetail().getLmpDate())")})
		HighRiskReportDetail mapHighRiskMotherCall(BenCallDetail benCallDetail);
		
		@Mappings({ @Mapping(target = "motherID", expression = "java(benCallDetail.getObdetail().getMotherDetail().getMctsIDNo())"),
			@Mapping(target = "motherName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getName())"),
			@Mapping(target = "phoneNo", expression = "java(benCallDetail.getPhoneNumber())"),
			@Mapping(target = "remark", expression = "java((benCallDetail.getRemark() != null) ? benCallDetail.getRemark() : null)"),
			@Mapping(target = "anmName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getAnmName())"),
			@Mapping(target = "ashaName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getAshaName())"),
			@Mapping(target = "phcName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getPHCName())"),
			@Mapping(target = "outboundCallType", expression = "java(benCallDetail.getObdetail().getOutboundCallType())"),
			@Mapping(target = "displayCallType", expression = "java(benCallDetail.getObdetail().getDisplayOBCallType())"),
			@Mapping(target = "callDateAndTime", expression = "java(benCallDetail.getDate())"),
			@Mapping(target = "address", expression = "java(benCallDetail.getObdetail().getMotherDetail().getAddress())"),
			@Mapping(target = "reason", expression = "java(benCallDetail.getCallSubTypeName())"),
			@Mapping(target = "districtName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getDistrictName())"),
			@Mapping(target = "blockName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getBlockName())"),
			@Mapping(target = "subCenterName", expression = "java(benCallDetail.getObdetail().getMotherDetail().getSubCenterName())")})
		CallAnsweredDetail mapMotherAnsweredReport(BenCallDetail benCallDetail);
		
		@Mappings({
			@Mapping(target = "motherID", expression = "java(benCallDetail.getObdetail().getChildDetail().getMotherID())"),
			@Mapping(target = "motherName", expression = "java(benCallDetail.getObdetail().getChildDetail().getMotherName())"),
			@Mapping(target = "childID", expression = "java(benCallDetail.getObdetail().getChildDetail().getMCTSIDnoChild_ID())"),
			@Mapping(target = "childName", expression = "java(benCallDetail.getObdetail().getChildDetail().getChildName())"),
			@Mapping(target = "phoneNo", expression = "java(benCallDetail.getPhoneNumber())"),
			@Mapping(target = "remark", expression = "java((benCallDetail.getRemark() != null) ? benCallDetail.getRemark() : null)"),
			@Mapping(target = "anmName", expression = "java(benCallDetail.getObdetail().getChildDetail().getAnmName())"),
			@Mapping(target = "ashaName", expression = "java(benCallDetail.getObdetail().getChildDetail().getAshaName())"),
			@Mapping(target = "phcName", expression = "java(benCallDetail.getObdetail().getChildDetail().getPhcName())"),
			@Mapping(target = "outboundCallType", expression = "java(benCallDetail.getObdetail().getOutboundCallType())"),
			@Mapping(target = "displayCallType", expression = "java(benCallDetail.getObdetail().getDisplayOBCallType())"),
			@Mapping(target = "callDateAndTime", expression = "java(benCallDetail.getDate())"),
			@Mapping(target = "address", expression = "java(benCallDetail.getObdetail().getChildDetail().getAddress())"),
			@Mapping(target = "reason", expression = "java(benCallDetail.getCallSubTypeName())"),
			@Mapping(target = "districtName", expression = "java(benCallDetail.getObdetail().getChildDetail().getDistrictName())"),
			@Mapping(target = "blockName", expression = "java(benCallDetail.getObdetail().getChildDetail().getBlockName())"),
			@Mapping(target = "subCenterName", expression = "java(benCallDetail.getObdetail().getChildDetail().getSubCenterName())")})
		CallAnsweredDetail mapChildAnsweredCall(BenCallDetail benCallDetail);


}
