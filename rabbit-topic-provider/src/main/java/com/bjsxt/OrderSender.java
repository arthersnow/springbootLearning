package com.bjsxt;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {
	@Autowired
	private AmqpTemplate rabbitAmqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;

	public void send(String msg) {
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "order.log.debug", "order.log.debug............." + msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "order.log.info", "order.log.info............." + msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "order.log.warn", "order.log.warn............." + msg);
		this.rabbitAmqpTemplate.convertAndSend(this.exchange, "order.log.error", "order.log.error............." + msg);

	}
}
