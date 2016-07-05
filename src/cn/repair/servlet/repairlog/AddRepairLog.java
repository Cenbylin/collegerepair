package cn.repair.servlet.repairlog;

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
import cn.repair.service.RepairLogService;

public class AddRepairLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 增加报修日志--用户普通
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> res = new HashMap<String, Object>();
		//获得参数
		int itemId=0;
		String logMsg = request.getParameter("logMsg");
		try {
			itemId = Integer.parseInt(request.getParameter("itemId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		//参数判断
		if(itemId!=0 && StringUtils.isNotEmpty(logMsg)){
			//调用service
			RepairLogService repairLogService = RepairLogService.getInstance();
			String msg = repairLogService.addMsgRepairLog(itemId, logMsg, (User)request.getSession().getAttribute("loginUser"));
			//结果判断
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
