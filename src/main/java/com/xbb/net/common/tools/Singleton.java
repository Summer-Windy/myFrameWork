package com.xbb.net.common.tools;

import org.junit.Test;

public class Singleton {
	
	private Singleton(){System.out.println("饿汉模式");}
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance(){
		return instance;
	}
	
}
