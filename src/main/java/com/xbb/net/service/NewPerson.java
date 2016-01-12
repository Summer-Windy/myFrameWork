package com.xbb.net.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class NewPerson {

	@Autowired
    private Person person; 
      
    public NewPerson(){  
        System.out.println("NewPerson lazy loading...");  
    }  
    public void printMsg(){  
        if(person !=null) {  
            System.out.println(person.getName());  
        } else {  
            System.out.println("no person initialize!");  
        }  
    }  
  
//    public void setPerson(Person person) {  
//        this.s_person = person;
//    }  
      
  
}  
