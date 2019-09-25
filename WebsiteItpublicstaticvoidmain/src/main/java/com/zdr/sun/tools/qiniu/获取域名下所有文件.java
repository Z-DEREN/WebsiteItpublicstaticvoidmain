package com.zdr.sun.tools.qiniu;

import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;

public class 获取域名下所有文件 {

    public static void main(String[] args) {
	// 构造一个带指定Zone对象的配置类
	Configuration cfg = new Configuration(Zone.zone0());
	// ...其他参数参考类注释

	String accessKey = "fMe8jQAwkUnHZ7Qji2xf1_3mRda44LAk4UpiaSbT";
	String secretKey = "g1FI8oiL_eCjpE116Drx9fSisMRYdrhRxtLEpdo1";
	String bucket = "ad66c2ec04ba37b9de37e6341e7d3fc6";

	Auth auth = Auth.create(accessKey, secretKey);
	BucketManager bucketManager = new BucketManager(auth, cfg);

	// 文件名前缀
	String prefix = "";
	// 每次迭代的长度限制，最大1000，推荐值 1000
	int limit = 1000;
	// 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
	String delimiter = "";

	// 列举空间文件列表
	BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit,
		delimiter);
	while (fileListIterator.hasNext()) {
	    // 处理获取的file list结果
	    FileInfo[] items = fileListIterator.next();
	    for (FileInfo item : items) {
		System.out.println(item.key);
		System.out.println(item.hash);
		System.out.println(item.fsize);
		System.out.println(item.mimeType);
		System.out.println(item.putTime);
		System.out.println(item.endUser);
		System.out.println();
	    }
	}

    }

}
