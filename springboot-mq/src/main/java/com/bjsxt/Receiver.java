package com.bjsxt;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接受者
 * 
 * @author Administrator
 *
 */
@Component
public class Receiver {
	/**
	 * 接受消息，採用消息队列监听机制
	 */
	@RabbitListener(queues = "hello-queue")
	public void process(String msg) {
		System.out.println("receiver:" + msg);
	}
}
