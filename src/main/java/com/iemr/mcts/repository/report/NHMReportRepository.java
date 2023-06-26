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
public interface NHMReportRepository extends CrudRepository<BenCallDetail, Integer>{

	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "inner join mother.identityDetail identity "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = true ")
	List<BenCallDetail> getNHMReportMother(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "inner join child.identityDetail identity "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = false ")
	List<BenCallDetail> getNHMReportChild(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID);

	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.motherDetail mother  "
			+ "inner join mother.identityDetail identity "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = true "
			+ "and benCallDetail.userID = :userID ")
	List<BenCallDetail> getNHMReportMotherByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);
	
	@Query("SELECT benCallDetail "
			+ "FROM BenCallDetail benCallDetail "
			+ "inner join benCallDetail.obdetail obdet "
			+ "inner join obdet.childDetail child  "
			+ "inner join child.identityDetail identity "
			+ "where benCallDetail.createdDate >= :startDate and benCallDetail.createdDate <= :endDate "
			+ "and benCallDetail.providerServiceMapID = :providerServiceMapID and benCallDetail.isMother = false "
			+ "and benCallDetail.userID = :userID ")
	List<BenCallDetail> getNHMReportChildByAgent(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, 
			@Param("providerServiceMapID") Long providerServiceMapID, @Param("userID") Integer userID);

}
