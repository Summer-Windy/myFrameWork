package com.xbb.net.test;

/**
 * 测试finally
 * return 的时候 注意用到了栈
 * @author Administrator
 *
 */
public class myTest2 {

	public static void main(String[] args) {
		System.out.println(method());
		System.out.println(method2());
	}

	/**
	 *  首先程序在执行到try{}语句中的return方法后，就会先返回相应的值，并把相应的值存储在一个临时栈中去保存这个结果。这时临时栈中存储的值为1。

		    但是程序不会立刻返回，转而回去执行finally中的方法，++x，在finally执行完后，方法全部执行完，这时会再次调用return方法，注意这时
		
		   不在是返回值，而是告诉主调程序，被调程序已经执行完了，你可以接着去执行你主程序的其它方法了。但是请注意，此时返回的值还是原来保存在临时
		
		   栈中的值1。
	 * @return
	 */
	public static int method() {
		int x = 1;
		try {
			return x;
		} catch (Exception e) {
			return 0;
		} finally {
			++x;
		}

	}
	
	/**
	 *  没错是2，这里仅仅需要注意的是在try{}语句中执行到return 1 会在临时栈中存储值为1的变量。接着回去执行finally里面的内容，这时执行finally中的return 2;方法，这时

    	临时栈中的值就是变为 2，会覆盖原来临时栈中的值1.所以它的返回值为2。
	 * @return
	 */
	public static int method2(){
	      try{
	          return 1;
	      }catch(Exception e)
	      {
	          return 0;
	      }finally{
	          return 2;
	      }
	       
	  }

}
