package com.bjsxt;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.logs}", autoDelete = "true") , exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.TOPIC) , key = "*.log.*") )
public class LogsReceiver {
	/**
	 * 接受消息的方法，采用消息队列监听机制
	 */
	@RabbitHandler
	public void process(String msg) {
		System.out.println("...ALL...receiver:" + msg);
	}
}
