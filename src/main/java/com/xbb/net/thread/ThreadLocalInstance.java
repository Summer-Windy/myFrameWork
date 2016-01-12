package com.xbb.net.thread;

/**
 * threadLocal获取单例模式
 * @author Administrator
 *
 */
public class ThreadLocalInstance {

	private ThreadLocalInstance  threadLocalInstance= null;
	private ThreadLocal<ThreadLocalInstance> thisThreadLocal;
	
	public ThreadLocalInstance getInstance(){
		if(threadLocalInstance == null){
			threadLocalInstance = new ThreadLocalInstance();
			thisThreadLocal.set(threadLocalInstance);
		}
		return threadLocalInstance;
	}
	
}
