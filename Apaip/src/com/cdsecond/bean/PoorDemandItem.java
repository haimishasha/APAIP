package com.cdsecond.bean;

/**
 * 
 * @author yaoyanyan
 *
 *说明：贫困户需求清单实体类
 *		这个类编写了贫困户需求清单的属性和set、get方法
 */
public class PoorDemandItem {

	/**
	 * 贫困户需求清单的属性编写
	 */
	
	private String demandID;		//需求ID

	private String demandName;		//需求名称
	
	private String demandDescript;	//需求描述
	
	private int poorDemandItemStatus;//需求状态
	
	/**
	 * 无参构造方法
	 */
	
	public PoorDemandItem(){
		
	}
	
	/**
	 * 各个属性的set、get方法
	 */

	public String getDemandID() {
		return demandID;
	}

	public void setDemandID(String demandID) {
		this.demandID = demandID;
	}

	public String getDemandName() {
		return demandName;
	}

	public void setDemandName(String demandName) {
		this.demandName = demandName;
	}

	public String getDemandDescript() {
		return demandDescript;
	}

	public void setDemandDescript(String demandDescript) {
		this.demandDescript = demandDescript;
	}

	public int getPoorDemandItemStatus() {
		return poorDemandItemStatus;
	}

	public void setPoorDemandItemStatus(int poorDemandItemStatus) {
		this.poorDemandItemStatus = poorDemandItemStatus;
	}
	
	
	
	
}
