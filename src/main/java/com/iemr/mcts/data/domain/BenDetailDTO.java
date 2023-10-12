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

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class BenDetailDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	private BigInteger beneficiaryDetailsId;
	private Integer areaId;
	private BigInteger beneficiaryRegID;
	private String community;
	private String createdBy;
	private Timestamp createdDate;
	private Boolean deleted = false;
	private Timestamp dob;
	private Integer age;
	private String education;
	private Boolean emergencyRegistration;
	private Integer healthCareWorkerId;
	private String healthCareWorker;
	private String fatherName;
	private String motherName;
	private String firstName;
	private String gender;
	private Integer incomeStatusId;
	private String incomeStatus;
	private Timestamp lastModDate;
	private String lastName;
	private String maritalStatus;
	private String middleName;
	private String modifiedBy;
	private Integer occupationId;
	private String occupation;
	private Integer phcId;
	private String placeOfWork;
	private String preferredLanguage;
	private Integer religionId;
	private String religion;
	private String remarks;
	private BigInteger servicePointId;
	private String sourceOfInfo;
	private String spouseName;
	private String status;
	private String title;
	private Integer zoneId;
	private Integer genderId;
	private Integer maritalStatusId;
	private Integer titleId;
	private Integer communityId;
	private Integer educationId;
	private Integer sexualOrientationID;
	private String sexualOrientationType;
	private Boolean isHIVPositive;
	
	public static Date setDateForBen(BenDetailDTO benDetailDTO) {
		Timestamp timestamp = benDetailDTO.dob;
		Date date = new Date(timestamp.getTime());
		return date;
	}
}