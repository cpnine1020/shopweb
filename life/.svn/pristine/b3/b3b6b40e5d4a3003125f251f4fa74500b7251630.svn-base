package com.xiangxiaole.util.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

	/*
	 * 字符串转date
	 */
	public static Date StrToDate(String str,String formatter){
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);  
	    try {
			return sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	/*
	 * date 转字符串
	 */
	public static String DateToStr(Date date,String formatter){
		if(date==null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);
		return sdf.format(date);
	}
}
