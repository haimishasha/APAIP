package com.cdsecond.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsecond.bean.Applicant;
import com.cdsecond.service.ApplicantService;

@SuppressWarnings("serial")
public class ApplicantServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ApplicantServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request,response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		if(action.equals("add")) {
			addApplicant(request, response);
		}
		
		if(action.equals("delete")) {
			deleteApplicant(request,response);
		}
		
		if(action.equals("select")) {
			selectApplicant(request,response);
		}
		
		if(action.equals("update")) {
			updateApplicant(request,response);
		}
		
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	
	private void updateApplicant(HttpServletRequest request,
			HttpServletResponse response) {
		
		String applicantID = request.getParameter("applicantID");
		
		String applicantName = request.getParameter("applicantName");
		
		String applicantSex = request.getParameter("applicantSex");
		
		String applicantNation = request.getParameter("applicantNation");
		
		String applicantIdNumber = request.getParameter("applicantIdNumber");
		
		String applicantPhone = request.getParameter("applicantPhone");
		
		String applicantAddress = request.getParameter("applicantAddress");
		
		int  applicantFamilyNumber = 0;
		
		try{
			applicantFamilyNumber = Integer.valueOf(request.getParameter("applicantFamilyNumber"));
		}catch(NumberFormatException e){
			
			applicantFamilyNumber = 0;
		}
		
		String applicantDisabilityNumber = request.getParameter("applicantDisabilityNumber");
		
		String applicantDisablityCondition = request.getParameter("applicantDisablityCondition");
		
		double applicantIncome = 0.0;
		
		try{
			applicantIncome = Double.valueOf(request.getParameter("applicantIncome"));
		}catch(NumberFormatException e) {
			applicantIncome = 0.0;
		}
		
		double houseArea = 0.0;
		
		try{
			houseArea = Double.valueOf(request.getParameter("houseArea"));
		}catch(NumberFormatException e ) {
			houseArea = 0.0;
		}
		
		String education = request.getParameter("education");
		
		String marriage = request.getParameter("marriage");
		
		String applicationTime = request.getParameter("applicationTime");
		
		String povertyRank = request.getParameter("povertyRank");
		
		String bankCardNumber = request.getParameter("bankCardNumber");
		
		String applicantReason = request.getParameter("applicantReason");
		
		Applicant applicant = new Applicant();
		
		applicant.setApplicantID(applicantID);
		
		applicant.setApplicantName(applicantName);
		
		applicant.setApplicantSex(applicantSex);
		
		applicant.setApplicantNation(applicantNation);
		
		applicant.setApplicantIdNumber(applicantIdNumber);
		
		applicant.setApplicantPhone(applicantPhone);
		
		applicant.setApplicantAddress(applicantAddress);
		
		applicant.setApplicantFamilyNumber(applicantFamilyNumber);
		
		applicant.setApplicantDisabilityNumber(applicantDisabilityNumber);
		
		applicant.setApplicantDisablityCondition(applicantDisablityCondition);
		
		applicant.setApplicantIncome(applicantIncome);
		
		applicant.setHouseArea(houseArea);
		
		applicant.setEducation(education);
		
		applicant.setMarriage(marriage);
		
		applicant.setApplicantTime(applicationTime);
		
		applicant.setPovertyRank(povertyRank);
		
		applicant.setBankCardNumber(bankCardNumber);
		
		applicant.setApplicantReason(applicantReason);
		
		try {
			if(ApplicantService.updateApplicant(applicant)) {
				
			}else{
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void selectApplicant(HttpServletRequest request,
			HttpServletResponse response) {
		
		int currentPage = 0;
		
		try{
			currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}catch(NumberFormatException e) {
			currentPage = 1;
		}
		
		String applicantName = request.getParameter("applicantName");
		
		String applicantSex = request.getParameter("applicantSex");
		
		String applicantNation = request.getParameter("applicantNation");
		
		String applicantIdNumber = request.getParameter("applicantIdNumber");
		
		String applicantPhone = request.getParameter("applicantPhone");
		
		String applicantAddress = request.getParameter("applicantAddress");
		
		int  applicantFamilyNumber = 0;
		
		try{
			applicantFamilyNumber = Integer.valueOf(request.getParameter("applicantFamilyNumber"));
		}catch(NumberFormatException e){
			
			applicantFamilyNumber = 0;
		}
		
		String applicantDisabilityNumber = request.getParameter("applicantDisabilityNumber");
		
		String applicantDisablityCondition = request.getParameter("applicantDisablityCondition");
		
		double applicantIncome = 0.0;
		
		try{
			applicantIncome = Double.valueOf(request.getParameter("applicantIncome"));
		}catch(NumberFormatException e) {
			applicantIncome = 0.0;
		}
		
		double houseArea = 0.0;
		
		try{
			houseArea = Double.valueOf(request.getParameter("houseArea"));
		}catch(NumberFormatException e ) {
			houseArea = 0.0;
		}
		
		String education = request.getParameter("education");
		
		String marriage = request.getParameter("marriage");
		
		String applicationTime = request.getParameter("applicationTime");
		
		String povertyRank = request.getParameter("povertyRank");
		
		String bankCardNumber = request.getParameter("bankCardNumber");
		
		String applicantReason = request.getParameter("applicantReason");
		
		Applicant applicant = new Applicant();
		
		applicant.setApplicantName(applicantName);
		
		applicant.setApplicantSex(applicantSex);
		
		applicant.setApplicantNation(applicantNation);
		
		applicant.setApplicantIdNumber(applicantIdNumber);
		
		applicant.setApplicantPhone(applicantPhone);
		
		applicant.setApplicantAddress(applicantAddress);
		
		applicant.setApplicantFamilyNumber(applicantFamilyNumber);
		
		applicant.setApplicantDisabilityNumber(applicantDisabilityNumber);
		
		applicant.setApplicantDisablityCondition(applicantDisablityCondition);
		
		applicant.setApplicantIncome(applicantIncome);
		
		applicant.setHouseArea(houseArea);
		
		applicant.setEducation(education);
		
		applicant.setMarriage(marriage);
		
		applicant.setApplicantTime(applicationTime);
		
		applicant.setPovertyRank(povertyRank);
		
		applicant.setBankCardNumber(bankCardNumber);
		
		applicant.setApplicantReason(applicantReason);
		
		try {
			List<Applicant> list = ApplicantService.selectApplicant(applicant, currentPage);
			
			request.setAttribute("list", list);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void deleteApplicant(HttpServletRequest request,
			HttpServletResponse response) {
		
		String applicantID = request.getParameter("applicantID");
		
		try {
			if(ApplicantService.deleteApplicant(applicantID)) {
				
			}else{
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void addApplicant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String applicantName = request.getParameter("applicantName");
		
		String applicantSex = request.getParameter("applicantSex");
		
		String applicantNation = request.getParameter("applicantNation");
		
		String applicantIdNumber = request.getParameter("applicantIdNumber");
		
		String applicantPhone = request.getParameter("applicantPhone");
		
		String applicantAddress = request.getParameter("applicantAddress");
		
		int  applicantFamilyNumber = 0;
		
		try{
			applicantFamilyNumber = Integer.valueOf(request.getParameter("applicantFamilyNumber"));
		}catch(NumberFormatException e){
			
			applicantFamilyNumber = 0;
		}
		
		String applicantDisabilityNumber = request.getParameter("applicantDisabilityNumber");
		
		String applicantDisablityCondition = request.getParameter("applicantDisablityCondition");
		
		double applicantIncome = 0.0;
		
		try{
			applicantIncome = Double.valueOf(request.getParameter("applicantIncome"));
		}catch(NumberFormatException e) {
			applicantIncome = 0.0;
		}
		
		double houseArea = 0.0;
		
		try{
			houseArea = Double.valueOf(request.getParameter("houseArea"));
		}catch(NumberFormatException e ) {
			houseArea = 0.0;
		}
		
		String education = request.getParameter("education");
		
		String marriage = request.getParameter("marriage");
		
		String applicationTime = request.getParameter("applicationTime");
		
		String povertyRank = request.getParameter("povertyRank");
		
		String bankCardNumber = request.getParameter("bankCardNumber");
		
		String applicantReason = request.getParameter("applicantReason");
		
		Applicant applicant = new Applicant();
		
		applicant.setApplicantName(applicantName);
		
		applicant.setApplicantSex(applicantSex);
		
		applicant.setApplicantNation(applicantNation);
		
		applicant.setApplicantIdNumber(applicantIdNumber);
		
		applicant.setApplicantPhone(applicantPhone);
		
		applicant.setApplicantAddress(applicantAddress);
		
		applicant.setApplicantFamilyNumber(applicantFamilyNumber);
		
		applicant.setApplicantDisabilityNumber(applicantDisabilityNumber);
		
		applicant.setApplicantDisablityCondition(applicantDisablityCondition);
		
		applicant.setApplicantIncome(applicantIncome);
		
		applicant.setHouseArea(houseArea);
		
		applicant.setEducation(education);
		
		applicant.setMarriage(marriage);
		
		applicant.setApplicantTime(applicationTime);
		
		applicant.setPovertyRank(povertyRank);
		
		applicant.setBankCardNumber(bankCardNumber);
		
		applicant.setApplicantReason(applicantReason);
		
		try {
			
			if(ApplicantService.addApplicant(applicant)){
				
				
			}else{
				
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
