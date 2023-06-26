package com.iemr.mcts.repository.agent;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.iemr.mcts.data.supervisor.ProviderServiceMapDetail;

@Repository
@RestResource(exported = false)
public interface ProviderServiceMapRepository extends CrudRepository<ProviderServiceMapDetail, Long> {

	@Query("select new ProviderServiceMapDetail(ps.serviceID, ps.stateID) from ProviderServiceMapDetail ps "
			+ "where providerServiceMapID = :providerServiceMapID")
	public ProviderServiceMapDetail getProviderServiceDetail(@Param("providerServiceMapID") Long providerServiceMapID);
}
