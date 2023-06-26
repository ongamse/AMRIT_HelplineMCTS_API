package com.iemr.mcts.repository.supervisor;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mcts.data.supervisor.ChildDataReader;

@Repository
@RestResource(exported = false)
public interface ChildDataReaderRepository extends CrudRepository<ChildDataReader, Long> {

	@Query("select new ChildDataReader(c.rowID, c.mctsChildNo, c.childName, c.fatherName, c.motherName, c.motherID, c.dob, "
			+ "c.placeOfBirth, c.gender, c.caste, c.bloodGroup, c.childAadhaarNo, c.weightOfChild, c.childEID, c.phoneNoOf, "
			+ "c.phoneNo, c.anmName, c.anmPh, c.ashaName, c.ashaPh) from ChildDataReader c where c.fileID in (select fileID from c.fileManager f "
			+ " where f.providerServiceMapID = :providerServiceMapID ) and c.isAllocated = false and c.deleted = false")
	public ArrayList<ChildDataReader> getChildUnallocatedCalls(@Param("providerServiceMapID") Long providerServiceMapID);
	
	@Modifying
	@Query("update ChildDataReader c set c.isAllocated = true where c.mctsChildNo = :mctsChildNo")
	@Transactional
	public int markIsAllocate(@Param("mctsChildNo") Long mctsChildNo);
}
