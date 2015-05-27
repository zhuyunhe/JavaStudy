package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class JdomParseXML {
	public static void main(String[] args){
		jdomParseXML();
	}
	
	/**
	 * JDOM����XMLԪ��
	 */
	public static void jdomParseXML(){
		try {
			SAXBuilder sb = new SAXBuilder();
			
			//��ȡxml�ļ�
			InputStream is = new FileInputStream("example.xml");
			
			Document doc = sb.build(is);
			
			Element root = doc.getRootElement();
			
			//�õ���Ϊemployee��������Ԫ��
			List<Element> list = root.getChildren("employee");
			
			for(int i=0; i<list.size(); i++){
				Element element = list.get(i);
				
				//ȡ��employeeԪ�ص���Ԫ��
				List<Element> children = element.getChildren();
				for(Element e : children){
					System.out.println(e.getName()+":"+e.getValue());
				}

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}  
}
