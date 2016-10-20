package com.cdsecond.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsecond.bean.SelectionNotes;
import com.cdsecond.service.SelectionNotesService;

@SuppressWarnings("serial")
public class SelectionNotesServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectionNotesServlet() {
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
		
		if(action.equals("add")){
			addSelectionNotes(request,response);
		}
		if(action.equals("delete")) {
			deleteSelectionNotes(request,response);
		}
		
		if(action.equals("update")) {
			updateSelectionNotes(request,response);
		}
		
		if(action.equals("select")) {
			selectSelectionNotes(request,response);
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

	private void selectSelectionNotes(HttpServletRequest request,
			HttpServletResponse response) {
		
		int currentPage = 0;
		
		try{
			currentPage = Integer.valueOf(request.getParameter("currentPage"));
		}catch(NumberFormatException e) {
			currentPage = 1;
		}
		
		String selectionNotesID = request.getParameter("selectionNotesID");
		
		String notesName = request.getParameter("notesName");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String applyTime = sdf.format(new Date());
		
		String applyPerson = request.getParameter("applyPerson");
		
		String applyStartTime = request.getParameter("applyStartTime");
		
		String applyEndTime = request.getParameter("applyEndTime");
		
		String applyContent = request.getParameter("applyContent");
		
		//定义申请评选须知
		SelectionNotes selectionNotes = new SelectionNotes();
		
		selectionNotes.setSelectionNotesID(selectionNotesID);
		
		selectionNotes.setNotesName(notesName);
		
		selectionNotes.setApplyTime(applyTime);
		
		selectionNotes.setApplyPerson(applyPerson);
		
		selectionNotes.setApplyStartTime(applyStartTime);
		
		selectionNotes.setApplyEndTime(applyEndTime);
		
		selectionNotes.setApplyContent(applyContent);
		
		try {
			List<SelectionNotes> list = SelectionNotesService.selectSelectionNotes(selectionNotes, currentPage);
			
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

	private void updateSelectionNotes(HttpServletRequest request,
			HttpServletResponse response) {
		
String selectionNotesID = request.getParameter("selectionNotesID");
		
		String notesName = request.getParameter("notesName");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String applyTime = sdf.format(new Date());
		
		String applyPerson = request.getParameter("applyPerson");
		
		String applyStartTime = request.getParameter("applyStartTime");
		
		String applyEndTime = request.getParameter("applyEndTime");
		
		String applyContent = request.getParameter("applyContent");
		
		//定义申请评选须知
		SelectionNotes selectionNotes = new SelectionNotes();
		
		selectionNotes.setSelectionNotesID(selectionNotesID);
		
		selectionNotes.setNotesName(notesName);
		
		selectionNotes.setApplyTime(applyTime);
		
		selectionNotes.setApplyPerson(applyPerson);
		
		selectionNotes.setApplyStartTime(applyStartTime);
		
		selectionNotes.setApplyEndTime(applyEndTime);
		
		selectionNotes.setApplyContent(applyContent);
		
		try {
			if(SelectionNotesService.updateSelectionNotes(selectionNotes)) {
				
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

	private void deleteSelectionNotes(HttpServletRequest request,
			HttpServletResponse response) {
		String selectionNotesID = request.getParameter("selectionNotesID");
		
		try {
			if(SelectionNotesService.deleteSelectionNotes(selectionNotesID)){
				
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

	private void addSelectionNotes(HttpServletRequest request,
			HttpServletResponse response) {
		
		String notesName = request.getParameter("notesName");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String applyTime = sdf.format(new Date());
		
		String applyPerson = request.getParameter("applyPerson");
		
		String applyStartTime = request.getParameter("applyStartTime");
		
		String applyEndTime = request.getParameter("applyEndTime");
		
		String applyContent = request.getParameter("applyContent");
		
		//定义申请评选须知
		SelectionNotes selectionNotes = new SelectionNotes();
		
		selectionNotes.setNotesName(notesName);
		
		selectionNotes.setApplyTime(applyTime);
		
		selectionNotes.setApplyPerson(applyPerson);
		
		selectionNotes.setApplyStartTime(applyStartTime);
		
		selectionNotes.setApplyEndTime(applyEndTime);
		
		selectionNotes.setApplyContent(applyContent);
		
		try {
			if(SelectionNotesService.addSelectionNotes(selectionNotes))	{
				
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
