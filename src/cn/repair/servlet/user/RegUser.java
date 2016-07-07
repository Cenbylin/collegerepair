package cn.repair.servlet.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import cn.repair.bean.User;
import cn.repair.core.MVCControler;
import cn.repair.service.UserService;

public class RegUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 注册用户
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数
		String userAccount = request.getParameter("regUserAccount");
		String userName = request.getParameter("regUserName");
		String userPassword = request.getParameter("regUserPassword");
		String userPhone = request.getParameter("regUserPhone");
		//封装参数
		User user = new User();
		user.setUserAccount(userAccount);
		user.setUserPassword(userPassword);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		UserService userService = UserService.getInstance();
		//更新操作
		String res = userService.addUser(user);
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isEmpty(res)) {
			resMap.put("state", true);
		}else{
			resMap.put("state", false);
			resMap.put("msg", res);
		}
		JSONObject jsonObject = JSONObject.fromObject(resMap);
		MVCControler.ajax(jsonObject.toString(), "text/html", request, response);
	}

}
