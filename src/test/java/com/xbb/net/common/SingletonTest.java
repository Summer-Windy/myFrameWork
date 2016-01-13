package com.xbb.net.common;

import org.junit.Test;

import com.xbb.net.common.tools.Singleton;
import com.xbb.net.common.tools.SingletonThree;
import com.xbb.net.common.tools.SingletonTwo;

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
