package com.cdsecond.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdsecond.bean.SelectionNotes;
import com.cdsecond.common.IsEmpty;
import com.cdsecond.common.MySqlConnection;

/**
 * 
 * @author yaoyanyan
 * 
 * 说明：这个类是对数据库进行操作的类，在这个类中，我们可以进行数据的增删改查操作
 *
 */
public class SelectionNotesDao {
	/**
	 * 无参构造方法
	 */
	public SelectionNotesDao() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 说明：这个方法是添加申请评选须知的方法，在这个方法中，我们进行申请评选须知的录入工作
	 * 		我们通过获取申请评选须知内容，将申请评选须知添加进数据库，最后返回是否成功（true为成功，false为失败）
	 * @param selectionNotes
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	
	public boolean addSelectionNotes(SelectionNotes selectionNotes) throws ClassNotFoundException, SQLException, IOException {
		
		//返回值标志位
		boolean flag = true;
		
		Connection con = null;
		
		PreparedStatement pstmt  = null;
		
		String sql = "insert into selection_notes(notesName,applyTime,applyPerson,applyStartTime,applyEndTime,applyContent,"
				+ "applyStatus) values (?,str_to_date(?,'%Y-%m-%d'),?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'),?,?)";
		
		//获取申请评选须知属性
		String notesName = selectionNotes.getNotesName();
		
		String applyTime = selectionNotes.getApplyTime();
		
		String applyPerson = selectionNotes.getApplyPerson();
		
		String applyStartTime = selectionNotes.getApplyStartTime();
		
		String applyEndTime = selectionNotes.getApplyEndTime();
		
		String applyContent = selectionNotes.getApplyContent();
		
		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		//为占位符赋值
		pstmt.setString(1, notesName);
		
		pstmt.setString(2, applyTime);
		
		pstmt.setString(3, applyPerson);
		
		pstmt.setString(4, applyStartTime);
		
		pstmt.setString(5, applyEndTime);
		
		pstmt.setString(6, applyContent);
		
		pstmt.setInt(7, 1);
		
		System.out.println(sql);
		//执行sql语句
		pstmt.execute();
		
		//关闭连接
		MySqlConnection.close(null, pstmt, con);
		
		//返回返回值
		return flag;
		
	}

	/**
	 * 说明：这个方法是查询申请评选须知的方法，在这个方法中，我们进行申请评选须知的查询工作
	 * 		最后我们取出评选须知内容，放入列表中。
	 * @param selectionNotes
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public List<SelectionNotes> selectSelectionNotes(String s,int currentPage) throws ClassNotFoundException, SQLException, IOException{
		//定义评选须知列表
		List<SelectionNotes> list = new ArrayList<SelectionNotes>();
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = "select selectionNotesID,notesName,applyTime,applyPerson,applyStartTime,applyEndTime,applyContent "
				+ "from selection_notes where " + s + " order by selectionNotesID limit " 
						+ (currentPage-1)*10 + ", "+ currentPage*10 + " ";;
		
		System.out.println(sql);
		
		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		//执行sql语句 
		pstmt.execute();
		
		//获取结果集
		rs = pstmt.getResultSet();
		//循环结果集中的内容
		while(rs.next()){
			//定义申请评选须知
			SelectionNotes selectionNotes = new SelectionNotes();
			
			selectionNotes.setSelectionNotesID(String.valueOf(rs.getInt("selectionNotesID")));
			
			selectionNotes.setNotesName(rs.getString("notesName"));
			
			selectionNotes.setApplyTime(rs.getString("applyTime"));
			
			selectionNotes.setApplyPerson(rs.getString("applyPerson"));
			
			selectionNotes.setApplyStartTime(rs.getString("applyStartTime"));
			
			selectionNotes.setApplyEndTime(rs.getString("applyEndTime"));
			
			selectionNotes.setApplyContent(rs.getString("applyContent"));
			
			list.add(selectionNotes);
		}
		
		System.out.println(list+"--------------------dao");
		//返回评选须知列表
		return list;
	}
	
	/**
	 * 说明：这个类用于sql语句条件的拼凑
	 * @param selectionNotes
	 * @return
	 */
	
	public String sqlStatement(SelectionNotes selectionNotes){
		String s = null;
		
		//获取申请评选须知属性
		String selectionNotesID = selectionNotes.getSelectionNotesID();
		
		String notesName = selectionNotes.getNotesName();
		
		String applyTime = selectionNotes.getApplyTime();
		
		String applyPerson = selectionNotes.getApplyPerson();
		
		String applyStartTime = selectionNotes.getApplyStartTime();
		
		String applyEndTime = selectionNotes.getApplyEndTime();
		
		String applyContent = selectionNotes.getApplyContent();
		
		
		StringBuffer sf = new StringBuffer(" applyStatus = 1 ");
		
		if(!IsEmpty.isEmpty(selectionNotesID)) {
			sf.append(" and selectionNotesID = '" + selectionNotesID + "'");
		}
		
		if(!IsEmpty.isEmpty(notesName)) {
			sf.append(" and notesName like '%" + notesName + "%'");
		}
		
		if(!IsEmpty.isEmpty(applyTime)) {
			sf.append( " and applyTime like '%" + applyTime + "%'");
		}
		
		if(!IsEmpty.isEmpty(applyPerson)) {
			sf.append( "and applyPerson like '%" + applyPerson + "%'");
		}
		
		if(!IsEmpty.isEmpty(applyStartTime)) {
			sf.append(" and applyStartTime like '%" + applyStartTime + "%'");
		}
		
		if(!IsEmpty.isEmpty(applyEndTime)) {
			sf.append(" and applyEndTime like '%" + applyEndTime + "%' ");
		}
		
		if (!IsEmpty.isEmpty(applyContent)) {
			sf.append(" and applyContent like '%" +applyContent + "%'");
		}
		
		s = sf.toString();
		
		return s;
		
	}
	/**
	 * 说明：这个方法用于修改申请评选须知
	 * @param selectionNotes
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	
	public boolean updateSelectionNotes(SelectionNotes selectionNotes) throws ClassNotFoundException, SQLException, IOException{
		//返回值标志位
		boolean flag = true;
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		//获取申请评选须知属性
		String selectionNotesID = selectionNotes.getSelectionNotesID();
		
		String notesName = selectionNotes.getNotesName();
		
		String applyTime = selectionNotes.getApplyTime();
		
		String applyPerson = selectionNotes.getApplyPerson();
		
		String applyStartTime = selectionNotes.getApplyStartTime();
		
		String applyEndTime = selectionNotes.getApplyEndTime();
		
		String applyContent = selectionNotes.getApplyContent();
		
		String sql = "update selection_notes set notesName = '" + notesName + "',"
				+ "applyTime = '" + applyTime + "', applyPerson = '" + applyPerson 
				+ "', applyStartTime = '" + applyStartTime + "', applyEndTime = '"+ applyEndTime
				+"', applyContent  = '" + applyContent + "' where selectionNotesID = '"
						+ selectionNotesID + "' ";
		
		System.out.println(sql);
		
		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		//执行sql语句
		pstmt.execute();
		
		//关闭连接
		MySqlConnection.close(null, pstmt, con);
				
		//返回返回值
		return flag;
		
	}
	
	/**
	 * 说明:这个类用于删除申请评选须知
	 * @param selectionNotesID
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public boolean deleteSelectionNotes(String selectionNotesID) throws ClassNotFoundException, SQLException, IOException {
		
		//返回值标志位
		boolean flag = true;
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		String sql = "update selection_notes set applyStatus = 0 where selectionNotesID = " + Integer.parseInt(selectionNotesID);
		
		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		//执行sql语句
		pstmt.execute();
		
		//关闭连接
		MySqlConnection.close(null, pstmt, con);
		
		//返回返回值
		return flag;
	}
	

	
}
