package com.cdsecond.bean;

public class PovertyPlan {

	private String planId;//计划ID
	public PovertyPlan(){
		
	}

	public PovertyPlan(String planId, String planName, String planTime,
			String planContent, String planMaker, double planTotalMoney,
			String planAim, String planPredictTime, String planStartTime,
			String planStatus) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planTime = planTime;
		this.planContent = planContent;
		this.planMaker = planMaker;
		this.planTotalMoney = planTotalMoney;
		this.planAim = planAim;
		this.planPredictTime = planPredictTime;
		this.planStartTime = planStartTime;
		this.planStatus = planStatus;
	}

	@Override
	public String toString() {
		return "PovertyPlan [planId=" + planId + ", planName=" + planName
				+ ", planTime=" + planTime + ", planContent=" + planContent
				+ ", planMaker=" + planMaker + ", planTotalMoney="
				+ planTotalMoney + ", planAim=" + planAim
				+ ", planPredictTime=" + planPredictTime + ", planStartTime="
				+ planStartTime + ", planStatus=" + planStatus + "]";
	}

	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public String getPlanContent() {
		return planContent;
	}
	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}
	public String getPlanMaker() {
		return planMaker;
	}
	public void setPlanMaker(String planMaker) {
		this.planMaker = planMaker;
	}
	public double getPlanTotalMoney() {
		return planTotalMoney;
	}
	public void setPlanTotalMoney(double planTotalMoney) {
		this.planTotalMoney = planTotalMoney;
	}
	public String getPlanAim() {
		return planAim;
	}
	public void setPlanAim(String planAim) {
		this.planAim = planAim;
	}
	public String getPlanPredictTime() {
		return planPredictTime;
	}
	public void setPlanPredictTime(String planPredictTime) {
		this.planPredictTime = planPredictTime;
	}
	public String getPlanStartTime() {
		return planStartTime;
	}
	public void setPlanStartTime(String planStartTime) {
		this.planStartTime = planStartTime;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	//计划名称
	private String planName;
	//计划时间
	private String planTime;
	//计划内容
	private String planContent;
	//制定人
	private String planMaker;
	//总预算金额
	private double planTotalMoney;
	
	
	
	//计划目标
	private String planAim;
	//预估时间
	private String planPredictTime;
	//起始时间
	private String planStartTime;
	//计划状态
	private String planStatus;
}
