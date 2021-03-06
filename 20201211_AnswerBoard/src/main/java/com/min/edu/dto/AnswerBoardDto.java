package com.min.edu.dto;

import java.io.Serializable;
import java.util.Date;

public class AnswerBoardDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String seq;
	private String id;
	private String title;
	private String content;
	private int refer;
	private int step;
	private int depth;
	private int readcount;
	private String delflag;
	private Date regdate;
	
	public AnswerBoardDto() {
		// TODO Auto-generated constructor stub
	}

	public AnswerBoardDto(String seq, String id, String title, String content, int refer, int step, int depth,
			int readcount, String delflag, Date regdate) {
		super();
		this.seq = seq;
		this.id = id;
		this.title = title;
		this.content = content;
		this.refer = refer;
		this.step = step;
		this.depth = depth;
		this.readcount = readcount;
		this.delflag = delflag;
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "AnswerBoardDto [seq=" + seq + ", id=" + id + ", title=" + title + ", content=" + content + ", refer="
				+ refer + ", step=" + step + ", depth=" + depth + ", readcount=" + readcount + ", delflag=" + delflag
				+ ", regdate=" + regdate + "]";
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getRefer() {
		return refer;
	}

	public void setRefer(int refer) {
		this.refer = refer;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
}
