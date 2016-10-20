package com.cdsecond.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsecond.bean.Dictionary;
import com.cdsecond.dao.DictionaryDao;

public class DictionarySevlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PovertyMeasureSevlet() {
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

		doPost(request, response);
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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String main=request.getParameter("main");

		if(main.equals("EditStart")){
			EditStart(request, response);			
		}else if(main.equals("edit")){
			edit(request,response);
		}else if(main.equals("List")){
			list(request,response);
		}else if(main.equals("Det")){
			det(request, response);
		}else if(main.equals("delete")){
			delete(request, response);
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
	/**
	 * 初始进入添加界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void EditStart(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		/**
		 * 修改时获取到需要修改的人物信息，若无信息，则为添加界面
		 */
		String ids = request.getParameter("id");
		request.setAttribute("id", ids);
		int id = Integer.parseInt(ids);
		Dictionary dictionary;
		try {
			dictionary = DictionaryDao.getOneDictionary(id);
			request.setAttribute("dictionary", dictionary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("dictionary/dictionaryEdit.jsp").forward(request, response);
		
	}
	/**
	 * 添加界面提交
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void edit(HttpServletRequest request,HttpServletResponse response) {
		
		String ids = request.getParameter("id");
		Dictionary a = new Dictionary();
		a.setTitle(request.getParameter("act_title"));
		a.setContext(request.getParameter("act_content"));
		a.setState(request.getParameter("act_state"));
		
		
		
		
		
	}
	
	
	
	

}
