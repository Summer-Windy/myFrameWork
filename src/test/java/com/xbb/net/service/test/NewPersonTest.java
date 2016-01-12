package com.xbb.net.service.test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xbb.net.service.NewPerson;
  
  
public class NewPersonTest {  
  
    @Test  
    public void printMsg(){  
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
        		"classpath:spring-beans.xml");  
        NewPerson test = (NewPerson) ctx.getBean("newPerson");  
        test.printMsg();  
    }  
}  

