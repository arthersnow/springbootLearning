package com.bjsxt;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 * 
 * @author Administrator
 *
 */
@Component
public class UserSender {

	@Autowired
	private AmqpTemplate rabbitamqAmqpTemplate;
	@Value("${mq.config.exchange}")
	private String exchange;

	public void send(String msg) {
		this.rabbitamqAmqpTemplate.convertAndSend(this.exchange, "user.log.debug", "user.log.debug......" + msg);
		this.rabbitamqAmqpTemplate.convertAndSend(this.exchange, "user.log.info", "user.log.info......" + msg);
		this.rabbitamqAmqpTemplate.convertAndSend(this.exchange, "user.log.warn", "user.log.warn......" + msg);
		this.rabbitamqAmqpTemplate.convertAndSend(this.exchange, "user.log.error", "user.log.error......" + msg);

	}

}
