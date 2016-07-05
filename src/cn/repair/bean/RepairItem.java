package cn.repair.bean;

/**
 * RepairItem entity. @author MyEclipse Persistence Tools
 */

public class RepairItem implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer itemId;
	private String itemPhone;
	private String itemAddress;
	private User user;
	private String itemDesc;
	private String itemTime;
	private Integer itemType;
	private Integer itemState=0;//0刚发起，1开始受理，2受理完毕

	// Constructors

	/** default constructor */
	public RepairItem() {
	}

	/** full constructor */
	public RepairItem(Integer userId, String itemPhone, String itemAddress,
			String itemDesc, Integer itemType, Integer itemState) {
		this.itemPhone = itemPhone;
		this.itemAddress = itemAddress;
		this.itemDesc = itemDesc;
		this.itemType = itemType;
		this.itemState = itemState;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemPhone() {
		return this.itemPhone;
	}

	public void setItemPhone(String itemPhone) {
		this.itemPhone = itemPhone;
	}

	public String getItemAddress() {
		return this.itemAddress;
	}

	public void setItemAddress(String itemAddress) {
		this.itemAddress = itemAddress;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public Integer getItemType() {
		return this.itemType;
	}

	public void setItemType(Integer itemType) {
		this.itemType = itemType;
	}

	public Integer getItemState() {
		return this.itemState;
	}

	public void setItemState(Integer itemState) {
		this.itemState = itemState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getItemTime() {
		return itemTime;
	}

	public void setItemTime(String itemTime) {
		this.itemTime = itemTime;
	}

}