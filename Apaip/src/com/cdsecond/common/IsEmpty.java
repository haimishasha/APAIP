package com.cdsecond.common;
/**
 * 
 * @author yaoyanyan
 * 
 * 说明：这个类用来判断字符串是否为空
 *
 */
public class IsEmpty {
	/**
	 * 无参构造方法
	 */

	public IsEmpty() {
		
	}
	
	/**
	 * 这个方法用来判断字符串是否为空
	 */
	public static boolean isEmpty(String str) {
		
		boolean flag = true;
		
		if(str == null || str.equals("")) {
			
			return flag;
			
		}else{
			
			flag = false;
			
		}
		
		return flag;
		
	}
 
}






























