package com.mqTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bjsxt.Sender;
import com.bjsxt.SpringbootServerApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootServerApplication.class)
public class RabbitQueueTest {

	@Autowired
	private Sender sender;

	/**
	 * 测试消息队列
	 */
	@Test
	public void test01() {
		this.sender.send("hello rabbitmq");
	}
}
