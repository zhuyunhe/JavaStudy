package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParseXML {
	public static void main(String[] args){
		domParseXML();
		//saxParseXML();
	}
	
	/**
	 * ʹ��dom����XML�ĵ�
	 * DOM����W3C�ṩ�Ľӿ�
	 * ��������XML�ĵ������ڴ棬����һ��DOM�����Ը����ڵ㣨Node�����в���
	 * �ŵ㣺�����ĵ����ڴ��У����ڲ�����֧��ɾ�����޸ġ��������еȶ��ֹ���
	 * ȱ�㣺�������ĵ������ڴ棬�˷���ʱ��Ϳռ�
	 */
	public static void domParseXML(){
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder domBuilder = domfac.newDocumentBuilder();
			
			//��ȡxml�ļ�
			InputStream is = new FileInputStream("example.xml");
			
			Document doc = domBuilder.parse(is);
			
			Node root = doc.getDocumentElement();
			
			NodeList employees = root.getChildNodes();
			
			if(employees!=null){
				for(int i=0; i<employees.getLength(); i++){
					Node employee = employees.item(i);
					
					NodeList employeeMeta = employee.getChildNodes();
					
					for(int k=0; k<employeeMeta.getLength(); k++){
						if(employeeMeta.item(k).getNodeType() == Node.ELEMENT_NODE){
							System.out.println(employeeMeta.item(k).getNodeName()+":"+employeeMeta.item(k).getTextContent());
						}
					}
					
				}
			}
			
			System.out.println("dom�������");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * SAX����XML
	 * SAX���ý������ĵ����ص��ڴ棬�����¼�������API(Observerģʽ)���û�ֻ��Ҫע���Լ�����Ȥ���¼����ɡ�SAX�ṩEntityResolver, DTDHandler, ContentHandler, ErrorHandler�ӿڣ��ֱ����ڼ�������ʵ���¼���DTD�����¼������Ĵ����¼��ʹ�������¼�.
	 * ��AWT���ƣ�SAX���ṩ��һ������4���ӿ�Ĭ�ϵ���DefaultHandler�������Ĭ��ʵ�֣���ʵ����һ���շ�������
	 * һ��ֻҪ�̳�DefaultHandler����д�Լ�����Ȥ���¼����ɡ�
	 */
	public static void saxParseXML(){
		try {
			SAXParserFactory saxfac = SAXParserFactory.newInstance();
			SAXParser parser = saxfac.newSAXParser();
			InputStream is = new FileInputStream("example.xml");
			parser.parse(is, new MyHandler("employee"));
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

/**
 * SAX��Handler�࣬��Ҫ��д�Լ�����Ȥ�ķ���
 * @author rttd
 *
 */
class MyHandler extends DefaultHandler{
	
	//�洢���ڽ�����Ԫ��
	private Map<String,String> map = null;
	
	//�洢���н�����Ԫ�ص�����
	private List<Map<String,String>> list = null;
	
	//�洢���ڽ�����Ԫ�ص�����
	String currentTag = null;
	
	//�洢���ڽ�����Ԫ�ص�ֵ
	String currentValue = null;
	
	//��ʼ������Ԫ��
	String nodeName = null;
	
	public MyHandler(String nodeName){
		this.nodeName = nodeName;
	}
	
	//�������õ������ݿ���������
	public List<Map<String, String>> getList() {
		return list;
	}


	//������ÿ��Ԫ�ص�����ʱ����õ��˷���
	@Override
	public void characters(char[] ch, int start, int end) throws SAXException {
		if(currentTag!=null && map!=null){
			currentValue = new String(ch,start,end);
			//������ݲ�Ϊ�ա��ո�ͻ��з��򽫸�Ԫ������ֵ����map��
			if(currentValue!=null && !currentValue.trim().equals("") && !currentValue.trim().endsWith("\n")){
				map.put(currentTag, currentValue);
				System.out.println(currentTag+":"+currentValue);
			}
			currentTag = null;
			currentValue = null;
		}
	}

	//���������ĵ�����������Ԫ�ؽ�����ǩʱ���ø÷���
	@Override
	public void endDocument() throws SAXException {
		System.err.println("SAX��������");
		super.endDocument();
	}

	//ÿ��Ԫ�ؽ���ʱ����ø÷���
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("endElement:"+qName);
		if(qName.equals(nodeName)){
			list.add(map);
			map=null;
		}
	}

	//��ʼ�����ĵ�ʱ���ø÷���
	@Override
	public void startDocument() throws SAXException {
		//���ִ�ӡ
		System.err.println("SAX��ʼ�����ĵ�");
		list = new LinkedList<Map<String,String>>();
	}

	//��ʼ����ÿ��Ԫ��ʱ���ø÷���
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		//System.out.println("startElement:"+qName);
		
		//�ж����ڽ�����Ԫ���ǲ�������Ҫ��ʼ������Ԫ��
		if(qName.equals(nodeName)){
			map = new HashMap<String, String>();
		}
		
		//�ж����ڽ�����Ԫ���Ƿ�������ֵ,���������ȫ��ȡ�������浽map�����У���:<person id="00001"></person>
		if(map!=null && attributes!=null){
			for(int i=0; i<attributes.getLength();i++){
				
				map.put(attributes.getQName(i), attributes.getValue(i));
				
			}
		}
		currentTag = qName;
	}
}