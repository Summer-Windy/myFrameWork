package com.xbb.net.common.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args){ 
		
		/*
		 * 固定的线程池
		 */
//		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		/*
		 * 不固定线程池
		 */
//		ExecutorService threadPool = Executors.newCachedThreadPool();
		/*
		 * 单个线程
		 */
		ExecutorService threadPool = Executors.newSingleThreadExecutor();
		
		
		for(int i = 0;i<=10 ;i++){
			final int task = i;
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					for(int j =0;j<10;j++){
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "is looping of "+j+" for the task " + task);
					}
				}
			});
		}
		
		System.out.println("all of 10 tasks have commited");
		threadPool.shutdown();
//		threadPool.shutdownNow();
		
		/**
		 * 定时线程池
		 */
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("booming...");
			}
		}, 10, TimeUnit.SECONDS);
		/**
		 * 每隔2秒钟执行一次
		 */
		Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("booming...");
			}
		}, 10,2, TimeUnit.SECONDS);
	}
}
