package com.zdr.sun.tools.qiniu;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.qiniu.util.Auth;

public class 下载文件_只能获取下载地址 {
    public static void main(String[] args) {
	String fileName = "FiJKRxrAzFW-2qxutNB2BnwiMWF8";
	String domainOfBucket = "http://ppzfru7zc.bkt.clouddn.com";
	String encodedFileName;
	try {
	    encodedFileName = URLEncoder.encode(fileName, "utf-8");

	    String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);

	    String accessKey = "fMe8jQAwkUnHZ7Qji2xf1_3mRda44LAk4UpiaSbT";
	    String secretKey = "g1FI8oiL_eCjpE116Drx9fSisMRYdrhRxtLEpdo1";
	    Auth auth = Auth.create(accessKey, secretKey);
	    long expireInSeconds = 36;// 1小时，可以自定义链接过期时间
	    String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);

	    System.out.println(finalUrl);

	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
