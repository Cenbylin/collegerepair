package cn.repair.dao;

import java.util.List;

import cn.repair.bean.RepairLog;

public interface RepairLogDao {
	/**
	 * 添加报修处理记录
	 * @param repairLog
	 * @return
	 */
	public String addRepairLog(RepairLog repairLog);
	/**
	 * 根据报修项目Id获得记录列表
	 * @param itemId
	 * @return
	 */
	public List<RepairLog> queryRepairLogByItemId(Integer itemId);
	/**
	 * 根据用户Id获得记录列表
	 * @param userId
	 * @return
	 */
	public List<RepairLog> queryRepairLogByUserId(Integer userId, int pageSize, int pageNum);
}
