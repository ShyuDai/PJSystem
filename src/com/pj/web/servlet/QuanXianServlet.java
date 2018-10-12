package com.pj.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.pj.entity.GangWei;
import com.pj.entity.Power;
import com.pj.service.GangweiService;
import com.pj.service.impl.GangweiServiceImpl;

@WebServlet("/QuanXianServlet")
public class QuanXianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 设置编码
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");

		int flag = Integer.parseInt(request.getParameter("flag"));

		if (flag == 0) {
			String gangweiidstr = request.getParameter("gangweiid");
			int gangweiid=Integer.parseInt(gangweiidstr);
			GangweiService service = new GangweiServiceImpl();
			GangWei gangWei = service.gatGangweiById(gangweiid);	
			List<Power> list=service.getPowerByGangweiId(gangweiid);

			if (list != null) {	
				request.setAttribute("list", list);	
				request.setAttribute("gangWei", gangWei);
				request.getRequestDispatcher("/gangwei_quanxian.jsp").forward(request, response);
			} else {
				service.addpower(gangweiid);
				request.setAttribute("gangWei", gangWei);
				request.getRequestDispatcher("/gangwei_quanxian.jsp").forward(request, response);
			}
		} else if(flag==1)
		{
			int gangweiset = 0,renyuanset=0,syslog=0,gwmxselect=0,guwenselect=0,customerselect=0;
			int gangweiid = Integer.parseInt(request.getParameter("gangweiid"));
			GangweiService service = new GangweiServiceImpl();
			String[] gangweisets=request.getParameterValues("gangweiset");
			if (gangweisets!=null) {
				for (String string : gangweisets) {
					gangweiset=1;
					service.updatepower(gangweiset, string, gangweiid);
				}
			} else {
				String str="gangweiset";
				gangweiset=0;
				service.updatepower(gangweiset, str, gangweiid);
			}
			String[] renyuansets=request.getParameterValues("renyuanset");
			if (renyuansets!=null) {
				for (String string : renyuansets) {
					renyuanset=1;
					service.updatepower(renyuanset, string, gangweiid);
				}
			} else {
				String str="renyuanset";
				renyuanset=0;
				service.updatepower(renyuanset, str, gangweiid);
			}
			String[] syslogs=request.getParameterValues("syslog");
			if (syslogs!=null) {
				for (String string : syslogs) {
					syslog=1;
					service.updatepower(syslog, string, gangweiid);
				}
			} else {
				String str="syslog";
				syslog=0;
				service.updatepower(syslog, str, gangweiid);
			}
			String[] gwmxselects=request.getParameterValues("gwmxselect");
			if (gwmxselects!=null) {
				for (String string : gwmxselects) {
					gwmxselect=1;
					service.updatepower(gwmxselect, string, gangweiid);
				}
			} else {
				String str="gwmxselect";
				gwmxselect=0;
				service.updatepower(gwmxselect, str, gangweiid);
			}
			String[] guwenselects=request.getParameterValues("guwenselect");
			if (guwenselects!=null) {
				for (String string : guwenselects) {
					guwenselect=1;
					service.updatepower(guwenselect, string, gangweiid);
				}
			} else {
				String str="guwenselect";
				guwenselect=0;
				service.updatepower(guwenselect, str, gangweiid);
			}
			String[] customerselects=request.getParameterValues("customerselect");
			if (customerselects!=null) {
				for (String string : customerselects) {
					customerselect=1;
					service.updatepower(customerselect, string, gangweiid);
				}
			} else {
				String str="customerselect";
				customerselect=0;
				service.updatepower(customerselect, str, gangweiid);
			}
			request.getRequestDispatcher("/GangweiServlet").forward(request, response);
		}
	}

}
