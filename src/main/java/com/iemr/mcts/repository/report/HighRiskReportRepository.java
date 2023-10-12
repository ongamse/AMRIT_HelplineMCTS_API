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
package com.iemr.mcts.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.BenCallDetail;
import com.iemr.mcts.data.report.HighRisk;

@Repository
@RestResource(exported = false)
public interface HighRiskReportRepository extends CrudRepository<BenCallDetail, Integer>{



	@Query("SELECT highRisk "
			+ "FROM HighRisk highRisk "
			+ "inner join highRisk.outboundHighRisk outbound "
			+ "where highRisk.createdDate >= :startDate and highRisk.createdDate <= :endDate "
			+ "and highRisk.providerServiceMapID = :providerServiceMapID and highRisk.HighRisk = true and outbound.motherID is null ")
	List<HighRisk> getHighRiskReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);
	
	
	@Query("SELECT highRisk "
			+ "FROM HighRisk highRisk "
			+ "inner join highRisk.outboundHighRisk outbound "
			+ "inner join outbound.highRiskCall highRiskCall  "
			+ "where highRiskCall.createdDate >= :startDate and highRiskCall.createdDate <= :endDate "
			+ "and highRiskCall.providerServiceMapID = :providerServiceMapID and highRisk.HighRisk = true "
			+ "and highRiskCall.userID = :userID group by highRisk.mctsIDNo ")
	List<HighRisk> getHighRiskReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail ob "
			+ "inner join ob.motherDetail mother  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and mother.HighRisk = true "
			+ "group by mother.mctsIDNo ")
	List<BenCallDetail> getHighRiskReportAll(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);


}
