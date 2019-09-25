package com.zdr.sun.controller.ButtonEnter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zdr.sun.dao.Cardetails.CardDao;
import com.zdr.sun.pojo.Kr36.news24th;
import com.zdr.sun.pojo.MD5.ZMD5;
import com.zdr.sun.pojo.cangku.Cangkupan;
import com.zdr.sun.service.cangku.CangkuService;
import com.zdr.sun.tools.Cardetails.Cardetails;
import com.zdr.sun.tools.EmalPop3.EmailType;
import com.zdr.sun.tools.IPpool.AcquireIp;
import com.zdr.sun.tools.Kr36.principal;
import com.zdr.sun.tools.MD5.MD5;
import com.zdr.sun.tools.MD5.PasswordEncoder;
import com.zdr.sun.tools.Response.ResponseMessage;
import com.zdr.sun.tools.Response.Result;

@Controller
@RequestMapping("/ButtonEnter")
public class ButtonEnter {

	// 重定向 redirect:

	private static final Logger logger = LogManager.getLogger(ButtonEnter.class.getName());

	/**
	 * 测试按钮页
	 * 
	 * @param response
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/Buttons", method = { RequestMethod.POST, RequestMethod.GET })
	public String yemian(HttpServletResponse response, HttpServletRequest request) {
		logger.info("测试按钮页"); // info级别的信息
		return "tools/ButtonEnter/ButtonEnter";
	}

	////////////////////////////////////////////////// 获取匿名IP方式 /
	////////////////////////////////////////////////// ////////////////////////////////////////////////////////
	AcquireIp AcquireIp = new AcquireIp();

	// 获取国内ip
	@RequestMapping(value = "/factorsippool")
	public String factorsippool() {
		logger.info(" IP--获取国内ip"); // info级别的信息
		AcquireIp.ChinaIPs();
		return null;
	}

	// 测试国内ip
	@RequestMapping(value = "/DebuggingIfippool")
	public String DebuggingIfippool() {
		logger.info(" IP--测试国内ip"); // info级别的信息
		AcquireIp.testchinaips();
		return null;
	}

	// 测试国内可用ip
	@RequestMapping(value = "/fromalchinaips")
	public String fromalchinaips() {
		logger.info(" IP--测试国内可用ip"); // info级别的信息
		AcquireIp.fromalchinaips();
		return null;
	}

//////////////////////////////////////////////////整理仓库	////////////////////////////////////////////////////////

	@Autowired
	private CangkuService cangkuService;

	/**
	 * 获取链接方式,并进行展示
	 * 
	 * @param response
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/9938fba0d33f9e1f62dc082fae371a68/{type}", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String user(HttpServletResponse response, HttpServletRequest request, @PathVariable String type) {

		//获取所有类型
		List<String> TypeList = cangkuService.Alltype();
		for (int i = 0; i < 5; i++) {
			request.setAttribute("alltype" + (i + 1), TypeList.get(i));
		}
		try {
			List<Cangkupan> list = new ArrayList<Cangkupan>();
			
			//没有类型自动为第一条
			if (type.equals("null") || type == null) {
				list = cangkuService.seleminid(TypeList.get(0));// 获取id
			}else {
				list = cangkuService.seleminid(type);// 获取id
			}
			logger.info(" 仓库" + " id:" + list.get(0).getNewid()); // info级别的信息
			request.setAttribute("id", list.get(0).getNewid());
			request.setAttribute("pan", list.get(0).getPan());
			request.setAttribute("tiqu", list.get(0).getTiqu());
			request.setAttribute("mima", list.get(0).getMima() + "_");
			if (list.get(0).getMima().equals("") || list.get(0).getMima() != null) {
				request.setAttribute("newmima", "密码");
			}
			System.out.println("id:" + list.get(0).getNewid() + "\n" + "pan:" + list.get(0).getPan() + "\n" + "提取码:"
					+ list.get(0).getTiqu() + "\n" + "密码:" + list.get(0).getMima() + "\n" + "类型:"
					+ list.get(0).getType() + "\n" + "时间:" + list.get(0).getTime());
			request.setAttribute("type", list.get(0).getType());
			request.setAttribute("time", list.get(0).getTime() + " ");
			String ssString = list.get(0).getNewid();
			cangkuService.updateminid(ssString);// 逻辑删除
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "tools/cangku/pan";
	}
	
	
	
	
	/**
	 * 获取链接方式,并进行展示
	 * 
	 * @param response
	 * @param request
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/TypeList", method = { RequestMethod.POST,
			RequestMethod.GET })
	public Object TypeList(HttpServletResponse response, HttpServletRequest request,ModelAndView model) {
		System.out.println("集合");
		List<String> TypeList = cangkuService.Alltype();
		
		String listtype = "";
		for(int  i  = 0 ; i <TypeList.size() ; i++) {
			listtype+=TypeList.get(i)+",";
		}
		
		model.addObject("listnum", TypeList.size());
		model.addObject("TypeList", listtype);
		model.setViewName("tools/cangku/Changku");
		return model;
	}
	
	
	
	
	

//////////////////////////////////////////////////邮件功能	////////////////////////////////////////////////////////

	private EmailType EmailType;// 邮件方法

	@RequestMapping(value = "/C91F20D06AFF773E5A6F97E2077C1FB9", method = { RequestMethod.POST, RequestMethod.GET })
	public String MBeanServerOne(HttpServletResponse response, HttpServletRequest request) {
		logger.info("一号邮件按钮"); // info级别的信息
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("EtoMailAddress", "10554214@qq.com");
		map.put("Etitle", "一号服务器出现状况");
		map.put("Etext", "具体状况为:");
		EmailType = new EmailType();
		EmailType.Custom(map);
		return "redirect:/ButtonEnter/Buttons";
	}

	@RequestMapping(value = "/A4B38AA025B0B7E3B28E3C8C64E4C8A7", method = { RequestMethod.POST, RequestMethod.GET })
	public String MBeanServerThree(HttpServletResponse response, HttpServletRequest request) {
		logger.info(" 点击三号服务器按钮...准备发送状况报告"); // info级别的信息
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("EtoMailAddress", "10554214@qq.com");
		map.put("Etitle", "三号服务器出现状况");
		map.put("Etext", "具体状况为:");
		EmailType = new EmailType();
		EmailType.Custom(map);
		return "redirect:/ButtonEnter/Buttons";
	}

//////////////////////////////////////////////////MD5	////////////////////////////////////////////////////////

	/**
	 * 跳转页
	 * 
	 * @return
	 */
	@RequestMapping(value = "/cbcca017a6c415a919dacb1e05459e77")
	public String jumMD5() {
		return "tools/MD5/MD5";
	}

	/**
	 * @Description MD5加方法
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "/8917cb5abfba22a861af3c21404b6ba7", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public ResponseMessage<?> addAdmin(@RequestBody ZMD5 md5) {
		logger.info(" MD5加密页"); // info级别的信息
		// TODO Auto-generated method stub
		try {
			Class cls = md5.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				f.setAccessible(true);
//				System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (md5.getPass() == null || md5.getPass().equals("")) {
			logger.info(" 没有填写需要加密的数据"); // info级别的信息
			return Result.error("没有填写需要加密的数据");
		}
		ZMD5 newmd5 = new ZMD5();
		newmd5.setMd5(MD5.Encode(md5.getPass()));
		if (md5.getSalt() != null && !md5.getSalt().equals("")) {
			String md5salt = PasswordEncoder.saltMD5(md5.getSalt(), md5.getPass());
			newmd5.setMd5salt(md5salt.toLowerCase());
		} else {
			logger.info("没有盐值"); // info级别的信息
			newmd5.setMd5salt("没有盐值");
		}
		try {
			Class cls = newmd5.getClass();
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				Field f = fields[i];
				f.setAccessible(true);
//				System.out.println("属性名:" + f.getName() + " 属性值:" + f.get(e));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<ZMD5> list = new ArrayList<>();
		list.add(newmd5);
		return Result.success(list);
	}

//////////////////////////////////////////////////36kr////////////////////////////////////////////////////////

	news24th news24th = new news24th();
	CardDao CardDao = new CardDao();

	/**
	 * 36kr(最新爬虫框架)测试
	 */
	@RequestMapping(value = "/Butt36kr")
	public void Butt36kr() {
		int NewsCount = 0;
		principal test = new principal();
		List<news24th> list = new ArrayList<>();
		Cardetails Cardetails = new Cardetails();
		// 开始

		System.out.println("获取xml文件长度:" + CardDao.TypeSqlCAR("36kr").length());
		Map<String, Object> MapObj1 = Cardetails.ZPusots(CardDao.TypeSqlCAR("36kr"), null);

		// 使用返回的map 从map中筛选出来数据
		for (int i = 0; true; i++) {
			if (MapObj1.containsKey("36krid" + i)) {
				news24th = new news24th(MapObj1.get("id" + i).toString(), MapObj1.get("title" + i).toString(),
						MapObj1.get("neirong" + i).toString(), MapObj1.get("url" + i).toString(),
						MapObj1.get("time" + i).toString());

				System.out.println(MapObj1.get("id" + i).toString() + "	" + MapObj1.get("title" + i).toString() + "	"
						+ MapObj1.get("neirong" + i).toString() + "	" + MapObj1.get("url" + i).toString() + "	"
						+ MapObj1.get("time" + i).toString());
				NewsCount++;
				list.add(news24th);
			} else {
				break;
			}
		}
		news24th.setListnews(list);
		news24th.setNewsCount(NewsCount);
		//
		System.out.println(222 + " " + news24th.getNewsCount());
		// 数量以及
//		try {
//			EmailType.Kr36Email(news24th.getNewsCount(), news24th.getListnews());
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
