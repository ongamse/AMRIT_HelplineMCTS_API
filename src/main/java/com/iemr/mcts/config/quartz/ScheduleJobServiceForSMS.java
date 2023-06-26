package com.iemr.mcts.config.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iemr.mcts.services.sms.MCTSSMSService;

@Service
@Transactional
public class ScheduleJobServiceForSMS implements Job
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private MCTSSMSService MCTSSMSService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("Started job " + arg0.getClass().getName());
		try {
			MCTSSMSService.sendSMS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage());
		}
		logger.info("Completed job " + arg0.getClass().getName());
	}

}
