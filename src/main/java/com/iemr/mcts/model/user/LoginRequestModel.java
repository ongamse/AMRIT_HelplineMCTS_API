package com.iemr.mcts.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = { "authKey" })
public @Data class LoginRequestModel
{
	private String userName;
	private String password;
	private String authKey;
}
