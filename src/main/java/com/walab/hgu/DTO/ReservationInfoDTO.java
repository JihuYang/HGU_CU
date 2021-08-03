package com.walab.hgu.DTO;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReservationInfoDTO {
	private int id;
	private int userId;
	private int spaceId;
	private String spaceName;
	private String person;
	private String email;
	private String phone;
	private Date reservationDate;
	private Time startTime;
	private Time endTime;
	private String purpose;
	private String memo;
	private Date regdate;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getSpaceId() {
		return spaceId;
	}


	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}
	

	
	public String getSpaceName() {
		return spaceName;
	}
	
	public void setSpaceName(String spaceName) {
		this.spaceName = spaceName;
	}
	
	public String getPerson() {
		return person;
	}
	
	public void setPerson(String person) {
		this.person = person;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getReservationDate() {
		return reservationDate;
	}


	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}


	public Time getStartTime() {
//		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
//		String time = format.format(startTime);
//        Time t = Time.valueOf(time);
		return startTime;
	}


	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}


	public Time getEndTime() {
		return endTime;
	}


	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}


	public String getPurpose() {
		return purpose;
	}


	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}


	public String getMemo() {
		return memo;
	}


	public void setMemo(String memo) {
		this.memo = memo;
	}


	public Date getRegdate() {
		return regdate;
	}


	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}


	@Override
	public String toString() {
		return "ReservaionDTO [id=" + id + " startTime="+startTime+" regdate=" + regdate+"]";
	}
	
}
