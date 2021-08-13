package com.walab.hgu.DTO;

public class Page {

	private int num;
	private int count;//게시물 총 갯수
	private int postNum = 10;//한 페이지에 출력할 게시물 갯수 
	private int pageNum;//하단 페이징 번호
	private int displayPost;//출력할 게시물
	private int pageNumCnt =5;//한번에 표시할 페이징 번호의 갯수 
	private int endPageNum;//표시되는 페이지 번호 중 마지막 번호
	private int startPageNum;//표시되는 페이지 번호 중 첫번째 번호
	
	private boolean prev;
	private boolean next;
	
	
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		
		dataCalc();
	}
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	
	public int getDisplayPost() {
		return displayPost;
	}
	
	public int getPageNumCnt() {
		return pageNumCnt;
	}
	
	public int getEndPageNum() {
		return endPageNum;
	}
	
	public int getStartPageNum() {
		return startPageNum;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	@Override
	public String toString() {
		return "Page [num=" + num + ", count=" + count + ", postNum=" + postNum + ", pageNume=" + pageNum
				+ ", displayPost=" + displayPost + ", pageNumCnt=" + pageNumCnt + ", endPageNum=" + endPageNum
				+ ", startPageNum=" + startPageNum + ", prev=" + prev + ", next=" + next + "]";
	}
	
	private void dataCalc() {
		 
		 // 마지막 번호
		 endPageNum = (int)(Math.ceil((double)num / (double)pageNumCnt) * pageNumCnt);
		 
		 // 시작 번호
		 startPageNum = endPageNum - (pageNumCnt - 1);
		 
		 // 마지막 번호 재계산
		 int endPageNum_tmp = (int)(Math.ceil((double)count / (double)postNum));
		 
		 if(endPageNum > endPageNum_tmp) {
		  endPageNum = endPageNum_tmp;
		 }
		 
		 prev = startPageNum == 1 ? false : true;
		 next = endPageNum * postNum >= count ? false : true;
		 
		 displayPost = (num - 1) * postNum;
		 
	}
	
	public String getSearchTypeKeyword() {
		 
		 if(searchType.equals("") || keyword.equals("")) {
		  return ""; 
		 } else {
		  return "&searchType=" + searchType + "&keyword=" + keyword; 
		 }
	}

	private String searchType;
	private String keyword; 

	public void setSearchType(String searchType) {
		this.searchType = searchType;  
	}

	public String getSearchType() {
	
		return searchType;
	} 

	public void setKeyword(String keyword) {
		 this.keyword = keyword;  
	} 

	public String getKeyword() {
		 return keyword;
	}
	
}
