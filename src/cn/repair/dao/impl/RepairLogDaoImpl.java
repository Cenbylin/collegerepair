package cn.repair.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import cn.repair.bean.RepairLog;
import cn.repair.core.DaoFactory;
import cn.repair.dao.RepairLogDao;

public class RepairLogDaoImpl implements RepairLogDao {
	private static RepairLogDaoImpl instance;
	/**私有构造方法*/
	private RepairLogDaoImpl(){}
	/**获得实例*/
	public static RepairLogDaoImpl getRepairLogDao() {
		if (instance == null) {
			instance = new RepairLogDaoImpl() ;
		}
		return instance ;
	}
	
	@Override
	public String addRepairLog(RepairLog repairLog) {
		//回调信息
		String msg = "";
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			//保存到数据库
			session.save(repairLog);
			//提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "添加报修项目失败";
			// 回滚事务
			transaction.rollback();
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}
		return msg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RepairLog> queryRepairLogByItemId(Integer itemId) {
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//查询
			List<RepairLog> logs = session.createQuery("from RepairLog where itemId=? order by id desc")
					.setParameter(0, itemId)
					.list();
			return logs;
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RepairLog> queryRepairLogByUserId(Integer userId, int pageSize,
			int pageNum) {
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//查询
			List<RepairLog> logs = session.createQuery("from RepairLog where userId=? order by id desc")
					.setParameter(0, userId)
					.setFetchSize(pageSize*(pageNum-1))
					.setMaxResults(pageSize)
					.list();
			return logs;
		} catch (Exception e) {
			e.printStackTrace();
			// 回滚事务
		} finally {
			if (session != null) {
				if (session.isOpen()) {
					// 关闭session
					session.close();
				}
			}
		}
		return null;
	}

}
