package com.xbb.common;

import org.junit.Test;

import com.xbb.common.Singleton;
import com.xbb.common.SingletonThree;
import com.xbb.common.SingletonTwo;

public class SingletonTest {

	@Test
	public void testSingleton(){
		Singleton.getInstance();
	}
	
	@Test
	public void testSingletonTwo(){
		SingletonTwo.getInstance();
	}
	
	@Test
	public void testSingletonThree(){
		SingletonThree.getInstance();
	}
	
}
