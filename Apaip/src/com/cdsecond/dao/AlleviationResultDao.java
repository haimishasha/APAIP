package com.cdsecond.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdsecond.bean.AlleviationResult;
import com.cdsecond.bean.AlleviationSituation;
import com.cdsecond.tools.DBUtil;
import com.cdsecond.tools.Tools;

public class AlleviationResultDao {
	/**
	 * 对于扶贫结果的录入功能（数据库的插入）
	 * @param alleviationSituation
	 * @return 成功插入与否
	 * @throws SQLException
	 */
	public static boolean addAlleviationResult(AlleviationResult alleviationResult) throws SQLException{
		boolean result = false;
		Connection con = DBUtil.getConnection();
		String sql = "insert into alleviation_result values(alleviation_result.nextval,?,?,"+Tools.str2date(alleviationResult.getRegisterTime())+","+Tools.str2date(alleviationResult.getAlleviationStartTime())+","+Tools.str2date(alleviationResult.getAlleviationEndTime())+",?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, alleviationResult.getApplicantID());
		pstmt.setString(2, alleviationResult.getRegistrant());
		pstmt.setString(3, alleviationResult.getRegisterTime());
		pstmt.setString(4, alleviationResult.getAlleviationStartTime());
		pstmt.setString(5, alleviationResult.getAlleviationEndTime());
		pstmt.setString(6, alleviationResult.getResultDescription());
		pstmt.setString(7, alleviationResult.getAlleviationStatus());
		int rs = pstmt.executeUpdate();
		result = (rs==1)?true:false;
		//AlleviationSituationDao.setClassNumber(alleviationSituation.getApplicantID());
		DBUtil.closeCon(con);
		return result;

	}
	/**
	 * 修改扶贫结果表（实时跟新表管理员权限）
	 * @param alleviationSituation
	 * @param id
	 * @return 修改是否成功
	 * @throws SQLException
	 */
	public static boolean updateAlleviationResult(AlleviationResult alleviationResult,int id) throws SQLException{
		boolean result = false;
		Connection con = DBUtil.getConnection();
		String sql = "update alleviation_result set alleviationResultID=?,applicantID=?,registrant=?,"+Tools.str2date(alleviationResult.getRegisterTime())+","+Tools.str2date(alleviationResult.getAlleviationStartTime())+","+Tools.str2date(alleviationResult.getAlleviationEndTime())+",resultDescription=?,alleviationStatus=?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, alleviationResult.getApplicantID());
		pstmt.setString(2, alleviationResult.getRegistrant());
		pstmt.setString(3, alleviationResult.getRegisterTime());
		pstmt.setString(4, alleviationResult.getAlleviationStartTime());
		pstmt.setString(5, alleviationResult.getAlleviationEndTime());
		pstmt.setString(6, alleviationResult.getResultDescription());
		pstmt.setString(7, alleviationResult.getAlleviationStatus());
		int rs = pstmt.executeUpdate();
		result = (rs==1)?true:false;
		//AlleviationSituationDao.setClassNumber(alleviationSituation.getApplicantID());
		DBUtil.closeCon(con);
		return result;

	}
	
	/**
	 * 默认返回扶贫情况的查询结果
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static List<AlleviationResult> getClassStudent(Long id) throws SQLException{
		List<AlleviationResult> list = new ArrayList<AlleviationResult>();
		Connection con =DBUtil.getConnection();
		String sql = "select * from alleviation_result";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		AlleviationResult  alleviationResult= null;
		while(rs.next()){
			alleviationResult = new AlleviationResult();
			pstmt.setInt(1, alleviationResult.getApplicantID());
			pstmt.setString(2, alleviationResult.getRegistrant());
			pstmt.setString(3, alleviationResult.getRegisterTime());
			pstmt.setString(4, alleviationResult.getAlleviationStartTime());
			pstmt.setString(5, alleviationResult.getAlleviationEndTime());
			pstmt.setString(6, alleviationResult.getResultDescription());
			pstmt.setString(7, alleviationResult.getAlleviationStatus());
			list.add(alleviationResult);
		}
		DBUtil.closeCon(rs);
		DBUtil.closeCon(pstmt);
		DBUtil.closeCon(con);
		return list;
	}
		
}
