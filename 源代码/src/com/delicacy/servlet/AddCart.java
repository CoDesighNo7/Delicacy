package com.delicacy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.delicacy.commodity.Commodity;
import com.delicacy.dao.CartDao;
import com.delicacy.dao.WareHouseDao;
import com.delicacy.user.UserBean;

public class AddCart extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddCart() {
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
		Commodity commodity=(Commodity) request.getSession().getAttribute("commodity");
		UserBean user=(UserBean)request.getSession().getAttribute("user");
		String userID=user.getUserID();
		String count=request.getParameter("count");
		boolean result=false;
		CartDao cartdao=new CartDao();
		if(cartdao.confirmCount(commodity.getId(), Float.parseFloat(count))){
			new WareHouseDao().redeceInventory(commodity.getWarehouseID(), Float.parseFloat(count),-1);
			result=cartdao.insertCart(userID, commodity, Float.parseFloat(count));	
		}
		
		if(result)
			response.sendRedirect("Cart.jsp");
		else
		{
			request.setAttribute("message", "����ʧ��");
			response.sendRedirect("Introduction.jsp");
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
