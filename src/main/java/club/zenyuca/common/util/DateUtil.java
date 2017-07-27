package club.zenyuca.common.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.util.Assert;

public class DateUtil {
	
	/** 年月日时分秒(无下划线) yyyyMMddHHmmssSSS */
    public static final String PATTERN_DTLONG  = "yyyyMMddHHmmssSSS";

	public static final String PATTERN_STANDARD = "yyyy-MM-dd HH:mm:ss";

	public static final String PATTERN_DATE = "yyyy-MM-dd";

	public static final String PATTERN_SECOND = "ssSSS";
	
	
	/**
	 * 获得服务器当前时间字符串
	 * @author NIUBIN
	 * @date 2015年12月11日
	 */
	public static String getTodayStr(String pattern) {
		if (pattern == null || "".equals(pattern)) {
			pattern = "yyyy-MM-dd HH:mm:ss"; //pattern
		}
		return new SimpleDateFormat(pattern).format(new Date());
	}
	
	public static String getTodayStr() {
		String pattern = "yyyy-MM-dd HH:mm:ss"; //pattern
		
		return new SimpleDateFormat(pattern).format(new Date());
	}
	/**
	 * 
	 * 获得一个日期上个月的日期字符串	
	 * @author NIUBIN
	 * @date 2015年12月11日
	 */
	public static String getLastMonthStr(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
		if(null==date){
			date = new Date(); 
		}
		Calendar cal = Calendar.getInstance();        
		cal.setTime(date);          
		cal.add(Calendar.MONTH, -1);         
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 
	 * 获得一个日期下个月的日期
	 * 2015-02   yyyy-MM ------>2015-03
	 * @author YIMAO
	 * @date 2017年5月5日
	 */
	public static Date getNextMonthStr(Date date,String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern); 
		if(null==date){
			date = new Date(); 
		}
		String dateStr = sdf.format(date);
		Calendar cal = Calendar.getInstance();        
		cal.setTime(string2Date(dateStr, pattern));          
		cal.add(Calendar.MONTH, 1);         
		return cal.getTime();
	}
	
	
	public static String timestamp2String(Timestamp timestamp, String pattern) {
		if (timestamp == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(new Date(timestamp.getTime()));
	}

	public static String date2String(java.util.Date date, String pattern) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("timestamp null illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
			;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	public static String getDataSecond()
	{
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return fmt.format(new Date());
	}
	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	public static String currentTimestamp2String(String pattern) {
		return timestamp2String(currentTimestamp(), pattern);
	}

	public static Timestamp string2Timestamp(String strDateTime, String pattern) {
		if (strDateTime == null || strDateTime.equals("")) {
			throw new java.lang.IllegalArgumentException("Date Time Null Illegal");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = PATTERN_STANDARD;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(strDateTime);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return new Timestamp(date.getTime());
	}

	public static Date string2Date(String strDate, String pattern) {
		if (strDate == null || strDate.equals("")) {
			throw new RuntimeException("str date null");
		}
		if (pattern == null || pattern.equals("")) {
			pattern = DateUtil.PATTERN_DATE;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;

		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		return date;
	}

	public static String stringToYear(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return String.valueOf(c.get(Calendar.YEAR));
	}

	public static String stringToMonth(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.MONTH));
		int month = c.get(Calendar.MONTH);
		month = month + 1;
		if (month < 10) {
			return "0" + month;
		}
		return String.valueOf(month);
	}

	public static String stringToDay(String strDest) {
		if (strDest == null || strDest.equals("")) {
			throw new java.lang.IllegalArgumentException("str dest null");
		}

		Date date = string2Date(strDest, DateUtil.PATTERN_DATE);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		// return String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		int day = c.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			return "0" + day;
		}
		return "" + day;
	}

	public static Date getFirstDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = 1;
		c.set(year, month, day, 0, 0, 0);
		return c.getTime();
	}

	public static Date getLastDayOfMonth(Calendar c) {
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;
		int day = 1;
		if (month > 11) {
			month = 0;
			year = year + 1;
		}
		c.set(year, month, day - 1, 0, 0, 0);
		return c.getTime();
	}

	public static String date2GregorianCalendarString(Date date) {
		if (date == null) {
			throw new java.lang.IllegalArgumentException("Date is null");
		}
		long tmp = date.getTime();
		GregorianCalendar ca = new GregorianCalendar();
		ca.setTimeInMillis(tmp);
		try {
			XMLGregorianCalendar t_XMLGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(ca);
			return t_XMLGregorianCalendar.normalize().toString();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new java.lang.IllegalArgumentException("Date is null");
		}

	}

	public static boolean compareDate(Date firstDate, Date secondDate) {
		if (firstDate == null || secondDate == null) {
			throw new java.lang.RuntimeException();
		}

		String strFirstDate = date2String(firstDate, "yyyy-MM-dd");
		String strSecondDate = date2String(secondDate, "yyyy-MM-dd");
		if (strFirstDate.equals(strSecondDate)) {
			return true;
		}
		return false;
	}
	
	public static Date getStartTimeOfDate(Date currentDate) {
		Assert.notNull(currentDate);
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 00:00:00";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	
	public static Date getEndTimeOfDate(Date currentDate) {
		Assert.notNull(currentDate);
		String strDateTime = date2String(currentDate,"yyyy-MM-dd") + " 23:59:59";
		return string2Date(strDateTime,"yyyy-MM-dd hh:mm:ss");
	}
	//获取两个时间相差秒数
	public static Long timeDifference(Date date) {
		long end=date.getTime();
		long start=new Date().getTime();
		return (start-end)/1000;
	}
	public static String getSerialVersionUID() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return fmt.format(new Date()) + new Random().nextInt(1000000);
	}
	
	public static void main(String[] args){
		String str1 = "2011-01-01";
		String str2 = "1988-09-09";
		Date date1 = DateUtil.string2Date(str1, "yyyy-MM-dd");
		Date date2 = DateUtil.string2Date(str2, "yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(date1);
		c2.setTime(date2);
		c2.add(Calendar.YEAR, 4);
		if (c2.before(c1)) {
			System.out.println("illegal");
		}else {
			System.out.println("ok");
		}
	}
}