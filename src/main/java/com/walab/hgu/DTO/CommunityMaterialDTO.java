package com.walab.hgu.DTO;

import java.util.Date;

public class CommunityMaterialDTO {

	private int id;
	private int userId;
	private String writer;
	private String title;
	private String content;
	private String originalUrl;
	private String realUrl;
	private int order;
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
	public void setUserId(int userId) {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getRealUrl() {
		return realUrl;
	}
	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
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
		return "CommunityMaterialDTO [id=" + id + ", userId=" + userId + ", writer=" + writer + ", title=" + title
				+ ", content=" + content + ", originalUrl=" + originalUrl + ", realUrl=" + realUrl + ", order=" + order
				+ ", regdate=" + regdate + ", viewCount=" + viewCount + "]";
	}

	
}
