package com.skplanet.dto;

public class MemberVO {

	public MemberVO(String name, String id, String email, String pw) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.pw = pw;
	}
	private String name;
	private String id;
	private String email;
	private String pw;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
}
