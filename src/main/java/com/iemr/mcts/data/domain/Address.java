package com.iemr.mcts.data.domain;

import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

import lombok.Data;

@Data
public class Address {
	private String addrLine1;
	private String addrLine2;
	private String addrLine3;
	private Integer countryId;
	private String country;
	private Integer stateId;
	private String state;
	private Integer districtId;
	private String district;
	private Integer subDistrictId;
	private String subDistrict;
	private Integer villageId;
	private String village;
	private String habitation;
	private String addressValue;
	private String pinCode;
	
	public static Address getAddressDetails(MctsDataReaderDetail dataReaderDetail) {
		Address address = new Address();
		
		if(dataReaderDetail != null) {
			address.addrLine1 = dataReaderDetail.getAddress();
			address.state = dataReaderDetail.getState_Name();
			address.district = dataReaderDetail.getDistrict_Name();
			address.subDistrict = dataReaderDetail.getTaluka_Name();
			address.village = dataReaderDetail.getVillage_Name();
		}
		return address;
	}
	
	public static Address getAddressDetailsForChild(ChildValidDataHandler childValidDataHandler) {
		Address address = new Address();
		
		if(childValidDataHandler != null) {
			address.addrLine1 = childValidDataHandler.getAddress();
			address.state = childValidDataHandler.getState_Name();
			address.district = childValidDataHandler.getDistrict_Name();
			address.subDistrict = childValidDataHandler.getTaluka_Name();
			address.village = childValidDataHandler.getVillage_Name();
		}
		return address;
	}
}
