package com.cdsecond.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cdsecond.bean.AlleviationSituation;
import com.cdsecond.tools.DBUtil;
import com.cdsecond.tools.Tools;



public class AlleviationSituationDao {

	/**
	 * 对于扶贫情况的录入功能（数据库的插入）
	 * @param alleviationSituation
	 * @return 成功添加与否
	 * @throws SQLException
	 */
	public static boolean addAlleviationSituation(AlleviationSituation alleviationSituation) throws SQLException{
		boolean result = false;
		Connection con = DBUtil.getConnection();
		String sql = "insert into alleviation_stiuation values(alleviation_stiuation.nextval,?,"+Tools.str2date(alleviationSituation.getStartTime())+","+Tools.str2date(alleviationSituation.getStartTime())+",?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, alleviationSituation.getApplicantID());
		pstmt.setString(2, alleviationSituation.getStartTime());
		pstmt.setString(3, alleviationSituation.getEndTime());
		pstmt.setString(4, alleviationSituation.getAlleviationDetail());
		pstmt.setInt(5, alleviationSituation.getAlleviationDelete());
		int rs = pstmt.executeUpdate();
		result = (rs==1)?true:false;
		//AlleviationSituationDao.setClassNumber(alleviationSituation.getApplicantID());
		DBUtil.closeCon(con);
		return result;

	}
	/**
	 * 修改扶贫情况表（实时跟新表管理员权限）
	 * @param alleviationSituation
	 * @param id
	 * @return 修改是否成功
	 * @throws SQLException
	 */
	public static boolean updateAlleviationSituation(AlleviationSituation alleviationSituation,int id) throws SQLException{
		boolean result = false;
		Connection con = DBUtil.getConnection();
		String sql = "update alleviation_stiuation set alleviationSituationID=?,applicantID=?,"+Tools.str2date(alleviationSituation.getStartTime())+","+Tools.str2date(alleviationSituation.getEndTime())+",alleviationDetail=?,alleviationDelete=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, alleviationSituation.getApplicantID());
		pstmt.setString(2, alleviationSituation.getStartTime());
		pstmt.setString(3, alleviationSituation.getEndTime());
		pstmt.setString(4, alleviationSituation.getAlleviationDetail());
		pstmt.setInt(5, alleviationSituation.getAlleviationDelete());
		int rs = pstmt.executeUpdate();
		result = (rs==1)?true:false;
		DBUtil.closeCon(pstmt);
		DBUtil.closeCon(con);
		return result;	
	}
	
	/**
	 * 默认返回扶贫情况的查询结果（刚进入界面显示的数据）
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static List<AlleviationSituation> listAlleviationSituation() throws SQLException{
		List<AlleviationSituation> list = new ArrayList<AlleviationSituation>();
		Connection con =DBUtil.getConnection();
		String sql = "select * from alleviation_situation";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		AlleviationSituation  alleviationSituation= null;
		while(rs.next()){
			alleviationSituation = new AlleviationSituation();
//			Product pro=new Product();
//		    String product_id=rs.getString("product_id");
//		    pro.setProduct_id(product_id);
//		    String product_name=rs.getString("product_name");
//		    pro.setProduct_name(product_name);
//		    float product_price=rs.getFloat("product_price");
//		    pro.setProduct_price(product_price);
//		    list.add(pro);
			
			//pstmt.setInt(0, alleviationSituation.getAlleviationSituationID());
			//pstmt.setInt(0,0);
			String alleviationSituationID=rs.getString("alleviationSituationID");
			int a=Integer.parseInt(alleviationSituationID);
			alleviationSituation.setAlleviationSituationID(a);
			
			
			String applicantID=rs.getString("applicantID");
			int a1=Integer.parseInt(applicantID);
			alleviationSituation.setApplicantID(a1);
			
			//pstmt.setInt(1, alleviationSituation.getApplicantID());
			
			/**时间类型转化为String
			 * String time;  
        		SimpleDateFormat formater = new SimpleDateFormat();  
        		formater.applyPattern("yyyy-MM-dd");  
        		time = formater.format(date);  
        		return time; 
			 */
			
			java.util.Date startTime = rs.getDate(3);
    		SimpleDateFormat formater = new SimpleDateFormat();  
    		formater.applyPattern("yyyy-MM-dd");  
    		String time = formater.format(startTime);  
    		alleviationSituation.setStartTime(time);
    		
    		java.util.Date endTime = rs.getDate(4);
    		SimpleDateFormat formater1 = new SimpleDateFormat();  
    		formater1.applyPattern("yyyy-MM-dd");  
    		String time1 = formater1.format(endTime);  
    		alleviationSituation.setEndTime(time1);
    		

			
			
			String alleviationDetail=rs.getString("alleviationDetail");
			alleviationSituation.setAlleviationDetail(alleviationDetail);
			
			String alleviationDelete=rs.getString("alleviationDelete");
			int a5=Integer.parseInt(alleviationDelete);
			alleviationSituation.setAlleviationDelete(a5);
			
//			pstmt.setString(2, alleviationSituation.getStartTime());
//			pstmt.setString(3, alleviationSituation.getEndTime());
//			pstmt.setString(4, alleviationSituation.getAlleviationDetail());
//			pstmt.setInt(5, alleviationSituation.getAlleviationDelete());
			list.add(alleviationSituation);
		}
		DBUtil.closeCon(rs);
		DBUtil.closeCon(pstmt);
		DBUtil.closeCon(con);
		return list;
	}
	
	
	/**
	 * 返回相应的ID的查询扶贫情况的结果（刚进入界面显示的数据）
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static List<AlleviationSituation> getAlleviationSituation(Long id) throws SQLException{
		List<AlleviationSituation> list = new ArrayList<AlleviationSituation>();
		Connection con =DBUtil.getConnection();
		String sql = "select * from alleviation_stiuation where alleviationSituationID="+id+"";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		AlleviationSituation  alleviationSituation= null;
		while(rs.next()){
			alleviationSituation = new AlleviationSituation();
			pstmt.setInt(1, alleviationSituation.getApplicantID());
			pstmt.setString(2, alleviationSituation.getStartTime());
			pstmt.setString(3, alleviationSituation.getEndTime());
			pstmt.setString(4, alleviationSituation.getAlleviationDetail());
			pstmt.setInt(5, alleviationSituation.getAlleviationDelete());
			list.add(alleviationSituation);
		}
		DBUtil.closeCon(rs);
		DBUtil.closeCon(pstmt);
		DBUtil.closeCon(con);
		return list;
	}
	
	
}
