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
		
		//д�ַ�ת��Ϊ�ֽ���
		try {
			//FileOutputStream,�ļ�����������ڽ�����д�� File �� FileDescriptor ����������ֽ���
			FileOutputStream  outputStream = new FileOutputStream(file);
			//OutputStreamWriter���ַ�ͨ���ֽڵ�����,�ַ����ֽ���Ҫ����
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
		
			
		//FileInputStream,���ļ�ϵͳ��ĳ���ļ��л�������ֽ�
		FileInputStream inputStream = new FileInputStream(file);
		
		//InputStreamReader,���ֽڵ��ַ���ת��������
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
