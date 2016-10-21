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
import com.cdsecond.bean.Dictionary;
import com.cdsecond.bean.PoorDemandItem;
import com.cdsecond.common.IsEmpty;
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
		
		System.out.println(action+"-------------");
		PrintWriter out = response.getWriter();
		
		if(action.equals("add")) {
			addApplicant(request, response,out);
		}
		
		if(action.equals("delete")) {
			deleteApplicant(request,response,out);
		}
		
		if(action.equals("select")) {
			selectApplicant(request,response,out);
		}
		
		if(action.equals("update")) {
			updateApplicant(request,response,out);
		}
		
		if(action.equals("getDic")) {
			selectDictionary(request, response,out);
		}
		
		
		
		
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
			HttpServletResponse response,PrintWriter out) {
		
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
		}catch(NullPointerException e) {
			applicantFamilyNumber = 0;
		}
		
		String applicantDisabilityNumber = request.getParameter("applicantDisabilityNumber");
		
		String applicantDisablityCondition = request.getParameter("applicantDisablityCondition");
		
		double applicantIncome = 0.0;
		
		try{
			applicantIncome = Double.valueOf(request.getParameter("applicantIncome"));
		}catch(NumberFormatException e) {
			applicantIncome = 0.0;
		}catch(NullPointerException e){
			applicantIncome = 0.0;
		}
		
		double houseArea = 0.0;
		
		try{
			houseArea = Double.valueOf(request.getParameter("houseArea"));
		}catch(NumberFormatException e ) {
			houseArea = 0.0;
		}catch(NullPointerException e) {
			houseArea = 0.0;
		}
		
		String education = request.getParameter("education");
		
		String marriage = request.getParameter("marriage");
		
		String applicationTime = request.getParameter("applicationTime");
		
		String povertyRank = request.getParameter("povertyRank");
		
		String bankCardNumber = request.getParameter("bankCardNumber");
		
		String applicantReason = request.getParameter("applicantReason");
		
		String[] applicantDemand = request.getParameterValues("applicantDemand");
		
		System.out.println(applicantDemand + "----------------");
		
		StringBuffer sf = new StringBuffer();
		
		for (int i = 0;i<applicantDemand.length;i++) {
			
			if(i<applicantDemand.length){
			
			sf.append(applicantDemand[i]+"、");
			}else{
				sf.append(applicantDemand[i]);
			}
			
		}
		
		String demand = sf.toString();
		
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
		
		applicant.setApplicantDemand(demand);
		
		
		try {
			if(ApplicantService.updateApplicant(applicant)){
				
				response.sendRedirect("ApplicantServlet?action=select");
				
			}else{
				

				out.println("<script>alert('添加失败')</script>");
				out.println("<script>window.location='jsp/ApplicantInfo/applicant-add.jsp'</script>");
				out.flush();
				out.close();
				
			}
		} catch (ClassNotFoundException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (SQLException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (IOException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}
		
		
	}

	@SuppressWarnings("unused")
	private void selectApplicant(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out) {
		
	
		
		int currentPage = 0;
		
		try{
			if(Integer.valueOf(request.getParameter("currentPage"))>0){
			
				currentPage = Integer.valueOf(request.getParameter("currentPage"));
			}else{
				currentPage = 1;
			}
		}catch(NumberFormatException e) {
			currentPage = 1;
		}catch(NullPointerException e) {
			currentPage = 1;
		}
		
		String applicantID = request.getParameter("applicantID");
		
		System.out.println(applicantID+"*****************id");
		
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
		}catch(NullPointerException e) {
			applicantIncome = 0.0;
		}
		
		double houseArea = 0.0;
		
		try{
			houseArea = Double.valueOf(request.getParameter("houseArea"));
		}catch(NumberFormatException e ) {
			houseArea = 0.0;
		}catch(NullPointerException e) {
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
			List<Applicant> list = ApplicantService.selectApplicant(applicant, currentPage);
			
			int totalRecords = list.size();
			if(list != null || totalRecords!=0) {
				request.setAttribute("list", list);
				request.setAttribute("totalRecords", totalRecords);
				request.setAttribute("currentPage", currentPage);
				
				
				
				
				
				if(!IsEmpty.isEmpty(applicantID)){
					Applicant applicant2 = list.get(0);
					
					
					request.setAttribute("applicant", applicant2);
					
					selectDictionary(request, response,out);
				}else{
				
				request.getRequestDispatcher("jsp/ApplicantInfo/applicant-table.jsp").forward(request, response);
				}	
				
			}else{
				out.print("<script>alert('没有找到数据')</script>");
				out.flush();
				out.close();
			}
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (SQLException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (IOException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}catch (ServletException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}catch(NullPointerException e){

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}
		
		
		
	}

	public void deleteApplicant(HttpServletRequest request,
			HttpServletResponse response, PrintWriter out) {
		
		String applicantID = request.getParameter("applicantID");
		
		try {
			if(ApplicantService.deleteApplicant(applicantID)) {
				
				response.sendRedirect("ApplicantServlet?action=select");
				
			}else{
				
			
				
				out.print("<script>alert('删除失败')</script>");
				out.flush();
				out.close();
				
			}
		} catch (ClassNotFoundException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (SQLException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (IOException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}
		
		
	}
	
	

	public void addApplicant(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
			throws ServletException, IOException {
		
		System.out.println("sdsdsdfsfsf------------------");
		
		
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
		}catch(NullPointerException e){
			applicantIncome = 0.0;
		}
		
		double houseArea = 0.0;
		
		try{
			houseArea = Double.valueOf(request.getParameter("houseArea"));
		}catch(NumberFormatException e ) {
			houseArea = 0.0;
		}catch(NullPointerException e){
			houseArea = 0.0;
		}
		
		String education = request.getParameter("education");
		
		String marriage = request.getParameter("marriage");
		
		String applicationTime = request.getParameter("applicationTime");
		
		String povertyRank = request.getParameter("povertyRank");
		
		String bankCardNumber = request.getParameter("bankCardNumber");
		
		String applicantReason = request.getParameter("applicantReason");
		
		String[] applicantDemand = request.getParameterValues("applicantDemand");
		
		System.out.println(applicantDemand + "----------------");
		
		StringBuffer sf = new StringBuffer();
		String demand = null;
		try{
		for (int i = 0;i<applicantDemand.length;i++) {
			
			if(i<applicantDemand.length){
			
			sf.append(applicantDemand[i]+"、");
			}else{
				sf.append(applicantDemand[i]);
			}
			
		}
		
		demand = sf.toString();
		}catch(NullPointerException e) {
			demand = null;
		}
		
	
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
		
		applicant.setApplicantDemand(demand);
		
		try {
			
			if(ApplicantService.addApplicant(applicant)){
				
				response.sendRedirect("jsp/ApplicantInfo/applicant-add.jsp");
				
			}else{
				

				out.println("<script>alert('添加失败')</script>");
				out.println("<script>window.location='jsp/ApplicantInfo/applicant-add.jsp'</script>");
				out.flush();
				out.close();
				
			}
		} catch (ClassNotFoundException e) {
			
			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
			
		} catch (SQLException e) {
			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}
	} 
	
	
	
	public void selectDictionary(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out) {
		
		System.out.println("------------------------------");
		
		try {
			List<Dictionary> education = ApplicantService.getEducation();
			
			request.setAttribute("education", education);
			
			List<Dictionary> marriage = ApplicantService.getMarriage();
			
			request.setAttribute("marriage",marriage );
			
			List<PoorDemandItem> poorDemandList = ApplicantService.getPoorDemandItem();
			
			request.setAttribute("poorDemandList", poorDemandList);
			
			String go = request.getParameter("go");
			
			if(go.equals("add")){
						
				request.getRequestDispatcher("jsp/ApplicantInfo/applicant-add.jsp").forward(request, response);
			}
				
			if(go.equals("update")){
			
				request.getRequestDispatcher("jsp/ApplicantInfo/applicant-update.jsp").forward(request, response);

			}
			
			if(go.equals("detail")){
				
				request.getRequestDispatcher("jsp/ApplicantInfo/applicant-detail.jsp").forward(request, response);

			}
			
			
			
		} catch (ClassNotFoundException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (SQLException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		} catch (IOException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
		}catch (ServletException e) {

			out.println("<script>window.location='html/404.html'</script>");
			out.flush();
			out.close();
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
