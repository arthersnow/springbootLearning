package com.bjsxt;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 消息创建队列
 * @author Administrator
 *
 */
@Configuration
public class QueueConfig {

	@Bean
	public Queue createQueue() {
		//要注意Queue的类型，及其实现
		return new Queue("hello-queue");
	}
}
