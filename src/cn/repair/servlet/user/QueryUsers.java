package cn.repair.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.repair.bean.User;
import cn.repair.core.MVCControler;
import cn.repair.service.UserService;
import cn.repair.utils.Pager;

public class QueryUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * 用户查询
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得参数
		Pager pager = new Pager();//分页
		pager.setPageNumber(Integer.valueOf(request.getParameter("pageNum")));
		User bean = new User();//查询对象
		bean.setUserSex(Integer.valueOf(request.getParameter("sex")));
		bean.setUserManager(Integer.valueOf(request.getParameter("userManager")));
		bean.setUserName(request.getParameter("userManager"));
		
		//执行查询
		UserService userService = UserService.getInstance();
		userService.queryUsers(pager, bean, (User)request.getSession().getAttribute("loginUser"));
		
		//MVCControler.ajax("", "text/html", request, response);
		MVCControler.doRoute("userList.jsp", request, response);
	}

}
