package com.bjsxt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试代码
 * 
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootApplication.class)
public class QueueTest {

	@Autowired
	private UserSender userSender;
	@Autowired
	private ProductSender productSender;
	@Autowired
	private OrderSender orderSender;
	/**
	 * 测试消息队列
	 */
    @Test
    public void test1(){
    	userSender.send("userSender....");
    	productSender.send("productSender...");
    	orderSender.send("orderSender...");
    }
	public QueueTest() {
		// TODO Auto-generated constructor stub
	}

}
