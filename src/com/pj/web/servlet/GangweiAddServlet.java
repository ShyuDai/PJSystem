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

@WebServlet("/GangweiAddServlet")
public class GangweiAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设置编码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		String gangweiname=request.getParameter("gangwei");
		String bumen=request.getParameter("bumen");
		
		GangWei gangwei=new GangWei();
		gangwei.setGangwei(gangweiname);
		gangwei.setBumen(bumen);
		GangweiService service=new GangweiServiceImpl();
		service.add(gangwei);
		
		request.getRequestDispatcher("/GangweiServlet").forward(request, response);
		
	}

}
