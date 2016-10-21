package com.cdsecond.common;

import java.lang.reflect.*;
import java.sql.ResultSet;
import java.util.*;

/**
 * 将resultset转换为list对象。目前只支持String 和 int 类型数据的转换
 * 使用方式：
 * 	1、model里面的属性需要和数据库中的字段完全一样
 * 	2、model中的字段全部定义成String
 * @author zhangwang
 *
 */
public class SetToEntity {
	
	public static List<?> resultsettolist(ResultSet rs, Class<?> cls) throws Exception {  
       
		List<Object> list = new ArrayList<Object>(); 
		//获取类中所定义的成员变量
        Field[] fields = cls.getDeclaredFields();  
        
        while (rs.next()) { 
        	//动态生成类的实例
            Object obj = newInstance(cls); 
            for (int i = 0; i < fields.length; i++) {  
            	//获取字段的数据类型（类）
                Class<?> type = fields[i].getType(); 
                //获取字段名称的字符串
                String fieldName = fields[i].getName();
                //String stype=type.getName();
                //if(true){
                //if (type.getName().equals(String.class.getName())) {  
                    String value = rs.getString(fieldName);  
                    setProperty(obj, fieldName, value);  
                //}  
            }  
            list.add(obj);  
        }  
        return list;  
  
    }  
  
    private static Object newInstance(Class<?> cls) throws Exception {  
        return cls.newInstance();  
    }  
  
    private static void setProperty(Object obj, String name, Object value) throws Exception {  
        Class<? extends Object> clazz = obj.getClass();  
        
        String methodName = returnSetMethodName(name);  
        //反射出类中的函数列表
        Method[] ms = clazz.getMethods();  
        for (Method m : ms) {
        	//判断函数名称是否与生成的函数名称相同
            if (m.getName().equals(methodName)) {  
                if (m.getParameterTypes().length == 1) {  
                    Class<?> clazzParameterType = m.getParameterTypes()[0];  
                    setFieldValue(clazzParameterType.getName(), value, m, obj);  
                    break;  
                }  
            }  
        }  
    }  
  
    private static void setFieldValue(String parameterTypeName, Object value, Method m, Object obj) throws Exception {  
        if (parameterTypeName.equals(int.class.getName()) || parameterTypeName.equals(Integer.class.getName())) { 
        	if(value!=null)
        	{
        		value = new Integer(Integer.parseInt(value.toString()));
        	}
        	//==》调用obj.setName(value)
            m.invoke(obj, value);  
            return;  
        }  
        if (parameterTypeName.equals(String.class.getName())) {  
            m.invoke(obj, value);  
            return;  
        }  
    }  
  
    //根据字段名称，动态的构建set访问器名称name ==>setName
    private static String returnSetMethodName(String name) {  
        name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());  
        return "set" + name;  
    }     
}
