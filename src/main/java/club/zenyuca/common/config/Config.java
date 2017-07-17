package club.zenyuca.common.config;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.lang3.math.NumberUtils;

public class Config {

	private static Config instance = null;

	public static Config getInstance() {
		if (null == instance) {
			instance = new Config();
		}
		return instance;
	}

	public static final String SESSION_USER = "sessionUser";// 平台账户

	public static String HttpFtpUrl = ""; // 图片库url

	public static String CloudURL = ""; // 云服务器地址

	public static String PAYURL = "";// 支付平台支付地址

	public static String PAYAPIURL = "";// 支付平台接口地址

	public static Long PAYTIMELIMITE = 15L;// 支付重复提交的验证时间间隔

	/** 卡券记录删除时限，例如值为10，那么就表示删除10天前的数据 */
	public static int CARD_DELETE_DAY;

	public static String PERSON_IP = "person_ip";// 记录用户ip

	public static String PERSON_CITY = "person_city";// 记录地区

	public static String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(sellerlogin)).*";

	public static String NO_FILTER = "admin";

	public static String SELLER_KEY = "!@#$%^&*()O0O0qwer";

	public static String PERSON_KEY = "!@#$%^&*2211t()O0O0qwer";

	// ////////////// ftp 参数
	public static String FtpHost = "";

	public static int Port;

	public static String Uname;

	public static String Pass;

	public static String ServerPath;

	public static String LocalPath;

	public static String SELECT_CITY;// 获取城市

	public static String SELECT_LATLON;// 获取经纬度

	public static String LOCAL_ADMIN_PATH;

	public static String LOCAL_APP_PATH;
	// 意见反馈发送到邮箱配置
	public static String FEED_BACK_EMAIL;
	public static String SENDER_EMAIL;
	public static String SENDER_PWD;
	public static String SEND_SERVER;
	public static String SEND_PORT;

	// 标记：认证入口
	public final static String MARK_AUTH_ENTRY = "MARK_AUTH_ENTRY";


	// /sms配置
	public static String SMS_URL = "http://222.73.117.158/msg/";
	public static String SMS_ACCOUNT = "shangwuC_vip_ycd";
	public static String SMS_PSWD = "Tch123456";
	public static boolean IS_DEBUG = false;
	public static boolean IS_LOCAL = true;

	// 意见反馈配置
	public static String RECEIVE_EMAIL = "";

	public static String NoFilter_Path = "";

	public static String NoFilterBossApp_Path = "";

	public static int BOSS_APP_ROLEID = 5;// 商户app默认权限id

	// 初始化默认的菜单权限
	public static String INIT_APP_EMPLOYEE_SYSTEMROLES = "26,55,56,57,58,59";

	public static String PING_TAI_SEQ = "2";

	public static String MERCHANT_ROLE = "";

	public static String SCAN_URL = "";// 二维码扫描跳转地址
	// 地区json
	public static String REGIONJSON = "";

	static {
		ResourceBundle bundle = null;
		if (isWindows()) {
			bundle = PropertyResourceBundle.getBundle("const");
		} else {
			bundle = PropertyResourceBundle.getBundle("const_linux");
		}
		HttpFtpUrl = bundle.getString("HTTP_URL");
		CloudURL = bundle.getString("CLOUD_URL");
		CARD_DELETE_DAY = NumberUtils.toInt(bundle.getString("CARD_DELETE_DAY"));

		FtpHost = bundle.getString("ftpHost");
		Port = NumberUtils.toInt(bundle.getString("ftpPort"));
		Uname = bundle.getString("ftpUserName");
		Pass = bundle.getString("ftpPass");
		ServerPath = bundle.getString("SAVE_PATH");
		LocalPath = bundle.getString("TRANSIT_PATH");
		SELECT_CITY = bundle.getString("SELECT_CITY");
		SELECT_LATLON = bundle.getString("SELECT_LATLON"); // 12.215.42.19&position=true
		LOCAL_ADMIN_PATH = bundle.getString("LOCAL_ADMIN_PATH");
		LOCAL_APP_PATH = bundle.getString("LOCAL_APP_PATH");

		/******** init ******************/
		NO_INTERCEPTOR_PATH = bundle.getString("NO_INTERCEPTOR_PATH");
		NO_FILTER = bundle.getString("NO_FILTER");
		SELLER_KEY = bundle.getString("SELLER_KEY");
		PERSON_KEY = bundle.getString("PERSON_KEY");

		SMS_URL = bundle.getString("SMS_URL");
		RECEIVE_EMAIL = bundle.getString("RECEIVE_EMAIL");

		SMS_ACCOUNT = bundle.getString("SMS_ACCOUNT");
		SMS_PSWD = bundle.getString("SMS_PSWD");
		IS_DEBUG = bundle.getString("IS_DEBUG").equals("true") ? true : false;
		IS_LOCAL = bundle.getString("IS_LOCAL").equals("true") ? true : false;
		NoFilter_Path = bundle.getString("NoFilter_Path");
		NoFilterBossApp_Path = bundle.getString("NoFilterBossApp_Path");
		PING_TAI_SEQ = bundle.getString("PING_TAI_SEQ");
		MERCHANT_ROLE = bundle.getString("MERCHANT_ROLE");
		SCAN_URL = bundle.getString("SCAN_URL");
		PAYAPIURL = bundle.getString("PAYAPIURL");
		PAYURL = bundle.getString("PAYURL");
		PAYTIMELIMITE = NumberUtils.toLong(bundle.getString("PAYTIMELIMITE"));
		BOSS_APP_ROLEID = NumberUtils.toInt(bundle.getString("BOSS_APP_ROLEID"));

		FEED_BACK_EMAIL = bundle.getString("FEED_BACK_EMAIL");
		SENDER_EMAIL = bundle.getString("SENDER_EMAIL");
		SENDER_PWD = bundle.getString("SENDER_PWD");
		SEND_SERVER = bundle.getString("SEND_SERVER");
		SEND_PORT = bundle.getString("SEND_PORT");

	}

	public static boolean isWindows() {
		boolean flag = false;
		if (System.getProperties().getProperty("os.name").toUpperCase().indexOf("WINDOWS") != -1) {
			flag = true;
		}
		return flag;
	}

}
