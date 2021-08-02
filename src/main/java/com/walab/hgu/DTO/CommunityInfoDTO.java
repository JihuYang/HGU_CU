package com.walab.hgu.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CommunityInfoDTO {

	private int id;
	private int userId;
	private String writer;
	private String title;
	private String content;
	private String originalUrl;
	private String realUrl;
	private MultipartFile file; 
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
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
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

	public void setUserId(int userId) {
		this.userId = userId;
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
				+ ", content=" + content + ", originalUrl=" + originalUrl + ", realUrl=" + realUrl + ", file=" + file
				+ ", order=" + order + ", regdate=" + regdate + ", viewCount=" + viewCount + "]";
	}
	
}
