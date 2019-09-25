package com.zdr.sun.pojo.qiniuyun;

import java.util.Date;

public class qiniuyun {

    // 本地排序id
    public Integer id;
    // key值(唯一,可手动设置,当未手动设置时默认为hash值)
    public String key;
    // hash值(唯一)
    public String hash;

    // 文件名
    public String filename;
    // 后缀
    public String suffix;

    // 字节数
    public long fsize;
    // 类型
    public String mimeType;
    // 时间戳
    public long putTime;
    // 未知
    public String endUser;
    // 状态(1可用,0删除)
    public Integer type;
    // 系统时间
    public Date times;
    // 本地文件存储地址
    public String local;

    public String getFilename() {
	return filename;
    }

    public void setFilename(String filename) {
	this.filename = filename;
    }

    public String getSuffix() {
	return suffix;
    }

    public void setSuffix(String suffix) {
	this.suffix = suffix;
    }

    public String getLocal() {
	return local;
    }

    public void setLocal(String local) {
	this.local = local;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getKey() {
	return key;
    }

    public void setKey(String key) {
	this.key = key;
    }

    public String getHash() {
	return hash;
    }

    public void setHash(String hash) {
	this.hash = hash;
    }

    public long getFsize() {
	return fsize;
    }

    public void setFsize(long fsize) {
	this.fsize = fsize;
    }

    public String getMimeType() {
	return mimeType;
    }

    public void setMimeType(String mimeType) {
	this.mimeType = mimeType;
    }

    public long getPutTime() {
	return putTime;
    }

    public void setPutTime(long putTime) {
	this.putTime = putTime;
    }

    public String getEndUser() {
	return endUser;
    }

    public void setEndUser(String endUser) {
	this.endUser = endUser;
    }

    public Integer getType() {
	return type;
    }

    public void setType(Integer type) {
	this.type = type;
    }

    public Date getTimes() {
	return times;
    }

    public void setTimes(Date times) {
	this.times = times;
    }

}
