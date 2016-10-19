package com.cdsecond.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdsecond.bean.Dictionary;
import com.cdsecond.tools.DBUtil;
import com.cdsecond.tools.Tools;

public class DictionaryDao {
	private static int totalnum = 0;
	/**
	 * 数据字典模糊查询及拼接sql语句
	 * @param dic_type
	 * @param dic_name
	 * @return String
	 */
	public static String getDicSql(String dicType,String dicDescription){
		StringBuffer sql = new StringBuffer("select dicID,dicName,dicType,dicDescription from dictionary where 1=1");
		if(!Tools.isEmpty(dicType)){
			sql.append(" and dicType = '"+dicType+"'");
		}
		if(!Tools.isEmpty(dicDescription)){
			sql.append(" and dicDescription like '"+Tools.getSelect(dicDescription)+"'");
		}
		return sql.toString();
	}
	/**
	 * 获取当前页数的记录
	 * @param startnum
	 * @param sq
	 * @return list
	 * @throws SQLException
	 */
	public static List<Dictionary> allDic(int startnum, String sq) throws SQLException{
		Connection con = DBUtil.getConnection();
		List<Dictionary> list = new ArrayList<Dictionary>();
		String sql="select * from ? limit ? ,10";
		ResultSet rs = null;
		PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, sq);
		 pstmt.setInt(2, startnum);
		 rs = pstmt.executeQuery();
			Dictionary dic = null;
			while(rs.next()){
				dic = new Dictionary();
				dic.setDicID(rs.getString(1));
				dic.setDicName(rs.getString(2));
				dic.setDicType(rs.getString(3));
				dic.setDicDescription(rs.getString(4));
				list.add(dic);
			}
			
			DBUtil.closeCon(rs);
			DBUtil.closeCon(pstmt);
			DBUtil.closeCon(con);
		
		
		return list;
		
	}
	/**
	 * 获取总页数的方法
	 * @param sq
	 * @return int
	 * @throws SQLException
	 */
	public static int getMaxPage(String sq) throws SQLException{
		
		Connection con = DBUtil.getConnection();
		String sql="select count(*) from ?";
		ResultSet rs;
		PreparedStatement pstmt = con.prepareStatement(sql);
		 pstmt.setString(1, sq);
		 rs = pstmt.executeQuery();
		 while(rs.next()){
			int abc =rs.getInt(1);
			
		 totalnum = abc/10;
		 }
			DBUtil.closeCon(pstmt);
			DBUtil.closeCon(con);
		
		
			 return totalnum;
	}
	
}
