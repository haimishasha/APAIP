package com.cdsecond.tools;

import java.net.URI;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 与数据库的连接
 * @author zhangjian
 *
 */
public class DBUtil {
	
	 //驱动名称
	static String driver = "com.mysql.jdbc.Driver";
	 //URL连接数据库
	static String url = "jdbc:mysql://localhost/apaip";
	//MySQL用户名
	static String user = "root";
	//MySQL密码
	static String password = "root";
	
	/**
	 * 关闭连接，session
	 * @param con
	 */
	public static void closeCon(Connection con){

		if(con !=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭pstmt
	 * @param pstmt
	 */
	public static void closeCon(PreparedStatement pstmt){

		if(pstmt !=null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭rs
	 * @param rs
	 */
	public static void closeCon(ResultSet rs){

		if(rs !=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 关闭call
	 * @param call
	 */
	public static void closeCon(CallableStatement call){

		if(call !=null){
			try {
				call.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
/**
 * 获取到mysql数据库额连接
 * @return Connection
 */
	public static Connection getConnection(){
	
		Connection con = null;
		
		try {
			Class.forName(driver);
				con = DriverManager.getConnection(url,user,password);
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
		
}


