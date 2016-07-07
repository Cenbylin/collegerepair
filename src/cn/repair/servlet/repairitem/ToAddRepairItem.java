package cn.repair.servlet.repairitem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.repair.bean.User;
import cn.repair.core.MVCControler;

public class ToAddRepairItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 跳转报修页面
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User loginUser = (User)request.getSession().getAttribute("loginUser");
		//判断有无登陆
		if (loginUser==null) {
			//没登陆
			MVCControler.doRoute("login.html", request, response);
		}else{
			//已经登陆
			
			
		}
	}

}
