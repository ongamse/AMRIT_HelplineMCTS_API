package com.iemr.mcts.data.supervisor;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;
import com.iemr.mcts.utils.mapper.OutputMapper;

import lombok.Data;

@Data
@Entity
@Table(name="t_childvaliddata")
public class ChildDataReader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name="RowID")
	private Long rowID;
	 
	@Expose
	@Column(name="MCTSID_no_Child_ID")
	private Long mctsChildNo;
	 
	@Expose
	@Column(name="Child_Name")
	private String childName;
	 
	@Expose
	@Column(name="Father_Name")
	private String fatherName;
	 
	@Expose
	@Column(name="Mother_Name")
	private String motherName;
	 
	@Expose
	@Column(name="Mother_ID")
	private Long motherID;
	 
	@Expose
	@Column(name="DOB")
	private Date dob;
	 
	@Expose
	@Column(name="Place_of_Birth")
	private String placeOfBirth;
	 
	@Expose
	@Column(name="Gender")
	private String gender;
	 
	@Expose
	@Column(name="Caste")
	private String caste;
	 
	@Expose
	@Column(name="BloodGroup")
	private String bloodGroup;
	 
	@Expose
	@Column(name="Child_Aadhaar_No")
	private String childAadhaarNo;
	 
	@Expose
	@Column(name="Weight_of_Child")
	private Float weightOfChild;
	 
	@Expose
	@Column(name="Child_EID")
	private Integer childEID;
	 
	@Expose
	@Column(name="Phone_No_of")
	private String phoneNoOf;
	 
	@Expose
	@Column(name="Phone_No")
	private String phoneNo;
	 
	@Expose
	@Column(name = "ANM_Name")
	private String anmName;
	
	@Expose
	@Column(name = "ANM_Ph")
	private String anmPh;
	
	@Expose
	@Column(name = "ASHA_Name")
	private String ashaName;
	
	@Expose
	@Column(name = "ASHA_Ph")
	private String ashaPh;
	
	@Column(name = "FileID")
	private Long fileID;
	
	@Column(name = "Deleted")
	private Boolean deleted;
	
	@Column(name = "CreatedBy")
	private String createdBy;
	
	@Column(name = "CreatedDate")
	private Date createdDate;
	
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	
	@Column(name = "LastModDate")
	private Date lastModDate;
	
	@Expose
	@Column(name = "IsAllocated")
	private Boolean isAllocated;
	
	/**
	 * file manager mapping
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fileID", insertable = false, updatable = false)
	private FileManager fileManager;
	
	/**
	 * Default Constructor
	 */
	public ChildDataReader(){}
	
	/**
	 * Constructor 
	 */
	public ChildDataReader(Long rowID, Long mctsChildNo, String childName, String fatherName, String motherName, 
			Long motherID, java.util.Date dob, String placeOfBirth, String gender, String caste, String bloodGroup, String childAadhaarNo, 
			Float weightOfChild, Integer childEID, String phoneNoOf, String phoneNo, String anmName, String anmPh, 
			String ashaName, String ashaPh){
		
		this.rowID = rowID;
		this.mctsChildNo = mctsChildNo;
		this.childName = childName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.motherID = motherID;
		this.dob = this.convertUtilDatetoSqlDate(dob);
		this.placeOfBirth = placeOfBirth;
		this.gender = gender;
		this.caste = caste;
		this.bloodGroup = bloodGroup;
		this.childAadhaarNo = childAadhaarNo;
		this.weightOfChild = weightOfChild;
		this.childEID = childEID;
		this.phoneNoOf = phoneNoOf;
		this.phoneNo = phoneNo;
		this.anmName = anmName;
		this.anmPh = anmPh;
		this.ashaName = ashaName;
		this.ashaPh = ashaPh;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return OutputMapper.gson().toJson(this);
	}

	/**
	 * 
	 * @param utilDate
	 * @return
	 */
	private Date convertUtilDatetoSqlDate(java.util.Date utilDate){
		
		return new Date(utilDate.getTime());
	}
}
