package com.xbb.net.common;

import org.junit.Test;

import com.xbb.net.common.tools.MyStream;

public class StreamTest {
	
	private MyStream steam = new MyStream();
		
	@Test
	public void testWriteByByte(){
		steam.writeToFileByByte("D:\\test/","test.txt", "test");
	}
	
	@Test
	public void testWriteByChar(){
		steam.writeToFileByChar("D:/test/","test2.txt", "test");
	}
	

}
