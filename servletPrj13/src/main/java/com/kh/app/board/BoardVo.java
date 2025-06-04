package com.kh.app.board;

public class BoardVo {
	private String no;
	private String title;
	private String content;
	
	public BoardVo(String no, String title, String content) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
	}
	
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
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
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + "]";
	}
}
