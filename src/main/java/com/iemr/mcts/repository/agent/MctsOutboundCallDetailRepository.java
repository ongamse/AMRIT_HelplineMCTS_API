package com.iemr.mcts.repository.agent;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mcts.data.agent.MctsOutboundCallDetail;

@Repository
@RestResource(exported = false)
public interface MctsOutboundCallDetailRepository extends CrudRepository<MctsOutboundCallDetail, Long> {

	@Query("select cd from MctsOutboundCallDetail cd join cd.callType where cd.obCallID in "
			+ " (select c.obCallID from MctsOutboundCall c where c.motherID = :motherID) order by cd.createdDate desc")
	public ArrayList<MctsOutboundCallDetail> getMotherCallHistory(@Param("motherID") Long motherID);
	
//	@Query("select cd from MctsOutboundCallDetail cd where cd.obCallID in "
//			+ " (select c.obCallID from MctsOutboundCall c where c.childID = :childID)")
	@Query("select cd from MctsOutboundCallDetail cd join cd.callType where cd.obCallID in "
			+ " (select c.obCallID from MctsOutboundCall c where c.childID = :childID) order by cd.createdDate desc")
	public ArrayList<MctsOutboundCallDetail> getChildCallHistory(@Param("childID") Long childID);
	
	@Query("select cd from MctsOutboundCallDetail cd where cd.czentrixCallID = :czentrixCallID "
			+ "and cd.allocatedUserID = :allocatedUserID")
	public MctsOutboundCallDetail isAvailable(@Param("czentrixCallID") String czentrixCallID, @Param("allocatedUserID") Integer allocatedUserID);
	
	@Transactional
	@Modifying
	@Query("update MctsOutboundCallDetail cd set cd.callTypeID = :callTypeID, cd.lastModDate = :lastModDate, "
			+ "cd.remark = :remark, cd.beneficiaryRegID = :beneficiaryRegID, cd.callEndTime = :callEndTime, cd.callDuration = :callDuration where cd.callDetailID = :callDetailID")
	public int updateCallHistory(@Param("callTypeID") Integer callTypeID, @Param("lastModDate") Timestamp lastModDate,
			@Param("remark") String remark, @Param("callDetailID") Long callDetailID, @Param("beneficiaryRegID") Long beneficiaryRegID,
			@Param("callEndTime") Timestamp callEndTime, @Param("callDuration") String callDuration);
	
	@Transactional
	@Modifying
	@Query("update MctsOutboundCallDetail cd set cd.smsAdvice = :smsAdvice, cd.smsPh = :smsPh "
			+ " where cd.callDetailID = :callDetailID")
	public int updateSmsAdvice(@Param("smsAdvice") String smsAdvice, @Param("smsPh") String smsPh, 
			@Param("callDetailID") Long callDetailID);
	
	@Query("select cd from MctsOutboundCallDetail cd join cd.callType where cd.callDetailID = :callDetailID")
	public MctsOutboundCallDetail findByCallDetailID(@Param("callDetailID") Long callDetailID);
	
	@Query("select cd from MctsOutboundCallDetail cd where cd.callDetailID = :callDetailID")
	public MctsOutboundCallDetail checkAdviseAvailable(@Param("callDetailID") Long callDetailID);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE db_iemr.t_bencall set ChangeLog = concat(COALESCE(ChangeLog, ''), :changeLog, ' ') "
			+ "where BenCallID = :callDetailID ", nativeQuery=true)
	public int appendChangeLog(@Param("changeLog") String changeLog, @Param("callDetailID") Long callDetailID);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE db_iemr.t_mctsoutboundcalldeatil set SMS_Advice = concat(COALESCE(SMS_Advice, ''), ', ', :smsAdvice, ' ') "
			+ "where CallDetailID = :callDetailID ", nativeQuery=true)
	public int appendSmsAdvise(@Param("smsAdvice") String smsAdvice, @Param("callDetailID") Long callDetailID);
	
	@Query("select cd from MctsOutboundCallDetail cd where cd.obCallID in "
			+ " (select c.obCallID from MctsOutboundCall c where c.motherID = :motherID) order by cd.createdDate")
	public ArrayList<MctsOutboundCallDetail> getMotherChangeLogs(@Param("motherID") Long motherID);
	
	@Query("select cd from MctsOutboundCallDetail cd where cd.obCallID in "
			+ " (select c.obCallID from MctsOutboundCall c where c.childID = :childID) order by cd.createdDate")
	public ArrayList<MctsOutboundCallDetail> getChildChangeLogs(@Param("childID") Long childID);

	
	@Transactional
	@Modifying
	@Query("update MctsOutboundCallDetail cd set cd.isVerified = :isVerified where cd.callDetailID = :callDetailID")
	public int updateIsVerified(@Param("isVerified") Boolean isVerified, @Param("callDetailID") Long callDetailID);
	
	@Query("select cd.callTime from MctsOutboundCallDetail cd where cd.callDetailID = :callDetailID")
	public Timestamp getCallStartTime(@Param("callDetailID") Long callDetailID);

}
