package com.xbb.net.common.tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Writer;

/**
 * 向文件中追加文本
 * @author Administrator
 *
 */
public class AppendFileStream {
	public File myfile = null;
	
	public AppendFileStream() {
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
	 * 
	 * @param filePath
	 * @param fileName
	 * @param contenet
	 */
	public void appendByBuffer(String filePath,String fileName,String contenet){
		
		createFile(filePath,fileName);
		
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(myfile,true)));
			out.write(contenet);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(out != null){
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void appendByFileWriter(String filePath,String fileName,String contenet){
		
		createFile(filePath,fileName);
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(myfile,true);
			writer.write(contenet);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(writer != null){
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void appendByRandomAccessFile(String filePath,String fileName,String contenet){
		
		createFile(filePath,fileName);
		
		RandomAccessFile randomFile = null;
		
		try {
			randomFile  =  new RandomAccessFile(myfile, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.writeBytes(contenet);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(randomFile != null){
					randomFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
