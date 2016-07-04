package cn.repair.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import cn.repair.bean.RepairItem;
import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.RepairItemDao;

public class RepairItemDaoImpl implements RepairItemDao{
	private static RepairItemDaoImpl instance;
	/**私有构造方法*/
	private RepairItemDaoImpl(){}
	/**获得实例*/
	public static RepairItemDaoImpl getRepairItemDao() {
		if (instance == null) {
			instance = new RepairItemDaoImpl() ;
		}
		return instance ;
	}
	
	@Override
	public String addRepairItem(RepairItem repairItem) {
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
			session.save(repairItem);
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
	public List<RepairItem> queryAllRepairItem(int pageSize, int pageNum) {
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//查询
			List<RepairItem> items = session.createQuery("from RepairItem order by id desc")
					.setFetchSize(pageSize*(pageNum-1))
					.setMaxResults(pageSize)
					.list();
			return items;
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
	public List<RepairItem> queryRepairItemByCondition(RepairItem repairItem,
			int pageSize, int pageNum) {
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//动态查询
			Criteria dc = session.createCriteria(User.class);
			if(repairItem.getItemState()!=null){
				dc.add(Restrictions.eq("itemState", repairItem.getItemState()));
			}
			if(repairItem.getItemState()!=null){
				dc.add(Restrictions.eq("itemState", repairItem.getItemState()));
			}
			//其他条件
			List<RepairItem> items = dc.setFetchSize(pageSize*(pageNum-1)).setMaxResults(pageSize).addOrder(Property.forName("itemId").desc()).list();
			return items;
		} catch (Exception e) {
			e.printStackTrace();
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
	@Override
	public String updateRepairItem(RepairItem repairItem) {
		//回调信息
		String msg = "";
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			session.update(repairItem);
			//提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "修改失败";
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
}
