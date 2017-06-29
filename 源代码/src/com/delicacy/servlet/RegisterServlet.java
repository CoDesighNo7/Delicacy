package com.delicacy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delicacy.dao.LogininfoDao;
import com.delicacy.dao.UserinfoDao;
import com.delicacy.user.UserBean;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
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

		response.setContentType("text/html");
		
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
		//获取表单信息
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String passwordRepeat=request.getParameter("passwordRepeat");
		boolean userExist=new UserinfoDao().isUserExist(phone, email);		//判断手机号或邮箱是否已被注册
		//若已被注册，跳转回注册界面
		if(userExist){
			response.sendRedirect("Register.jsp");
			return ;
		}
		UserBean user=null;
		//向userinfo 表中插入用户信息
		if(email!=null||phone!=null){
			int invitation=email.hashCode();
			user=new UserinfoDao().insertUser(email,phone,String.valueOf(email.hashCode()));
		}
		//若插入成功，将user添加到session作用域中，向登录信息表中添加新用户登录信息，跳转到主页
		if(user!=null){
			int login=new LogininfoDao().insertLogininfo(user.getUserID(), password, 1);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Home.jsp");
			return; 
		}
		//若插入失败，跳转回注册界面
		else
			response.sendRedirect("Register.jsp");
		
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
