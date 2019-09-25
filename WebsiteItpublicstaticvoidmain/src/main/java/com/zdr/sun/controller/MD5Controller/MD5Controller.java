package com.zdr.sun.controller.MD5Controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdr.sun.controller.Login.LoginController;
import com.zdr.sun.pojo.MD5.ZMD5;
import com.zdr.sun.pojo.qiniuyun.qiniuyun;
import com.zdr.sun.tools.IPpool.AcquireIp;
import com.zdr.sun.tools.Kr36.principal;
import com.zdr.sun.tools.MD5.MD5;
import com.zdr.sun.tools.MD5.PasswordEncoder;
import com.zdr.sun.tools.Response.ResponseMessage;
import com.zdr.sun.tools.Response.Result;

@Controller
@RequestMapping("/7f138a09169b250e9dcb378140907378")
public class MD5Controller {
	private static final Logger logger = LogManager.getLogger(MD5Controller.class.getName());

//	@RequestMapping(value = "/cbcca017a6c415a919dacb1e05459e77")
//	public String jumMD5() {
//		return "tools/MD5/MD5";
//	}
//
//	/**
//	 * @Description MD5加方法
//	 * @param admin
//	 * @return
//	 */
//	@RequestMapping(value = "/8917cb5abfba22a861af3c21404b6ba7", method = { RequestMethod.POST, RequestMethod.GET })
//	@ResponseBody
//	public ResponseMessage<?> addAdmin(@RequestBody ZMD5 md5) {
//		logger.info(" MD5加密页"); // info级别的信息
//		// TODO Auto-generated method stub
//
//		try {
//			reflect(md5);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		if (md5.getPass() == null || md5.getPass().equals("")) {
//			logger.info(" 没有填写需要加密的数据"); // info级别的信息
//			return Result.error("没有填写需要加密的数据");
//		}
//
//		ZMD5 newmd5 = new ZMD5();
//		newmd5.setMd5(MD5.Encode(md5.getPass()));
//		if (md5.getSalt() != null && !md5.getSalt().equals("")) {
//			String md5salt = PasswordEncoder.saltMD5(md5.getSalt(), md5.getPass());
//			newmd5.setMd5salt(md5salt.toLowerCase());
//		} else {
//			logger.info("没有盐值"); // info级别的信息
//			newmd5.setMd5salt("没有盐值");
//		}
//
//		try {
//			reflect(newmd5);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		List<ZMD5> list = new ArrayList<>();
//		list.add(newmd5);
//
//		return Result.success(list);
//	}

//	public static void reflect(ZMD5 e) throws Exception {
//		Class cls = e.getClass();
//		Field[] fields = cls.getDeclaredFields();
//		for (int i = 0; i < fields.length; i++) {
//			Field f = fields[i];
//			f.setAccessible(true);
////			System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
//		}
//	}
}
