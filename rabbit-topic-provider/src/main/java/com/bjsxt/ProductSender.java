package com.bjsxt;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductSender {
	@Autowired
	private AmqpTemplate rabbAmqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;
	public void send(String msg){
		this.rabbAmqpTemplate.convertAndSend(this.exchange,"product.log.debug","product.log.debug.........."+msg);
		this.rabbAmqpTemplate.convertAndSend(this.exchange,"product.log.info","product.log.info.........."+msg);
		this.rabbAmqpTemplate.convertAndSend(this.exchange,"product.log.warn","product.log.warn.........."+msg);
		this.rabbAmqpTemplate.convertAndSend(this.exchange,"product.log.error","product.log.error.........."+msg);
	}

}
