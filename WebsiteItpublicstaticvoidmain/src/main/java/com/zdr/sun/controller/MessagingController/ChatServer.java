package com.zdr.sun.controller.MessagingController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.zdr.sun.pojo.Zuser.Zuser;

import com.zdr.sun.tools.Session.GetHttpSessionConfigurator;
import com.zdr.sun.tools.Session.lajisession;

import net.sf.json.JSONObject;

@ServerEndpoint(value = "/websocket", configurator = GetHttpSessionConfigurator.class)
public class ChatServer {
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Vector<Session> room = new Vector<Session>();

    private static int onlineCount = 0;
    // concurrent包的线程安全Set，用来存放每个客户端对应的webSocketSet对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static CopyOnWriteArraySet<ChatServer> webSocketSet = new CopyOnWriteArraySet<ChatServer>();
    // 一个会话可能造成
    private static Map<String, HttpSession> socketNumb = new ConcurrentHashMap<String, HttpSession>();
    // 与某个客户端的连接会话，需要通过它来给客户端发送数据

    private Session session;

    // 会话
    private HttpSession httpSession;

    /**
     * 连接建立成功调用的方法
     * 
     * @param session
     *                    可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
	this.session = session;
	this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());

	webSocketSet.add(this); // 加入set中
	addOnlineCount(); // 连接数+1
	System.out.println("有新连接加入！当前连接数为：" + getOnlineCount());
	socketNumb.put(session.getId(), httpSession);
    }

    /**
     * 收到客户端消息后调用的方法
     * 
     * @param message
     *                    客户端发送过来的消息
     * @param session
     *                    可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) {

	System.out.println("字符串:" + message);

	Map<String, String> map = session.getPathParameters();
	String userId = map.get("userId");

	System.out.println("userId:" + userId);

	HttpServletRequest request = lajisession.getRequest();

	// Zuser zuser = new Zuser();
	// try {
	// zuser = (Zuser) session.getAttribute("2aa83c25b2550a178ce8cae7342dd975");
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// String username = zuser.getZusername();
	//
	// System.out.println("username:" + username);

	// 把用户发来的消息解析为JSON对象

	JSONObject obj = JSONObject.fromObject(message);
	System.out.println("json中的信息:" + obj);
	// 向JSON对象中添加发送时间
	// obj.put("nickname", username);
	obj.put("date", df.format(new Date()));
	// 遍历聊天室中的所有会话

	int num = 0;
	for (Session se : room) {
	    num++;

	}
	System.out.println("当前在线人数" + num);

	obj.put("num", num);
	for (Session se : room) {
	    // 设置消息是否为自己的
	    obj.put("isSelf", se.equals(session));
	    // 发送消息给远程用户
	    se.getAsyncRemote().sendText(obj.toString());
	}
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
	webSocketSet.remove(this); // 从set中删除
	subOnlineCount(); // 在线数减1
	System.out.println("有一连接关闭！当前连接数为：" + getOnlineCount());
    }

    /**
     * 发生错误时调用
     * 
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
	System.out.println("发生错误");
	error.printStackTrace();
    }

    public static synchronized int getOnlineCount() {
	return onlineCount;
    }

    public static synchronized void addOnlineCount() {
	onlineCount = ChatServer.getOnlineCount();
	onlineCount++;
    }

    public static synchronized void subOnlineCount() {
	onlineCount = ChatServer.getOnlineCount();
	onlineCount--;
    }

}