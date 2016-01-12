package com.xbb.net.dataStructure;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;

//import com.qinhannet.domain.smartbox.DeviceModel;
//import com.qinhannet.middleware.DeviceModelSqlHelper;
//import com.qinhannet.middleware.DeviceModelSqlHelperImpl;

public class TreeTest {

	@Test
	public void TestAdd(){
		Tree tree=Tree.getTree();
		String str1="abcd";
		String str2="abce";
		String str3="bcde";
		String str4="acce";
		String str5="acbd";
		
		tree.addBranch(null, 0, str3);
		tree.addBranch(null, 0, str1);
		tree.addBranch(null, 0, str2);
		tree.addBranch(null, 0, str4);
		tree.addBranch(null, 0, str5);
		
		String strr="b";
		List<String> list=tree.select(null, 0, strr,10);
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		System.out.println("--------------");
	}
	
	@Test
	public void TestStringBuilder(){
		StringBuilder sb=new StringBuilder();
		sb.append("1");
		sb.append("2");
		sb.append("3");
		sb.append("4");
		sb.deleteCharAt(3);
	}
	
	@Test
	public void TestTree(){
		Tree tree=Tree.getTree();
//		DeviceModelSqlHelper deviceModelSqlHelper=new DeviceModelSqlHelperImpl("ICCIRCLE");
//		int count=deviceModelSqlHelper.count();
		int layer=0;
//		if(count!=0)
//			layer=count/500000;
		for(int i=0;i<=layer;i++){
//			List<DeviceModel> list=deviceModelSqlHelper.queryPage(500000*i, 500000);

//			for(int j=0;j<list.size();j++){
////				System.out.println(list.get(j).getModel_name());
//				tree.add(list.get(j).getModel_name().trim());
//			}
//			list.clear();
//			list=null;
//			Runtime.getRuntime().freeMemory();
//			Runtime.getRuntime().totalMemory();
			System.out.println("程序当前所用内存是："+Runtime.getRuntime().totalMemory());
		}
//		String queryStr="0-1102855";
		Calendar now = Calendar.getInstance(); 
		System.out.println("当前时间毫秒数：" + now.getTimeInMillis()); 
		
		String queryStr="0-11028";
		List<String> listResult=tree.select(queryStr,10);
		
		Calendar now2 = Calendar.getInstance(); 
		System.out.println("当前时间毫秒数：" + now2.getTimeInMillis()); 
		System.out.println("相差的毫秒数："+(now2.getTimeInMillis()-now.getTimeInMillis()));
			System.out.println(listResult+"---");
	}
}
