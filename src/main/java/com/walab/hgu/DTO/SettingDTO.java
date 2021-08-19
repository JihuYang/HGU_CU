package com.walab.hgu.DTO;

import java.util.Date;

public class SettingDTO {

	private int id;
	private String key;
	private int value;
	private Date regdate;
	


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
	}



	public Date getRegdate() {
		return regdate;
	}



	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}



	@Override
	public String toString() {
		return "SettingDTO [ id=" + id + ", key=" + key + ", value=" + value
				+ ", regdate=" + regdate + "]";
	}
	
	
}
