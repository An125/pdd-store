package com.oxygen.shop.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jdom.JDOMException;



/**
 * xml工具类
 * @author miklchen
 *
 */
public class XMLUtil {

	/**
	 * 解析xml,返回第一级元素键值对。如果第一级元素有子节点，则此节点的值是子节点的xml数据。
	 * @param strxml
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	public static Map<String, String> doXMLParse(String strxml){
		//System.out.println("strxml------"+strxml);
		strxml = strxml.replaceFirst("encoding=\".*\"", "encoding=\"UTF-8\"");
		//strxml = strxml.replaceFirst("encoding[a-zA-Z0-9\"-=]{1,}", "encoding=\"UTF-8\""); 
		//System.out.println("strxml==========="+strxml);
		Map<String, String> map = new HashMap<String, String>();
        Document doc = null;
        try {
            doc = DocumentHelper.parseText(strxml); // 将字符串转为XML
            Element rootElt = doc.getRootElement(); // 获取根节点
            @SuppressWarnings("unchecked")
            List<Element> list = rootElt.elements();// 获取根节点下所有节点
            for (Element element : list) { // 遍历节点
                map.put(element.getName(), element.getText()); // 节点的name为map的key，text为map的value
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
		/*if(null == strxml || "".equals(strxml)) {
			return null;
		}		
		HashMap<String, String> m = new HashMap<String, String>();		
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(strxml);
		} catch (DocumentException e) {
		
			e.printStackTrace();
		}//将xml转为dom对象
		Element root = doc.getRootElement();//获取根节点
		Element element = root.element("queryRequest");//获取名称为queryRequest的子节点
		 List<Element> elements = element.elements();//获取这个子节点里面的所有子元素，也可以element.elements("userList")
		 for (Object obj : elements) {  //遍历子元素
			 element = (Element) obj;  
			String k = element.getName();
			String v = element.getTextTrim();
			System.out.println("k===="+k);
			System.out.println("v===="+v);
			m.put(k, v);
		}	
		return m;
	}*/
	
	/**
	 * 获取子结点的xml
	 * @param children
	 * @return String
	 */
	/*public static String getChildrenText(List children) {
		StringBuffer sb = new StringBuffer();
		if(!children.isEmpty()) {
			Iterator it = children.iterator();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				String name = e.getName();
				String value = e.getTextNormalize();
				List list = e.getChildren();
				sb.append("<" + name + ">");
				if(!list.isEmpty()) {
					sb.append(XMLUtil.getChildrenText(list));
				}
				sb.append(value);
				sb.append("</" + name + ">");
			}
		}*/
		
//		return sb.toString();
//	}
	
	/**
	 * 获取xml编码字符集
	 * @param strxml
	 * @return
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	/*public static String getXMLEncoding(String strxml) throws JDOMException, IOException {
		InputStream in = HttpClientUtil.String2Inputstream(strxml);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(in);
		in.close();
		return (String)doc.getProperty("encoding");
	}*/
	
	

