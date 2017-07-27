package club.zenyuca.common.config;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


/**
 * 常量配置类
 *
 * @author yuca
 * Date: 2017年7月26日
 */
public class Const {

	private static Const instance = null;

	public static Const getInstance() {
		if (null == instance) {
			instance = new Const();
		}
		return instance;
	}

	// session 常量配置
	/** 登录用户 */
	public static String SESSION_USER;
	
	// json 返回标记
	public static final String JSON_STATUS = "status";
	public static final String JSON_MSG = "msg";
	public static final String JSON_DATA = "data";

	static {
		ResourceBundle bundle = PropertyResourceBundle.getBundle("const");
		SESSION_USER = bundle.getString("SESSION_USER");
	}

	public enum ResponseCode {
		SUCCESS(0, "SUCCESS"),
		
		LOGIN_ERROR(1, "用户名或密码错误"),
		LOGIN_NO_LOGIN(10, "NO_LOGIN"),
		LOGIN_ILLEGAL_ARGUMENT(20, "ILLEGAL_ARGUMENT"),
		
		LOGOUT_ERROR(1, "用户名或密码错误"),
		;

		private int code;
		private String desc;

		ResponseCode(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public int getCode() {
			return this.code;
		}

		public String getDesc() {
			return this.desc;
		}
	}
}
