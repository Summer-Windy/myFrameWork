package com.xbb.net.common.thread.test;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class ThreadLocalTest {

	@Test
	public void localData(){
		//threadLocal里面存放一个共享数据
		
	}
	
	@Test
	public void myThreadScopeData(){
		//threadLocal里面存放多个对象
		
	}
	
	@Test
	public void getInstance(){
		//通过ThreadLocal获取调用的线程的具体实例
		
	}
	
	@Test
	public void atomicInteger(){
		AtomicInteger atomicInteger = new AtomicInteger();
		atomicInteger.addAndGet(10);
		System.out.println(atomicInteger);
	}
	
	
}
