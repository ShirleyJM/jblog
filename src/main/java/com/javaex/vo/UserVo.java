package com.javaex.vo;

public class UserVo {
	private String id;
	private int userNo;
	private String userName;
	private String password;
	private String joinDate;
	
	
	

	public UserVo() {
	
	}


	public UserVo(String id, String userName, String password) {
		
		this.id = id;
		this.userName = userName;
		this.password = password;
	}


	public UserVo(String id, int userNo, String userName, String password, String joinDate) {
		super();
		this.id = id;
		this.userNo = userNo;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}




	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
