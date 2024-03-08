package com.wissen.springfinal.models;

public class TransactionBody {
	private long fromAccno;
	private long toAccno;
	private String ifsc;
	public TransactionBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionBody(long fromAccno, long toAccno, String ifsc) {
		super();
		this.fromAccno = fromAccno;
		this.toAccno = toAccno;
		this.ifsc = ifsc;
	}
	
	public long getFromAccno() {
		return fromAccno;
	}
	public void setFromAccno(long fromAccno) {
		this.fromAccno = fromAccno;
	}
	public long getToAccno() {
		return toAccno;
	}
	public void setToAccno(long toAccno) {
		this.toAccno = toAccno;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	
}
