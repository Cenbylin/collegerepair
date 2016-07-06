package cn.repair.servlet.repairitem;

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
import cn.repair.service.RepairItemService;

public class DoneRepair extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	/**
	 * 处理完毕
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> res = new HashMap<String, Object>();
		//获取参数
		int itemId = -1;
		try {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		} catch (Exception e) {}
		if(itemId!=-1){
			RepairItemService repairItemService = RepairItemService.getInstance();
			String msg = repairItemService.doneRepairItem(itemId, (User)request.getSession().getAttribute("loginUser"));
			
			if (StringUtils.isEmpty(msg)) {
				res.put("state", true);
			}else{
				res.put("state", false);
				res.put("msg", msg);
			}
			
		}else{
			res.put("state", false);
			res.put("msg", "参数错误");
		}
		JSONObject jsonObject = JSONObject.fromObject(res);
		MVCControler.ajax(jsonObject.toString(), "text/html", request, response);
	}

}
