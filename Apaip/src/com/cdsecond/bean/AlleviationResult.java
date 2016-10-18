package com.cdsecond.bean;

public class AlleviationResult {
	//private String alleviationResultID;		//帮扶结果ID
	private String alleviationStartTime;	//帮扶开始时间
	private String alleviationEndTime;		//帮扶结束时间
	private String registerTime;			//登记时间
	private String resultDescription;		//帮扶结果描述
	private String alleviationStatus;		//帮扶状态
	private String registrant;				//登记人

	public String getAlleviationStartTime() {
		return alleviationStartTime;
	}
	public void setAlleviationStartTime(String alleviationStartTime) {
		this.alleviationStartTime = alleviationStartTime;
	}
	public String getAlleviationEndTime() {
		return alleviationEndTime;
	}
	public void setAlleviationEndTime(String alleviationEndTime) {
		this.alleviationEndTime = alleviationEndTime;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getResultDescription() {
		return resultDescription;
	}
	public void setResultDescription(String resultDescription) {
		this.resultDescription = resultDescription;
	}
	public String getAlleviationStatus() {
		return alleviationStatus;
	}
	public void setAlleviationStatus(String alleviationStatus) {
		this.alleviationStatus = alleviationStatus;
	}
	public String getRegistrant() {
		return registrant;
	}
	@Override
	public String toString() {
		return "AlleviationResult [alleviationStartTime="
				+ alleviationStartTime + ", alleviationEndTime="
				+ alleviationEndTime + ", registerTime=" + registerTime
				+ ", resultDescription=" + resultDescription
				+ ", alleviationStatus=" + alleviationStatus + ", registrant="
				+ registrant + ", toString()=" + super.toString() + "]";
	}
	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}
	public AlleviationResult() {
		super();
	}
	public AlleviationResult(String alleviationStartTime,
			String alleviationEndTime, String registerTime,
			String resultDescription, String alleviationStatus,
			String registrant) {
		super();
		this.alleviationStartTime = alleviationStartTime;
		this.alleviationEndTime = alleviationEndTime;
		this.registerTime = registerTime;
		this.resultDescription = resultDescription;
		this.alleviationStatus = alleviationStatus;
		this.registrant = registrant;
	}

}
