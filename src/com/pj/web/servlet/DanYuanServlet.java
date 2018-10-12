package com.pj.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.pj.entity.Danyuan;
import com.pj.service.DanYuanService;
import com.pj.service.impl.DanYuanServiceImpl;

@WebServlet("/danYuanServlet")
public class DanYuanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		switch (flag) {
		case 1:
			getPinPaiListByCityCode(request, response);
			break;

		default:
			break;
		}
	}
	
	public void getPinPaiListByCityCode(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String parentCode = request.getParameter("parentCode");
		DanYuanService danYuanService = new DanYuanServiceImpl();
		
		List<Danyuan> danYuanList = danYuanService.getDanYuanListByParentCode(parentCode);
		String json = JSON.toJSONString(danYuanList);
//		System.out.println(json);
		
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}

}
