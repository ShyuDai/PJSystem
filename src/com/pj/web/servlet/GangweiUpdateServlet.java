package com.pj.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.GangWei;
import com.pj.service.GangweiService;
import com.pj.service.impl.GangweiServiceImpl;

@WebServlet("/GangweiUpdateServlet")
public class GangweiUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设置编码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		int flag=Integer.parseInt(request.getParameter("flag"));
		if(flag==0) {
			String gangweiid= request.getParameter("gangweiid");
			GangweiService service=new GangweiServiceImpl();
			GangWei gangWei=service.gatGangweiById(Integer.parseInt(gangweiid));
			request.setAttribute("gangWei", gangWei);
			request.getRequestDispatcher("/gangwei_update.jsp").forward(request, response);
		} else {
			String gangweiname=request.getParameter("gangwei");
			String bumen=request.getParameter("bumen");
			int gangweiid =Integer.parseInt(request.getParameter("gangweiid"));
			GangweiService service=new GangweiServiceImpl();
			service.updateName(gangweiname, bumen, gangweiid);
			request.getRequestDispatcher("/GangweiServlet").forward(request, response);
		}
	}
}
