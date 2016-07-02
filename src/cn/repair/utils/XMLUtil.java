package cn.repair.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xml工具类
 * 
 * @author Cenbylin
 */
public class XMLUtil {
	/**
	 * xml转成Map集合
	 * 
	 * @param xml的输入流
	 * @return 解析后的Map
	 * @throws DocumentException
	 * @throws IOException
	 */
	public static Map<String, String> xmlToMap(InputStream xmlStream)
			throws DocumentException, IOException {
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(xmlStream);
		xmlStream.close();
		Element root = doc.getRootElement();
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		return map;
	}

	/**
	 * javabean转XML
	 * 
	 * @param javabean
	 * @return
	 */
	public static String BeanToXml(Object javabean) {
		XStream xstream = new XStream(new DomDriver("UTF-8"));

		xstream.alias("xml", javabean.getClass());
		return xstream.toXML(javabean);
	}
}
