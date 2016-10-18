package com.cdsecond.bean;

public class AlleviationSituation {
	//private int alleviationSituationID;		//帮扶情况ID
	private String alleviationStartTime;		//帮扶开始时间	
	private String alleviationEndTime;			//帮扶结束时间
	private String alleviationDetail;			//具体措施
	private int alleviationDelete;				//删除

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
		return "alleviationSituation [alleviationStartTime="
				+ alleviationStartTime + ", alleviationEndTime="
				+ alleviationEndTime + ", alleviationDetail="
				+ alleviationDetail + ", alleviationDelete="
				+ alleviationDelete + ", toString()=" + super.toString() + "]";
	}
	public AlleviationSituation(String alleviationStartTime,
			String alleviationEndTime, String alleviationDetail,
			int alleviationDelete) {
		super();
		this.alleviationStartTime = alleviationStartTime;
		this.alleviationEndTime = alleviationEndTime;
		this.alleviationDetail = alleviationDetail;
		this.alleviationDelete = alleviationDelete;
	}
	public AlleviationSituation() {
		super();
	}

	

}
