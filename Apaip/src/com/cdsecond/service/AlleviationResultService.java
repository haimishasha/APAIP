package com.cdsecond.service;

import com.cdsecond.view.AlleviationResultView;


public class AlleviationResultService {
	/**
	 * 组合查询 得到sql
	 * @param 
	 * @return String
	 */
	public static String getStudentSql(AlleviationResultView view){
		StringBuffer sql = new StringBuffer("select stu_id,stu_name,stu_sex,c.c_name class_name,stu_phone,stu_edu,"
				+ "stu_school,stu_major,to_char(stu_startyear,'yyyy-mm-dd') s_startyear,stu_state from g3_student s,g3_stuclass c"
				+ " where stu_delete = 0 and s.c_id = c.c_id");

		return sql.toString();
		
	}	
}
