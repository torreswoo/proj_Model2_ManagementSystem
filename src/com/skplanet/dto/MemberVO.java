package com.skplanet.dto;

public class MemberVO {

	public MemberVO(String name, String id, String email, String pw, String admin) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.admin = admin;
	}
	public MemberVO() {
		// TODO Auto-generated constructor stub
	}
	private String name;
	private String id;
	private String email;
	private String pw;
	private String admin;
	
	public void getMemberVO(String name, String id, String email, String pw, String admin) {
		this.name = name;
		this.id = id;
		this.email = email;
		this.pw = pw;
		this.admin = admin;
	}
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
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
}
