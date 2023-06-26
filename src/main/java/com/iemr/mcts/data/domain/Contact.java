package com.iemr.mcts.data.domain;

import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

import lombok.Data;

@Data
public class Contact {

	private String preferredPhoneNum;
	private String preferredPhoneTyp;
	private String preferredSMSPhoneNum;
	private String preferredSMSPhoneTyp;
	private String emergencyContactNum;
	private String emergencyContactTyp;
	private String phoneNum1;
	private String phoneTyp1;
	private String phoneNum2;
	private String phoneTyp2;
	private String phoneNum3;
	private String phoneTyp3;
	private String phoneNum4;
	private String phoneTyp4;
	private String phoneNum5;
	private String phoneTyp5;
	
	public static Contact addContacts(MctsDataReaderDetail dataReaderDetail) {
		Contact contact = new Contact();
		if(dataReaderDetail != null) {
			contact.preferredPhoneTyp = dataReaderDetail.getPhoneNo_Of_Whom();
			contact.preferredPhoneNum = dataReaderDetail.getWhom_PhoneNo();
			contact.phoneTyp1 = dataReaderDetail.getANM_Name();
			contact.phoneNum1 = dataReaderDetail.getANM_Ph();
			contact.phoneTyp2 = dataReaderDetail.getASHA_Name();
			contact.phoneNum2 = dataReaderDetail.getASHA_Ph();
		}
		
		return contact;
	}
	
	public static Contact addContactsForChild(ChildValidDataHandler childValidDataHandler) {
		Contact contact = new Contact();
		if(childValidDataHandler != null) {
			contact.preferredPhoneTyp = childValidDataHandler.getPhone_No_of();
			contact.preferredPhoneNum = childValidDataHandler.getPhone_No();
			contact.phoneTyp1 = childValidDataHandler.getANM_Name();
			contact.phoneNum1 = childValidDataHandler.getANM_Phone_No();
			contact.phoneTyp2 = childValidDataHandler.getASHA_Name();
			contact.phoneNum2 = childValidDataHandler.getASHA_Phone_No();

		}
		
		return contact;
	}
}
