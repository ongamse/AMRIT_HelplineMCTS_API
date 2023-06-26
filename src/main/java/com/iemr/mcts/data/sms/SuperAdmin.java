package com.iemr.mcts.data.sms;

import lombok.Data;

@Data
public class SuperAdmin {

	String hostName;
	String ipAddress;
	String sessionStatus;
	String isAuthenticated;
	String userName;
	String loginIPAddress;
	String userID;
	String key;
}
