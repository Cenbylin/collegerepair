package cn.repair.service;

import cn.repair.bean.RepairItem;
import cn.repair.bean.RepairLog;
import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.RepairItemDao;
import cn.repair.dao.RepairLogDao;
import cn.repair.dao.UserDao;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserDao userDao = DaoFactory.getUserDao();
		User user = new User();
		user.setUserAccount("admin");
		user.setUserPassword("123");
		//登陆
		user = userDao.queryUserByAccountAndPwd(user);
		//修改
		user.setUserName("林安成");
		user.setUserManager(1);
		user.setUserPhone("13560487066");
		user.setUserSex(1);
		user.setUserAddress("中山大道西293");
		userDao.updateUser(user);
		//模拟报修
		RepairItemDao repairItemDao = DaoFactory.getRepairItemDao();
		RepairItem repairItem = new RepairItem();
		repairItem.setUser(user);
		repairItem.setItemAddress(user.getUserAddress());
		repairItem.setItemDesc("aaaaa");
		repairItem.setItemType(1);
		repairItemDao.addRepairItem(repairItem);
		//模拟记录
		RepairLogDao repairLogDao = DaoFactory.getRepaiLogDao();
		RepairLog repairLog = new RepairLog();
		repairLogDao.addRepairLog(repairLog);
	}

}
