package org.momo.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getTime(String format){
		Date date = new Date();  
	    SimpleDateFormat sdf = new SimpleDateFormat(format);  
	    String dateNowStr = sdf.format(date);  
	    return dateNowStr;
	}

}
