package com.walab.hgu.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EventDTO {
	private int id;
	private String eventName;
	private String eventSpace;
	private String eventContent;
	private Date startDate;
	private Date endDate;
	private Date regdate;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public String getEventContent() {
		return eventContent;
	}


	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}


	public Date getStartDate(){
		return startDate;
	}


	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	public String getEventSpace() {
		return eventSpace;
	}

	public void setEventSpace(String eventSpace) {
		this.eventSpace = eventSpace;
	}

	@Override
	public String toString() {
		return "EventDTO [id=" + id + ", eventName=" + eventName + ", startDate=" + startDate + ", endDate=" + endDate
				 + ", regdate=" + regdate + "]";
	}
	
}
