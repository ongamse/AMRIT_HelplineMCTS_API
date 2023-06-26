package com.iemr.mcts.services.report;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.iemr.mcts.repository.report.ComplaintReportRepository;
@RunWith(MockitoJUnitRunner.class)
public class MctsReportServiceImplTest {

	@InjectMocks
	ComplaintReportServiceImpl mctsReportServiceImpl;
	
	@Mock
	ComplaintReportRepository complaintReportRepository;
	
	@Test
	public void getComplaintReportTest1()
	{
		/*ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintReportDetails.setIsMother(true);
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByFeedbackTypeID(Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
			assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
/*	@Test
	public void getComplaintReportTest11()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByFeedbackTypeID1(Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
			//assertTrue(res.contains("\"feedbackTypeID\":101"));
			assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
/*	@Test
	public void getComplaintReportTest2()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackNatureID(new Integer("101"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintReportDetails.setIsMother(true);
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByFeedbackNatureID(Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertTrue(res.contains("\"feedbackNatureID\":101"));
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
	}
	@Test
	public void getComplaintReportTest21()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackNatureID(new Integer("101"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByFeedbackNatureID1(Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//assertTrue(res.contains("\"feedbackNatureID\":101"));
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
	}
	@Test
	public void getComplaintReportTest3()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setDesignationID(new Integer("101"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintReportDetails.setIsMother(true);
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByDesignationID(Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"designationID\":101"));
	}
	@Test
	public void getComplaintReportTest31()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setDesignationID(new Integer("101"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByDesignationID1(Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"designationID\":101"));
	}
	@Test
	public void getComplaintReportTest4()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setFeedbackNatureID(new Integer("201"));
		complaintReportDetails.setIsMother(true);
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByTypeAndNature(Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"feedbackTypeID\":101"));
		//assertTrue(res.contains("\"feedbackNatureID\":201"));
	}
	@Test
	public void getComplaintReportTest41()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setFeedbackNatureID(new Integer("201"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByTypeAndNature1(Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"feedbackTypeID\":101"));
		//assertTrue(res.contains("\"feedbackNatureID\":201"));
	}
	@Test
	public void getComplaintReportTest5()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackNatureID(new Integer("101"));
		complaintReportDetails.setDesignationID(new Integer("201"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintReportDetails.setIsMother(true);
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByNatureDesignation(Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"designationID\":201"));
		//assertTrue(res.contains("\"feedbackNatureID\":101"));
	}
	@Test
	public void getComplaintReportTest51()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackNatureID(new Integer("101"));
		complaintReportDetails.setDesignationID(new Integer("201"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByNatureDesignation1(Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"designationID\":201"));
		//assertTrue(res.contains("\"feedbackNatureID\":101"));
	}
	@Test
	public void getComplaintReportTest6()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setDesignationID(new Integer("201"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintReportDetails.setIsMother(true);
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByTypeAndDesignation(Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"feedbackTypeID\":101"));
		//assertTrue(res.contains("\"designationID\":201"));
	}
	@Test
	public void getComplaintReportTest61()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setDesignationID(new Integer("201"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByTypeAndDesignation1(Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"feedbackTypeID\":101"));
		//assertTrue(res.contains("\"designationID\":201"));
	}
	@Test
	public void getComplaintReportTest7()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setFeedbackNatureID(new Integer("201"));
		complaintReportDetails.setDesignationID(new Integer("301"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintReportDetails.setIsMother(true);
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByTypeAndNatureAndDesign(Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"feedbackTypeID\":101"));
		//assertTrue(res.contains("\"designationID\":301"));
		//assertTrue(res.contains("\"feedbackNatureID\":201"));

	}
	@Test
	public void getComplaintReportTest71()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintReportDetails.setFeedbackTypeID(new Integer("101"));
		complaintReportDetails.setFeedbackNatureID(new Integer("201"));
		complaintReportDetails.setDesignationID(new Integer("301"));
		complaintReportDetails.setTypeOfComplain("Fraud");
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailListByTypeAndNatureAndDesign1(Mockito.anyInt(),Mockito.anyInt(),Mockito.anyInt(),
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertTrue(res.contains("\"feedbackTypeID\":101"));
		//assertTrue(res.contains("\"designationID\":301"));
		//assertTrue(res.contains("\"feedbackNatureID\":201"));

	}
	@Test
	public void getComplaintReportTest8()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setIsMother(true);
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailList(
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class), Mockito.anyBoolean(),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertFalse(res.contains("\"feedbackTypeID\":101"));
	}
	@Test
	public void getComplaintReportTest81()
	{
		ComplaintReportDetails complaintReportDetails=new ComplaintReportDetails();
		complaintReportDetails.setTypeOfComplain("Fraud");
		List<ComplaintReportDetails> complaintList=Lists.newArrayList();
		complaintList.add(complaintReportDetails);
		doReturn(complaintList).when(complaintReportRepository).getComplaintDetailList1(
				Mockito.any(Timestamp.class), Mockito.any(Timestamp.class),Mockito.anyLong());
		String res="";
		try {
			res=mctsReportServiceImpl.getComplaintReport(complaintReportDetails);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(res.contains("\"typeOfComplain\":\"Fraud\""));
		//assertFalse(res.contains("\"feedbackTypeID\":101"));
	}
*/
}
