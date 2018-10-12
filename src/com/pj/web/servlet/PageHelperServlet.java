package com.pj.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.PageHelperDataResult;
import com.pj.service.SystemUserService;
import com.pj.service.impl.SystemUserServiceImpl;

/**
 * Servlet implementation class PageHelperServlet
 */
@WebServlet("/PageHelperServlet")
public class PageHelperServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageHelperServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String chengshiStr=(String) request.getSession().getAttribute("chengshi");
		String pinpaiStr=(String) request.getSession().getAttribute("pinpai");
		String zhuanguiStr=(String) request.getSession().getAttribute("zhuangui");
		String begintimeStr=(String) request.getSession().getAttribute("begintime");
		String overtimeStr=(String) request.getSession().getAttribute("overtime");
//		System.out.println("PageHelperServlet中的---"+chengshiStr+"---"+pinpaiStr+"---"+zhuanguiStr+"---"+begintimeStr+"---"+overtimeStr);
		
		String CurrentPageStr=request.getParameter("currentPage");
		//获取当前页
		int CurrentPage=Integer.parseInt(CurrentPageStr);
//		int rows=10;//每页显示多少条数据
		SystemUserService sus=new SystemUserServiceImpl();
		String SourceStr=request.getParameter("Source");
		//获取路径参数
		int SourceInt=Integer.parseInt(SourceStr);
		//实例化分页数据对象
		PageHelperDataResult result=new PageHelperDataResult();
		if(SourceInt==1) {
//			System.out.println("当前页---"+CurrentPage);
//			System.out.println("路径---"+SourceInt);
			//无条件查询下的分页功能
			if(chengshiStr.equals("") || pinpaiStr.equals("") || zhuanguiStr.equals("") || begintimeStr.equals("") || overtimeStr.equals("")) {
				//sql语句
				String sql = "select * from pingjiajilu";
//				System.out.println(sql);
				result=sus.getAllPingjiajiluOfGuWenMingXiChaXun(CurrentPage,10,sql);
//				request.getSession().setAttribute("pageHelper", result);
//				response.sendRedirect("/mingxi.jsp");
				request.setAttribute("pageHelper", result);
				request.getRequestDispatcher("/mingxi.jsp").forward(request, response);
			}
			//组合条件查询下的分页功能
			else{
				//组装sql语句
				String sql = "select * from pingjiajilu "
						+ "where createTime>='"+begintimeStr+" 00:00:00' and createTime<='"+overtimeStr+" 23:59:59' "
								+ "and chengShi='"+chengshiStr+"' and pinPai='"+pinpaiStr+"' and zhuanGui='"+zhuanguiStr+"'";
//				System.out.println(sql);
				result=sus.getAllPingjiajiluOfGuWenMingXiChaXun(CurrentPage,10,sql);
				request.setAttribute("pageHelper", result);
//				System.out.println("PageHelperServlet的pageHelper---"+result);
				request.getRequestDispatcher("/mingxi.jsp").forward(request, response);
			}
			
		}
		if(SourceInt==2) {
//			System.out.println("当前页---"+CurrentPage);
//			System.out.println("路径---"+SourceInt);
			//无条件查询下的分页功能
			if(chengshiStr.equals("") || pinpaiStr.equals("") || zhuanguiStr.equals("") || begintimeStr.equals("") || overtimeStr.equals("")) {
				//sql语句
				String sql = "select * from pingjiajilu group by renyuanmc";
//				System.out.println(sql);
				result=sus.getAllPingjiajiluOfGuWenChaXun(CurrentPage,2,sql);
//				request.getSession().setAttribute("pageHelper", result);
//				response.sendRedirect("/mingxi.jsp");
				request.setAttribute("pageHelper", result);
				request.getRequestDispatcher("/guwen.jsp").forward(request, response);
			}else {
				String sql = "select * from pingjiajilu "
						+ "where chengShi='"+chengshiStr+"' and pinPai='"+pinpaiStr+"' and zhuanGui='"+zhuanguiStr+"' "
						+ "and createTime>='"+begintimeStr+" 00:00:00' and createTime<='"+overtimeStr+" 23:59:59' group by renyuanmc";
//				System.out.println(sql);
				//组合条件查询下的分页功能
				if(chengshiStr!=null && pinpaiStr!=null && zhuanguiStr!=null && begintimeStr!=null && overtimeStr!=null) {
					result=sus.getAllPingjiajiluOfGuWenChaXun(CurrentPage,2,sql);
					request.setAttribute("pageHelper", result);
				}
	//			System.out.println("Source---"+SourceInt);
	//			System.out.println("CurrentPage---"+CurrentPage);
	//			System.out.println("PageHelperServlet的pageHelper---"+result);
				request.getRequestDispatcher("/guwen.jsp").forward(request, response);
			}
		}
		if(SourceInt==3) {
//			System.out.println("当前页---"+CurrentPage);
//			System.out.println("路径---"+SourceInt);
			if(chengshiStr.equals("") || pinpaiStr.equals("") || zhuanguiStr.equals("") || begintimeStr.equals("") || overtimeStr.equals("")) {
				//sql语句
				String sql = "select pinPai,chengShi,zhuanGui,openId from pingjiajilu group by openId";
//				System.out.println(sql);
				result=sus.getAllPingjiajiluOfGuKeChaXun(CurrentPage,10,sql);
//				request.getSession().setAttribute("pageHelper", result);
//				response.sendRedirect("/mingxi.jsp");
				request.setAttribute("pageHelper", result);
				request.getRequestDispatcher("/guke.jsp").forward(request, response);
			}else {
			String sql = "select pinPai,chengShi,zhuanGui,openId from pingjiajilu "
					+ "where chengShi='"+chengshiStr+"' and pinPai='"+pinpaiStr+"' and zhuanGui='"+zhuanguiStr+"' "
					+ "and createTime>='"+begintimeStr+" 00:00:00' and createTime<='"+overtimeStr+" 23:59:59' group by openId";
//			System.out.println(sql);
			result=sus.getAllPingjiajiluOfGuKeChaXun(CurrentPage, 10,sql);
			request.setAttribute("pageHelper", result);
//			System.out.println("PageHelperServlet的pageHelper---"+result);
			request.getRequestDispatcher("/guke.jsp").forward(request, response);
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
