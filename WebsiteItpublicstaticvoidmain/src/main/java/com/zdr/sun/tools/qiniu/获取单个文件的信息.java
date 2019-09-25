package com.zdr.sun.tools.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

public class 获取单个文件的信息 {
    public static void main(String[] args) {
	// 构造一个带指定Zone对象的配置类
	Configuration cfg = new Configuration(Zone.zone0());
	// ...其他参数参考类注释

	String accessKey = "fMe8jQAwkUnHZ7Qji2xf1_3mRda44LAk4UpiaSbT";
	String secretKey = "g1FI8oiL_eCjpE116Drx9fSisMRYdrhRxtLEpdo1";
	String bucket = "ad66c2ec04ba37b9de37e6341e7d3fc6";
	String key = "2222";

	Auth auth = Auth.create(accessKey, secretKey);
	BucketManager bucketManager = new BucketManager(auth, cfg);
	try {
	    FileInfo fileInfo = bucketManager.stat(bucket, key);
	    System.out.println(fileInfo.hash);
	    System.out.println(fileInfo.fsize);
	    System.out.println(fileInfo.mimeType);
	    System.out.println(fileInfo.putTime);
	} catch (QiniuException ex) {
	    System.err.println(ex.response.toString());
	}

    }
}
