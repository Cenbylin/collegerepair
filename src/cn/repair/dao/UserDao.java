package cn.repair.dao;

import java.util.List;

import cn.repair.bean.User;

public interface UserDao {
	/**
	 * 用户增加 
	 */
	public String addUser(User user);
	/**
	 * 用户登陆
	 */
	public User queryUserByAccountAndPwd(User user);
	/**
	 * 修改资料
	 */
	public String updateUser(User user);
	/**
	 * 查询所有管理员--分页
	 */
	public List<User> queryAllManager(final int pageSize,final int pageNum);
	/**
	 * 查询所有用户--分页
	 */
	public List<User> queryAllUser(final int pageSize,final int pageNum);
	/**
	 * 查询用户--条件查询分页
	 */
	public List<User> queryUserByCondition(User user, final int pageSize,final int pageNum);
}
