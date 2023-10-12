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
package com.iemr.mcts.data.domain;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

@Data
public class IdentityDTO {

	private String eventTypeName;
	private Timestamp eventTypeDate;
	private Integer agentId;
	private String agentName;
	private Integer agentPSMapId;
	private String agentComment;
	private Integer serviceId;
	private String serviceName;
	private Integer serviceProviderId;
	private String serviceProviderName;
	private Integer stateId;
	private String stateName;
	private Integer providerServiceMapId;

	private Integer areaId;
	private Integer beneficiaryId;
	private Integer beneficiaryRegId;
	private Integer communityId;
	private String community;
	private Timestamp dob;
	private Integer age;
	private Timestamp marriageDate;
	private Integer ageAtMarriage;
	private Integer educationId;
	private String education;
	private Boolean emergencyRegistration;
	private Integer healthCareWorkerId;
	private String healthCareWorker;
	private String fatherName;
	private String motherName;
	private String firstName;
	private Integer genderId;
	private String gender;
	private Integer incomeStatusId;
	private String incomeStatus;
	private String lastName;
	private Integer maritalStatusId;
	private String maritalStatus;
	private String middleName;
	private Integer occupationId;
	private String occupation;
	private Integer phcId;
	private Integer parkingPlaceId;
	private String placeOfWork;
	private String literacyStatus;
	private Integer preferredLanguageId;
	private String preferredLanguage;
	private Integer religionId;
	private String religion;
	private String remarks;
	private Integer servicePointId;
	private String sourceOfInfo;
	private String spouseName;
	private Integer statusId;
	private String status;
	private Integer titleId;
	private String title;
	private Integer zoneId;

	// address
	private Address currentAddress;
	private Address permanentAddress;
	private Address emergencyAddress;
	private Boolean isPermAddrSameAsCurrAddr;
	private Boolean isPermAddrSameAsEmerAddr;
	private Boolean isEmerAddrSameAsCurrAddr;
	private Boolean isEmerAddrSameAsPermAddr;
	private String addressType;

	// contacts
	private String preferredEmailId;
	private Contact contact;

	// family tagging
	List<BenFamilyDTO> benFamilyDTOs;

	// identities
	private List<Identity> identities;

	private Integer sexualOrientationID;
	private String sexualOrientationType;
	private Boolean isHIVPositive;

}