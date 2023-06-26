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

