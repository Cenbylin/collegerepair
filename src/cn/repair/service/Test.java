package cn.repair.service;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		/*
		UserDao userDao = DaoFactory.getUserDao();
		List<User> managers = userDao.queryAllManager();
		//形成指定分隔符
		String phones = StringUtils.join(managers.toArray(), ",");
		System.out.println(phones);
		
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
		
		//模拟查询记录
		RepairItem beanItem = new RepairItem();
		beanItem.setItemState(Constants.ITEM_STATE_DOING);
		List<RepairItem> repairItems = repairItemDao.queryRepairItemByCondition(beanItem, 5, 1);
		System.out.println(repairItems);
		*/
	}

}
