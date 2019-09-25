package com.zdr.sun.pojo.MD5;

public class ZMD5 {

    public String pass;

    public String md5;
    public String md5salt;
    public String salt;
    public String hash;

    public String getMd5salt() {
	return md5salt;
    }

    public void setMd5salt(String md5salt) {
	this.md5salt = md5salt;
    }

    public String getPass() {
	return pass;
    }

    public void setPass(String pass) {
	this.pass = pass;
    }

    public String getHash() {
	return hash;
    }

    public void setHash(String hash) {
	this.hash = hash;
    }

    public String getMd5() {
	return md5;
    }

    public void setMd5(String md5) {
	this.md5 = md5;
    }

    public String getSalt() {
	return salt;
    }

    public void setSalt(String salt) {
	this.salt = salt;
    }

}
