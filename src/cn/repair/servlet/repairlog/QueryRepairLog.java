package cn.repair.servlet.repairlog;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.repair.bean.RepairLog;
import cn.repair.core.MVCControler;
import cn.repair.service.RepairLogService;

public class QueryRepairLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 异步，获得报修日志
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int itemId=0;
		Map<String, Object> res = new HashMap<String, Object>();
		//获得参数
		try {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(itemId!=0){
			RepairLogService repairLogService = RepairLogService.getInstance();
			//获得列表
			List<RepairLog> list = repairLogService.queryRepairLogByItemId(itemId);
			res.put("logs", list);
			res.put("state", true);
		}else{
			res.put("state", false);
			res.put("msg", "参数错误");
		}
		JSONObject jsonObject = JSONObject.fromObject(res);
		//异步返回json
		MVCControler.ajax(jsonObject.toString(), "text/html", request, response);
	}
}
