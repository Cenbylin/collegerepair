package cn.repair.servlet.repairitem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.repair.bean.User;
import cn.repair.core.MVCControler;
import cn.repair.service.RepairItemService;
import cn.repair.utils.Pager;

public class QueryUserItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 报修查询
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得参数
		Pager pager = new Pager();//分页
		pager.setPageNumber(Integer.valueOf(request.getParameter("pageNum")));
		//执行查询
		RepairItemService userService = RepairItemService.getInstance();
		userService.queryUserItems(pager, (User)request.getSession().getAttribute("loginUser"));
		
		
		request.setAttribute("pager", pager);
		MVCControler.doRoute("repairItemList.jsp", request, response);
	}
}
