package com.cdsecond.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public static List<AlleviationSituation> getClassStudent(Long id) throws SQLException{
		List<AlleviationSituation> list = new ArrayList<AlleviationSituation>();
		Connection con =DBUtil.getConnection();
		String sql = "select * from alleviation_stiuation";
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
