package com.cdsecond.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Resource {

	static {
		Resource resource = new Resource();
		
		InputStream stream = resource.getClass().getResourceAsStream("file/mysql.properties");
		Properties p = new Properties();
		try {
			p.load(stream);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			password = p.getProperty("password");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static String driver;
    private static String url;
    private static String user;
    private static String password;
	public static String getDriver() {
		return driver;
	}
	public static String getUrl() {
		return url;
	}
	public static String getUser() {
		return user;
	}
	public static String getPassword() {
		return password;
	}
}
