package com.iemr.mcts.controller.supervisor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.tika.exception.TikaException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;

import com.iemr.mcts.services.supervisor.MctsDataHandlerService;
import com.iemr.mcts.utils.exception.IEMRException;

@RunWith(MockitoJUnitRunner.class)
public class MctsDataHandlerControllerTest {

	@InjectMocks
	MctsDataHandlerController mctsDataHandlerController;
	
	@Mock
	MctsDataHandlerService mctsDataHandlerService;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void uploadDataTest() throws IOException, TikaException, IEMRException
	{
        MockMultipartFile file = new MockMultipartFile("file", "orig", null, "bar".getBytes());
        String str=new String("success");
        HttpServletRequest request=mock(HttpServletRequest.class);
        doReturn(str).when(mctsDataHandlerService).mctsDataUpload(str,request);
        String res=mctsDataHandlerController.uploadData(str,  request);
        assertTrue(res.contains("\"response\":\"success\""));
	}
	@Test
	public void uploadDataEmptyTest() throws IOException, TikaException, IEMRException
	{
        String str=new String(" ");
        HttpServletRequest request=mock(HttpServletRequest.class);
        doReturn(str).when(mctsDataHandlerService).mctsDataUpload(str,request);
        String res=mctsDataHandlerController.uploadData(str,  request);
        assertFalse(res.contains("\"response\":\"success\""));
	}
	
	@Test
	public void updateBeneficiaryTest() throws IEMRException
	{
		String str=new String("success");
		doReturn(str).when(mctsDataHandlerService).updateBeneficiary(Mockito.anyString());
        String res=mctsDataHandlerController.updateBeneficiary(Mockito.anyString());
        assertTrue(res.contains("\"response\":\"success\""));
	}
	@Test
	public void updateBeneficiaryExceptionTest() 
	{
		try {
			doThrow(Exception.class).when(mctsDataHandlerService).updateBeneficiary(Mockito.anyString());
		} catch (IEMRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String res=mctsDataHandlerController.updateBeneficiary(Mockito.anyString());
        assertFalse(res.contains("\"response\":\"success\""));
	}

}
