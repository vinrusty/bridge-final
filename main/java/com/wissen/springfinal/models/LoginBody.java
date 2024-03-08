package com.wissen.springfinal.models;

public class LoginBody {
	
	private int cid;
	private String password;
	public LoginBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoginBody(int cid, String password) {
		super();
		this.cid = cid;
		this.password = password;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "LoginBody [cid=" + cid + ", password=" + password + "]";
	}
	
}
