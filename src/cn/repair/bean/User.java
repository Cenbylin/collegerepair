package cn.repair.bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String userAccount;
	private String userPassword;
	private String userName;
	private Integer userSex;
	private String userPhone;
	private String userAddress;
	private Integer userManager;//1为是管理员 0不是

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userAccount) {
		this.userAccount = userAccount;
	}

	/** full constructor */
	public User(String userAccount, String userPassword, String userName,
			Integer userSex, String userPhone, String userAddress,
			Integer userManager) {
		this.userAccount = userAccount;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userSex = userSex;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userManager = userManager;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return this.userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public Integer getUserManager() {
		return this.userManager;
	}

	public void setUserManager(Integer userManager) {
		this.userManager = userManager;
	}

	@Override
	public String toString() {
		return userPhone;
	}

}