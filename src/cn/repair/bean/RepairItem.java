package cn.repair.bean;

import cn.repair.utils.Constants;

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
	private String itemTypeString;
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

	/**
	 * 获得标题
	 * @return
	 */
	public String getItemTitle() {
		//截取关键字
		StringBuffer sb = new StringBuffer();
		sb.append(itemAddress.length()>4?itemAddress.substring(0, 4):itemAddress);
		sb.append(" ");
		sb.append(itemDesc.length()>4?itemDesc.substring(0, 4):itemDesc);
		return sb.toString();
	}

	public String getItemTypeString() {
		switch(itemType){
		case Constants.ITEM_TYPE_1:itemTypeString="电路";
			break;
		case Constants.ITEM_TYPE_2:itemTypeString="水路";
		break;
		case Constants.ITEM_TYPE_3:itemTypeString="移动网络";
		break;
		case Constants.ITEM_TYPE_4:itemTypeString="电信网络";
		break;
		case Constants.ITEM_TYPE_5:itemTypeString="门窗";
		break;
		case Constants.ITEM_TYPE_6:itemTypeString="空调";
		break;
		}
		
		
		return itemTypeString;
	}

	public void setItemTypeString(String itemTypeString) {
		this.itemTypeString = itemTypeString;
	}

}