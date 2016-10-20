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
		StringBuffer sql = new StringBuffer("select * from dictionary where 1=1");
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
	public static List<Dictionary> allDic(int current, String sq) throws SQLException{
		Connection con = DBUtil.getConnection();
		List<Dictionary> list = new ArrayList<Dictionary>();
		int startnum = Tools.getStartRecord(current);
		String sql=sq+" limit "+startnum+" , 10";
		ResultSet rs = null;
		PreparedStatement pstmt = con.prepareStatement(sql);
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
		String sql="select count(*) num from ("+sq +") a";
		System.out.println(sql);
		ResultSet rs;
		PreparedStatement pstmt = con.prepareStatement(sql);
//		 pstmt.setString(1, sq);
		pstmt.execute();
		 rs = pstmt.getResultSet();
		 System.out.println(rs.next()+"--------");
		 if(rs.next()){
			int abc =rs.getInt("num");
			System.out.println(abc+"********");
			
		 totalnum = abc/10;
		 }
			DBUtil.closeCon(pstmt);
			DBUtil.closeCon(con);
		
		
			 return totalnum;
	}
	/**
	 * 获取字典内容
	 * @param id
	 * @return Teacher
	 * @throws SQLException
	 */
	public static Dictionary getOneDictionary(int id) throws SQLException{
		Connection con = DBUtil.getConnection();
		Dictionary dic= new Dictionary();
		String sql ="select * from Dictionary  dicID="+id;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			pstmt=con.prepareStatement(sql);
//			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				dic.setDicID(String.valueOf(rs.getInt("dicID")));
				dic.setDicName(rs.getString("dicName"));
				dic.setDicType(rs.getString("dicType"));
				dic.setDicDescription(rs.getString("dicDescription"));
			}

			DBUtil.closeCon(rs);
			DBUtil.closeCon(pstmt);
			DBUtil.closeCon(con);
		return dic;
	}
	public static void main(String[] args) throws SQLException {
		DictionaryDao dic = new DictionaryDao();

		int a = dic.getMaxPage("select * from dictionary");
//		List list = dic.allDic(1, dic.getDicSql(null,null));
		System.out.println(a);
//		for(int i = 0 ; i< list.size();i++){   
//            
//            System.out.println(list.get(i).toString());   
//        }   
	}
}
