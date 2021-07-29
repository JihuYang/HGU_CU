package com.walab.hgu.DTO;

import java.util.Date;

public class ClubDTO {

	private int categoryId;
	private int userId;
	private int id;//동아리 아이디 
	private String categoryName;//분과 이
	private String clubName;//동아리 이름 
	private String clubCeoName;
	private String clubLocation;//동방 위치 
	private String phone;//대표 번호 
	private Date foundationDate;//창립일 
	private String clubDescription;//동아리 소개 설명글 
	private String instagramLink;
	private String facebookLink;
	private String originalUrl;
	private Date regdate;
	

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getClubName() {
		return clubName;
	}
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	public Date getFoundationDate() {
		return foundationDate;
	}
	public void setFoundationDate(Date foundationDate) {
		this.foundationDate = foundationDate;
	}
	public String getClubDescription() {
		return clubDescription;
	}
	public void setClubDescription(String clubDescription) {
		this.clubDescription = clubDescription;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClubLocation() {
		return clubLocation;
	}
	public void setClubLocation(String clubLocation) {
		this.clubLocation = clubLocation;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getClubCeoName() {
		return clubCeoName;
	}
	public void setClubCeoName(String clubCeoName) {
		this.clubCeoName = clubCeoName;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public String getInstagramLink() {
		return instagramLink;
	}
	public void setInstagramLink(String instagramLink) {
		this.instagramLink = instagramLink;
	}
	public String getFacebookLink() {
		return facebookLink;
	}
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}
	@Override
	public String toString() {
		return "ClubDTO [categoryId=" + categoryId + ", userId=" + userId + ", id=" + id + ", categoryName="
				+ categoryName + ", clubName=" + clubName + ", clubCeoName=" + clubCeoName + ", clubLocation="
				+ clubLocation + ", phone=" + phone + ", foundationDate=" + foundationDate + ", clubDescription="
				+ clubDescription + ", instagramLink=" + instagramLink + ", facebookLink=" + facebookLink
				+ ", originalUrl=" + originalUrl + ", regdate=" + regdate + "]";
	}
	
	
}
