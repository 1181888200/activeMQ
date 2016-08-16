package com.lwl.activemq.controller.websocket;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 功能说明：websocket处理类, 使用J2EE7的标准
 * @author Administrator
 * @create 2016-8-11 下午4:08:35
 * @version 1.0
 */
@ServerEndpoint("/websocket/{myWebsocket}")
public class WebsocketController {
	private static final Logger logger = LoggerFactory.getLogger(WebsocketController.class);

    public static Map<String, Session> clients = new ConcurrentHashMap<String, Session>();

    /**
     * 打开连接时触发
     * @param myWebsocket
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("myWebsocket") String myWebsocket, Session session){
        logger.info("Websocket Start Connecting:" + myWebsocket);
        System.out.println("进入："+myWebsocket);
        clients.put(myWebsocket, session);
    }

    /**
     * 收到客户端消息时触发
     * @param myWebsocket
     * @param message
     * @return
     */
    @OnMessage
    public String onMessage(@PathParam("myWebsocket") String myWebsocket, String message) {
        return "Got your message ("+ message +").Thanks !";
    }

    /**
     * 异常时触发
     * @param myWebsocket
     * @param throwable
     */
    @OnError
    public void onError(@PathParam("myWebsocket") String myWebsocket, Throwable throwable) {
        logger.info("Websocket Connection Exception:" + myWebsocket);
        logger.info(throwable.getMessage(), throwable);
        clients.remove(myWebsocket);
    }

    /**
     * 关闭连接时触发
     * @param myWebsocket
     */
    @OnClose
    public void onClose(@PathParam("myWebsocket") String myWebsocket) {
        logger.info("Websocket Close Connection:" + myWebsocket);
        clients.remove(myWebsocket);
    }


    /**
     * 将数据传回客户端
     * 异步的方式
     * @param myWebsocket
     * @param message
     */
    public static void broadcast(String myWebsocket, String message) {
        if (clients.containsKey(myWebsocket)) {
            clients.get(myWebsocket).getAsyncRemote().sendText(message);
        } else {
            throw new NullPointerException("[" + myWebsocket +"]Connection does not exist");
        }
    }

}
