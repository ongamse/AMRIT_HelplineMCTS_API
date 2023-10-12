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

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.OutboundCallAnsweredCountDetail;

@Repository
@RestResource(exported = false)
public interface CallCountRepository extends CrudRepository<OutboundCallAnsweredCountDetail, Integer>{

	@Query("SELECT COUNT(outboundCallAnsweredCountDetail.benCallID) FROM OutboundCallAnsweredCountDetail outboundCallAnsweredCountDetail "
			+ "inner join outboundCallAnsweredCountDetail.callType callTypeName "
			+ "where outboundCallAnsweredCountDetail.providerServiceMapID = :providerServiceMapID "
			+ "and outboundCallAnsweredCountDetail.agentID = :agentID "
			+ "and outboundCallAnsweredCountDetail.createdDate >= :startDate and outboundCallAnsweredCountDetail.createdDate <= :endDate "
			+ "and callTypeName.callGroupType = 'Answered' ")
	Long getCallAnsweredCount(@Param("providerServiceMapID") Long providerServiceMapID,@Param("agentID") Long agentID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);
	
	
	@Query("SELECT COUNT(outboundCallAnsweredCountDetail.benCallID) FROM OutboundCallAnsweredCountDetail outboundCallAnsweredCountDetail "
			+ "where outboundCallAnsweredCountDetail.providerServiceMapID = :providerServiceMapID "
			+ "and outboundCallAnsweredCountDetail.agentID = :agentID "
			+ "and outboundCallAnsweredCountDetail.createdDate >= :startDate and outboundCallAnsweredCountDetail.createdDate <= :endDate "
			+ "and outboundCallAnsweredCountDetail.isVerified = true ")
	Long getCallVerifiedCount(@Param("providerServiceMapID") Long providerServiceMapID,@Param("agentID") Long agentID,
			@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate);

}
