package com.xbb.net.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xbb.net.service.BusinessBean;
    
public class BusinessBeanTest {     
    public static void main(String[] args) {     
        ApplicationContext context = new ClassPathXmlApplicationContext(     
        "classpath:spring-beans.xml");     

        BusinessBean business = (BusinessBean) context.getBean("businessBean");     
             
        business.save();     
    }     
} 
