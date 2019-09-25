package com.zdr.sun.tools.qiniu;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;
import com.zdr.sun.pojo.qiniuyun.qiniuyun;

public class up {
    private String accessKey = "fMe8jQAwkUnHZ7Qji2xf1_3mRda44LAk4UpiaSbT";
    private String secretKey = "g1FI8oiL_eCjpE116Drx9fSisMRYdrhRxtLEpdo1";
    private String bucket = "ad66c2ec04ba37b9de37e6341e7d3fc6";

    public static void main(String[] args) {
	up up = new up();

	qiniuyun niu = new qiniuyun();

	niu = up.Upload("E:\\七牛云测试文件\\asdsada.txt");

	try {
	    up.reflect(niu);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    public static void reflect(qiniuyun e) throws Exception {
	Class cls = e.getClass();
	Field[] fields = cls.getDeclaredFields();
	for (int i = 0; i < fields.length; i++) {
	    Field f = fields[i];
	    f.setAccessible(true);
	    System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
	}
    }

    public qiniuyun Upload(String Local) {

	qiniuyun niu = new qiniuyun();
	niu.setLocal(Local);
	// 构造一个带指定Zone对象的配置类
	Configuration cfg = new Configuration(Zone.zone1());
	// ...其他参数参考类注释
	UploadManager uploadManager = new UploadManager(cfg);
	// ...生成上传凭证，然后准备上传

	// 如果是Windows情况下，格式是 D:\\qiniu\\test.png
	String localFilePath = Local;

	String filename = localFilePath.substring(localFilePath.lastIndexOf("\\") + 1);

	// 获取后缀
	String suffix = "";
	int endIndex = filename.indexOf(".");
	if (endIndex > 0) {
	    suffix = filename.substring(endIndex + 1);
	} else {
	    System.out.println("无后缀,后缀则为空");
	    suffix = "null";
	}

	niu.setSuffix(suffix);
	niu.setFilename(filename);

	// 默认不指定key的情况下，以文件内容的hash值作为文件名
	String key = null;

	Auth auth = Auth.create(accessKey, secretKey);
	String upToken = auth.uploadToken(bucket);

	try {
	    Response response = uploadManager.put(localFilePath, key, upToken);
	    // 解析上传成功的结果
	    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
	    // System.out.println("文件的名字:" + putRet.key);
	    // System.out.println("文件的hash值:" + putRet.hash);

	    List<Object> list = new ArrayList<>();

	    list = dangewenjian(putRet.key);

	    niu.setHash(list.get(0) + "");
	    niu.setFsize((Long) list.get(1));
	    niu.setMimeType(list.get(2) + "");
	    niu.setPutTime((Long) list.get(3));
	    niu.setKey(putRet.key);
	    niu.setHash(putRet.hash);
	    niu.setType(1);
	    niu.setTimes(new Date());

	} catch (QiniuException ex) {
	    Response r = ex.response;
	    System.err.println(r.toString());
	    try {
		System.err.println(r.bodyString());
		System.out.println("七牛云上传文件出错");
	    } catch (QiniuException ex2) {
		// ignore
	    }

	    return null;
	}

	return niu;

    }

    /**
     * 获取key文件的信息
     * 
     * @param keys
     * @return
     */
    public List<Object> dangewenjian(String keys) {

	List<Object> list = new ArrayList<>();

	Configuration cfg = new Configuration(Zone.zone1());

	Auth auth = Auth.create(accessKey, secretKey);
	BucketManager bucketManager = new BucketManager(auth, cfg);
	try {
	    FileInfo fileInfo = bucketManager.stat(bucket, keys);
	    // System.out.println(fileInfo.hash);
	    // System.out.println(fileInfo.fsize);
	    // System.out.println(fileInfo.mimeType);
	    // System.out.println(fileInfo.putTime);

	    list.add(fileInfo.hash);
	    list.add(fileInfo.fsize);
	    list.add(fileInfo.mimeType);
	    list.add(fileInfo.putTime);

	} catch (QiniuException ex) {
	    System.err.println(ex.response.toString());
	}
	return list;
    }
}
