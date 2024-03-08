package com.wissen.springfinal.models;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Accounts {
	@Id
	private int cid;
	private String password;
	private long accountno;
	private String ifsc;
	private String type;
	private long mobile;
	private long amount;
	
	public Accounts() {
		super();
	}

	public Accounts(int cid, String password, long accountno, String ifsc, String type, long mobile, long amount) {
		super();
		this.cid = cid;
		this.password = password;
		this.accountno = accountno;
		this.ifsc = ifsc;
		this.type = type;
		this.mobile = mobile;
		this.amount = amount;
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

	public long getAccountno() {
		return accountno;
	}

	public void setAccountno(long accountno) {
		this.accountno = accountno;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Accounts [cid=" + cid + ", password=" + password + ", accountno=" + accountno + ", ifsc=" + ifsc
				+ ", type=" + type + ", mobile=" + mobile + ", amount=" + amount + "]";
	}
	
	
	
}
