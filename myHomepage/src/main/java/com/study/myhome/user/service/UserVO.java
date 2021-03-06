package com.study.myhome.user.service;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.ibatis.type.Alias;

import com.study.myhome.common.service.Pageable;

@Alias("UserVO")
public class UserVO extends Pageable {

	{
		joinDate = new Date();
	}

	// @Size(min = 4, max = 10)
	@NotNull
	private String username;

	@NotNull
	private String password;

	// 가입 날짜
	private Date joinDate;

	// 사용자 권한
	private UserAuthorityVO userAuthority;

	public UserVO(String username) {
		super();
		this.username = username;
	}

	public UserVO(String username, String password, UserAuthorityVO userAuthority) {
		super();
		this.username = username;
		this.password = password;
		this.userAuthority = userAuthority;
	}

	public UserAuthorityVO getUserAuthority() {
		return userAuthority;
	}

	public void setUserAuthority(UserAuthorityVO userAuthority) {
		this.userAuthority = userAuthority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public UserVO() {
		this.joinDate = new Date();
	}

	public UserVO(String username, String password) {
		this.username = username;
		this.password = password;
		this.joinDate = new Date();
	}

}
