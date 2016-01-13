package com.xbb.net.common;

import org.junit.Before;
import org.junit.Test;

import com.xbb.net.common.tools.AppendFileStream;

public class AppendFileStreamTest {
	private AppendFileStream appendFileStream = new AppendFileStream();
	
	@Before
	public void testAppendBefore(){
		System.out.println("abd");
	}
	@Test
	public void testAppendByBuffer(){
		System.out.println("1");
		appendFileStream.appendByBuffer("D:\\test/","test.txt", "test1");
	}
	
	@Test
	public void testAppendByFileWriter(){
		System.out.println("2");
		appendFileStream.appendByFileWriter("D:\\test/","test.txt", "test2");
		
	}
	@Test
	public void testAppendByRandomAccessFile(){
		System.out.println("3");
		appendFileStream.appendByRandomAccessFile("D:\\test/","test.txt", "test3");
	}
	
}
