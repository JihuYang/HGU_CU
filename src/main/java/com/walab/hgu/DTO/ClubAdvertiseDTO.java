package com.walab.hgu.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class ClubAdvertiseDTO {
	

	private int id;
	private int writer;
	private int clubId;
	private String title;
	private String content;
	private String originalUrl;
	private String fileOriginalUrl;
	private MultipartFile file; 
	private MultipartFile imageFile; 
	private Date regdate;
	private int order;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWriter() {
		return writer;
	}
	public void setWriter(int writer) {
		this.writer = writer;
	}
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imagefile) {
		this.imageFile = imagefile;
	}
	public String getFileOriginalUrl() {
		return fileOriginalUrl;
	}
	public void setFileOriginalUrl(String fileOriginalUrl) {
		this.fileOriginalUrl = fileOriginalUrl;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return "ClubAdvertiseDTO [id=" + id + ", writer=" + writer + ", clubId=" + clubId + ", title=" + title
				+ ", content=" + content + ", originalUrl=" + originalUrl + ", fileOriginalUrl=" + fileOriginalUrl
				+ ", file=" + file + ", imageFile=" + imageFile + ", regdate=" + regdate + ", order=" + order + "]";
	}
	 
}
