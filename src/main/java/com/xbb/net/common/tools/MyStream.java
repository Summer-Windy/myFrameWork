package com.xbb.net.common.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sun.org.apache.bcel.internal.generic.CALOAD;

/**
 * 文件写入到文本
 * @author Administrator
 *
 */
public class MyStream {
	public File myfile = null;
	
	
	public MyStream() {
		super();
	}

	private File createFile(String filePath,String fileName){
		
		filePath = filePath.replace("/", File.separator)
					.replace("\\", File.separator);
		
		
		File path = new File(filePath);
		if(!path.exists())
			path.mkdir();
		
		File file = new File(filePath + fileName);
		if(file.exists())
			try {
				file.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		return this.myfile=file;
	}
	

	/**
	 * 字节流
	 * @param filePath
	 * @param fileName
	 * @param contenet
	 * @return
	 */
	public Boolean writeToFileByByte(String filePath,String fileName,String contenet){
		createFile(filePath, fileName);
		
		OutputStream out = null;
		
		Calendar calendar = Calendar.getInstance();
		String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:SS")).format(calendar.getTime());
		String sb = str + "\t"+contenet;
		
		byte b[] =sb.getBytes();
		
		try {
			out = new FileOutputStream(myfile);
			System.out.println("-->"+myfile.getPath());
			out.write(b);
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		finally{
			System.out.println("文件操作结束");
		}
	}

	/**
	 * 字符流
	 * @param filePath
	 * @param fileName
	 * @param contenet
	 * @return
	 */
	public Boolean writeToFileByChar(String filePath, String fileName, String contenet) {
		createFile(filePath, fileName);
		
		Writer out = null;
		
		try {
			out = new FileWriter(myfile);
			out.write(contenet);
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		finally{
			System.out.println("文件操作结束");
		}
	}
	
	
	
}
