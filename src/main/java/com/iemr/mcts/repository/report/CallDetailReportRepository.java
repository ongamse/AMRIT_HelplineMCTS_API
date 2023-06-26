package com.iemr.mcts.repository.report;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.report.BenCallDetail;

@Repository
@RestResource(exported = false)
public interface CallDetailReportRepository extends CrudRepository<BenCallDetail, Integer>{

	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID "
			+ "and benCallDetail.userID = :userID and benCallDetail.isMother = true ")
	List<BenCallDetail> getMotherCallReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = true ")
	List<BenCallDetail> getMotherCallReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID "
			+ "and benCallDetail.userID = :userID and benCallDetail.isMother = false ")
	List<BenCallDetail> getChildCallReportByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = false ")
	List<BenCallDetail> getChildCallReport(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);

	
	@Query("SELECT COUNT(benCallDetail.benCallID) "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "where benCallDetail.obCallID = :obCallID "
			+ "and (benCallDetail.callTypeName = 'Answered' or child.phoneNoof = 'Self') " )
	Integer getAnsweredCountChild(
			 @Param("obCallID") Long obCallID);
	
	@Query("SELECT COUNT(benCallDetail.benCallID) "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "where benCallDetail.obCallID = :obCallID "
			+ "and (benCallDetail.callTypeName = 'Answered' or mother.phoneNoOfWhom = 'Self') " )
	Integer getAnsweredCountMother(
			 @Param("obCallID") Long obCallID);
	
	@Query("SELECT COUNT(benCallDetail.benCallID) "
			+ "FROM BenCallDetail benCallDetail "
			+ "where benCallDetail.obCallID = :obCallID and benCallDetail.isVerified = true ")
	Integer getCountVerified(
			 @Param("obCallID") Long obCallID);
}
