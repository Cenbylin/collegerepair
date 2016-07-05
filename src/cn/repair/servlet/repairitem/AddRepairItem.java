package cn.repair.servlet.repairitem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.repair.bean.RepairItem;
import cn.repair.bean.User;
import cn.repair.core.MVCControler;
import cn.repair.service.RepairItemService;

public class AddRepairItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 新增报修
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> res = new HashMap<String, Object>();
		//获取参数
		int itemType=-1;
		String itemPhone = request.getParameter("itemPhone");
		String itemAddress = request.getParameter("itemAddress");
		String itemDesc = request.getParameter("itemDesc");
		try {
			itemType = Integer.parseInt(request.getParameter("itemType"));
		} catch (Exception e) {}
		//判断参数
		if (itemType!=-1 && itemPhone!=null && itemAddress!=null && itemDesc!=null) {
			//封装参数
			RepairItem bean = new RepairItem();
			bean.setItemAddress(itemAddress);
			bean.setItemDesc(itemDesc);
			bean.setItemPhone(itemPhone);
			bean.setItemType(itemType);
			//执行添加
			RepairItemService repairItemService = RepairItemService.getInstance();
			repairItemService.addRepairItem(bean, (User)request.getSession().getAttribute("loginUser"));
			res.put("state", true);
		}else{
			res.put("state", false);
			res.put("msg", "参数错误");
		}
		
		JSONObject jsonObject = JSONObject.fromObject(res);
		MVCControler.ajax(jsonObject.toString(), "text/html", request, response);
	}

}
