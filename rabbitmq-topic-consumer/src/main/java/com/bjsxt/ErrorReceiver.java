package com.bjsxt;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * 
 * @author Administrator
 * @RabbitListener bindings:绑定队列
 * @QueueBinding value:绑定队列的名称 exchange:配置交换器
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.error}", autoDelete = "true") , exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.TOPIC) , key = "*.log.error") )
public class ErrorReceiver {
	/**
	 * 消息接受的方法，采用消息队列监听机制
	 */
	@RabbitHandler
	public void process(String msg) {
		System.out.println("....Error...receiver:" + msg);
	}
}
