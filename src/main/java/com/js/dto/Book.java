package com.js.dto;

public class Book {
	private int Bid;
	private String Bname;
	private String Bauthor;
	private int Bpage;
	private Double Bpricel;
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getBauthor() {
		return Bauthor;
	}
	public void setBauthor(String bauthor) {
		Bauthor = bauthor;
	}
	public int getBpage() {
		return Bpage;
	}
	public void setBpage(int bpage) {
		Bpage = bpage;
	}
	public Double getBpricel() {
		return Bpricel;
	}
	public void setBpricel(Double bpricel) {
		Bpricel = bpricel;
	}
	@Override
	public String toString() {
		return "Book [Bid=" + Bid + ", Bname=" + Bname + ", Bauthor=" + Bauthor + ", Bpage=" + Bpage + ", Bpricel="
				+ Bpricel + "]";
	}
	
}
	