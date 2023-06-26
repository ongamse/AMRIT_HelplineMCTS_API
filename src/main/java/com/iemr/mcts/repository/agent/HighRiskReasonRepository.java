package com.iemr.mcts.repository.agent;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.agent.HighRiskPregReason;

@Repository
@RestResource(exported = false)
public interface HighRiskReasonRepository extends CrudRepository<HighRiskPregReason, Long> {

	@Query("select reason.highRiskPregReason from HighRiskPregReason reason ")
	public List getHighRiskReason();
}
