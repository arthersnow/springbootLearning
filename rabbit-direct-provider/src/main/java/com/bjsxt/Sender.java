package com.bjsxt;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息提供者
 * 
 * @author Administrator
 *
 */
@Component
public class Sender {
	@Autowired
	private AmqpTemplate rabbitmqTemplate;
	// exchange交换器的名称
	@Value("${mq.config.exchange}")
	private String exchange;
	@Value("${mq.config.queue.error.routing.key}")
	private String routingkey;

	/**
	 * 发送消息
	 */
	public void send(String msg) {
		this.rabbitmqTemplate.convertAndSend(this.exchange, this.routingkey, msg);
		;
	}

}
