package cn.repair.service;

import java.util.List;

import cn.repair.bean.RepairItem;
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
