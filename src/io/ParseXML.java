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
	 * 使用dom解析XML文档
	 * DOM是由W3C提供的接口
	 * 它将整个XML文档读入内存，构建一个DOM树来对各个节点（Node）进行操作
	 * 优点：整个文档在内存中，便于操作，支持删除、修改、重新排列等多种功能
	 * 缺点：将整个文档调入内存，浪费了时间和空间
	 */
	public static void domParseXML(){
		DocumentBuilderFactory domfac = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder domBuilder = domfac.newDocumentBuilder();
			
			//读取xml文件
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
			
			System.out.println("dom解析完毕");
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
	 * SAX解析XML
	 * SAX不用将整个文档加载到内存，基于事件驱动的API(Observer模式)，用户只需要注册自己感兴趣的事件即可。SAX提供EntityResolver, DTDHandler, ContentHandler, ErrorHandler接口，分别用于监听解析实体事件、DTD处理事件、正文处理事件和处理出错事件.
	 * 与AWT类似，SAX还提供了一个对这4个接口默认的类DefaultHandler（这里的默认实现，其实就是一个空方法），
	 * 一般只要继承DefaultHandler，重写自己感兴趣的事件即可。
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
 * SAX的Handler类，需要重写自己感兴趣的方法
 * @author rttd
 *
 */
class MyHandler extends DefaultHandler{
	
	//存储正在解析的元素
	private Map<String,String> map = null;
	
	//存储所有解析的元素的数据
	private List<Map<String,String>> list = null;
	
	//存储正在解析的元素的名字
	String currentTag = null;
	
	//存储正在解析的元素的值
	String currentValue = null;
	
	//开始解析的元素
	String nodeName = null;
	
	public MyHandler(String nodeName){
		this.nodeName = nodeName;
	}
	
	//解析所得到的数据可以留着用
	public List<Map<String, String>> getList() {
		return list;
	}


	//解析到每个元素的内容时会调用到此方法
	@Override
	public void characters(char[] ch, int start, int end) throws SAXException {
		if(currentTag!=null && map!=null){
			currentValue = new String(ch,start,end);
			//如果内容不为空、空格和换行符则将该元素名和值存入map中
			if(currentValue!=null && !currentValue.trim().equals("") && !currentValue.trim().endsWith("\n")){
				map.put(currentTag, currentValue);
				System.out.println(currentTag+":"+currentValue);
			}
			currentTag = null;
			currentValue = null;
		}
	}

	//结束解析文档，即解析根元素结束标签时调用该方法
	@Override
	public void endDocument() throws SAXException {
		System.err.println("SAX解析结束");
		super.endDocument();
	}

	//每个元素结束时候调用该方法
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//System.out.println("endElement:"+qName);
		if(qName.equals(nodeName)){
			list.add(map);
			map=null;
		}
	}

	//开始解析文档时调用该方法
	@Override
	public void startDocument() throws SAXException {
		//红字打印
		System.err.println("SAX开始解析文档");
		list = new LinkedList<Map<String,String>>();
	}

	//开始解析每个元素时调用该方法
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		//System.out.println("startElement:"+qName);
		
		//判断正在解析的元素是不是我们要开始解析的元素
		if(qName.equals(nodeName)){
			map = new HashMap<String, String>();
		}
		
		//判断正在解析的元素是否有属性值,如果有则将其全部取出并保存到map对象中，如:<person id="00001"></person>
		if(map!=null && attributes!=null){
			for(int i=0; i<attributes.getLength();i++){
				
				map.put(attributes.getQName(i), attributes.getValue(i));
				
			}
		}
		currentTag = qName;
	}
}