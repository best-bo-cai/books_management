package com.java.util;
/**
 * ÅĞ¶Ï×Ö·û´®ÊÇ·ñÎª¿Õ
 * @author admin
 *
 */
public class StringNull {
	/**
	 * ÅĞ¶ÏÊÇ·ñÎª¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str)  {
		if(str==null||"".equals(str.trim())) {
			return true;//1Õæ
		}else {
			return false;//0¼Ù
		}
	}
	/**
	 * ÅĞ¶ÏÊÇ·ñ²»Îª¿Õ
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if(str!=null&&!"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
}
