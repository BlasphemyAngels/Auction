package com.wc.web.EL;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class MyEL {
	public static String formatDate(Timestamp d){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		return sf.format(d);
	}
}
