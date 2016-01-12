package com.xbb.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostUtil {
	/**
	 * 向指定URL发送GET方法的请求
	 * @param url  发送请求的URL
	 * @param param  请求参数，请求参数应该是name1=value1&name2=value2的形式
	 * @return URL所代表远程资源的响应
	 */

	public String sendGet(String url, String param,String CharSet) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlName = url + "?" + param;
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
//			for (String key : map.keySet()) {
//				System.out.println(key + "--->" + map.get(key));
//			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),CharSet));
			String line;
			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

/**
	 * 向指定URL发送POST方法的请求
	 * @param url 发送请求的URL
	 * @param param 请求参数，请求参数应该是name1=value1&name2=value2的形式
	 * @return URL所代表远程资源的响应
	 */
	public String sendPost(String url, String param,String CharSet) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			
			conn.setDoOutput(true);// 发送POST请求必须设置如下两行
			conn.setDoInput(true);
			
			out = new PrintWriter(conn.getOutputStream());// 获取URLConnection对象对应的输出流s
			out.print(param);// 发送请求参数
			out.flush();// flush输出流的缓冲
			in = new BufferedReader(new InputStreamReader(conn.getInputStream(),CharSet));// 定义BufferedReader输入流来读取URL的响应
			String line;
			while ((line = in.readLine()) != null) {
				result += "\n" + line;
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

	// 提供主方法，测试发送GET请求和POST请求
	public static void main(String args[]) {
		// 发送GET请求
//		String s = TestGetPost.sendGet("http://localhost:9080/net/orderList?order_status=0", "");
//		System.out.println(s);
		// 发送POST请求
		GetPostUtil getPostUtil = new GetPostUtil();
		String s1 = getPostUtil.sendPost("http://localhost:9080/net/orderList?order_status=0",	"user=李刚&pass=abc","GBK");
		System.out.println(s1);
	}
}
