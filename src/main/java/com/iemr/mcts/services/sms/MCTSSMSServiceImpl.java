package com.iemr.mcts.services.sms;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iemr.mcts.configure.HttpRestModal;
import com.iemr.mcts.data.sms.SMSRequest;
import com.iemr.mcts.data.sms.SMSTemplate;
import com.iemr.mcts.data.sms.SuperAdmin;
import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.repository.agent.MCTSOutboundCallRepository;
import com.iemr.mcts.repositroy.sms.MCTSSMSRepository;
import com.iemr.mcts.utils.config.ConfigProperties;
import com.iemr.mcts.utils.mapper.InputMapper;
import com.iemr.mcts.utils.mapper.OutputMapper;


@Service
public class MCTSSMSServiceImpl implements MCTSSMSService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	/**
	 * Inject HttpRestModal
	 */
	@Autowired
	private HttpRestModal httpRestModal;
	
	/**
	 * Common URL
	 */
	private static final String COMMON_URL = ConfigProperties.getPropertyByName("common-api");
	
	/**
	 * Send SMS URL
	 */
	private static final String sendSMS_URL = ConfigProperties.getPropertyByName("common-api-sendSMS-url");
	
	/**
	 * Get SuperAdmin Authenticate URL
	 */
	private static final String SuperAdminAuth_URL = ConfigProperties.getPropertyByName("common-api-superadminauth-url");
	
	
	private MCTSOutboundCallRepository outboundCallRepository;

	/**
	 * @param outboundCallRepository the outboundCallRepository to set
	 */
	@Autowired
	public void setOutboundCallRepository(MCTSOutboundCallRepository outboundCallRepository) {
		this.outboundCallRepository = outboundCallRepository;
	}
	
	private MCTSSMSRepository mctsSMSRepository;

	/**
	 * @param mctsSMSRepository the mctsSMSRepository to set
	 */
	@Autowired
	public void setMctsSMSRepository(MCTSSMSRepository mctsSMSRepository) {
		this.mctsSMSRepository = mctsSMSRepository;
	}

	@Override
	public void sendSMS() throws Exception
	{
		logger.info("MCTSSMSServiceImpl sendSMS Started ");
		LocalDate now = LocalDate.now();
		now = now.plusDays(7);
		Date futureDate= Date.valueOf(now);
		
		ArrayList<MctsOutboundCall> callList= outboundCallRepository.getFutureCallList(futureDate);
		
		List<SMSRequest> listofBeneficiary=new ArrayList<SMSRequest>();
		
		for(MctsOutboundCall call : callList)
		{
			
		SMSRequest smsRequest=new SMSRequest();
		SMSTemplate smsTemplate =null;
		String callType= call.getOutboundCallType().substring(0, call.getOutboundCallType().length() - 1);
		if(call.getChildValidDataHandler()!=null || callType.equals("PNC"))
		{
			smsTemplate = mctsSMSRepository.getPNCSMSTemplate(call.getProviderServiceMapID());
		}
		else
		{
			smsTemplate = mctsSMSRepository.getANCSMSTemplate(call.getProviderServiceMapID());
		}
		
		if(null!= smsTemplate && smsTemplate.getSmsTemplateID()>0)
		{
		smsRequest.setBeneficiaryRegID(call.getBeneficiaryRegID());
		smsRequest.setSmsTemplateID(smsTemplate.getSmsTemplateID());
		smsRequest.setObCallID(call.getObCallID());
		smsRequest.setCreatedBy("MCTS_scheduler");
		listofBeneficiary.add(smsRequest);
		}
		
		}
		
		String loginResponse= httpRestModal.restURLConnect("{\"userName\":\"SuperAdmin\",\"password\":\"admin@123\"}",
				COMMON_URL + SuperAdminAuth_URL, "");
		
		SuperAdmin superAdmin = InputMapper.gson().fromJson(loginResponse, SuperAdmin.class);
		String req = null;
		req = OutputMapper.gsonWithoutExposeRestriction().toJson(listofBeneficiary);
		
		String key= superAdmin.getKey();
		
		if(null!=key) {
			
			logger.info("sendSMS request " + req);
			String res = httpRestModal.restURLConnect(req,COMMON_URL + sendSMS_URL, key);
			logger.info("sendSMS response " + res);
		}
		
		logger.info("MCTSSMSServiceImpl sendSMS End");
	}

}
