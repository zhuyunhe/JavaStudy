package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.io.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;


public class Dom4jParseXMl {
	public static void main(String[] args){
		dom4jParse();
	}
	
	public static void dom4jParse(){
		try {
			SAXReader reader = new SAXReader();
			InputStream is = new FileInputStream("example.xml");
			Document doc = reader.read(is);
			Element root = doc.getRootElement();
			
			//得到名为employee的所有子元素
			List<Element> list = root.elements("employee");
			
			
			for(int i=0; i<list.size(); i++){
				Element element = list.get(i);
				
				//取得employee元素的子元素
				List<Element> children = element.elements();
				for(Element e : children){
					System.out.println(e.getName()+":"+e.getText());
				}

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
