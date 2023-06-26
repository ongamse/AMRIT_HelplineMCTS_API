package com.iemr.mcts.data.report;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Entity
@Table(name = "db_reporting.dim_beneficiary", schema = "db_reporting")
@Data
public class IdentityDetail implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Dim_BeneficiaryID")
	private Long dimBeneficiaryID;

	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Column(name = "FirstName")
	private String firstName;
	
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "DOB")
	private Date birthDate;

	@Column(name = "PermDistrictId")
	private Long districtID;

	@Column(name = "PermDistrict")
	private String districtName;
	
	@Column(name = "BeneficiaryID")
	private String beneficiaryID;
	
	@Column(name = "PhoneNum2")
	private String phoneNum2;

	@Override
	public String toString() {

		return OutputMapper.gsonWithoutExposeRestriction().toJson(this);
	}


}

