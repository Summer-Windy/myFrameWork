package com.spring.service;



//使用jdk动态代理
public class AServiceImpl implements AService {

	public void barA() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AServiceImpl.barA()");
	}

	public void fooA(String _msg) {
		System.out.println("AServiceImpl.fooA(msg:" + _msg + ")");
	}
}