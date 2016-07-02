package cn.repair.utils;

import java.util.List;

/**
 * Bean类 - 分页
 */
@SuppressWarnings("rawtypes")
public class Pager {
	
	public static final Integer MAX_PAGE_SIZE = 500;// 每页最大记录数限制

	private Integer pageNumber = 1;// 当前页码
	private Integer pageSize = 20;// 每页记录数
	private Integer totalCount = 0;// 总记录数
	private Integer pageCount = 0;// 总页数
	private String marker="";//标识字符串
	
	private List list;// 数据List

	/**
	 * 获取当前页码
	 * @return
	 * @ChangeLog
	 *
	 */
	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		if (pageNumber < 1) {
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

	/**
	 * 获取每页记录数
	 * @return
	 * @ChangeLog
	 *
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		} else if(pageSize > MAX_PAGE_SIZE) {
			pageSize = MAX_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPageCount() {
		pageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			pageCount ++;
		}
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getMarker() {
		return marker;
	}

	public void setMarker(String marker) {
		this.marker = marker;
	}

}