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
		String file = "g:/stream.txt";
		String charset = "UTF-8";
		
		//д�ַ�ת��Ϊ�ֽ���
		try {
			FileOutputStream  outputStream = new FileOutputStream(file);
			OutputStreamWriter writer = new OutputStreamWriter(outputStream,charset);
			try {
				writer.write("Ҫ����������ַ�");
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
		
		FileInputStream inputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(inputStream,charset);
		StringBuffer buffer = new StringBuffer();
		char[] buf = new char[64];
		int count = 0;
		while((count = reader.read(buf)) != -1){
			buffer.append(buf, 0, count);
		}
		System.out.println(buffer.toString());
		
		String s = "1";
		byte[] b = s.getBytes("UTF-8");
		
		
	}
}
