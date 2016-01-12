package com.xbb.common;


public class SingletonThree {
	
	private static SingletonThree instance;
	private SingletonThree(){System.out.println("饱汉模式");}

	
	public static synchronized SingletonThree getInstance(){
		if(instance == null)
			instance = new SingletonThree();
		return instance;
	}
	
}
