package cn.repair.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.repair.dao.RepairItemDao;
import cn.repair.dao.RepairLogDao;
import cn.repair.dao.impl.RepairItemDaoImpl;
import cn.repair.dao.impl.RepairLogDaoImpl;
import cn.repair.dao.impl.UserDaoImpl;

/**
 * Dao工厂
 * @author Cenby7
 *
 */
public class DaoFactory {
	//读取hibernate.cfg.xml文件
	static Configuration cfg = new Configuration().configure();
	//建立SessionFactory
	static SessionFactory factory = cfg.buildSessionFactory();
	//拿到SessionFactory
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	//拿到UserDao
	public static UserDaoImpl getUserDao(){
		return UserDaoImpl.getUserDao();
	}
	//拿到RepaiItemDao
	public static RepairItemDao getRepairItemDao(){
		return RepairItemDaoImpl.getRepairItemDao();
	} 
	//拿到RepaiLogDao
	public static RepairLogDao getRepaiLogDao(){
		return RepairLogDaoImpl.getRepairLogDao();
	} 
}
