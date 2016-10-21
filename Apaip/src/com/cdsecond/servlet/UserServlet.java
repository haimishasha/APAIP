package com.cdsecond.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdsecond.bean.User;
import com.cdsecond.dao.UserDAO;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		if (cmd.equals("list")) {
			list(request, response);
		} else if (cmd.equals("add")) {
			add(request, response);
		}else if(cmd.equals("edit")){
			edit(request,response);
		}else if(cmd.equals("login")){
			login(request,response);
		}else if(cmd.equals("detail")){
			detail(request,response);
		}else if(cmd.equals("editpwd")){
			editpwd(request,response);
		}else if(cmd.equals("editforword")){
			editforword(request,response);
		}else if(cmd.equals("relogin")){
			relogin(request,response);
		}else if(cmd.equals("editstatus")){
			editstatus(request,response);
		}
	}

	/**
	 * 登陆
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {		
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		String pwd = request.getParameter("userPassword");

		List listuser = new UserDAO().search(user);
		if(!listuser.equals(null) && listuser.size()>0){
			user = (User)listuser.get(0);
			String inputpwd=user.getUserPassword();
			int status = user.getUserStatus();
			if(!inputpwd.equals(pwd)){
				request.setAttribute("loginmsg", "0");
				//request.getRequestDispatcher("LoginUser/login.jsp").forward(request,response);
				return;
			}else if(status==0){
				request.setAttribute("loginmsg", "该用户已被删除！");
				//request.getRequestDispatcher("LoginUser/login.jsp").forward(request,response);
				return;
			}else{
				HttpSession session = request.getSession(true);
				session.setAttribute("loginuser", user);
				request.setAttribute("userlist",new UserDAO().searchall());
				//request.setAttribute("list", allLis);
				request.getRequestDispatcher("UserManagement/index.jsp").forward(request,response);
				//response.sendRedirect("UserManagement/index.jsp");
			}
		}else
		{
			request.setAttribute("loginmsg", "用户名或密码不能为空！");
			//request.getRequestDispatcher("LoginUser/login.jsp").forward(request,response);
			
		}
		
	}
	/**
	 * 点击重定向用户管理
	 */
	private void relogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {		
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		HttpSession session = request.getSession(true);
		session.setAttribute("loginuser", user);
		request.setAttribute("userlist",new UserDAO().searchall());
		//request.setAttribute("list", allLis);
		request.getRequestDispatcher("UserManagement/index.jsp").forward(request,response);
		
	}
	/**
	 * 跳转修改用户前的数据准备
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void editforword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		User user =new User();
		user.setUserName(username);
		
		List<User> list = new UserDAO().search(user);
		request.setAttribute("user", list.get(0));
		request.getRequestDispatcher("UserManagement/userupdate.jsp").forward(request,
				response);
	}
	/**
	 * 修改用户
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User user = new User();
		user.setUserName(request.getParameter("username"));
		List<User> list = new UserDAO().search(user);
		System.out.println(list.size());
		user = list.get(0);
		user.setUserPassword(request.getParameter("userPassword"));
		user.setUserTrueName(request.getParameter("userTrueName"));
		user.setUserSex(request.getParameter("userSex"));
		user.setIDCard(request.getParameter("IDCard"));
		user.setUserPhone(request.getParameter("userPhone"));
		user.setUserAddr(request.getParameter("userAddr"));
		
		new UserDAO().edit(user);
		request.getRequestDispatcher("UserManagement/index.jsp").forward(request,
				response);
	}
	/**
	 * 修改密码
	 */
	private void editpwd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User user = new User();
		user.setUserName(request.getParameter("username"));
		List<User> list = new UserDAO().search(user);
		user=list.get(0);
		user.setUserPassword(request.getParameter("userPassword"));
		request.setAttribute("userlist",new UserDAO().searchall());
		Integer rtn = new UserDAO().edit(user);
		request.getRequestDispatcher("UserManagement/index.jsp").forward(request,response);
	}

	/**
	 * 编辑状态
	 */
	private void editstatus(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		User user = new User();
		user.setUserName(request.getParameter("username"));
		System.out.println(user.getUserName());
		List<User> list = new UserDAO().search(user);
		System.out.println(list.size());
		System.out.println(list.get(0).getUserName());
		user=list.get(0);
		user.setUserStatus(0);
		Integer rtn = new UserDAO().edit(user);
		request.setAttribute("userlist",new UserDAO().searchall());
		request.getRequestDispatcher("UserManagement/index.jsp").forward(request,response);
	}
	/**
	 * 新增用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setUserPassword(request.getParameter("userPassword"));
		user.setUserTrueName(request.getParameter("userTrueName"));
		user.setUserSex(request.getParameter("userSex"));
		user.setIDCard(request.getParameter("IDCard"));
		user.setUserPhone(request.getParameter("userPhone"));
		user.setUserAddr(request.getParameter("userAddr"));
		user.setUserStatus(1);
		Integer rtn = new UserDAO().add(user);
		if (rtn > 0) {
			//List<User> list = new UserDAO().searchall();
			//request.setAttribute("userlist", list);
			//response.sendRedirect("UserManagement/index.jsp");
			//request.getRequestDispatcher("UserManagement/index.jsp").forward(request,response);
			this.relogin(request, response);
		}
	}

	/**
	 * 查询用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		user.setUserTrueName(request.getParameter("userTrueName"));

		List<User> list = new UserDAO().search(user);
		request.setAttribute("userlist", list);

		request.getRequestDispatcher("UserManagement/index.jsp").forward(request,
				response);
	}

	/**
	 * 用户详情
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("username");
		User user =new User();
		user.setUserName(username);
		
		List<User> list = new UserDAO().search(user);
		request.setAttribute("user", list.get(0));
		request.getRequestDispatcher("UserManagement/userDetail.jsp").forward(request,
				response);
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
