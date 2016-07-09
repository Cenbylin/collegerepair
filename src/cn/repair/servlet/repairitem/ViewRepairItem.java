package cn.repair.servlet.repairitem;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.repair.bean.RepairItem;
import cn.repair.bean.RepairLog;
import cn.repair.bean.User;
import cn.repair.core.MVCControler;
import cn.repair.service.RepairItemService;
import cn.repair.service.RepairLogService;

public class ViewRepairItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	/**
	 * 跳转报修详情页面
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得参数
		int id = -1;
		try {
			id = Integer.parseInt(request.getParameter("itemId"));
		} catch (Exception e) {}
		
		//判断参数是否正确获取
		if (id!=-1) {
			RepairItemService repairItemService = RepairItemService.getInstance();
			RepairItem repairItem = repairItemService.queryItemById(id, (User)request.getSession().getAttribute("loginUser"));
			RepairLogService repairLogService = RepairLogService.getInstance();
			List<RepairLog> logs = repairLogService.queryRepairLogByItemId(id);
			//设置到request域
			request.setAttribute("repairLogs", logs);
			request.setAttribute("repairItem", repairItem);
		}
		MVCControler.doRoute("itemDetail.jsp", request, response);
	}

}
