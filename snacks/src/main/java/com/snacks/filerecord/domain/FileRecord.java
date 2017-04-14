package com.snacks.filerecord.domain;


import com.snacks.common.domain.CommonDomain;

/**
 * Created by xuwushun on 2016/11/3.
 */
public class FileRecord extends CommonDomain {
	public static final Byte FILE_TYPE_IMAGE = 0;
	private String fileName;
	private String url;
	private Byte fileType;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Byte getFileType() {
		return fileType;
	}

	public void setFileType(Byte fileType) {
		this.fileType = fileType;
	}
}
