package com.wc.web.EL;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MyEL {
	public static String formatDate(Date d){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��  hh:mm:ss");
		return sf.format(d);
	}
}
