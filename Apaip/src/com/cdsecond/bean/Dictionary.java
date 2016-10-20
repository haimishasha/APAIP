package com.cdsecond.bean;

/**
 * 
 * @author zhangjian
 * 说明：扶贫措施类
 * 	这个类描述了扶贫措施的属性跟set、get方法
 *
 */
public class Dictionary {
	/**
	 * 字典ID
	 */
	private String dicID;
	/**
	 * 名字
	 */
	private String dicName;
	/**
	 * 类型
	 */
	private String dicType;
	/**
	 * 描述
	 */
	private String dicDescription;
	public String getDicID() {
		return dicID;
	}
	public void setDicID(String dicID) {
		this.dicID = dicID;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public String getDicType() {
		return dicType;
	}
	public void setDicType(String dicType) {
		this.dicType = dicType;
	}
	public String getDicDescription() {
		return dicDescription;
	}
	public void setDicDescription(String dicDescription) {
		this.dicDescription = dicDescription;
	}
	@Override
	public String toString() {
		return "Dictionary [dicID=" + dicID + ", dicName=" + dicName
				+ ", dicType=" + dicType + ", dicDescription=" + dicDescription
				+ "]";
	}
	public Dictionary(){
		
	}
	public Dictionary(String dicID, String dicName, String dicType,
			String dicDescription) {
		super();
		this.dicID = dicID;
		this.dicName = dicName;
		this.dicType = dicType;
		this.dicDescription = dicDescription;
	}
}