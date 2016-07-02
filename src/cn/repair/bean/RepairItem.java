package cn.repair.bean;

/**
 * RepairItem entity. @author MyEclipse Persistence Tools
 */

public class RepairItem implements java.io.Serializable {

	// Fields

	private Integer itemId;
	private Integer userId;
	private String itemPhone;
	private String itemAddress;
	private String itemDesc;
	private Integer itemType;

	// Constructors

	/** default constructor */
	public RepairItem() {
	}

	/** full constructor */
	public RepairItem(Integer userId, String itemPhone, String itemAddress,
			String itemDesc, Integer itemType) {
		this.userId = userId;
		this.itemPhone = itemPhone;
		this.itemAddress = itemAddress;
		this.itemDesc = itemDesc;
		this.itemType = itemType;
	}

	// Property accessors

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

}