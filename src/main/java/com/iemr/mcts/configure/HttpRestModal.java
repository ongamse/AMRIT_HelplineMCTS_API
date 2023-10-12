/*
* AMRIT – Accessible Medical Records via Integrated Technology
* Integrated EHR (Electronic Health Records) Solution
*
* Copyright (C) "Piramal Swasthya Management and Research Institute"
*
* This file is part of AMRIT.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see https://www.gnu.org/licenses/.
*/
package com.iemr.mcts.configure;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.iemr.mcts.utils.exception.IEMRException;
import com.iemr.mcts.utils.http.HttpUtils;
import com.iemr.mcts.utils.mapper.InputMapper;
import com.iemr.mcts.utils.response.OutputResponse;

@Service
public class HttpRestModal {

	private static HttpUtils httpUtils = new HttpUtils();

	private InputMapper inputMapper = new InputMapper();

	public String restURLConnect(String request, String url, String auth) throws IEMRException {

		String result;

		HashMap<String, Object> header = new HashMap<>();
		if (auth != null) {
			header.put("Authorization", auth);
		}
		result = httpUtils.post(url, request, header);

		OutputResponse identityResponse = inputMapper.gson().fromJson(result, OutputResponse.class);
		if (identityResponse.getStatusCode() == OutputResponse.USERID_FAILURE) {
			throw new IEMRException(identityResponse.getErrorMessage());
		}
		return identityResponse.getData();
	}
}
