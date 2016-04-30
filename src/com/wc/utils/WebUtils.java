package com.wc.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

/**
 * webģ���õĵĹ�����
 * @author ccl
 *
 */
public class WebUtils {
	/**
	 * ��request�е���Ϣת���ɱ�
	 * @param request requestʵ��
	 * @param beanClass Ҫת���ɵ����CLass
	 * @return ת���ɵ����ʵ��
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
	 * ����������
	 * @param src Դ��
	 * @param dest Ŀ����
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
		SimpleDateFormat sf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		return sf.format(d);
	}
	public static String formatDate(Date d, String format){
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.format(d);
	}
	
	/**
	 * �����ڻ������ж�һ�޶���ID
	 * @return string���͵�ID
	 */
	public static String generateId() {
		return UUID.randomUUID().toString();
	}
}
