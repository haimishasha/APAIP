package com.cdsecond.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author yaoyanyan
 * 
 * 目标：获取数据库连接所需属性
 * 说明：这个类用来获取数据库连接所需的各种属性
 * 实现：通过对属性文件mysql.properties的读取，获取到其中的value值。
 * 		创建静态方法getProperty(String key,String filePath)，key,filePath为参数，当我们想要获取到value值时，我们通过
 * 		调用该方法，输入key,filePath的值，然后获取到value的值，即数据库属性值。
 */

public class GetSqlProperties {
	
	/**
	 * 无参构造方法
	 */
	public GetSqlProperties() {
		
	}
	
	/**
	 * 说明：通过key值和文件路径值获取到value值，及数据库连接属性值
	 * @param key
	 * @param filePath
	 * @return value(key对应的value 值)
	 * @throws IOException 
	 */
	public static String getProperty(String key,String filePath) throws IOException{
		
		String value = null;
		
		Properties prop = new Properties();
		
		
		//读取属性文件mysql.properties
		InputStream in = new BufferedInputStream(new FileInputStream(filePath));
		//加载属性列表
		prop.load(in);
		//根据key值获取到value的值
		value = prop.getProperty(key);
		//关闭数据流
		in.close();
		
		return value;
	}
	

}
