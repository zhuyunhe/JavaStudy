package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileIO {
	public static void main(String[] args) throws IOException{
		String file = "f:/stream.txt";
		String charset = "UTF-8";
		
		//写字符转化为字节流
		try {
			//FileOutputStream,文件输出流是用于将数据写入 File 或 FileDescriptor 的输出流，字节流
			FileOutputStream  outputStream = new FileOutputStream(file);
			//OutputStreamWriter是字符通向字节的桥梁,字符到字节需要编码
			OutputStreamWriter writer = new OutputStreamWriter(outputStream,charset);
			try {
				writer.write("要保存的中文字符");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally{
				writer.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		//FileInputStream,从文件系统的某个文件中获得输入字节
		FileInputStream inputStream = new FileInputStream(file);
		
		//InputStreamReader,从字节到字符的转化桥梁。
		InputStreamReader reader = new InputStreamReader(inputStream,charset);
		StringBuffer buffer = new StringBuffer();
		char[] buf = new char[64];
		int count = 0;
		try{
			
		while((count = reader.read(buf)) != -1){
			buffer.append(buf, 0, count);
		}
		System.out.println(buffer.toString());
		}
		finally{
			reader.close();
		}
		
		
		String s = "1";
		byte[] b = s.getBytes("UTF-8");//49
		
		
	}
}
