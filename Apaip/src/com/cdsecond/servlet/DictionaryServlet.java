package com.cdsecond.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsecond.bean.Dictionary;
import com.cdsecond.dao.DictionaryDao;
import com.cdsecond.tools.Tools;

public class DictionaryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DictionaryServlet() {
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
		PrintWriter out = response.getWriter();
		String main=request.getParameter("main");

		if(main.equals("EditStart")){
			EditStart(request, response,out);			
		}else if(main.equals("edit")){
			edit(request,response,out);
		}else if(main.equals("List")){
			List(request,response,out);
		}else if(main.equals("delete")){
			delete(request, response,out);
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
	protected void EditStart(HttpServletRequest request,HttpServletResponse response,PrintWriter out) throws ServletException, IOException{
		/**
		 * 修改时获取到需要修改的人物信息，若无信息，则为添加界面
		 */
		String ids = request.getParameter("id");
		request.setAttribute("id", ids);
		int id = Integer.parseInt(ids);
		Dictionary dictionary;
		List<String> dicType = DictionaryDao.getType();
		request.setAttribute("dicType",dictype);
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void edit(HttpServletRequest request,HttpServletResponse response,PrintWriter out) throws ClassNotFoundException, SQLException, IOException, ServletException {
		
		String ids = request.getParameter("id");
		Dictionary a = new Dictionary();
		a.setDicName(request.getParameter(""));
		a.setDicType(request.getParameter(""));
		a.setDicDescription(request.getParameter(""));
		/**添加**/
		if(Tools.isEmpty(ids)){
			
			if(DictionaryDao.addDictionary(a)){
				request.getRequestDispatcher("ActivityServlet?main=List").forward(request, response);
			}else{
				out.print("添加失败");
				}
			
		}else{
			/**修改**/
			
			if(DictionaryDao.updateDictionary(a, ids)){
				out.print("<a href='ActivityServlet?main=Det&id="+id+"'>修改成功，返回查看</a>");
			}else{
				out.print("<a href='ActivityServlet?main=EditStart&id="+id+"'>修改失败，返回重新修改</a>");
			}
			
		}
		
	}
	/**
	 * 展示界面
	 * @param request
	 * @param response
	 * @param out
	 * @throws SQLException
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void List(HttpServletRequest request, HttpServletResponse response,
			PrintWriter out) throws SQLException, ServletException, IOException{
		/**
		 * 第一次进入为第一页
		 * 设置总页数至少为一
		 */
		int Page = 1;
		if(request.getParameter("pageIndex")==null||request.getParameter("pageIndex").equals("0")){
			Page =1;
		}else{
			try{
				Page =Integer.parseInt(request.getParameter("pageIndex"));
			}catch(NumberFormatException e){
				Page =1;
			}
		}
		String DictionaryType = request.getParameter("type");
		String DictionaryDescription = request.getParameter("description");
		Dictionary d = new Dictionary();
		d.setDicName(DictionaryType);
		d.setDicDescription(DictionaryDescription);
		request.setAttribute("Dictionary",d);
		List<Dictionary> list = DictionaryDao.allDic(Page, DictionaryDao.getDicSql(DictionaryType, DictionaryDescription));
		int num = DictionaryDao.getMaxPage(DictionaryDao.getDicSql(DictionaryType, DictionaryDescription));
		/**如果页数等于0赋值于1**/
		if(num==0){
			num=1;
		}
		request.setAttribute("List",list);
		request.setAttribute("pagenum",num);
		request.setAttribute("pageindex",Page);
		request.getRequestDispatcher("jsp/Dictionary/DictionaryList.jsp").forward(request, response);	
	
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
