package cn.repair.dao;

import java.util.List;
import cn.repair.bean.RepairItem;

public interface RepairItemDao {
	/**
	 * 增加报修
	 */
	public String addRepairItem();
	/**
	 * 修改报修
	 */
	public String updateRepairItem();
	/**
	 * 查询所有报修--分页
	 */
	public List<RepairItem> queryAllRepairItem(final int pageSize,final int pageNum);
	/**
	 * 查询报修--条件查询分页
	 */
	public List<RepairItem> queryRepairItemByCondition(RepairItem repairItem, final int pageSize,final int pageNum);
}
