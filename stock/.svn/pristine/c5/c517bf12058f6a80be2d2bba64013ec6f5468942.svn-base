package com.ningx.stock.util.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
	
	public static Date StrToDate(String date,String formatter){
		SimpleDateFormat sdf = new SimpleDateFormat(formatter);  
	    Date _date = null;
		try {
			_date = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	    return _date;
	}
}
