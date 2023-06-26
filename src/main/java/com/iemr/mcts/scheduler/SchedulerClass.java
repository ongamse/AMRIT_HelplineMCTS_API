package com.iemr.mcts.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;

public class SchedulerClass {

	 //private static final Logger log = LoggerFactory.getLogger(SchedulerClass.class);
	//later scheduler format
	@Scheduled(fixedRate = 5000)  
	public static void main(String[] args) {
		
		  
		  
		  SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		       System.out.println("The time is now {}"+dateFormat.format(new Date()));
		  
	}
}
