package com.cdsecond.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author yaoyanyan
 * 
 * 目标：实现Java与mysql的连接。
 * 说明：这个类是用来进行数据库连接的，本项目中，我们使用mysql数据库来进行连接。
 *     数据库的属性通过属性文件mysql.properties来获取。
 * 具体实现：我们首先创建一个getConnection()方法，通过该方法，我们可以连接Java与mysql数据库。
 * 		其次，我们应该关闭连接，具体关闭Connection，ResultSet，preparedStatement。
 */

public class MySqlConnection {
	/**
	 * 无参构造方法
	 */
	public MySqlConnection() {
		
	}
	
	/**
	 * 创建静态方法getConnection()获取连接，最后返回一个Connection对象
	 * @return	con (Connection 对象)
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException{
		//创建Connection对象
		Connection con = null;
		//加载驱动程序，抛出一个ClassNotFound异常
		Class.forName(GetSqlProperties.getProperty("driver", "file/mysql.properties"));
		//建立Oracle与Java的连接,抛出SQLException异常
		con = DriverManager.getConnection(GetSqlProperties.getProperty("url", "file/mysql.properties"),GetSqlProperties.getProperty("userName", "file/mysql.properties"),GetSqlProperties.getProperty("password", "file/mysql.properties"));
		
		System.out.println("连接成功");
		//返回Connection对象
		return con;
	}
	
	/**
	 * 最后,不要忘了关闭连接，关闭连接有三个步骤：
	 * （1）关闭ResultSet；
	 * （2）关闭PreparedStatement；
	 * （3）关闭Connection
	 * 创建静态方法close(ResultSet rs,PreparedStatement pstmt,Connection con)来关闭连接
	 * @param rs
	 * @param call
	 * @param con
	 * @throws SQLException
	 */
	 
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		//关闭rs
		if(rs != null){
			rs.close();
		}
		//关闭call
		if(pstmt != null) {
			pstmt.close();
		}
		//关闭con
		if(con != null){
				con.close();
		}
	}
	
	
}
