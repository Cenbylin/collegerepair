package cn.repair.service;

import java.util.List;

import cn.repair.bean.RepairItem;
import cn.repair.bean.RepairLog;
import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.RepairItemDao;
import cn.repair.utils.Constants;
import cn.repair.utils.Pager;
import cn.repair.utils.TimeUtil;

public class RepairItemService {
	private static RepairItemService instance;
	/**私有构造方法*/
	private RepairItemService(){}
	/**获得实例*/
	public static RepairItemService getInstance() {
		if (instance == null) {
			instance = new RepairItemService() ;
		}
		return instance ;
	}
	/**
	 * 报修处理完毕
	 * @param itemId
	 * @param loginUser
	 * @return
	 */
	public String doneRepairItem(int itemId, User loginUser){
		String msg = "";
		//判断用户权限
		if(loginUser!=null && loginUser.getUserManager()==Constants.USER_ROLE_MANAGER){
			RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
			RepairItem bean = repairItemDao.queryRepairItemById(itemId);
			if (bean!=null) {
				//设置数据
				bean.setItemState(Constants.ITEM_STATE_DONE);
				msg = repairItemDao.updateRepairItem(bean);
				//日志记录
				RepairLog repairLog = new RepairLog();
				repairLog.setRepairItem(bean);
				repairLog.setLogMsg("处理完毕");
				repairLog.setLogType(Constants.LOGTYPE_STATE);
				RepairLogService repairLogService = RepairLogService.getInstance();
				msg += repairLogService.addRepairLog(repairLog, loginUser);
			}else{
				msg = "不存在该项目";
			}
		}else {
			msg = "未登陆";
		}
		return msg;
	}
	/**
	 * 报修受理
	 * @param itemId
	 * @param loginUser
	 * @return
	 */
	public String disposeRepairItem(int itemId, User loginUser){
		String msg = "";
		//判断用户权限
		if(loginUser!=null && loginUser.getUserManager()==Constants.USER_ROLE_MANAGER){
			RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
			RepairItem bean = repairItemDao.queryRepairItemById(itemId);
			if (bean!=null) {
				//设置数据
				bean.setItemState(Constants.ITEM_STATE_DOING);
				msg = repairItemDao.updateRepairItem(bean);
				//日志记录
				RepairLog repairLog = new RepairLog();
				repairLog.setRepairItem(bean);
				repairLog.setLogMsg("已经由 "+loginUser.getUserName()+"受理");
				repairLog.setLogType(Constants.LOGTYPE_STATE);
				RepairLogService repairLogService = RepairLogService.getInstance();
				msg += repairLogService.addRepairLog(repairLog, loginUser);
			}else{
				msg = "不存在该项目";
			}
		}else {
			msg = "未登陆";
		}
		return msg;
	}
	/**
	 * 新增报修项目
	 * @param bean
	 * @param loginUser
	 * @return
	 */
	public String addRepairItem(RepairItem bean, User loginUser){
		String msg = "";
		//判断用户
		if(loginUser!=null){
			//设置数据
			bean.setUser(loginUser);
			bean.setItemTime(TimeUtil.getCurrTime(TimeUtil.Y_M_D_H_M));
			RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
			msg = repairItemDao.addRepairItem(bean);
		}else {
			msg = "未登陆";
		}
		return msg;
	}
	
	/**
	 * 条件查询项目
	 * @param pager
	 * @param bean
	 * @param loginUser
	 */
	public Pager queryAllItems(Pager pager, RepairItem bean, User loginUser) {
		//判断是否登陆，并且是管理员
		if(loginUser!=null && loginUser.getUserManager()==Constants.USER_ROLE_MANAGER){
			RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
			//分页查询
			List<RepairItem> repairItems = repairItemDao.queryRepairItemByCondition(bean, pager.getPageSize(), pager.getPageNumber());
			pager.setList(repairItems);
		}
		return pager;
	}
	public Pager queryUserItems(Pager pager, User loginUser) {
		//判断是否登陆
		if(loginUser!=null){
			//封装条件
			RepairItem bean = new RepairItem();
			bean.setUser(loginUser);
			RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
			//分页查询
			List<RepairItem> repairItems = repairItemDao.queryRepairItemByUserId(loginUser.getUserId(), pager.getPageSize(), pager.getPageNumber());
			pager.setList(repairItems);
		}
		return pager;
	}
}
