package com.pj.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.pj.entity.Rizhi;
import com.pj.service.RizhiService;
import com.pj.service.impl.RizhiServiceImpl;
import com.pj.util.PageResult;

/**
 * Servlet implementation class RizhiServlet
 */
public class RizhiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		
		int flag=0;
		String flagStr=request.getParameter("flag");
		if(flagStr !=null) {
			flag=Integer.parseInt(flagStr);
		}
		PrintWriter out=response.getWriter();
		switch (flag) {
		case 0:
			getRizhiListPage(request,response);
			break;
		case 1:
			int rizhiId=Integer.parseInt(request.getParameter("rizhiId"));
			int rows=deleteRizhiByRizhiId(rizhiId);
			if(rows==1) {
				out.print(1);
			}else {
				out.print(0);
				out.flush();
				out.close();
			}
			
			break;
		}
		
	}
	
	private int deleteRizhiByRizhiId(int rizhiid) {
		// TODO Auto-generated method stub
		RizhiService rizhiService=new RizhiServiceImpl();
		return rizhiService.deleteRizhiByRizhiId(rizhiid);
		
	}

	private void getRizhiListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//分页
		int pageNO=1;
		int pageSize=10;

		String pageNOStr=request.getParameter("pageNO");		
		if(pageNOStr !=null) {
			pageNO=Integer.parseInt(pageNOStr);
		}
		
		String pageSizeStr=request.getParameter("pageSize");		
		if(pageSizeStr != null) {
			pageSize=Integer.parseInt(pageSizeStr);
		}
		
		RizhiService rizhiService=new RizhiServiceImpl();
		List<Rizhi> rizhiList=rizhiService.getRizhiListPage(pageNO, pageSize);
	    //List<Rizhi> rizhiList=rizhiService.getAllRizhiList();
		PageResult pageResult=new PageResult();
		pageResult.setPageNO(pageNO);
		pageResult.setPageSize(pageSize);
		pageResult.setResults(rizhiList);
		
		int count=rizhiService.getAllRizhiList().size();
		pageResult.setCount(count);
		
		if(count%pageSize==0) {
			pageResult.setPageCount(count / pageSize);
		}else {
			pageResult.setPageCount(count / pageSize + 1);
		}
		
		request.setAttribute("pageResult", pageResult);
		request.getRequestDispatcher("/Rizhi.jsp").forward(request, response);
	}

}
