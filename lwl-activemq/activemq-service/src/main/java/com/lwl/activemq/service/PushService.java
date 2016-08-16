package com.lwl.activemq.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 推送的接口
 * @author Administrator
 * @create 2016-8-10 下午3:41:03
 * @version 1.0
 */
public interface PushService {

	public final ExecutorService pushExecutor = Executors.newFixedThreadPool(10);
	
	public void push(Object info);
	
}
