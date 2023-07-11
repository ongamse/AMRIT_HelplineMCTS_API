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
package com.iemr.mcts.repository.agent;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.agent.MotherValidRecordDetail;

@Repository
@RestResource(exported = false)
public interface MotherStageDetailsRepository extends CrudRepository<MotherValidRecordDetail, Long> {

	@Query("select m.mctsIDNo, m.name, m.husbandName, m.districtName, m.blockName,"
			+ "m.PHCName, m.subCenterName, m.GPVillage, m.address, m.whomPhoneNo, "
			+ "m.phoneNoOfWhom, m.ashaName, m.anmName, m.child1ID,"
			+ "m.Child1Name, m.lmpDate from MotherValidRecordDetail m WHERE m.mctsIDNo=:val")
	ArrayList<Objects[]> getMotherDetails(@Param("val") Long mCTSIDNo);
	
}

