package cn.repair.servlet.repairitem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.repair.bean.RepairItem;
import cn.repair.bean.User;
import cn.repair.core.MVCControler;
import cn.repair.service.RepairItemService;
import cn.repair.utils.Pager;

public class QueryRepairItem extends HttpServlet {
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
		//获得分页参数
		int pageNum=1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		} catch (Exception e) {}
		
		pager.setPageNumber(pageNum);
		RepairItem bean = new RepairItem();//查询对象
		bean.setItemAddress(request.getParameter("itemAddress"));
		bean.setItemDesc(request.getParameter("itemDesc"));
		bean.setItemPhone(request.getParameter("itemPhone"));
		//获取类型参数
		int itemType=-1;
		try {
			pageNum = Integer.parseInt(request.getParameter("itemType"));
		} catch (Exception e) {}
		
		if (itemType!=-1) {
			bean.setItemType(itemType);
		}
		bean.setItemState(null);
		//执行查询
		RepairItemService userService = RepairItemService.getInstance();
		userService.queryAllItems(pager, bean, (User)request.getSession().getAttribute("loginUser"));
		
		request.setAttribute("pager", pager);
		MVCControler.doRoute("repairAllList.jsp", request, response);
	}

}
