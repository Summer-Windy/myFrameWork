package com.xbb.net.common.tools;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 * @author Administrator
 *
 */
public class TraditionalTimer {

	public static void main(String[] args){
		
		class  myTimerTask extends TimerTask{

			@Override
			public void run() {
				System.out.println("myTimerTask booming");
				
				new Timer().schedule(new myTimerTask(), 2000);
				
			}
		}
		
		new Timer().schedule(new myTimerTask(), 1000);
		
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
