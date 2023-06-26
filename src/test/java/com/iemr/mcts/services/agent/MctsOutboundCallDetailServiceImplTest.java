package com.iemr.mcts.services.agent;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.data.agent.MctsOutboundCallDetail;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;
import com.iemr.mcts.data.supervisor.MctsOutboundCall;
import com.iemr.mcts.repository.agent.MCTSOutboundCallRepository;
import com.iemr.mcts.repository.agent.MctsOutboundCallDetailRepository;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsOutboundCallDetailServiceImplTest {

	@InjectMocks
	MctsOutboundCallDetailServiceImpl mctsOutboundCallDetailServiceImpl;
	
	@Mock
	MctsOutboundCallDetailRepository mctsOutboundCallDetailRepository;
	
	@Mock
	MCTSOutboundCallRepository mctsOutboundCallRepository;
	
	@Mock
	MctsIdentityServiceImpl mctsIdentityServiceImpl;
	
	@Test
	public void getCallHistoryTest()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setChildID(new Long("101"));
		List<MctsOutboundCallDetail> list=Lists.newArrayList();
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		mctsOutboundCallDetail.setCzentrixCallID("505");
		list.add(mctsOutboundCallDetail);
		doReturn(list).when(mctsOutboundCallDetailRepository).getChildCallHistory(Mockito.anyLong());
		try {
			String response=mctsOutboundCallDetailServiceImpl.getCallHistory(mctsOutboundCall.toString());
			assertTrue(response.contains("\"czentrixCallID\":\"505\""));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getCallHistoryTest1()
	{
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setOutboundCallType("type");
		mctsOutboundCall.setMotherID(new Long("101"));
		List<MctsOutboundCallDetail> list=Lists.newArrayList();
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		mctsOutboundCallDetail.setCzentrixCallID("505");
		list.add(mctsOutboundCallDetail);
		doReturn(list).when(mctsOutboundCallDetailRepository).getMotherCallHistory(Mockito.anyLong());
		try {
			String response=mctsOutboundCallDetailServiceImpl.getCallHistory(mctsOutboundCall.toString());
			assertTrue(response.contains("\"czentrixCallID\":\"505\""));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void getBeneficiaryDetailsTest()
	{
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		MctsOutboundCall mctsOutboundCall=new MctsOutboundCall();
		mctsOutboundCall.setAllocatedUserID(202);
		mctsOutboundCallDetail.setMctsOutboundCall(mctsOutboundCall);
		mctsOutboundCallDetail.setCzentrixCallID("101");
		HttpServletRequest servletRequest=mock(HttpServletRequest.class);
		MctsDataReaderDetail rReaderDetail=new MctsDataReaderDetail();
		rReaderDetail.setBeneficiaryRegID(new Long("1019"));
		mctsOutboundCall.setMctsDataReaderDetail(rReaderDetail);
		doReturn(mctsOutboundCall).when(mctsOutboundCallRepository).findOnClientID(Mockito.anyString());
		/*try {
			String response = null ; 
			//=mctsOutboundCallDetailServiceImpl.getBeneficiaryDetails(mctsOutboundCallDetail.toString(),servletRequest);
			assertTrue(response.contains("\"allocatedUserID\":202"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	@Test
	public void getBeneficiaryDetailsTest1()
	{
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		mctsOutboundCallDetail.setCzentrixCallID("101");
		HttpServletRequest servletRequest=mock(HttpServletRequest.class);
		try {
			String response=mctsOutboundCallDetailServiceImpl.getBeneficiaryDetails(mctsOutboundCallDetail.toString(),servletRequest);
			assertTrue(response.contains("No beneficiary found with this caller id"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void createCallHistoryTest()
	{
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		mctsOutboundCallDetail.setCzentrixCallID("101");
		doReturn(mctsOutboundCallDetail).when(mctsOutboundCallDetailRepository).isAvailable(Mockito.anyString(),Mockito.anyInt());
		try {
			String response=mctsOutboundCallDetailServiceImpl.createCallHistory(mctsOutboundCallDetail.toString());
			assertTrue(response.contains("\"czentrixCallID\":\"101\""));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/*	@Test
	public void sendSmsAdviceTest()
	{
		MctsOutboundCallDetail mctsOutboundCallDetail=new MctsOutboundCallDetail();
		mctsOutboundCallDetail.setSmsAdvice("sms");
		mctsOutboundCallDetail.setSmsPh("phone");
		mctsOutboundCallDetail.setCallDetailID(new Long("101"));
		try {
			String response=mctsOutboundCallDetailServiceImpl.sendSmsAdvice(mctsOutboundCallDetail.toString());
			assertTrue(response.contains("SMS sent successfully"));
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
