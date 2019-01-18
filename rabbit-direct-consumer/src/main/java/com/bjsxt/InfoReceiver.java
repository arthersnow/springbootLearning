package com.bjsxt;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接受者和
 * 
 * @RabbitListener bindings:绑定队列
 * @QueueBinding value:绑定队列的名称 exchange:配置交换器
 * @Queue value：队列名称 autoDelete:是否是一个可删除的临时队列
 * @Exchange value:为了交换器的名称 type:指定具体的交换器类型
 * @author Administrator
 *
 */
@Component
@RabbitListener(bindings = @QueueBinding(value = @Queue(value = "${mq.config.queue.info}", autoDelete = "true") , exchange = @Exchange(value = "${mq.config.exchange}", type = ExchangeTypes.DIRECT) , key = "${mq.config.queue.info.routing.key}") )
public class InfoReceiver {
	/**
	 * 接受消息，采用监听机制，消息队列监听机制
	 */
	@RabbitHandler
	public void process(String msg) {
		System.out.println("Info.....receiver:" + msg);
	}
}
