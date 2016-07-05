package cn.repair.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;

/**
 * 时间工具类
 * @author Eidolon
 *
 */
public class TimeUtil {
	
	private static SimpleDateFormat format_Y_M = null ;
	private static SimpleDateFormat format_Y_M_D = null ;
	private static SimpleDateFormat format_Y_M_D_H_M = null ;
	private static SimpleDateFormat format_Y_M_D_H_M_S = null ;
	private static SimpleDateFormat format_Y_M_D_H_M_S2 = null ;
	private static SimpleDateFormat format_Y_M_D_H_M_S_MS = null ;
	private static SimpleDateFormat format_H_M = null ;
	private static SimpleDateFormat format_H_M_S = null ;
	private static SimpleDateFormat format_H_M_S_MS = null ;
	private static SimpleDateFormat format_YY_MM_DD = null;
	
	static {
		format_Y_M = new SimpleDateFormat("yyyy-MM");
		format_Y_M_D = new SimpleDateFormat("yyyy-MM-dd") ;
		format_Y_M_D_H_M = new SimpleDateFormat("yyyy-MM-dd HH:mm") ;
		format_Y_M_D_H_M_S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		format_Y_M_D_H_M_S2 = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss") ;
		format_Y_M_D_H_M_S_MS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS") ;
		format_H_M = new SimpleDateFormat("HH:mm") ;
		format_H_M_S = new SimpleDateFormat("HH:mm:ss") ;
		format_H_M_S_MS = new SimpleDateFormat("HH:mm:ss:SSS") ;
		format_YY_MM_DD = new SimpleDateFormat("yyMMdd");
	}
	
	/**时间格式：yyyy-MM-dd*/
	public static final int Y_M = 10 ;
	
	/**时间格式：yyyy-MM-dd*/
	public static final int Y_M_D = 1 ;
	
	/**时间格式：yyyy-MM-dd HH:mm*/
	public static final int Y_M_D_H_M = 2 ;
	
	/**时间格式：yyyy-MM-dd HH:mm:ss*/
	public static final int Y_M_D_H_M_S = 3 ;
	
	/**时间格式：yyyy_MM_dd_HH_mm_ss，天和小时之间有下划线*/
	public static final int Y_M_D_H_M_S2 = 8 ;


	/**时间格式：yyyy-MM-dd HH:mm:ss:SSS*/
	public static final int Y_M_D_H_M_S_MS = 4 ;
	
	/**时间格式：HH:mm*/
	public static final int H_M = 5 ;
	/**时间格式：HH:mm:ss*/
	public static final int H_M_S = 6 ;
	/**时间格式：HH:mm:ss:SSS*/
	public static final int H_M_S_MS = 7 ;
	/**时间格式：YY_MM_DD*/
	public static final int YYMMDD = 9;
	
	/**
	 * 获取当前时间的字符串值
	 * @param flag 字符串格式
	 * @return
	 * @changelog 
	 *
	 */
	public static String getCurrTime(int flag){
		String res = "" ;
		switch (flag) {
		case Y_M:
			res = format_Y_M.format(new Date()) ;
			break;
		case Y_M_D:
			res = format_Y_M_D.format(new Date()) ;
			break;
		case Y_M_D_H_M:
			res = format_Y_M_D_H_M.format(new Date()) ;
			break;
		case Y_M_D_H_M_S:
			res = format_Y_M_D_H_M_S.format(new Date()) ;
			break;
		case Y_M_D_H_M_S2:
			res = format_Y_M_D_H_M_S2.format(new Date()) ;
			break;
		case Y_M_D_H_M_S_MS:
			res = format_Y_M_D_H_M_S_MS.format(new Date()) ;
			break;
		case H_M:
			res = format_H_M.format(new Date()) ;
			break;
		case H_M_S:
			res = format_H_M_S.format(new Date()) ;
			break;
		case H_M_S_MS:
			res = format_H_M_S_MS.format(new Date()) ;
			break;
		case YYMMDD:
			res = format_YY_MM_DD.format(new Date());
		default:
			break;
		}
		return res ;
	}
	
	public static String getYear(){
		String date = getCurrTime(TimeUtil.Y_M_D);
		String year = "";
		if (StringUtils.isNotEmpty(date) && date.length()>4) {
			year = date.substring(0,4);
		}
		return year;
	}
	
	public static String getMonth(){
		String date = getCurrTime(TimeUtil.Y_M_D);
		String month = "";
		if (StringUtils.isNotEmpty(date) && date.length()>7) {
			month = date.substring(5,7);
		}
		return month;
	}
	
	public static String getYear(String date){
		String year = "";
		if (StringUtils.isNotEmpty(date) && date.length()>4) {
			year = date.substring(0,4);
		}
		return year;
	}
	
	public static String getMonth(String date){
		String month = "";
		if (StringUtils.isNotEmpty(date) && date.length()>=7) {
			month = date.substring(5,7);
		}
		return month;
	}
	
	public static Date getCurrentTimeByDiff(float timeDiff){
		int hourDiff = timeDiff<0?(int)Math.floor(timeDiff)+1:(int)Math.floor(timeDiff);
		int minuDiff = (int)((timeDiff-hourDiff)*60);
		Calendar date = Calendar.getInstance();
		Date now = new Date();
		date.setTime(now);
		date.set(Calendar.HOUR_OF_DAY, date.get(Calendar.HOUR_OF_DAY)+hourDiff);
		date.set(Calendar.MINUTE, date.get(Calendar.MINUTE)+minuDiff);
		return date.getTime();
	}
	
	/**
	 * 获取2个日期之间的时间差（单位为秒）
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 * @ChangeLog
	 *
	 */
	public static long getDiffSecond(Date start,Date end){
		return (end.getTime()-start.getTime())/1000 ;
	}
	
	/**
	 * 获取2个日期之间的时间差（单位为分）
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 * @ChangeLog
	 *
	 */
	public static long getDiffMinite(Date start,Date end){
		return (end.getTime()-start.getTime())/(1000*60) ;
	}
	
	/**
	 * 获取2个日期之间的时间差（单位为小时）
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 * @ChangeLog
	 *
	 */
	public static long getDiffHour(Date start,Date end){
		return (end.getTime()-start.getTime())/(1000*60*60) ;
	}
	
	/**
	 * 获取2个日期之间的时间差（单位为天）
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 * @ChangeLog
	 *
	 */
	public static long getDiffDay(Date start,Date end){
		return (end.getTime()-start.getTime())/(1000*60*60*24) ;
	}
	
	public static String format(Date date,int type){
		String res = "" ;
		switch (type) {
		case Y_M_D:
			res = format_Y_M_D.format(date) ;
			break;
		case Y_M_D_H_M:
			res = format_Y_M_D_H_M.format(date) ;
			break;
		case Y_M_D_H_M_S:
			res = format_Y_M_D_H_M_S.format(date) ;
			break;
		case Y_M_D_H_M_S2:
			res = format_Y_M_D_H_M_S2.format(date) ;
			break;
		case Y_M_D_H_M_S_MS:
			res = format_Y_M_D_H_M_S_MS.format(date) ;
			break;
		case H_M:
			res = format_H_M.format(date) ;
			break;
		case H_M_S:
			res = format_H_M_S.format(date) ;
			break;
		case H_M_S_MS:
			res = format_H_M_S_MS.format(date) ;
			break;

		default:
			break;
		}
		return res ;
	}
	
	/**
	 * 增加月中的日期数
	 * @param date 日期
	 * @param days 需要增加的日数
	 * @return
	 */
	public static Date addDayOfMonth(Date date,int days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH)+days);
		Date endTime = calendar.getTime();
		return endTime;
	}
	
	public static String formatMonth(int m){
		String month = "";
		if (m<10) {
			month = "0"+m;
		}else{
			month = ""+m;
		}
		return month;
	}
	
	/**
	 * 根据指定日期，获取一周内所有的天数，从周一开始
	 * 没有处理跨年的问题
	 * @param date
	 * @return
	 */
	public static List<String> getDaysOfWeek(Date date){
		List<String> days = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int diff = 0;
		
		if (dayOfWeek == 1) {
			// 周日
			diff = 6;
		}else{
			// 周一到周六
			diff = dayOfWeek - 2;
		}
		
		// 计算周一的日期
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear - diff);
		days.add(format(calendar.getTime(), Y_M_D));
		
		// 计算本周其他日期
		for (int i = 1; i <= 6; i++) {
			dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
			calendar.set(Calendar.DAY_OF_YEAR, dayOfYear + 1);
			days.add(format(calendar.getTime(), Y_M_D));
		}
		return days;
	}
	
	/**
	 * 判断是否超出当前日期
	 * @param date
	 * @return
	 */
	public static boolean isOverCurrentDate(String date){
		boolean flag = false;
		long time = new Date().getTime();
		try {
			Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			long dtTime = dt.getTime();
			
			if (dtTime > time) {
				flag = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	/**
	 * 时间转化工具
	 * @param dateFormat
	 * @param millSec
	 * @return
	 */
	public static String transferLongToDate(String dateFormat,Long millSec){
	     SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
	     Date date= new Date(millSec);
	            return sdf.format(date);
	}
	public static void main(String[] args) {
		System.out.println(getDaysOfWeek(new Date()));
	}
	
}
