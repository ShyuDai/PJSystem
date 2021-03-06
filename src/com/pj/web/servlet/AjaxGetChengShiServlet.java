package com.pj.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.Danyuan;
import com.pj.entity.PageHelperDataResult;
import com.pj.service.SystemUserService;
import com.pj.service.impl.SystemUserServiceImpl;
import com.pj.util.JSONUtil;

/**
 * Servlet implementation class AjaxGetChengShi
 */
@WebServlet("/AjaxGetChengShi")
public class AjaxGetChengShiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxGetChengShiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String method=request.getParameter("method");
//		System.out.println("开始获取城市。。。。。");
		SystemUserService sus = new SystemUserServiceImpl();
		List<Danyuan> list=sus.AjaxGetChengShi();
		PageHelperDataResult result=new PageHelperDataResult();
		result.setRows(list);
		String resultJson = JSONUtil.toJson(result);
//		System.out.println(resultJson);
		PrintWriter out = response.getWriter();
		out.write(resultJson);
		
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
