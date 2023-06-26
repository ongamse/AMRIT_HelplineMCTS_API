package com.iemr.mcts.repository.agent;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.agent.MctsCallResponseDetail;

@Repository
@RestResource(exported = false)
public interface MctsCallResponseRepository extends CrudRepository<MctsCallResponseDetail, Long> {

	@Transactional
	@Modifying
	@Query("update MctsCallResponseDetail res set res.callDetailID = :callDetailID where callDetailID is null "
			+ "and res.motherID = :motherID")
	public int updateMotherCallDetailID(@Param("callDetailID") Long callDetailID, @Param("motherID") Long motherID);

	@Transactional
	@Modifying
	@Query("update MctsCallResponseDetail res set res.callDetailID = :callDetailID where callDetailID is null "
			+ "and res.childID = :childID")
	public int updateChildCallDetailID(@Param("callDetailID") Long callDetailID, @Param("childID") Long childID);

	// @Query("select res from MctsCallResponseDetail res where :callDetailID is
	// null or res.callDetailID = :callDetailID "
	// + "or :motherID is null or res.motherID = :motherID or :childID is null
	// or res.childID = :childID")
	@Query("select res from MctsCallResponseDetail res join res.questionnaireDetail where res.callDetailID = :callDetailID "
			+ " and res.deleted = false ")
	public ArrayList<MctsCallResponseDetail> getMctsCallResponse(@Param("callDetailID") Long callDetailID);// ,
	// @Param("motherID") Long motherID, @Param("childID") Long childID);

//	@Query("select qres from MctsCallResponseDetail qres join qres.questionnaireDetail "
//			+ "where qres.callDetailID qres.callDetailID = :callDetailID and qres.callDetailID is not null")
//	public ArrayList<MctsCallResponseDetail> getMctsCallResponseForOutboundCallType(@Param("callDetailID") Long callDetailID);
	
	@Transactional
	@Modifying
	@Query("update MctsCallResponseDetail res set res.answer = :answer, res.remarks = :remarks, res.deleted = false "
			+ " where res.mctsCallResponseID = :mctsCallResponseID ")
	public int updateMctsCall(@Param("mctsCallResponseID") Long mctsCallResponseID, @Param("answer") String answer,
			@Param("remarks") String remarks);

	@Query("select max(res.mctsCallResponseID) from MctsCallResponseDetail res "
			+ "where res.callDetailID = :callDetailID and res.questionID = :questionID")
	public Long isRecordAvail(@Param("callDetailID") Long callDetailID, @Param("questionID") Integer questionID);

//	@Query("select max(res.mctsCallResponseID) from MctsCallResponseDetail res "
//			+ "where res.callDetailID = :callDetailID and res.questionID = :questionID")
//	public Long isChildRecordAvail(@Param("callDetailID") Long callDetailID, @Param("questionID") Integer questionID);
	
	
	// deleting previous answers.
	
	@Transactional
	@Modifying
	@Query("update MctsCallResponseDetail md set md.deleted = true where md.callDetailID = :callDetailID "
			+ " and md.outboundCallType = :outboundCallType ")
	public int deletePreviousAnswer(@Param("callDetailID") Long callDetailID, @Param("outboundCallType") String outboundCallType );

	
	@Query("select res from MctsCallResponseDetail res join res.questionnaireDetail where res.callDetailID = :callDetailID "
			+ " and res.deleted = false and res.outboundCallType = :outboundCallType ")
	public ArrayList<MctsCallResponseDetail> getMctsCallResponseForAgent(@Param("callDetailID") Long callDetailID, @Param("outboundCallType") String outboundCallType);
}
