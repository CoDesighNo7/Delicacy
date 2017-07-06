package com.delicacy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delicacy.dao.LogininfoDao;
import com.delicacy.dao.UserinfoDao;
import com.delicacy.user.UserBean;
//@WebServlet("/home/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单信息
		String username=request.getParameter("user");
		String password=request.getParameter("password");
		LogininfoDao logininfo=new LogininfoDao();
		//判断用户登陆信息是否正确，若正确，跳转到主页。
		if(logininfo.isCorrect(username, password, 1)){
			UserBean user=new UserinfoDao().selectUserByID(username);
			String birth=user.getUserBirth();
			String [] b=birth.split("-");
			int year=Integer.parseInt(b[0]);
			int month=Integer.parseInt(b[1]);
			int day=Integer.parseInt(b[2]);
			request.getSession().setAttribute("year", year);
			request.getSession().setAttribute("month", month);
			request.getSession().setAttribute("day", day);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Home.jsp");
		}
		else
			response.sendRedirect("Login.jsp");

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
