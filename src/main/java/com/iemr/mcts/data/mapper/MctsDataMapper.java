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
package com.iemr.mcts.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

@Mapper(componentModel = "spring", imports = {})
public interface MctsDataMapper {
	MctsDataMapper INSTANCE = Mappers.getMapper(MctsDataMapper.class);

	@Mappings({ @Mapping(source = "name", target = "mother_Name"),
		@Mapping(source = "phoneNo_Of_Whom", target = "phone_No_of"),
		@Mapping(source = "whom_PhoneNo", target = "phone_No"),
		@Mapping(source = "caste", target = "caste"),
		@Mapping(source = "state_Name", target = "state_Name"),
		@Mapping(source = "district_Name", target = "district_Name"),
		@Mapping(source = "taluka_Name", target = "taluka_Name"),
		@Mapping(source = "block_Name", target = "block_Name"),
		@Mapping(source = "subCenter_Name", target = "subCenter_Name"),
		@Mapping(source = "village_Name", target = "village_Name"),
		@Mapping(source = "subCenter_Name1", target = "subCenter_Name1"),
		@Mapping(source = "ANM_Name", target = "ANM_Name"),
		@Mapping(source = "ANM_Ph", target = "ANM_Phone_No"),
		@Mapping(source = "ASHA_Name", target = "ASHA_Name"),
		@Mapping(source = "ASHA_Ph", target = "ASHA_Phone_No"),
		@Mapping(source = "PHC_Name", target = "PHC_Name"),
		@Mapping(source = "address", target = "address"),
		@Mapping(source = "MCTSID_no", target = "mother_ID"),
		@Mapping(source = "husband_Name", target = "father_Name"),
		@Mapping(source = "delivery_Place_home_type", target = "place_of_Birth"),
		@Mapping(source = "city_Name", target = "city")

	})
	ChildValidDataHandler MctsDataReaderDetailToChildValidDataHandler(MctsDataReaderDetail mctsDataReaderDetail);
}
