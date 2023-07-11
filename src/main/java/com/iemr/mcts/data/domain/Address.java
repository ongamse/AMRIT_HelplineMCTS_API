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

import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

import lombok.Data;

@Data
public class Address {
	private String addrLine1;
	private String addrLine2;
	private String addrLine3;
	private Integer countryId;
	private String country;
	private Integer stateId;
	private String state;
	private Integer districtId;
	private String district;
	private Integer subDistrictId;
	private String subDistrict;
	private Integer villageId;
	private String village;
	private String habitation;
	private String addressValue;
	private String pinCode;
	
	public static Address getAddressDetails(MctsDataReaderDetail dataReaderDetail) {
		Address address = new Address();
		
		if(dataReaderDetail != null) {
			address.addrLine1 = dataReaderDetail.getAddress();
			address.state = dataReaderDetail.getState_Name();
			address.district = dataReaderDetail.getDistrict_Name();
			address.subDistrict = dataReaderDetail.getTaluka_Name();
			address.village = dataReaderDetail.getVillage_Name();
		}
		return address;
	}
	
	public static Address getAddressDetailsForChild(ChildValidDataHandler childValidDataHandler) {
		Address address = new Address();
		
		if(childValidDataHandler != null) {
			address.addrLine1 = childValidDataHandler.getAddress();
			address.state = childValidDataHandler.getState_Name();
			address.district = childValidDataHandler.getDistrict_Name();
			address.subDistrict = childValidDataHandler.getTaluka_Name();
			address.village = childValidDataHandler.getVillage_Name();
		}
		return address;
	}
}
