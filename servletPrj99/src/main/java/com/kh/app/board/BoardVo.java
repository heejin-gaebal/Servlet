package com.kh.app.board;

public class BoardVo {
	private int no;
	private String title;
	private String content;
	private int writerNo;
	private String createdDate;
	private int hit;
	private String delYn;
	
	public BoardVo(int no, String title, String content, int writerNo, String createdDate, int hit, String delYn) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writerNo = writerNo;
		this.createdDate = createdDate;
		this.hit = hit;
		this.delYn = delYn;
	}
	
	public BoardVo() {

	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
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
	public int getWriterNo() {
		return writerNo;
	}
	public void setWriterNo(int writerNo) {
		this.writerNo = writerNo;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", writerNo=" + writerNo
				+ ", createdDate=" + createdDate + ", hit=" + hit + ", delYn=" + delYn + "]";
	}
}
