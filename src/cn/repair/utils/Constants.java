package cn.repair.utils;

public class Constants {
	/**用户性别-男*/
	public static final Integer USER_SEX_M=1;
	/**用户性别-女*/
	public static final Integer USER_SEX_F=0;
	/**用户权限-管理*/
	public static final Integer USER_ROLE_MANAGER=1;
	/**用户权限-非管理*/
	public static final Integer USER_ROLE_NOMANAGER=0;
	/**报修日志-状态*/
	public static final Integer LOGTYPE_STATE=0;
	/**报修日志-附加信息*/
	public static final Integer LOGTYPE_MSG=1;
	/**报修状态-未处理*/
	public static final Integer ITEM_STATE_NO=0;
	/**报修状态-处理中*/
	public static final Integer ITEM_STATE_DOING=1;
	/**报修状态-处理结束*/
	public static final Integer ITEM_STATE_DONE=2;
}
