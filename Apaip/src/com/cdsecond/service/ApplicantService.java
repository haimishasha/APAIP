package com.cdsecond.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cdsecond.bean.Applicant;
import com.cdsecond.common.GetTotalRecords;
import com.cdsecond.dao.ApplicantDao;

/**
 * 
 * @author yaoyanyan
 * 说明：这个类用来处理业务逻辑
 * 		进行servlet与dao链接
 *
 */
public class ApplicantService {

	/**
	 * 无参构造方法
	 */
	public ApplicantService() {
		
	}
	
	public static boolean addApplicant(Applicant applicant) throws ClassNotFoundException, SQLException, IOException{
		
		boolean flag = true;
		
		ApplicantDao dao = new ApplicantDao();
		
		flag = dao.addApplicant(applicant);
		
		return flag;
	}

	public static boolean deleteApplicant(String applicantID) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = true;
		
		ApplicantDao dao = new ApplicantDao();
		
		flag = dao.deleteApplicant(applicantID);
		
		return flag;
	}
	
	public static List<Applicant> selectApplicant(Applicant applicant,int currentPage) throws ClassNotFoundException, SQLException, IOException {
		
		ApplicantDao dao = new ApplicantDao();
		
		String s = dao.sqlStatement(applicant);
		
		List<Applicant> list = dao.selectApplicant(s, currentPage);
		
		return list;
	}
	
	public static boolean updateApplicant(Applicant applicant) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = true;
		
		ApplicantDao dao = new ApplicantDao();
		
		flag = dao.updateApplicant(applicant);
		
		return flag;
	}
	
	public static int getTotalRecords() throws ClassNotFoundException, SQLException, IOException{
		
		int totalPages = 0;
		
		totalPages = GetTotalRecords.getTotalRecords("applicant_info");
		
		return totalPages;
				
	}
}

