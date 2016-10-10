package com.bit2016.jdbc.vo;

public class BookVo {
	private Long no;
	private String title;
	private String pubDate;
	private String state;
	private Long authorNo;
	
	public Long getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getPubDate() {
		return pubDate;
	}
	public String getState() {
		return state;
	}
	public Long getAuthorNo() {
		return authorNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}
	

}
