package com.walab.hgu.DTO;

import java.util.Date;

public class CommunityInfoDTO {

	private int id;
	private int userId;
	private String writer;
	private String title;
	private Date regdate;
	private int viewCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setName(int userId) {
		this.userId = userId;
	}
	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
	public String toString() {
		return "CommunityInfoDTO [id=" + id + ", userId=" + userId + ", writer=" + writer + ", title=" + title
				+ ", regdate=" + regdate + ", viewCount=" + viewCount + "]";
	}
	
}
