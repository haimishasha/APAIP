package com.cdsecond.bean;

public class AlleviationSituation {
	private int alleviationSituationID;			//帮扶情况ID
	private int applicantID;					//申请人ID
	private String startTime;					//帮扶开始时间	
	private String endTime;						//帮扶结束时间
	private String alleviationDetail;			//具体措施
	private int alleviationDelete;				//删除
	public int getAlleviationSituationID() {
		return alleviationSituationID;
	}
	public void setAlleviationSituationID(int alleviationSituationID) {
		this.alleviationSituationID = alleviationSituationID;
	}
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getAlleviationDetail() {
		return alleviationDetail;
	}
	public void setAlleviationDetail(String alleviationDetail) {
		this.alleviationDetail = alleviationDetail;
	}
	public int getAlleviationDelete() {
		return alleviationDelete;
	}
	public void setAlleviationDelete(int alleviationDelete) {
		this.alleviationDelete = alleviationDelete;
	}
	@Override
	public String toString() {
		return "AlleviationSituation [alleviationSituationID="
				+ alleviationSituationID + ", applicantID=" + applicantID
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", alleviationDetail=" + alleviationDetail
				+ ", alleviationDelete=" + alleviationDelete + ", toString()="
				+ super.toString() + "]";
	}
	public AlleviationSituation(int alleviationSituationID, int applicantID,
			String startTime, String endTime, String alleviationDetail,
			int alleviationDelete) {
		super();
		this.alleviationSituationID = alleviationSituationID;
		this.applicantID = applicantID;
		this.startTime = startTime;
		this.endTime = endTime;
		this.alleviationDetail = alleviationDetail;
		this.alleviationDelete = alleviationDelete;
	}
	public AlleviationSituation() {
		super();
	}

}
