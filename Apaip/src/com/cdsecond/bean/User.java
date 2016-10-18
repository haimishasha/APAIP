package com.cdsecond.bean;

/**
 * user表的Bean组件
 * @author JING
 *
 */

public class User {
	
	/**
	 * user表中的属性字段
	 */

	private String userID; //用户ID
	
	private String userName; //用户名
	
	private String userPassword; //用户密码
	
	private String userTrueName; //用户真实姓名
	
	private String userSex; //用户性别
	
	private String IDCard; //用户身份证号
	
	private String userPhone; //用户手机号码
	
	private String userAddr; //用户家庭地址
	
	private int userStatus; //用户状态

	/**
	 * user表的getter和setter方法
	 */
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTrueName() {
		return userTrueName;
	}

	public void setUserTrueName(String userTrueName) {
		this.userTrueName = userTrueName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * user表的构造方法
	 * @param userID
	 * @param userName
	 * @param userPassword
	 * @param userTrueName
	 * @param userSex
	 * @param iDCard
	 * @param userPhone
	 * @param userAddr
	 * @param userStatus
	 */
	public User(){};
	public User(String userID, String userName, String userPassword,
			String userTrueName, String userSex, String iDCard,
			String userPhone, String userAddr, int userStatus) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userTrueName = userTrueName;
		this.userSex = userSex;
		IDCard = iDCard;
		this.userPhone = userPhone;
		this.userAddr = userAddr;
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName
				+ ", userPassword=" + userPassword + ", userTrueName="
				+ userTrueName + ", userSex=" + userSex + ", IDCard=" + IDCard
				+ ", userPhone=" + userPhone + ", userAddr=" + userAddr
				+ ", userStatus=" + userStatus + "]";
	}
	
	
	
}
