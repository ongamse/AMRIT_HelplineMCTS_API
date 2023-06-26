package com.iemr.mcts.repository.agent;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.agent.ChildCongenitalAnomaliesDetail;

@Repository
@RestResource(exported = false)
public interface ChildCongenitalAnomaliesRepository extends CrudRepository<ChildCongenitalAnomaliesDetail, Long> {

	public ArrayList<ChildCongenitalAnomaliesDetail> findByChildID(Long childID);
	
	public ArrayList<ChildCongenitalAnomaliesDetail> findByMotherID(Long motherID);
}
