package cn.repair.core.sms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 从配置文件读配置项，并且一些定时刷新的属性也在这里处理
 * @author Cenby7
 *
 */
public class SMSInfo {
	//短信平台
	private static String ACCOUNT_SID = null;
	private static String AUTH_TOKEN = null;
	private static String APP_ID = null;

	static {
		loadConfig();//加载
		//定时任务线程
		Runnable runnable = new Runnable() {
			public void run() {
				
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		
	}

	@SuppressWarnings({ "unchecked", "unused" })
	/**
	 * 从配置文件中装载核心信息
	 */
	public static void loadConfig(){
		Element root = null;
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		try {
				InputStream xmlStream = SMSInfo.class.getClassLoader().getResourceAsStream("SMS-config.xml");
				Document doc = reader.read(xmlStream);	
				xmlStream.close();
				root = doc.getRootElement();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (DocumentException e2){
			
		}

		List<Element> list = root.elements();
		for (Element e : list) {
			if(e.getName().equals("sms")){
				List<Element> list1 = e.elements();
				for(Element e1 : list1){
					if(e1.getName().equals("ACCOUNT_SID")){
						ACCOUNT_SID = e1.getStringValue();
					}else if(e1.getName().equals("AUTH_TOKEN")){
						AUTH_TOKEN = e1.getStringValue();
					}else if(e1.getName().equals("APP_ID")){
						APP_ID = e1.getStringValue();
					}
				}
			}
		}
	}

	public static String getACCOUNT_SID() {
		return ACCOUNT_SID;
	}

	public static String getAUTH_TOKEN() {
		return AUTH_TOKEN;
	}

	public static String getAPP_ID() {
		return APP_ID;
	}
}
