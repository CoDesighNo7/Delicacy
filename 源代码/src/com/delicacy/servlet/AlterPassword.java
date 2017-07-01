package com.delicacy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delicacy.dao.LogininfoDao;
import com.delicacy.user.UserBean;
@WebServlet("/person/AlterPassword")
public class AlterPassword extends HttpServlet {

	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public AlterPassword() {
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
		UserBean user=(UserBean) request.getSession().getAttribute("user");
		String oldpassword=request.getParameter("user_old_password");
		String newpassword=request.getParameter("user_new_password");
		String confirmpassword=request.getParameter("user_confirm_password");
		LogininfoDao loginDao=new LogininfoDao();
		if(!loginDao.isCorrect(user.getUserID(), oldpassword, 1)){
			request.setAttribute("message", "Ô­Ê¼ÃÜÂë´íÎó");
			RequestDispatcher rd=request.getRequestDispatcher("/person/Alterpassword.jsp");
			rd.forward(request, response);
		}
		if(!newpassword.equals(confirmpassword)){
			request.setAttribute("message", "ÃÜÂë²»Ò»ÖÂ");
			RequestDispatcher rd=request.getRequestDispatcher("/person/Alterpassword.jsp");
			rd.forward(request, response);
		}
		
		if(loginDao.updatePassword(user.getUserID(), newpassword))
			response.sendRedirect("UserInformation.jsp");
		else{
			request.setAttribute("message", "ÐÞ¸ÄÊ§°Ü");
			RequestDispatcher rd=request.getRequestDispatcher("/person/Alterpassword.jsp");
			rd.forward(request, response);
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
