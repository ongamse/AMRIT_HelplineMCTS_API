package com.iemr.mcts.services.agent;

import java.sql.Timestamp;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.data.supervisor.OutboundCallAnsweredCountDetail;
import com.iemr.mcts.repository.agent.CallCountRepository;

@Service
public class CallCountServiceImpl implements CallCountService{

	Logger logger = LoggerFactory.getLogger(CallCountServiceImpl.class);
	/**
	 * CallCountRepository repo
	 */
	private CallCountRepository callCountRepository;

	/**
	 * CallCountRepository repo
	 */
	
	@Autowired
	public void setCallCountRepository(CallCountRepository callCountRepository) {
		this.callCountRepository = callCountRepository;
	}
	
	@Override
	public String getCallAnsweredCount(OutboundCallAnsweredCountDetail outboundCallAnsweredCountDetail) throws Exception {
		
		logger.info("CallAnsweredCountService.getCallAnsweredCount - start");
		Long callCounted=0L;
		
		Timestamp startDate = null;
		Timestamp endDate = null;
		Calendar cal = Calendar.getInstance();

	    			cal.set(Calendar.HOUR_OF_DAY, 0);
	    			cal.set(Calendar.MINUTE,0);
	    			cal.set(Calendar.SECOND,0);
	    			cal.set(Calendar.MILLISECOND,0);

	    			startDate = new Timestamp(cal.getTimeInMillis());
	    	
	    			cal.set(Calendar.HOUR_OF_DAY, 23);
	    			cal.set(Calendar.MINUTE,59);
	    			cal.set(Calendar.SECOND,59);
	    			cal.set(Calendar.MILLISECOND,000);

	    			endDate = new Timestamp(cal.getTimeInMillis());
	    			
	    			callCounted= callCountRepository.getCallAnsweredCount(outboundCallAnsweredCountDetail.getProviderServiceMapID(),
	    					outboundCallAnsweredCountDetail.getAgentID(), startDate, endDate);
		
		
		logger.info("CallAnsweredCountService.getCallAnsweredCount - end");
		
		return callCounted.toString();
	}
	
	@Override
	public String getCallVerifiedCount(OutboundCallAnsweredCountDetail outboundCallAnsweredCountDetail) throws Exception {
		
		logger.info("CallAnsweredCountService.getCallVerifiedCount - start");
		Long callCounted=0L;
		
		Timestamp startDate = null;
		Timestamp endDate = null;
		Calendar cal = Calendar.getInstance();

	    			cal.set(Calendar.HOUR_OF_DAY, 0);
	    			cal.set(Calendar.MINUTE,0);
	    			cal.set(Calendar.SECOND,0);
	    			cal.set(Calendar.MILLISECOND,0);

	    			startDate = new Timestamp(cal.getTimeInMillis());
	    	
	    			cal.set(Calendar.HOUR_OF_DAY, 23);
	    			cal.set(Calendar.MINUTE,59);
	    			cal.set(Calendar.SECOND,59);
	    			cal.set(Calendar.MILLISECOND,000);

	    			endDate = new Timestamp(cal.getTimeInMillis());
	    			
	    			callCounted= callCountRepository.getCallVerifiedCount(outboundCallAnsweredCountDetail.getProviderServiceMapID(),
	    					outboundCallAnsweredCountDetail.getAgentID(), startDate, endDate);
		
		
		logger.info("CallAnsweredCountService.getCallVerifiedCount - end");
		
		return callCounted.toString();
	}


}
