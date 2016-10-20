package com.cdsecond.tools;

import java.util.ArrayList;
import java.util.List;



/**
 * 公共方法
 * @author zhangjian
 *
 */
public class Tools {
	
	/**
	 * 判断字符串是否非空
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断Long是否为空
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(Long str){
		if(str==null||str.equals("")){
			return true;
		}
		return false;
	}
	
	/**
	 * 把null转化为""
	 * @param str
	 * @return String
	 */
	public static String ToEmpty(String str){
		if(str==null){
			str="";
		}
		return str;

	}
	/**
	 * 获得分页查询的首选项
	 * @param a
	 * @return int
	 */
	
	
	
	public static int getStartRecord(int currentpage){
		int startnum =10*(currentpage-1)+1; 
		return startnum-1;
	}
	
	
	/**
	 * 模糊查询字符串转换
	 * @param str
	 * @return String
	 */
	public static String getSelect(String str){
		return "%"+str+"%";
	}
	
	
	/**
	 * 字符串转化为日期格式
	 * @param str
	 * @return String
	 */
	public static String str2date(String str){
		return "to_date('"+str+"','yyyy-mm-dd')";
	}
	
	
	/**
	 * 日期转化为字符串格式
	 * @param str
	 * @return String
	 */
	public static String date2str(String str){
		return "to_char('"+str+"','yyyy-mm-dd')";
	}

	
	/**
	 * 根据日期是否为空来截取日期，是它只显示年月日
	 * @param date
	 * @return String
	 */
	public static String getDate(String date){
		String str=null;
		if(isEmpty(date)){
			str = date;
		}else{
			str = date.substring(0,10);
		}
		return str;
	}
	
	/**
	 * list倒序
	 * @param list
	 * @return List
	 */
	public static List<Catalog> getList(List<Catalog> list){
		List<Catalog> getList = new ArrayList<Catalog>();
		for(int i=list.size()-1;i>=0;i--){
			getList.add(list.get(i));
		}
		return getList;
	}
	
	/**
	 * 截取字符串
	 * @param str
	 * @return String
	 */
	
	public static String getStringOne2Ten(String str){
		String get = "";
		if(str.length()>8){
			get=str.substring(0, 7)+"...";
		}else{
			get=str;
		}
		return get;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
