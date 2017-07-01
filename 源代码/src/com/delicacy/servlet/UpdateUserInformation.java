package com.delicacy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delicacy.dao.*;
import com.delicacy.user.*;
@WebServlet("/person/UpdateUserInformation")
public class UpdateUserInformation extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public UpdateUserInformation() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String username=request.getParameter("username");
		String usersex=request.getParameter("sex");
		String birth_year=request.getParameter("birth_year");
		String birth_month=request.getParameter("birth_month");
		String birth_day=request.getParameter("birth_day");
		String userBirth=birth_year+"-"+birth_month+"-"+birth_day;
		
		UserBean user=(UserBean) request.getSession().getAttribute("user");	//从session作用域提取user信息
		int updateRow=new UserinfoDao().updateUserinfo(user.getUserID(), username, usersex, userBirth);
		if(updateRow==1){
			user.setUserName(username);
			user.setUserBirth(userBirth);
			user.setUserSex(usersex);
			request.getSession().setAttribute("user", user);
		}
			response.sendRedirect("UserInformation.jsp");
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
