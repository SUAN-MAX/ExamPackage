package com.min.edu.dto;

public class UserDto {

	private String id;
	private String pw;
	private String auth;
	private String delflag;
	private String regdate;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserDto() {
	}
	
	public UserDto(String id, String pw, String auth, String delflag, String regdate, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.auth = auth;
		this.delflag = delflag;
		this.regdate = regdate;
		this.name = name;
	}
	

	public UserDto(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", pw=" + pw + ", auth=" + auth + ", delflag=" + delflag + ", regdate=" + regdate
				+ ", name=" + name + "]";
	}
	
}
