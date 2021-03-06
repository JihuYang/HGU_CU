package com.walab.hgu.DTO;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {

	private int id;
	private int communityInfoId;
	private int communityMaterialId;
	private int clubAdvertiseId;
	private int clubId;
	private String originalUrl;
	private String fileOriginalUrl;
	private String realUrl;
	private MultipartFile file; 
	private int fileOrder;
	private int order;
	private int clubOrder;
	private Date regdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCommunityInfoId() {
		return communityInfoId;
	}
	public void setCommunityInfoId(int communityInfoId) {
		this.communityInfoId = communityInfoId;
	}
	public int getCommunityMaterialId() {
		return communityMaterialId;
	}
	public void setCommunityMaterialId(int communityMaterialId) {
		this.communityMaterialId = communityMaterialId;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getFileOrder() {
		return fileOrder;
	}
	public void setFileOrder(int fileOrder) {
		this.fileOrder = fileOrder;
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

	public int getClubAdvertiseId() {
		return clubAdvertiseId;
	}
	public void setClubAdvertiseId(int clubAdvertiseId) {
		this.clubAdvertiseId = clubAdvertiseId;
	}
	public String getFileOriginalUrl() {
		return fileOriginalUrl;
	}
	public void setFileOriginalUrl(String fileOriginalUrl) {
		this.fileOriginalUrl = fileOriginalUrl;
	}
	
	public int getClubId() {
		return clubId;
	}
	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	public int getClubOrder() {
		return clubOrder;
	}
	public void setClubOrder(int clubOrder) {
		this.clubOrder = clubOrder;
	}
	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", communityInfoId=" + communityInfoId + ", communityMaterialId="
				+ communityMaterialId + ", clubAdvertiseId=" + clubAdvertiseId + ", clubId=" + clubId + ", originalUrl="
				+ originalUrl + ", fileOriginalUrl=" + fileOriginalUrl + ", realUrl=" + realUrl + ", file=" + file
				+ ", fileOrder=" + fileOrder + ", order=" + order + ", clubOrder=" + clubOrder + ", regdate=" + regdate
				+ "]";
	}

}
