package com.cdsecond.tools;

/**
 * 
 * @author zs
 *
 */
public class Catalog {
	/**
	 * ID
	 */
	private Long id;
	/**分类名称
	 * 
	 */
	private String name;
	/**
	 * 所属父分类
	 */
	private Long fathernum;
	private Long type;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getFathernum() {
		return fathernum;
	}
	public void setFathernum(Long fathernum) {
		this.fathernum = fathernum;
	}

	public String getEntry() {
		return entry;
	}
	public void setEntry(String entry) {
		this.entry = entry;
	}
	public String getEntrytime() {
		return entrytime;
	}
	public void setEntrytime(String entrytime) {
		this.entrytime = entrytime;
	}
	public Long getDelete() {
		return delete;
	}
	public void setDelete(Long delete) {
		this.delete = delete;
	}
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getUpload() {
		return upload;
	}
	public void setUpload(Long upload) {
		this.upload = upload;
	}
	/**
	 * 分类描述
	 */
	private String location;
	/**
	 * 录入人
	 */
	private String entry;
	/**
	 * 录入时间
	 */
	private String entrytime;
	/**删除
	 * 
	 */
	private Long delete;
	/**
	 * 大小
	 */
	private Long size;
	/**
	 * 下载
	 */
	private Long upload;
}
