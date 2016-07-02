package cn.repair.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cn.repair.dao.impl.UserDaoImpl;

/**
 * Dao工厂
 * @author Cenby7
 *
 */
public class DaoFactory {
	// 读取hibernate.cfg.xml文件
	static Configuration cfg = new Configuration().configure();
	// 建立SessionFactory
	static SessionFactory factory = cfg.buildSessionFactory();
	//拿到SessionFactory
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	//拿到UserDao
	public static UserDaoImpl getUserDao(){
		return UserDaoImpl.getUserDao();
	}
}
