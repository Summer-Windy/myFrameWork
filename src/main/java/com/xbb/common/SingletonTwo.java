package com.xbb.common;


public class SingletonTwo {
	private static class SingletonTwoHolder{
		private  static final SingletonTwo  INSTANCE =new SingletonTwo();
	}
	private SingletonTwo(){System.out.println("静态内部类方式，饿汉模式，懒加载...");}
	
	public static SingletonTwo getInstance(){
		return SingletonTwoHolder.INSTANCE;
	}
	
}
