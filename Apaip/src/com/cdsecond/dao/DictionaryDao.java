package com.cdsecond.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.cdsecond.bean.Dictionary;
import com.cdsecond.common.MySqlConnection;
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
		System.out.println(sql);
		ResultSet rs = null;
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.execute();
		 rs = pstmt.getResultSet();
			Dictionary dic = null;
//			System.out.println(rs);
//			System.out.println(rs.next()+"----");
			while(rs.next()){
//				System.out.println(rs.next()+"--");
				dic = new Dictionary();
				dic.setDicID(rs.getString(1));
				System.out.println(rs.getString(1));
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
//		 System.out.println(rs);
//		 System.out.println(rs.next()+"--------");
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
	
	
	/**
	 * 说明：这个方法是添加数据字典的方法，在这个方法中，我们进行申请人信息的录入工作
	 * 		我们通过获取申请人信息，将申请人信息添加进数据库，最后返回是否成功（true为成功，false为失败）
	 * @param dictionary
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public boolean addDictionary(Dictionary dictionary) throws ClassNotFoundException, SQLException, IOException {
		Connection con = null;	
		int a;
		boolean result = false;
		
		PreparedStatement pstmt = null;
		String sql = "insert into Dictionary(dicName,dicType,dicDescription) value(?,?,?)";
		String dicName = dictionary.getDicName();		//获取姓名
		
		String dicType = dictionary.getDicType();		//获取类型
		
		String dicDescriptionn = dictionary.getDicDescription();//获取描述
		
		con = MySqlConnection.getConnection();		//连接数据库
		
		pstmt = con.prepareStatement(sql);			//发送sql语句到数据库
		
		//为占位符赋值
				pstmt.setString(1, dicName);
				
				pstmt.setString(2,dicType);
				
				pstmt.setString(3, dicDescriptionn);
				//执行sql语句
				a=pstmt.executeUpdate();
				result=(a==1)?true:false;

				//关闭连接
				MySqlConnection.close(null, pstmt, con);
				return result;
	}
	/**
	 * 删除数据字典
	 * @param ids
	 * @return boolean
	 * @throws SQLException
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */public static boolean deleteDictionary(int id) throws SQLException, ClassNotFoundException, IOException{
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = null;
			boolean result = false;
			String sql="delete dictionary  where dicID="+id;
			//连接数据库
			con = MySqlConnection.getConnection();
			
			//发送sql语句
			pstmt = con.prepareStatement(sql);
			
			//执行sql语句
			int a=0;
			a=pstmt.executeUpdate();
			result=(a==1)?true:false;
			
			//关闭连接
			MySqlConnection.close(null, pstmt, con);
			return result;
		}
	 /**
		 * 修改数据字典
		 * @param dictionary
		 * @param id
		 * @return boolean
		 * @throws SQLException
		 */
	 public boolean updateDictionary(Dictionary dictionary) throws ClassNotFoundException, SQLException, IOException{
			
			Connection con = null;
			int a;
			boolean result = false;
			
			
			PreparedStatement pstmt  = null;
			String dicID = dictionary.getDicID();
			int id = Integer.parseInt(dicID);
			String dicName = dictionary.getDicName();		//获取姓名
			
			String dicType = dictionary.getDicType();		//获取类型
			
			String dicDescription = dictionary.getDicDescription();//获取描述
			
			String sql = "update Dictionary set dicName = '"+dicName +"', dicType = '"+dicType+"' , Description = '"+dicDescription+"' " + " where dicID = '" + id+ "'";
			
			//连接数据库
			con = MySqlConnection.getConnection();
			pstmt = con.prepareStatement(sql);
			
			//发送sql语句
			a=pstmt.executeUpdate();
			result=(a==1)?true:false;
			
			pstmt.setString(1, dicName);
			
			pstmt.setString(2,dicType);
			
			pstmt.setString(3, dicDescription);
		
			//关闭连接
			MySqlConnection.close(null, pstmt, con);
			
			return result;
		}
}
