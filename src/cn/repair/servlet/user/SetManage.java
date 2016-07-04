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

public class SetManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 设置管理员
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得参数
		int id = Integer.parseInt(request.getParameter("userId"));
		UserService userService = UserService.getInstance();
		String res = userService.setManager(id, (User)request.getSession().getAttribute("loginUser"));
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
