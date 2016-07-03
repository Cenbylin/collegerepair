package cn.repair.bean;

/**
 * RepairLog entity. @author MyEclipse Persistence Tools
 */

public class RepairLog implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer logId;
	private Integer userId;
	private String logTime;
	private User user;
	private RepairItem repairItem;
	private Integer logType;
	private String logMsg;

	// Constructors

	/** default constructor */
	public RepairLog() {
	}

	/** full constructor */
	public RepairLog(Integer itemId, Integer userId, String logTime,
			Integer logType, String logMsg) {
		this.userId = userId;
		this.logTime = logTime;
		this.logType = logType;
		this.logMsg = logMsg;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLogTime() {
		return this.logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public Integer getLogType() {
		return this.logType;
	}

	public void setLogType(Integer logType) {
		this.logType = logType;
	}

	public String getLogMsg() {
		return this.logMsg;
	}

	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RepairItem getRepairItem() {
		return repairItem;
	}

	public void setRepairItem(RepairItem repairItem) {
		this.repairItem = repairItem;
	}

}