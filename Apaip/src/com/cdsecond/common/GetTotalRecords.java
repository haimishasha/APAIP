package com.cdsecond.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author yaoyanyan
 *
 *说明：这个类用于获取表中的总记录数
 */
public class GetTotalRecords {
	/**
	 * 无参构造方法
	 */
	public GetTotalRecords() {
	}
	
	/**
	 * 说明：这个方法用于查询数据的总记录数
	 * @param tableNames
	 * @return
	 * @throws  
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static int getTotalRecords(String tableNames) throws ClassNotFoundException, SQLException, IOException {
		//定义总记录数
		int totalRecords = 0;
		
		Connection con = null;
		
		PreparedStatement pstmt  = null;
		
		ResultSet rs = null;
		
		String sql = "select count(*) num from " + tableNames;
		
		//连接数据库 
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		//执行sql语句
		pstmt.execute();
		
		rs = pstmt.getResultSet();
		
		while(rs.next()){
			totalRecords = rs.getInt("num");
		}
		
		//返回总记录数
		return totalRecords;
	}
	

}
