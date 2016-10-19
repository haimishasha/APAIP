package com.cdsecond.bean;

public class PovertyMeasure {
	/**
	 * @author zhangjian
 * 说明：扶贫措施类
 * 		这个类描述了扶贫措施的属性跟set、get方法
	 */
	private String measureID;//措施ID
	public PovertyMeasure(String measureID, int planID, String measureName,
			int poorNumber, String poorVillage, String measureContent,
			double budgetAmount, String measureTime) {
		super();
		this.measureID = measureID;
		this.planID = planID;
		this.measureName = measureName;
		this.poorNumber = poorNumber;
		this.poorVillage = poorVillage;
		this.measureContent = measureContent;
		this.budgetAmount = budgetAmount;
		this.measureTime = measureTime;
	}


	@Override
	public String toString() {
		return "PovertyMeasure [measureID=" + measureID + ", planID=" + planID
				+ ", measureName=" + measureName + ", poorNumber=" + poorNumber
				+ ", poorVillage=" + poorVillage + ", measureContent="
				+ measureContent + ", budgetAmount=" + budgetAmount
				+ ", measureTime=" + measureTime + "]";
	}


	public String getMeasureID() {
		return measureID;
	}


	public void setMeasureID(String measureID) {
		this.measureID = measureID;
	}


	public int getPlanID() {
		return planID;
	}


	public void setPlanID(int planID) {
		this.planID = planID;
	}


	public String getMeasureName() {
		return measureName;
	}


	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}


	public int getPoorNumber() {
		return poorNumber;
	}


	public void setPoorNumber(int poorNumber) {
		this.poorNumber = poorNumber;
	}


	public String getPoorVillage() {
		return poorVillage;
	}


	public void setPoorVillage(String poorVillage) {
		this.poorVillage = poorVillage;
	}


	public String getMeasureContent() {
		return measureContent;
	}


	public void setMeasureContent(String measureContent) {
		this.measureContent = measureContent;
	}


	public double getBudgetAmount() {
		return budgetAmount;
	}


	public void setBudgetAmount(double budgetAmount) {
		this.budgetAmount = budgetAmount;
	}


	public String getMeasureTime() {
		return measureTime;
	}


	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}


	private int planID;//计划ID
	private String measureName;//措施名称
	private int poorNumber;//扶贫人数
	private String poorVillage;//扶贫村庄
	private String measureContent;//措施内容
	private double budgetAmount;//预算金额
	private String measureTime;//措施 制定 时间
	
	
	public PovertyMeasure(){
		
	}

	
}
