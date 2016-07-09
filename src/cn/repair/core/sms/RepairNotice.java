package cn.repair.core.sms;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import cn.repair.bean.RepairItem;
import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.UserDao;

import com.cloopen.rest.sdk.CCPRestSmsSDK;


public class RepairNotice {
	private static RepairNotice instance;
	//短信API
	private CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
	/**私有构造方法*/
	private RepairNotice(){
		//接口初始化
		restAPI.init("app.cloopen.com", "8883");
		restAPI.setAccount(SMSInfo.getACCOUNT_SID(), SMSInfo.getAUTH_TOKEN());
		restAPI.setAppId(SMSInfo.getAPP_ID());
	}
	/**获得实例*/
	public static RepairNotice getInstance() {
		if (instance == null) {
			instance = new RepairNotice() ;
		}
		return instance ;
	}
	
	/**
	 * 发送报修通知短信
	 */
	public void sendRepairNotice(RepairItem repairItem) {
		//int i;
		UserDao userDao = DaoFactory.getUserDao();
		List<User> managers = userDao.queryAllManager();
		//逗号作分隔拼接，重写了User的toString
		String phones = StringUtils.join(managers.toArray(), ",");
		
		/*老方法
		StringBuffer sb = new StringBuffer(); 
		int i;
		for (i = 0; i < managers.size()-1; i++) {
			sb.append(managers.get(i).getUserPhone()+",");
		}
		sb.append(managers.get(i).getUserPhone());*/
		
		//群发
		restAPI.sendTemplateSMS(phones,"1" ,
				new String[]{repairItem.getUser().getUserName(),
				repairItem.getItemAddress(),
				repairItem.getItemDesc(),
				repairItem.getUser().getUserPhone()});
	}
	
}
