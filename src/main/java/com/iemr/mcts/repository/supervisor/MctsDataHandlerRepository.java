package com.iemr.mcts.repository.supervisor;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

@Repository
@RestResource(exported = false)
public interface MctsDataHandlerRepository extends CrudRepository<MctsDataReaderDetail, Long> {

	@Query("SELECT count(m)>0 FROM MctsDataReaderDetail m WHERE MCTSID_no = :MCTSID_no")
	public boolean ifExists(@Param("MCTSID_no") Long MCTSID_no);
	
	@Query("select count(*) from MctsDataReaderDetail m where m.FileID = :fileID")
	public long validCount(@Param("fileID") Long fileID);
	
	@Transactional
	@Modifying
	@Query("update MctsDataReaderDetail m set m.IsAllocated = true where m.MCTSID_no = :mctsIdNo")
	public int markIsAllocate(@Param("mctsIdNo") Long mctsIDNo);

	@Modifying
	@Transactional
	@Query("update MctsDataReaderDetail m set m.BeneficiaryRegID = :beneficiaryRegID WHERE MCTSID_no = :MCTSID_no")
	public int addBeneficiaryRegID(@Param("beneficiaryRegID") Long beneficiaryRegID, @Param("MCTSID_no") Long mctsid_no);
	
	@Modifying
	@Transactional
	@Query("update MctsDataReaderDetail m set m.Name = :Name, m.Whom_PhoneNo = :Whom_PhoneNo, "
			+ "m.State_ID = :State_ID, m.State_Name = :State_Name, m.District_ID = :District_ID, m.District_Name = :District_Name WHERE MCTSID_no = :MCTSID_no")
	public int updateMotherRecord(@Param("Name") String Name, @Param("Whom_PhoneNo") String Whom_PhoneNo, @Param("State_ID") Long State_ID,
			@Param("State_Name") String State_Name, @Param("District_ID") Long District_ID, @Param("District_Name") String District_Name,
			@Param("MCTSID_no")Long MCTSID_no);

}
