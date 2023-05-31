package com.mycom.myapp.board;

import java.util.Date;

//게시글 정보를 담는 객체
//BoardDAO에서 사용되며, 게시글 정보를 전달하는 용도로 사용
public class BoardVO {
	private int seq;          // 게시글 번호
	private String title;     // 제목
	private String writer;    // 작성자
	private String content;   // 내용
	private Date regdate;     // 작성일자
	private int cnt;          // 조회수
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}