package com.techprimers.messaging.standaloneactivemqexample.config;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MyMsgBeans {

	@Value("${activemq.broker-url}")
	private String brokerUrl;
	
	@Bean
	public Queue VikasQueue() {
		return new ActiveMQQueue("VikasQueue");
	}

	@Bean
	public Queue KiaanQueue() {
		return new ActiveMQQueue("KiaanQueue");
	}

	
	public Queue OtherQueue(String queueName) {
		Queue q;
		switch(queueName) {
		case "KiaanQueue":
			q=KiaanQueue();
			break;
			
		case "VikasQueue":
			q=VikasQueue();
			break;
			
			default:
			q=new ActiveMQQueue("OtherQueue");	
		}
		return q;
	}
	
	@Bean
	public ConnectionFactory getConFactory() {
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(brokerUrl);
		factory.setTrustAllPackages(true);
		return factory;
	}
	
	@Bean
  public JmsTemplate jmsTemplate() {
      return new JmsTemplate(getConFactory());
  }
}
