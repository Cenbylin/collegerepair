package cn.repair.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.repair.bean.User;
import cn.repair.core.DaoFactory;
import cn.repair.dao.UserDao;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 登陆是ajax的，为了防止微信传参限制
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Map<String, Object> res = new HashMap<String, Object>();
		//获得参数
		String userAccount = request.getParameter("userAccount");
		String userPassword = request.getParameter("userPassword");
		if(userAccount!=null && userPassword!=null){
			//封装对象
			User loginUser = new User();
			loginUser.setUserAccount(userAccount);
			loginUser.setUserPassword(userPassword);
			UserDao userDao = DaoFactory.getUserDao();
			loginUser = userDao.queryUserByAccountAndPwd(loginUser);
			if (loginUser!=null) {
				//登陆成功
				request.getSession().setAttribute("loginUser", loginUser);
				res.put("state", true);
			}else{
				//登陆失败
				res.put("state", false);
				res.put("msg", "请检查账号密码！");
			}
			//组装json
			JSONObject jsonObject = JSONObject.fromObject(res);
			out.print(jsonObject.toString());
		}else{
			res.put("state", false);
			res.put("msg", "参数有误");
			//组装json
			JSONObject jsonObject = JSONObject.fromObject(res);
			out.print(jsonObject.toString());
		}
		out.flush();
		out.close();
	}

}
