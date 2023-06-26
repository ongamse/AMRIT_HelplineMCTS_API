package com.iemr.mcts.repository.agent;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.agent.CongenitalAnomaliesDetail;

@Repository
@RestResource(exported = false)
public interface CongenitalAnomaliesRepository extends CrudRepository<CongenitalAnomaliesDetail, Integer> {

	@Query("select new CongenitalAnomaliesDetail(ca.congenitalAnomaliesID, ca.congenitalAnomalies) from CongenitalAnomaliesDetail ca ")
			//+ "where ca.serviceID in(select serviceID ServiceMasterDetail where serviceName='MCTS'")
	public ArrayList<CongenitalAnomaliesDetail> getCongenitalAnomalies();
}
