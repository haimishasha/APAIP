package com.cdsecond.bean;
/**
 * 
 * @author yaoyanyan
 *说明：这个类是申请人信息实体类
 *		对申请人信息的属性及 set、get方法进行了编写，便于之后的访问
 */

public class Applicant {
	
	/**
	 * 申请人信息属性编写
	 */
	private String applicantID ;		//申请人ID 
	
	private String applicantName;		//申请人姓名
	
	private String applicantSex;		//申请人性别
	
	private String applicantNation;		//申请人民族
	
	private String applicantIdNumber;	//申请人身份证号
	
	private String applicantDisabilityNumber;//申请人残疾证号
	
	private String applicantAddress;	//户籍所在地
	
	private int applicantFamilyNumber;	//家庭人数
	
	private String applicantDisablityCondition; //残疾状况
	
	private String applicantPhone;		//联系方式
	
	private String applicantIncome;		//家庭收入
	
	private float houseArea;			//住房面积
	
	private String education;			//受教育程度
	
	private String marriage;			//婚姻状况
	
	private String applicantTime;		//申请时间
	
	private String povertyRank;			//贫困等级
	
	private String applicantStatus;		//申请人状态
	
	private String bankCardNumber;		//银行卡号
	
	private String applicantReason;		//申请理由

	/**
	 * 无参构造方法
	 */
	public Applicant() {
		
	}
	
	/**
	 * 
	 * 属性的set、get方法
	 */

	public String getApplicantID() {
		return applicantID;
	}

	public void setApplicantID(String applicantID) {
		this.applicantID = applicantID;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantSex() {
		return applicantSex;
	}

	public void setApplicantSex(String applicantSex) {
		this.applicantSex = applicantSex;
	}

	public String getApplicantNation() {
		return applicantNation;
	}

	public void setApplicantNation(String applicantNation) {
		this.applicantNation = applicantNation;
	}

	public String getApplicantIdNumber() {
		return applicantIdNumber;
	}

	public void setApplicantIdNumber(String applicantIdNumber) {
		this.applicantIdNumber = applicantIdNumber;
	}

	public String getApplicantDisabilityNumber() {
		return applicantDisabilityNumber;
	}

	public void setApplicantDisabilityNumber(String applicantDisabilityNumber) {
		this.applicantDisabilityNumber = applicantDisabilityNumber;
	}

	public String getApplicantAddress() {
		return applicantAddress;
	}

	public void setApplicantAddress(String applicantAddress) {
		this.applicantAddress = applicantAddress;
	}

	public int getApplicantFamilyNumber() {
		return applicantFamilyNumber;
	}

	public void setApplicantFamilyNumber(int applicantFamilyNumber) {
		this.applicantFamilyNumber = applicantFamilyNumber;
	}

	public String getApplicantDisablityCondition() {
		return applicantDisablityCondition;
	}

	public void setApplicantDisablityCondition(String applicantDisablityCondition) {
		this.applicantDisablityCondition = applicantDisablityCondition;
	}

	public String getApplicantPhone() {
		return applicantPhone;
	}

	public void setApplicantPhone(String applicantPhone) {
		this.applicantPhone = applicantPhone;
	}

	public String getApplicantIncome() {
		return applicantIncome;
	}

	public void setApplicantIncome(String applicantIncome) {
		this.applicantIncome = applicantIncome;
	}

	public float getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(float houseArea) {
		this.houseArea = houseArea;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getApplicantTime() {
		return applicantTime;
	}

	public void setApplicantTime(String applicantTime) {
		this.applicantTime = applicantTime;
	}

	public String getPovertyRank() {
		return povertyRank;
	}

	public void setPovertyRank(String povertyRank) {
		this.povertyRank = povertyRank;
	}

	public String getApplicantStatus() {
		return applicantStatus;
	}

	public void setApplicantStatus(String applicantStatus) {
		this.applicantStatus = applicantStatus;
	}

	public String getBankCardNumber() {
		return bankCardNumber;
	}

	public void setBankCardNumber(String bankCardNumber) {
		this.bankCardNumber = bankCardNumber;
	}

	public String getApplicantReason() {
		return applicantReason;
	}

	public void setApplicantReason(String applicantReason) {
		this.applicantReason = applicantReason;
	}
	
	

	

}
