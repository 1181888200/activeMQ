package com.lwl.activemq.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lwl.activemq.domain.News;
import com.lwl.activemq.controller.websocket.WebsocketController;

@Component("newsPushListener")
public class NewsPushListener implements MessageListener {
	 protected static final Logger logger = Logger.getLogger(NewsPushListener.class);
	@Override
	public void onMessage(Message message) {
		 logger.info("[NewsPushListener.onMessage]:begin onMessage.");
	        TextMessage textMessage = (TextMessage) message;
	        try {
	            String jsonStr = textMessage.getText();
	            logger.info("[NewsPushListener.onMessage]:receive message is,"+ jsonStr);
	            if (jsonStr != null) {
	            	News info = JSON.parseObject(jsonStr, News.class);
	                System.out.println("==============================接受到的新闻信息 开始====================================");
	                System.out.println(info.toString());
	                System.out.println("==============================接受到的新闻信息 结束====================================");
	                WebsocketController.broadcast("news", jsonStr);
	            }
	        } catch (JMSException e) {
	            logger.error("[NewsPushListener.onMessage]:receive message occured an exception",e);
	        }
	        logger.info("[NewsPushListener.onMessage]:end onMessage.");
	    }
}

