package cn.repair.service;

import java.util.List;

import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.UserDao;
import cn.repair.utils.Constants;
import cn.repair.utils.Pager;


public class UserService {
	private static UserService instance;
	/**私有构造方法*/
	private UserService(){}
	/**获得实例*/
	public static UserService getInstance() {
		if (instance == null) {
			instance = new UserService() ;
		}
		return instance ;
	}
	
	/**
	 * 用户查询--管理员
	 * @param pager
	 * @param bean
	 * @param loginUser
	 * @return
	 */
	public Pager queryUsers(Pager pager, User bean, User loginUser){
		//判断是否登陆，并且是管理员
		if(loginUser!=null && loginUser.getUserManager()==Constants.USER_ROLE_MANAGER){
			UserDao userDao = DaoFactory.getUserDao();
			//分页查询
			List<User> users = userDao.queryUserByCondition(bean, pager.getPageSize(), pager.getPageNumber());
			pager.setList(users);
		}
		return pager;
	}
	/**
	 * 设置管理员
	 * @param id
	 * @param loginUser
	 * @return
	 */
	public String setManager(Integer id, User loginUser){
		String msg = "";
		//判断是否登陆，并且是管理员
		if(loginUser!=null && loginUser.getUserManager()==1){
			UserDao userDao = DaoFactory.getUserDao();
			User user = userDao.getUserById(id);
			//修改角色
			user.setUserManager(Constants.USER_ROLE_MANAGER);
			msg = userDao.updateUser(user);
		}
		return msg;
	}
	
	/**
	 * 更新用户
	 * @param id
	 * @param loginUser
	 * @return
	 */
	public String updateUser(User user, User loginUser){
		String msg = "";
		UserDao userDao = DaoFactory.getUserDao();
		User bean = userDao.getUserById(loginUser.getUserId());
		//判断身份
		if(bean!=null && (bean.getUserId() == loginUser.getUserId() || loginUser.getUserManager()==Constants.USER_ROLE_MANAGER)){
			//重设属性
			bean.setUserAddress(user.getUserAddress());
			bean.setUserName(user.getUserName());
			bean.setUserSex(user.getUserSex());
			bean.setUserPhone(user.getUserPhone());
			msg = userDao.updateUser(bean);
		}
		return msg;
	}
	/**
	 * 根据Id获得用户
	 * @param id
	 * @param loginUser
	 * @return
	 */
	public User getUserById(int id){
		UserDao userDao = DaoFactory.getUserDao();
		return userDao.getUserById(id);
	}
	
	/**
	 * 注册用户
	 * @param id
	 * @param loginUser
	 * @return
	 */
	public String addUser(User user){
		String msg = "";
		UserDao userDao = DaoFactory.getUserDao();
		msg = userDao.addUser(user);
		return msg;
	}
	
	/**
	 * 修改密码
	 * @param id
	 * @param loginUser
	 * @return
	 */
	public String editPassword(String oldPassword, String newPassword, User loginUser){
		String msg = "";
		UserDao userDao = DaoFactory.getUserDao();
		User bean = new User();
		bean.setUserAccount(loginUser.getUserAccount());
		bean.setUserPassword(oldPassword);
		//验证账号密码
		bean = userDao.queryUserByAccountAndPwd(bean);
		//判断身份
		if(bean!=null && bean.getUserId().intValue() == loginUser.getUserId().intValue()){
			//重设属性
			bean.setUserPassword(newPassword);
			msg = userDao.updateUser(bean);
		}else{
			msg = "无权限";
		}
		return msg;
	}
}
