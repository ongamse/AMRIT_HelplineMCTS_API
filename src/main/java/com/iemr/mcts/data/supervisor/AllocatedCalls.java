package com.iemr.mcts.data.supervisor;

import java.sql.Timestamp;
import java.util.Comparator;

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

@Entity
@Data
@Table(name = "t_MCTSOutboundCalls")
public class AllocatedCalls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose
	@Column(name = "OBCallID")
	private Long obCallID;
	
	@Expose
	@Column(name = "MotherID", insertable = true, updatable = true)
	private Long motherID;

	@Expose
	@Column(name = "ChildID")
	private Long childID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "AllocatedUserID", insertable = false, updatable = true)
	private Integer allocatedUserID;

	@Expose
	@Column(name = "OutboundCallType")
	private String outboundCallType;

	@Expose
	@Column(name = "CallDateFrom")
	private Timestamp callDateFrom;
	
	@Column(name = "CallDateTo")
	private Timestamp callDateTo;
	
	@Expose
	@Column(name = "AllocationStatus")
	private String allocationStatus;
	
	@Column(name = "CallStatus")
	private String callStatus;

	/**
	 * map id on with mother data reader detail
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "motherID", referencedColumnName = "MCTSID_no", insertable = false, updatable = false)
	@Expose
	private MctsDataReaderDetail mctsDataReaderDetail;

	/**
	 * map id on with mother data reader detail
	 */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "childID", referencedColumnName = "MCTSID_no_Child_ID", insertable = false, updatable = false)
	@Expose
	private ChildValidDataHandler childValidDataHandler;

	/**
	 * OutputMapper
	 */
	private static OutputMapper outputMapper = new OutputMapper();
	
	
	public AllocatedCalls(Long obCallID,Integer allocatedUserID,java.util.Date callDateFrom)
	{
			this.obCallID=obCallID;
			this.allocatedUserID=allocatedUserID;
			this.callDateFrom = new Timestamp(callDateFrom.getTime());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((callDateFrom == null) ? 0 : callDateFrom.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllocatedCalls other = (AllocatedCalls) obj;
		if (callDateFrom == null) {
			if (other.callDateFrom != null)
				return false;
		} else if (!callDateFrom.equals(other.callDateFrom))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return outputMapper.gson().toJson(this);
	}

	public static Comparator<AllocatedCalls> getSortCompoByCallFromDate() {

		Comparator<AllocatedCalls> comp = new Comparator<AllocatedCalls>() {

			@Override
			public int compare(AllocatedCalls o1, AllocatedCalls o2) {

				if (o1.getCallDateFrom() != null && o2.getCallDateFrom() != null)
					return o1.getCallDateFrom().compareTo(o2.getCallDateFrom());

				else
					return 0;
			}
		};

		return comp;
	}
}
