package com.zdr.sun.tools.qiniu;

import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.zdr.sun.pojo.qiniuyun.qiniuyun;

public class 上传 {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

	System.out.println(new Date());

	Scanner input = new Scanner(System.in);
	// 构造一个带指定Zone对象的配置类
	Configuration cfg = new Configuration(Zone.zone2());
	// ...其他参数参考类注释
	UploadManager uploadManager = new UploadManager(cfg);
	// ...生成上传凭证，然后准备上传
	String accessKey = "fMe8jQAwkUnHZ7Qji2xf1_3mRda44LAk4UpiaSbT";
	String secretKey = "g1FI8oiL_eCjpE116Drx9fSisMRYdrhRxtLEpdo1";
	String bucket = "ad66c2ec04ba37b9de37e6341e7d3fc6";
	// 如果是Windows情况下，格式是 D:\\qiniu\\test.png
	// String localFilePath = "E:\\七牛云测试文件\\ssssss.txt";
	String localFilePath = input.next();
	// 默认不指定key的情况下，以文件内容的hash值作为文件名
	String key = null;
	Auth auth = Auth.create(accessKey, secretKey);
	String upToken = auth.uploadToken(bucket);

	try {
	    Response response = uploadManager.put(localFilePath, key, upToken);
	    // 解析上传成功的结果
	    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
	    System.out.println("文件的名字:" + putRet.key);
	    System.out.println("文件的hash值:" + putRet.hash);
	} catch (QiniuException ex) {
	    Response r = ex.response;
	    System.err.println(r.toString());
	    try {
		System.err.println(r.bodyString());
	    } catch (QiniuException ex2) {
		// ignore
	    }
	}

    }

    private String accessKey = "fMe8jQAwkUnHZ7Qji2xf1_3mRda44LAk4UpiaSbT";
    private String secretKey = "g1FI8oiL_eCjpE116Drx9fSisMRYdrhRxtLEpdo1";
    private String bucket = "ad66c2ec04ba37b9de37e6341e7d3fc6";

    public qiniuyun Upload(String fileid) {
	qiniuyun niu = new qiniuyun();

	// 构造一个带指定Zone对象的配置类
	Configuration cfg = new Configuration(Zone.zone1());
	// ...其他参数参考类注释
	UploadManager uploadManager = new UploadManager(cfg);
	// ...生成上传凭证，然后准备上传
	String localFilePath = fileid;
	// 默认不指定key的情况下，以文件内容的hash值作为文件名
	String key = null;
	Auth auth = Auth.create(accessKey, secretKey);
	String upToken = auth.uploadToken(bucket);

	try {
	    Response response = uploadManager.put(localFilePath, key, upToken);
	    // 解析上传成功的结果
	    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
	    System.out.println("文件的名字:" + putRet.key);
	    System.out.println("文件的hash值:" + putRet.hash);
	    niu.setKey(putRet.key);
	    niu.setHash(putRet.hash);
	} catch (QiniuException ex) {
	    Response r = ex.response;
	    System.err.println(r.toString());
	    try {
		System.out.println(new Date());
		System.err.println(r.bodyString());
		System.out.println("七牛云上传文件出错");
	    } catch (QiniuException ex2) {
		// ignore
	    }
	    return null;
	}
	System.out.println("已完成上传操作");
	return niu;

    }

}
