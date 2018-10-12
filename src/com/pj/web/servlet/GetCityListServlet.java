package com.pj.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.Danyuan;
import com.pj.service.DanYuanService;
import com.pj.service.impl.DanYuanServiceImpl;

@WebServlet("/GetCityListServlet")
public class GetCityListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DanYuanService danYuanService = new DanYuanServiceImpl();
		List<Danyuan> danYuanList = danYuanService.getCityList();
		
		request.setAttribute("danYuanList", danYuanList);
		request.getRequestDispatcher("/wenjuandiaocha.jsp").forward(request, response);
	}

}
