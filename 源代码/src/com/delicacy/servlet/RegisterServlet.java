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
		//��ȡ����Ϣ
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
		String passwordRepeat=request.getParameter("passwordRepeat");
		boolean userExist=new UserinfoDao().isUserExist(phone, email);		//�ж��ֻ��Ż������Ƿ��ѱ�ע��
		//���ѱ�ע�ᣬ��ת��ע�����
		if(userExist){
			response.sendRedirect("Register.jsp");
			return ;
		}
		UserBean user=null;
		//��userinfo ���в����û���Ϣ
		if(email!=null||phone!=null){
			int invitation=email.hashCode();
			user=new UserinfoDao().insertUser(email,phone,String.valueOf(email.hashCode()));
		}
		//������ɹ�����user��ӵ�session�������У����¼��Ϣ����������û���¼��Ϣ����ת����ҳ
		if(user!=null){
			int login=new LogininfoDao().insertLogininfo(user.getUserID(), password, 1);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("Home.jsp");
			return; 
		}
		//������ʧ�ܣ���ת��ע�����
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
