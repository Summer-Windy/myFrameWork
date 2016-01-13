package com.xbb.net.test;

import java.util.Calendar;

import org.junit.Test;

public class MyTest {

	@Test
	public void pringRegx(){
		String str = "sfds\\tfs";
		System.out.println(str);
		System.out.println(str.replace("\\", "T"));
	}
	
	@Test
	public void testFinally(){
		System.out.println(myfinally());
		System.out.println(myfinally2());
	}
	
	/**
	 * 1 安全，防止任何类修改他的意义或实现
	 * 2 高效，实行final的时候，会进入内嵌机制，提高执行效率 
	 */
	@Test
	public void testFinal(){
		final int a;
		a = 10;
		System.out.println(a);
	}
	
	public static int myfinally(){
		int a = 1;
		try {
			return a=a++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return a+100;
		}
	}
	
	public static String myfinally2(){
		String a = "aaa";
		try {
			return  a + "bbb";
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			return  a + "ccc";
		}
	}
	
	@Test
	public void dateName(){
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getTime());
		System.out.println(System.currentTimeMillis());
	}
	
	@Test
	public void testReturn(){
		for(int i = 0;i<10;i++){
			System.out.println(i);
			if(i>5 && i<8){
				System.out.println(i);
			}else{
				return ;
			}
		}
	}
	
}
