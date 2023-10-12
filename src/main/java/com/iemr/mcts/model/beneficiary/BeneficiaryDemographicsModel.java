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
package com.iemr.mcts.model.beneficiary;

import com.iemr.mcts.model.user.HealthCareWorkerModel;
import com.iemr.mcts.model.userbeneficiary.CityModel;
import com.iemr.mcts.model.userbeneficiary.CommunityModel;
import com.iemr.mcts.model.userbeneficiary.CountryModel;
import com.iemr.mcts.model.userbeneficiary.District;
import com.iemr.mcts.model.userbeneficiary.DistrictBlock;
import com.iemr.mcts.model.userbeneficiary.DistrictBranchMapping;
import com.iemr.mcts.model.userbeneficiary.Language;
import com.iemr.mcts.model.userbeneficiary.ReligionModel;
import com.iemr.mcts.model.userbeneficiary.StateModel;

import lombok.Data;

public @Data class BeneficiaryDemographicsModel
{
	private Long benDemographicsID;
	private Long beneficiaryRegID;
	private BeneficiaryModel beneficiaryModel;
	private Integer educationID;
	private String educationName;
	private BeneficiaryEducationModel beneficiaryeducation;
	private Integer occupationID;
	private String occupationName;
	private BeneficiaryOccupationModel beneficiaryoccupation;
	private Short healthCareWorkerID;
	private String healthCareWorkerName;
	private HealthCareWorkerModel healthCareWorkerType;
	private Integer incomeStatusID;
	private String incomeStatusName;
	private BeneficiaryIncomeStatusModel i_beneficiaryincomestatus;
	private Integer communityID;
	private String communityName;
	private CommunityModel communityModel;
	private CommunityModel m_community;
	private Integer preferredLangID;
	private String preferredLangName;
	private Language m_language;
	private Integer religionID;
	private String religionName;
	private ReligionModel m_religion;
	private Boolean isPhoto;
	private String photoFilePath;
	private Boolean isBiometric;
	private String biometricFilePath;
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	private String addressLine4;
	private String addressLine5;
	private Integer cityID;
	private String cityName;
	private CityModel m_city;
	private Integer stateID;
	private String stateName;
	private StateModel m_state;
	private Integer districtID;
	private String districtName;
	private District m_district;
	private Integer blockID;
	private String blockName;
	private DistrictBlock m_districtblock;
	private Integer districtBranchID;
	private String districtBranchName;
	private DistrictBranchMapping m_districtbranchmapping;
	private Integer countryID;
	private String countryName;
	private CountryModel m_country;
	private String pinCode;
	private Boolean isAddPresent;
	private Boolean isAddPermanent;
	private Boolean deleted;
	private String createdBy;
	private String modifiedBy;
}
