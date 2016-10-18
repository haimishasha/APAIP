package com.cdsecond.bean;

/**
 * 
 * @author yaoyanyan
 * 说明：申请评选须知实体类
 * 		这个类描述了申请评选须知的属性跟set、get方法
 *
 */

public class SelectionNotes {
	
	/**
	 * 申请评选须知的属性编写
	 */
	private String selectionNotesID;		//申请评选须知ID 
	
	private String notesName;				//申请评选须知名称
	
	private String applyStartTime;			//申请开始时间
	
	private String applyEndTime;			//申请结束时间
	
	private String applyContent;			//申请内容
	
	private String applyPerson;				//录入人
	
	private String applyTime;				//申请时间
	
	private int applyStatus;				//申请状态

	
	/**
	 * 无参构造方法
	 */
	public SelectionNotes(){
		
	}
	
	/**
	 * 各个属性的 set、get方法
	 */

	public String getSelectionNotesID() {
		return selectionNotesID;
	}


	public void setSelectionNotesID(String selectionNotesID) {
		this.selectionNotesID = selectionNotesID;
	}


	public String getNotesName() {
		return notesName;
	}


	public void setNotesName(String notesName) {
		this.notesName = notesName;
	}


	public String getApplyStartTime() {
		return applyStartTime;
	}


	public void setApplyStartTime(String applyStartTime) {
		this.applyStartTime = applyStartTime;
	}


	public String getApplyEndTime() {
		return applyEndTime;
	}


	public void setApplyEndTime(String applyEndTime) {
		this.applyEndTime = applyEndTime;
	}


	public String getApplyContent() {
		return applyContent;
	}


	public void setApplyContent(String applyContent) {
		this.applyContent = applyContent;
	}


	public String getApplyPerson() {
		return applyPerson;
	}


	public void setApplyPerson(String applyPerson) {
		this.applyPerson = applyPerson;
	}


	public String getApplyTime() {
		return applyTime;
	}


	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}


	public int getApplyStatus() {
		return applyStatus;
	}


	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}
	
	
	
}
