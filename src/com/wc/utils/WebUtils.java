package com.wc.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * web模块用的的工具类
 * @author ccl
 *
 */
public class WebUtils {
	/**
	 * 将request中的信息转换成表
	 * @param request request实例
	 * @param beanClass 要转换成的类的CLass
	 * @return 转换成的类的实例
	 */
	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass) {
		try {
			T bean = beanClass.newInstance();
			Enumeration<String> e = request.getParameterNames();
			while (e.hasMoreElements()) {
				String name = e.nextElement();
				String value = request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	/**
	 * 两个类的深拷贝
	 * @param src 源类
	 * @param dest 目的类
	 */
	public static void copyBean(Object src, Object dest) {
		try {
			BeanUtils.copyProperties(dest, src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static String formatDate(Timestamp d){
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		return sf.format(d);
	}
	public static String formatDate(Date d, String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(d);
	}
	
	/**
	 * 产生在互联网中独一无二的ID
	 * @return string类型的ID
	 */
	public static String generateId() {
		return UUID.randomUUID().toString();
	}
}
