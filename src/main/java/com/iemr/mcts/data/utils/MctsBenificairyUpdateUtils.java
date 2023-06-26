package com.iemr.mcts.data.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.iemr.mcts.data.supervisor.ChildValidDataHandler;
import com.iemr.mcts.data.supervisor.MctsDataReaderDetail;

public class MctsBenificairyUpdateUtils {

	@SerializedName("fieldFor")
	@Expose
	private String fieldFor;
	
	@SerializedName("childValidDataHandler")
	@Expose
	private ChildValidDataHandler childValidDataHandler;
	
	@SerializedName("mctsDataReaderDetail")
	@Expose
	private MctsDataReaderDetail mctsDataReaderDetail;

	/**
	 * @return the fieldFor
	 */
	public String getFieldFor() {
		return fieldFor;
	}

	/**
	 * @param fieldFor the fieldFor to set
	 */
	public void setFieldFor(String fieldFor) {
		this.fieldFor = fieldFor;
	}

	/**
	 * @return the childValidDataHandler
	 */
	public ChildValidDataHandler getChildValidDataHandler() {
		return childValidDataHandler;
	}

	/**
	 * @param childValidDataHandler the childValidDataHandler to set
	 */
	public void setChildValidDataHandler(ChildValidDataHandler childValidDataHandler) {
		this.childValidDataHandler = childValidDataHandler;
	}

	/**
	 * @return the mctsDataReaderDetail
	 */
	public MctsDataReaderDetail getMctsDataReaderDetail() {
		return mctsDataReaderDetail;
	}

	/**
	 * @param mctsDataReaderDetail the mctsDataReaderDetail to set
	 */
	public void setMctsDataReaderDetail(MctsDataReaderDetail mctsDataReaderDetail) {
		this.mctsDataReaderDetail = mctsDataReaderDetail;
	}
	
}
