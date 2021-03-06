package com.study.myhome.board.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import com.study.myhome.common.service.Pageable;

import egovframework.com.cmm.service.FileVO;

@Alias("BoardVO")
public class BoardVO extends Pageable {
	private Long idx;

	private String title;

	private String content;

	private int view_cnt = 0;

	private String use_yn = "Y";

	private String atch_file_id;

	private String username;
	
	private Date regdate;
	
	private List<FileVO> files;
	
	{
		regdate = new Date();
	}
	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Long getIdx() {
		return idx;
	}

	public BoardVO() {

	}

	public BoardVO(String title, String content, String atchFileId) {
		super();
		this.title = title;
		this.content = content;
		this.atch_file_id = atchFileId;
	}

	public BoardVO(Long idx, String title, String content, String atchFileId) {
		super();
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.atch_file_id = atchFileId;
	}

	public void setIdx(Long idx) {
		this.idx = idx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getView_cnt() {
		return view_cnt;
	}

	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getAtch_file_id() {
		return atch_file_id;
	}

	public void setAtch_file_id(String atch_file_id) {
		this.atch_file_id = atch_file_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAtch_file_id(List<FileVO> files) {
		if(files != null) {
			this.atch_file_id = files.get(0).getAtch_file_id();
		}
	}

	public List<FileVO> getFiles() {
		return files;
	}

	public void setFiles(List<FileVO> files) {
		this.files = files;
	}
	
}
