package com.cdsecond.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cdsecond.bean.Applicant;
import com.cdsecond.common.IsEmpty;
import com.cdsecond.common.MySqlConnection;

/**
 * 
 * @author yaoyanyan
 * 
 * 说明：这个类是对数据库进行操作的类，在这个类中，我们可以进行数据的增删改查操作
 *
 */

public class ApplicantDao {
	
	/**
	 * 无参构造方法
	 */
	public ApplicantDao() {
		
	}
	
	/**
	 * 说明：这个方法是添加申请人的方法，在这个方法中，我们进行申请人信息的录入工作
	 * 		我们通过获取申请人信息，将申请人信息添加进数据库，最后返回是否成功（true为成功，false为失败）
	 * @param applicant
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public boolean addApplicant(Applicant applicant) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = true;		//返回值标志flag
		
		Connection con = null;		
		
		PreparedStatement pstmt = null;
		
		String sql = "insert into applicant_info(applicantName,applicantSex,applicantNation,"				//sql语句
				+ "applicantIdNumber,applicantPhone,applicantAddress,applicantFamilyNumber,"
				+ "applicantDisabilityNumber,applicantDisablityCondition,applicantIncome,houseArea,"
				+ "education,marriage,applicationTime,povertyRank,applicantStatus,bankCardNumber,"
				+ "applicantReason) value(?,?,?,?,?,?,?,?,?,?,?,?,?,str_to_date(?,'%Y-%m-%d'),?,?,?,?)";
		
		//获取申请人属性值
		
		String applicantName = applicant.getApplicantName();		//获取申请人姓名
		
		String applicantSex = applicant.getApplicantSex();		//获取申请人性别
		
		String applicantNation = applicant.getApplicantNation();		//获取申请人民族
		
		String applicantIdNumber = applicant.getApplicantIdNumber();	//获取申请人身份证号
		
		String applicantDisabilityNumber = applicant.getApplicantDisabilityNumber();//获取申请人残疾证号
		
		String applicantAddress = applicant.getApplicantAddress();	//获取户籍所在地
		
		int applicantFamilyNumber = applicant.getApplicantFamilyNumber();	//获取家庭人数
		
		String applicantDisablityCondition = applicant.getApplicantDisablityCondition(); //获取残疾状况
		
		String applicantPhone = applicant.getApplicantPhone();		//获取联系方式
		
		double applicantIncome = applicant.getApplicantIncome();		//获取家庭收入
		
		double houseArea = applicant.getHouseArea();			//获取住房面积
		
		String education = applicant.getEducation();			//获取受教育程度
		
		String marriage = applicant.getMarriage();			//获取婚姻状况
		
		String applicationTime = applicant.getApplicantTime();		//获取申请时间
		
		String povertyRank = applicant.getPovertyRank();			//获取贫困等级
				
		String bankCardNumber = applicant.getBankCardNumber();		//获取银行卡号
		
		String applicantReason = applicant.getApplicantReason();		//获取申请理由
		
		con = MySqlConnection.getConnection();		//连接数据库
		
		pstmt = con.prepareStatement(sql);			//发送sql语句到数据库
		
		//为占位符赋值
		pstmt.setString(1, applicantName);
		
		pstmt.setString(2,applicantSex);
		
		pstmt.setString(3, applicantNation);
		
		pstmt.setString(4, applicantIdNumber);
		
		pstmt.setString(5, applicantPhone);
		
		pstmt.setString(6, applicantAddress);
		
		pstmt.setInt(7, applicantFamilyNumber);
		
		pstmt.setString(8, applicantDisabilityNumber);
		
		pstmt.setString(9, applicantDisablityCondition);
		
		pstmt.setDouble(10, applicantIncome);
		
		pstmt.setDouble(11, houseArea);
		
		pstmt.setString(12, education);
		
		pstmt.setString(13, marriage);
		
		pstmt.setString(14,applicationTime);
		
		pstmt.setString(15, povertyRank);
		
		pstmt.setInt(16, 1);
		
		pstmt.setString(17, bankCardNumber);
		
		pstmt.setString(18, applicantReason);
		
		//执行sql语句
		pstmt.execute();
		
		
		//关闭连接
		MySqlConnection.close(null, pstmt, con);
		
		return flag;
		
	}
	
	
	
	
	/**
	 * 说明：这个方法是删除申请人的方法，在这个方法中，我们进行申请人信息的删除工作
	 * 		我们通过获取申请人id，从数据库中找到该申请人，并将其状态信息改为0，最后返回是否成功（true为成功，false为失败）
	 * @param applicantID
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public boolean deleteApplicant(String applicantID) throws ClassNotFoundException, SQLException, IOException{
		
		boolean flag = true;	//返回值标志位
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
	
		//sql语句
		String sql = "update applicant_info set applicantStatus = 0 where applicantID = " + Integer.parseInt(applicantID);
		
		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		//执行sql语句
		pstmt.execute();
		
		//关闭连接
		MySqlConnection.close(null, pstmt, con);
		
		return flag;
	}
	
	
	/**
	 * 说明：这个方法是修改申请人的方法，在这个方法中，我们进行申请人信息的修改工作
	 * 		我们通过获取申请人id，将该申请人修改后的信息存入数据库，最后返回是否成功（true为成功，false为失败）
	 * @param applicantID
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	
	public boolean updateApplicant(Applicant applicant) throws ClassNotFoundException, SQLException, IOException{
		
		boolean flag = true;		//返回值标志位
		
		Connection con = null;
		
		PreparedStatement pstmt  = null;
		
		//获取申请人属性值
		String applicantID = applicant.getApplicantID();		//获取申请人ID
		
		String applicantName = applicant.getApplicantName();		//获取申请人姓名
		
		String applicantSex = applicant.getApplicantSex();		//获取申请人性别
		
		String applicantNation = applicant.getApplicantNation();		//获取申请人民族
		
		String applicantIdNumber = applicant.getApplicantIdNumber();	//获取申请人身份证号
		
		String applicantDisabilityNumber = applicant.getApplicantDisabilityNumber();//获取申请人残疾证号
		
		String applicantAddress = applicant.getApplicantAddress();	//获取户籍所在地
		
		int applicantFamilyNumber = applicant.getApplicantFamilyNumber();	//获取家庭人数
		
		String applicantDisablityCondition = applicant.getApplicantDisablityCondition(); //获取残疾状况
		
		String applicantPhone = applicant.getApplicantPhone();		//获取联系方式
		
		double applicantIncome = applicant.getApplicantIncome();		//获取家庭收入
		
		double houseArea = applicant.getHouseArea();			//获取住房面积
		
		String education = applicant.getEducation();			//获取受教育程度
		
		String marriage = applicant.getMarriage();			//获取婚姻状况
		
		String applicationTime = applicant.getApplicantTime();		//获取申请时间
		
		String povertyRank = applicant.getPovertyRank();			//获取贫困等级
				
		String bankCardNumber = applicant.getBankCardNumber();		//获取银行卡号
		
		String applicantReason = applicant.getApplicantReason();		//获取申请理由


		String sql = "update applicant_info set applicantName = '" + applicantName 
				+ "', applicantSex = '" + applicantSex + "' , applicantNation = '"+ applicantNation + "' , "
				+ "applicantIdNumber = '" + applicantIdNumber+"' , applicantPhone = '"+applicantPhone + "' , "
				+ "applicantAddress = '" + applicantAddress + "' , applicantFamilyNumber = "+ applicantFamilyNumber + ","
				+ "applicantDisabilityNumber = '"+applicantDisabilityNumber + "' , applicantDisablityCondition = '"+applicantDisablityCondition + "',"
				+ "applicantIncome = "+applicantIncome+" , houseArea = "+houseArea+" , education = '"+education+"' ,"
				+ "marriage = '"+ marriage+"' , applicationTime = str_to_date('"+applicationTime+"','%Y-%m-%d') ,"
				+ "povertyRank = '"+povertyRank+"' , bankCardNumber = '"+bankCardNumber+"' , applicantReason = '"+applicantReason
				+"' " + " where applicantID = '" + applicantID+ "'";
		
		

		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		System.out.println(sql);
		
		//执行sql语句
		pstmt.execute();
		
		//关闭连接
		MySqlConnection.close(null, pstmt, con);
		
		return flag;
	}
	
	/**
	 * 说明：这个方法是查询申请人的方法，在这个方法中，我们进行申请人信息的查询工作
	 * 		最后返回申请人列表
	 * @param s
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public List<Applicant> selectApplicant(String s,int currentPage) throws ClassNotFoundException, SQLException, IOException {
		
		//创建申请人列表
		List<Applicant> list = new ArrayList<Applicant>();
		
		Connection con = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = "select applicantID,applicantName,applicantSex,applicantNation,"				//sql语句
				+ "applicantIdNumber,applicantPhone,applicantAddress,applicantFamilyNumber,"
				+ "applicantDisabilityNumber,applicantDisablityCondition,applicantIncome,houseArea,"
				+ "education,marriage,applicationTime,povertyRank,applicantStatus,bankCardNumber,"
				+ "applicantReason from applicant_info where " + s + " order by applicantID limit " 
				+ (currentPage-1)*10 + ", "+ 10*currentPage + " ";
		
		//连接数据库
		con = MySqlConnection.getConnection();
		
		//发送sql语句
		pstmt = con.prepareStatement(sql);
		
		System.out.println(sql+"****************");
		
		pstmt.execute();
		
		//执行sql语句
		rs = pstmt.getResultSet();
		
		Applicant applicant = null;
		
		while(rs.next()) {
			
			applicant = new Applicant();
			
			applicant.setApplicantID(String.valueOf(rs.getInt("applicantID")));
			
			applicant.setApplicantName(rs.getString("applicantName"));
			
			applicant.setApplicantSex(rs.getString("applicantSex"));
			
			applicant.setApplicantNation(rs.getString("applicantNation"));
			
			applicant.setApplicantIdNumber(rs.getString("applicantIdNumber"));
			
			applicant.setApplicantPhone(rs.getString("applicantPhone"));
			
			applicant.setApplicantAddress(rs.getString("applicantAddress"));
			
			applicant.setApplicantFamilyNumber(rs.getInt("applicantFamilyNumber"));
			
			applicant.setApplicantDisabilityNumber(rs.getString("applicantDisabilityNumber"));
			
			applicant.setApplicantIncome(rs.getDouble("applicantIncome"));
			
			applicant.setHouseArea(rs.getDouble("houseArea"));
			
			applicant.setEducation(rs.getString("education"));
			
			applicant.setMarriage(rs.getString("marriage"));
			
			applicant.setApplicantTime(rs.getString("applicationTime"));
			
			applicant.setPovertyRank(rs.getString("povertyRank"));
			
			applicant.setBankCardNumber(rs.getString("bankCardNumber"));
			
			applicant.setApplicantReason(rs.getString("applicantReason"));
		
			list.add(applicant);
			
			
		}
		

		//返回申请人列表
		return list;
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
	public int getTotalRecords(String tableNames) throws ClassNotFoundException, SQLException, IOException {
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
	
	/**
	 * 说明：这个方法用于sql语句的拼接，用于查询方法中条件的拼接
	 * @param applicant
	 * @return
	 */
	public String sqlStatement(Applicant applicant){
		
		String s = null;
		
		StringBuffer sf = new StringBuffer(" applicantStatus = 1 ");
		
		//获取申请人属性值
		String applicantID = applicant.getApplicantID();		//获取申请人ID
		
		String applicantName = applicant.getApplicantName();		//获取申请人姓名
		
		String applicantSex = applicant.getApplicantSex();		//获取申请人性别
		
		String applicantNation = applicant.getApplicantNation();		//获取申请人民族
		
		String applicantIdNumber = applicant.getApplicantIdNumber();	//获取申请人身份证号
		
		String applicantDisabilityNumber = applicant.getApplicantDisabilityNumber();//获取申请人残疾证号
		
		String applicantAddress = applicant.getApplicantAddress();	//获取户籍所在地
		
		int applicantFamilyNumber = applicant.getApplicantFamilyNumber();	//获取家庭人数
		
		String applicantDisablityCondition = applicant.getApplicantDisablityCondition(); //获取残疾状况
		
		String applicantPhone = applicant.getApplicantPhone();		//获取联系方式
		
		double applicantIncome = applicant.getApplicantIncome();		//获取家庭收入
		
		double houseArea = applicant.getHouseArea();			//获取住房面积
		
		String education = applicant.getEducation();			//获取受教育程度
		
		String marriage = applicant.getMarriage();			//获取婚姻状况
		
		String applicationTime = applicant.getApplicantTime();		//获取申请时间
		
		String povertyRank = applicant.getPovertyRank();			//获取贫困等级
				
		String bankCardNumber = applicant.getBankCardNumber();		//获取银行卡号
		
		String applicantReason = applicant.getApplicantReason();		//获取申请理由

		
		if(!IsEmpty.isEmpty(applicantID)){
			
			sf.append(" and applicantID = " + applicantID + " ");
		}
		
		if(!IsEmpty.isEmpty(applicantName)) {
			sf.append(" and applicantName like %" + applicantName + "% ");
		}
		
		if(!IsEmpty.isEmpty(applicantSex)) {
			sf.append(" and applicantSex = %" + applicantSex + "% ");
		}
		
		if(!IsEmpty.isEmpty(applicantNation)) {
			sf.append(" and applicantNation like %" + applicantNation + "% ");
		}

		if(!IsEmpty.isEmpty(applicantIdNumber) ) {
			sf.append(" and applicantIdNumber like %"  + applicantIdNumber + "% ");
		}
		
		if(!IsEmpty.isEmpty(applicantPhone)) {
			sf.append(" and applicantPhone like %" + applicantPhone + "% ");
		}
		
		if(!IsEmpty.isEmpty(applicantAddress)) {
			sf.append(" and applicantAddress like %" + applicantAddress + "% ");
		}
		
		if(applicantFamilyNumber != 0) {
			sf.append(" and applicantFamilyNumber like %" + applicantFamilyNumber + "% ");
			
		}
		
		if(!IsEmpty.isEmpty(applicantDisabilityNumber)) {
			sf.append(" and applicantDisabilityNumber like %" + applicantDisabilityNumber + "% ");
		}
		
		if(!IsEmpty.isEmpty(applicantDisablityCondition)) {
			sf.append(" and applicantDisablityCondition like %" + applicantDisablityCondition + "% ");
		}
		
		if(applicantIncome != 0.0) {
			sf.append(" and applicantIncome = " + applicantIncome +" ");
		}
		
		if(houseArea != 0.0) {
			sf.append(" and houseArea = " + houseArea + " ");
		}
		
		if(!IsEmpty.isEmpty(education)) {
			sf.append(" and education like %" + education + "% ");
		}
		
		if(!IsEmpty.isEmpty(marriage)) {
			sf.append(" and marriage like %" + marriage + "%");
		}
		
		if(!IsEmpty.isEmpty(applicationTime)) {
			sf.append(" and applicationTime like %"  + applicationTime + "% ");
		}
		
		if(!IsEmpty.isEmpty(povertyRank)) {
			sf.append(" and povertyRank like %" + povertyRank + "% ");
		}
		
		if(!IsEmpty.isEmpty(bankCardNumber)) {
			sf.append(" and bankCardNumber like %" + bankCardNumber + "% ");
		}
		
		if(!IsEmpty.isEmpty(applicantReason)) {
			sf.append(" and applicantReason like %" + applicantReason  +"% ");
		}
		
		s = sf.toString();
		
		return s;
	}	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		ApplicantDao dao = new ApplicantDao();
		
//		try {
//			List<Applicant> list = dao.selectApplicant(" applicantStatus = 1 ",1);
//			
//			
//			for(Applicant a:list){
//				
//				System.out.println(a.getApplicantName());
//				
//				System.out.println(a.getApplicantAddress());
//				
//				System.out.println(a.getApplicantDisabilityNumber());
//			}
//			
//	
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
//		int totalRecords = dao.getTotalRecords("applicant_info");
//		
//		System.out.println(totalRecords);
		
//		try {
			boolean flag = dao.deleteApplicant("1");
			System.out.println(flag);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Applicant a = new Applicant();
//		
//		a.setApplicantName("王五");
//		
//		a.setApplicantSex("男");
//		
//		a.setApplicantNation("汉族");
//		
//		a.setApplicantIdNumber("142723199403080882");
//		
//		a.setApplicantPhone("18435155844");
//		
//		a.setApplicantAddress("成都");
//		
//		a.setApplicantFamilyNumber(5);
//		
//		a.setApplicantDisabilityNumber("123456789");
//		
//		a.setApplicantDisablityCondition("生活不能自理");
//		
//		a.setApplicantIncome(1000.5);
//		
//		a.setHouseArea(50.0);
//		
//		a.setEducation("小学");
//		
//		a.setMarriage("未婚");
//		
//		a.setApplicantTime("2016-10-18");
//		
//		a.setPovertyRank("0");
//		
//		a.setApplicantStatus(1);
//		
//		a.setBankCardNumber("6217000260000247803");
//		
//		a.setApplicantReason("家庭贫困，缺乏经济来源");
//		
//		boolean flag = dao.updateApplicant(a);
//		
//		System.out.println(flag);
//		
//		
//		boolean flag;
//		try {
//			flag = dao.addApplicant(a);
//			System.out.println(flag);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
	}

}
