package com.walab.hgu.DTO;

import java.util.Date;

public class SpaceDTO {
	private int id;
	private String name;
	private int capacity;
	private int password;
	private String description;
	private int timeLimit;
	private Date regdate;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(int timeLimit) {
		this.timeLimit = timeLimit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "SpaceDTO [id=" + id + ", name=" + name + ", capacity=" + capacity + ", password=" + password
				+ ", description=" + description + ", timeLimit=" + timeLimit + ", regdate=" + regdate + "]";
	}
	
}
