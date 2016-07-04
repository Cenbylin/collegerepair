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

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 更新用户
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取参数
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		int userSex = Integer.parseInt(request.getParameter("sex"));
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");
		//封装参数
		User user = new User();
		user.setUserId(userId);
		user.setUserAddress(userAddress);
		user.setUserName(userName);
		user.setUserPhone(userPhone);
		user.setUserSex(userSex);
		UserService userService = UserService.getInstance();
		//更新操作
		String res = userService.updateUser(user, (User)request.getSession().getAttribute("loginUser"));
		Map<String, Object> resMap = new HashMap<String, Object>();
		if (StringUtils.isNotEmpty(res)) {
			resMap.put("state", true);
		}else{
			resMap.put("state", false);
			resMap.put("msg", res);
		}
		JSONObject jsonObject = JSONObject.fromObject(resMap);
		MVCControler.ajax(jsonObject.toString(), "text/html", request, response);
	}

}
