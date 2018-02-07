package com.fasthink.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("guest");
		factory.setPassword("guest");
		//设置 RabbitMQ 地址
		factory.setHost("localhost");
		//建立到代理服务器到连接
		Connection conn = factory.newConnection();
		//获得信道
		Channel channel = conn.createChannel();
		//声明交换器
		String exchangeName = "hello-exchange";
		channel.exchangeDeclare(exchangeName, "direct", true);

		String routingKey = "hola";
		//发布消息
		byte[] messageBodyBytes = "quit".getBytes();
		channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
		channel.close();
		conn.close();
	}

	@Test
	public void publish() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setUsername("guest");
		factory.setPassword("guest");
		//设置 RabbitMQ 地址
		factory.setHost("localhost");
		//建立到代理服务器到连接
		Connection conn = factory.newConnection();
		//获得信道
		Channel channel = conn.createChannel();
		//声明交换器
		String exchangeName = "hello-exchange";
		channel.exchangeDeclare(exchangeName, "direct", true);

		String routingKey = "hola";
		//发布消息
		byte[] messageBodyBytes = "quit".getBytes();
		channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
		channel.close();
		conn.close();
	}

}
