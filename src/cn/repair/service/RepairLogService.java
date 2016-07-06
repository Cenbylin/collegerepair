package cn.repair.service;

import java.util.List;

import cn.repair.bean.RepairItem;
import cn.repair.bean.RepairLog;
import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.RepairItemDao;
import cn.repair.dao.RepairLogDao;
import cn.repair.utils.Constants;
import cn.repair.utils.TimeUtil;

public class RepairLogService {
	private static RepairLogService instance;
	/**私有构造方法*/
	private RepairLogService(){}
	/**获得实例*/
	public static RepairLogService getInstance() {
		if (instance == null) {
			instance = new RepairLogService() ;
		}
		return instance ;
	}
	
	/**
	 * 根据报修项目Id获得记录列表
	 * @param itemId
	 * @return
	 */
	public List<RepairLog> queryRepairLogByItemId(int itemId){
		//拿到Dao
		RepairLogDao repairLogDao = DaoFactory.getRepaiLogDao();
		return repairLogDao.queryRepairLogByItemId(itemId);
	}
	/**
	 * 添加消息报修日志
	 * @param itemId
	 * @param logMsg
	 * @param loginUser
	 * @return
	 */
	public String addMsgRepairLog(int itemId, String logMsg, User loginUser){
		String msg = "";
		//验证身份
		if (loginUser!=null) {
			RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
			RepairItem repairItem = repairItemDao.queryRepairItemById(itemId);
			if (repairItem!=null) {
				//封装对象
				RepairLog bean = new RepairLog();
				bean.setLogMsg(logMsg);
				bean.setRepairItem(repairItem);
				bean.setUser(loginUser);
				bean.setLogType(Constants.LOGTYPE_MSG);
				bean.setLogTime(TimeUtil.getCurrTime(TimeUtil.Y_M_D_H_M));
				//执行保存
				RepairLogDao repairLogDao = DaoFactory.getRepaiLogDao();
				msg = repairLogDao.addRepairLog(bean);
			}else{
				msg="报修项目不存在";
			}
		}else{
			msg = "未登陆";
		}
		return msg;
	}
	/**
	 * 添加报修日志
	 * @param repairLog
	 * @param loginUser
	 * @return
	 */
	public String addRepairLog(RepairLog bean, User loginUser){
		String msg = "";
		//验证身份
		if (loginUser!=null) {
			//设置数据
			bean.setUser(loginUser);
			bean.setLogTime(TimeUtil.getCurrTime(TimeUtil.Y_M_D_H_M));
			//执行保存
			RepairLogDao repairLogDao = DaoFactory.getRepaiLogDao();
			msg = repairLogDao.addRepairLog(bean);
		}else{
			msg = "未登陆";
		}
		return msg;
	}
}
