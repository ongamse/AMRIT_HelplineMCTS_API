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
