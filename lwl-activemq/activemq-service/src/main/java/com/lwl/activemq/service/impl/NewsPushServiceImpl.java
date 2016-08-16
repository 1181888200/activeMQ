package com.lwl.activemq.service.impl;


import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lwl.activemq.domain.News;
import com.lwl.activemq.service.PushService;
@Service("newsPushService")
public class NewsPushServiceImpl implements PushService {

	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("newsServiceQueue")
	private Destination destination;
	
	@Override
	public void push(final Object info) {
		pushExecutor.execute(new Runnable() {
			@Override
			public void run() {
				jmsTemplate.send(destination, new MessageCreator() {
					public Message createMessage(Session session) throws JMSException {
						 News p = (News) info;
						return session.createTextMessage(JSON.toJSONString(p));
					}
				});
			}			
		});
	}

}
