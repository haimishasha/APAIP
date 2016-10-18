package com.cdsecond.bean;
/**
 * 
 * @author yaoyanyan
 *
 *说明：贫困户需求情况表
 *		这个类描述了贫困户需求情况的属性和set、get方法
 */
public class PoorDemandCondition {
	
	/**
	 * 贫困户需求情况的属性描述
	 */
	private String poorDemandConditionID;	//贫困需求情况ID
	
	private String demandID;				//需求ID 
	
	private String applicantID;				//申请人ID 
	
	/**
	 * 无参构造方法
	 */
	public PoorDemandCondition(){
		
	}
	
	/**
	 * 各个属性的set、get方法
	 */

	public String getPoorDemandConditionID() {
		return poorDemandConditionID;
	}

	public void setPoorDemandConditionID(String poorDemandConditionID) {
		this.poorDemandConditionID = poorDemandConditionID;
	}

	public String getDemandID() {
		return demandID;
	}

	public void setDemandID(String demandID) {
		this.demandID = demandID;
	}

	public String getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(String applicantID) {
		this.applicantID = applicantID;
	}
	
	
	
	
	

}
