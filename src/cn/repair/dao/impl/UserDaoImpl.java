package cn.repair.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import cn.repair.bean.User;
import cn.repair.dao.DaoFactory;

/**
 * 用户
 * @author Cenby7
 *
 */
public class UserDaoImpl {
	private static UserDaoImpl instance;
	/**私有构造方法*/
	private UserDaoImpl(){}
	/**获得实例*/
	public static UserDaoImpl getUserDao() {
		if (instance == null) {
			instance = new UserDaoImpl() ;
		}
		return instance ;
	}
	/**
	 * 用户增加 
	 */
	@SuppressWarnings("unchecked")
	public String addUser(User user){
		//回调信息
		String msg = "";
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			//查重
			List<User> users = session.createQuery("from User user where user.userAccount=?").setParameter(0, user.getUserAccount()).list();
			//查询到
			if(users!=null && users.size()>0){
				msg = "已有相同用户名";
			}else{
				//保存到数据库
				session.save(user);
			}
			//提交事务
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "添加用户失败";
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
	
	/**
	 * 用户登陆
	 */
	@SuppressWarnings("unchecked")
	public User queryUserByAccountAndPwd(User user){
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//查询
			List<User> users = session.createQuery("from User user where user.userAccount=? and user.userPassword=?")
					.setParameter(0, user.getUserAccount())
					.setParameter(1, user.getUserPassword())
					.list();
			//查询到
			if(users!=null && users.size()>0){
				return user;
			}
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
	/**
	 * 修改资料
	 */
	public String updateUser(User user){
		//回调信息
		String msg = "";
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			// 开启事务
			transaction = session.beginTransaction();
			session.update(user);
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
	
	/**
	 * 查询所有管理员--分页
	 */
	@SuppressWarnings("unchecked")
	public List<User> queryAllManager(final int pageSize,final int pageNum){
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//查询
			List<User> users = session.createQuery("from User user where user.userManager=?")
					.setFetchSize(pageSize*(pageNum-1))
					.setMaxResults(pageSize)
					.setParameter(0, 1)
					.list();
			return users;
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
	
	/**
	 * 查询所有用户--分页
	 */
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser(final int pageSize,final int pageNum){
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//查询
			List<User> users = session.createQuery("from User order by id desc")
					.setFetchSize(pageSize*(pageNum-1))
					.setMaxResults(pageSize)
					.list();
			return users;
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
	
	/**
	 * 查询用户--条件查询分页
	 */
	@SuppressWarnings("unchecked")
	public List<User> queryUserByCondition(User user, final int pageSize,final int pageNum){
		SessionFactory factory = DaoFactory.getSessionFactory();
		Session session = null;
		try {
			session = factory.openSession();
			//动态查询
			Criteria dc = session.createCriteria(User.class);
			if(user.getUserManager()!=null){
				dc.add(Restrictions.eq("userManager", user.getUserManager()));
			}
			if(user.getUserSex()!=null){
				dc.add(Restrictions.eq("userSex", user.getUserSex()));
			}
			if(user.getUserPhone()!=null){
				dc.add(Restrictions.eq("userPhone", user.getUserPhone()));
			}
			if(user.getUserName()!=null){
				dc.add(Restrictions.eq("userName", user.getUserName()));
			}
			//其他条件
			List<User> users = dc.setFetchSize(pageSize*(pageNum-1)).setMaxResults(pageSize).addOrder(Property.forName("userId").desc()).list();
			return users;
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
}
