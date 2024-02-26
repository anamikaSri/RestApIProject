package com.springrest.springrest.entity;

public class course {
  
	

	private long id;
	
	private String titleString;
	
	private String descripString;
	

//	constructor

	public course(long id, String titleString, String descripString) {
		super();
		this.id = id;
		this.titleString = titleString;
		this.descripString = descripString;
	}

	public course() {
		super();
		// TODO Auto-generated constructor stub
	}

//	getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitleString() {
		return titleString;
	}

	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}

	public String getDescripString() {
		return descripString;
	}

	public void setDescripString(String descripString) {
		this.descripString = descripString;
	}
	
	@Override
	public String toString() {
		return "course [id=" + id + ", titleString=" + titleString + ", descripString=" + descripString + "]";
	}
	
}
