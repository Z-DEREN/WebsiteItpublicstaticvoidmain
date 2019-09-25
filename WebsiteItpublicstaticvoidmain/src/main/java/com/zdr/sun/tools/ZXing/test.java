package com.zdr.sun.tools.ZXing;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class test {
    /**
     * 测试二维码生成方法
     * 
     * @param args
     */
    public static void main(String[] args) {
	try {
	    // 二维码内容
	    String content = "Hello rdujstyHFYGLULKJGFEDSWTYAGDFIUHTHRFDsgn!";
	    // 二维码生成路径
	    String path = "E:\\image\\二维码";
	    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
	    Map hints = new HashMap();
	    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	    BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
	    File file1 = new File(path, "test.jpg");
	    ImageWrite.writeToFile(bitMatrix, "jpg", file1);
	    System.out.println("二维码已生成！");
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (WriterException e) {
	    e.printStackTrace();
	}
    }
}
