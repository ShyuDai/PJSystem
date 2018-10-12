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
import com.pj.entity.Renyuan;
import com.pj.service.RenYuanService;
import com.pj.service.impl.RenYuanServiceImpl;
@WebServlet("/renYuanServlet")
public class RenYuanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String flagStr = request.getParameter("flag");
		int flag = Integer.parseInt(flagStr);
		
		switch (flag) {
		case 1:
			getRenYuanListByDanYuanCode(request, response);
			break;

		default:
			break;
		}
	}
	
	
	public void getRenYuanListByDanYuanCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("UTF-8");
		
		String danYuanCode = request.getParameter("danYuanCode");
		RenYuanService renYuanService = new RenYuanServiceImpl();
		List<Renyuan> renYuanList = renYuanService.getRenYuanListByDanYuanCode(danYuanCode);
		String json = JSON.toJSONString(renYuanList);
		
		PrintWriter out = response.getWriter();
		
//		System.out.println(json);
		out.print(json);
		
		out.flush();
		out.close();
	}

}
