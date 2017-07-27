package club.zenyuca.common.enums;


/**
 * 角色枚举
 * @author cy
 *
 */
public enum RoleEnum {
	/** 管理员 admin = -1 */
	ADMIN(-1,"admin", "管理员"),
	/** 录单员 listRecorder = 1 */
	LIST_RECORDER(1,"listRecorder", "录单员"),
	/** 勘察员 listChecker = 2 */
	LIST_CHECKER(2,"listChecker", "勘察员"),
	/** 抄表员 eleNumRecorder = 3 */
	ELE_NUM_RECORDER(3,"eleNumRecorder", "抄表员"),
	/** 计量员 calcer = 4 */
	CALCER(4,"calcer", "接电员"),
	;
	
	private int type;
	private String name;
	private String chineseName;
	private RoleEnum(int type, String name, String chinessName) {
		this.type = type;
		this.name = name;
		this.chineseName = chinessName;
	}
	public int getType() {
		return this.type;
	}
	public String getName() {
		return this.name;
	}
	public String getChineseName() {
		return chineseName;
	}
}
