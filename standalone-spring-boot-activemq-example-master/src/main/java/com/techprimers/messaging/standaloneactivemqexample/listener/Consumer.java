package com.techprimers.messaging.standaloneactivemqexample.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.techprimers.messaging.standaloneactivemqexample.resource.Student;

@Component
public class Consumer {
	
	
	
    @JmsListener(destination = "XYZQueue")
    public void consume(Student stu) {
        System.out.println("Received XYZQueue Queue Message: " + stu.toString());
    }
//    
    @JmsListener(destination = "KiaanQueue")
    public void consumeKiaan(Student stu) {
        System.out.println("Received Kiaan Queue Message: " + stu.toString());
    }
    
    @JmsListener(destination = "OtherQueue")
    public void consumeOther(Student stu) {
        System.out.println("Received Other Queue Message: " + stu.toString());
    }
    @JmsListener(destination = "Otherqueue")
    public void consumeOther2(Student stu) {
        System.out.println("Received Otherqueue Queue Message: " + stu.toString());
    }
//    
   
}
