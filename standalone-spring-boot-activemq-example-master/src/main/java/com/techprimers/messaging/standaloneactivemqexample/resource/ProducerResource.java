package com.techprimers.messaging.standaloneactivemqexample.resource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.messaging.standaloneactivemqexample.config.MyMsgBeans;

import javax.jms.JMSException;
import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {
	
    @Autowired
    JmsTemplate jmsTemplate;

	@Autowired
    private MyMsgBeans msgBean;

	Queue oqueue;
    
    @Autowired
    @Qualifier("KiaanQueue")
    Queue queue;

    @PostMapping(value = "/newstudent")
    public String publish(@RequestBody final Student student) throws JMSException {
    	oqueue=msgBean.OtherQueue(student.getQueueName());
    	jmsTemplate.convertAndSend(oqueue, student);
        return "Published Successfully Into "+oqueue.getQueueName()+" Queue";
    }
    
    @PostMapping(value = "/knewstudent")
    public String publishn(@RequestBody final Student student) {

        jmsTemplate.convertAndSend(queue, student);
        
        return "Published Successfully Into Kiaan Queue";
    }
    
    

}
