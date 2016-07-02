package cn.repair.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RepairDao {
	// 读取hibernate.cfg.xml文件
	static Configuration cfg = new Configuration().configure();
	// 建立SessionFactory
	static SessionFactory factory = cfg.buildSessionFactory();
	public static SessionFactory getFactory() {
		return factory;
	}
}
