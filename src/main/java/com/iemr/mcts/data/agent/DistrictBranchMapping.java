package com.iemr.mcts.data.agent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Entity
@Table(name = "m_DistrictBranchMapping")
@Data
public class DistrictBranchMapping
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DistrictBranchID")
	@Expose
	private Integer districtBranchID;

	@Column(name = "BlockID")
	@Expose
	private Integer blockID;
	
	@Column(name = "PanchayatName")
	@Expose
	private String panchayatName;
	
	@Column(name = "VillageName")
	@Expose
	private String villageName;
	
	@Column(name = "Habitat")
	@Expose
	private String habitat;
	@Column(name = "PinCode")
	@Expose
	private String pinCode;
	@Column(name = "Deleted", insertable = false, updatable = false)
	@Expose
	private Boolean deleted;

}
