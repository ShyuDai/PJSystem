package com.pj.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.pj.entity.GangWei;
import com.pj.service.GangweiService;
import com.pj.service.impl.GangweiServiceImpl;
@WebServlet("/GangweiServlet")
public class GangweiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GangweiServlet() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设置编码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		
		GangweiService service=new GangweiServiceImpl();
		List<GangWei> gangWeis=service.getGangweis();
		String json=JSON.toJSONString(gangWeis);
		PrintWriter out= response.getWriter();
		out.println(json);
		
		request.getSession().setAttribute("gangWeis", gangWeis);
		request.getRequestDispatcher("/gangwei.jsp").forward(request, response);
		out.flush();
		out.close();
	}

}
