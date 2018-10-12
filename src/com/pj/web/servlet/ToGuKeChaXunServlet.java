package com.pj.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.PageHelperDataResult;
import com.pj.service.SystemUserService;
import com.pj.service.impl.SystemUserServiceImpl;
import com.pj.util.JSONUtil;

/**
 * Servlet implementation class ToGuKeChaXun
 */
@WebServlet("/ToGuKeChaXunServlet")
public class ToGuKeChaXunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ToGuKeChaXunServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 清空Session
		request.getSession().setAttribute("chengshi", "");
		request.getSession().setAttribute("pinpai", "");
		request.getSession().setAttribute("zhuangui", "");
		request.getSession().setAttribute("begintime", "");
		request.getSession().setAttribute("overtime", "");

		// 去评价记录表查询，查询所有记录返回页面，并且分页显示：查询满意次数和不满意次数
		// 每页显示10条数据
		// 显示 首页 上一页 第几页 下一页 末页 共多少条结果
		int page = 1;
		int rows = 10;
		SystemUserService sus = new SystemUserServiceImpl();
		PageHelperDataResult result = new PageHelperDataResult();

		// 获取组合条件
		String chengshiStr = request.getParameter("chengshi");
		String pinpaiStr = request.getParameter("pinpai");
		String zhuanguiStr = request.getParameter("zhuangui");
		String begintimeStr = request.getParameter("begintime");
		String overtimeStr = request.getParameter("overtime");
//		System.out.println("---chengshi:"+chengshiStr + "---pinpai:" + pinpaiStr + "---zhuangui:" + zhuanguiStr + "---begintime:" + begintimeStr + "---overtime:" + overtimeStr);

		// 无条件查询进入
		if ("".equals(chengshiStr) || "".equals(pinpaiStr) || "".equals(zhuanguiStr)
				|| "".equals(begintimeStr) || "".equals(overtimeStr) || chengshiStr == null
				|| pinpaiStr == null || zhuanguiStr == null || begintimeStr == null || overtimeStr == null) {
			// 组装sql语句
			String sql = "select pinPai,chengShi,zhuanGui,openId from pingjiajilu group by openId";
			result = sus.getAllPingjiajiluOfGuKeChaXun(page, rows, sql);
			request.setAttribute("pageHelper", result);
		} else {
			// 按组合条件查询进入
			String chengshi = sus.getNameByCode(chengshiStr);
			String pinpai = sus.getNameByCode(pinpaiStr);
			String zhuangui = sus.getNameByCode(zhuanguiStr);
			String begintime = begintimeStr;
			String overtime = overtimeStr;
			// 组装sql语句
			String sql = "select pinPai,chengShi,zhuanGui,openId from pingjiajilu " + "where chengShi='" + chengshi
					+ "' and pinPai='" + pinpai + "' and zhuanGui='" + zhuangui + "' " + "and createTime>='" + begintime
					+ " 00:00:00' and createTime<='" + overtime + " 23:59:59' group by openId";
//			System.out.println(sql);
			result = sus.getAllPingjiajiluOfGuKeChaXun(page, rows, sql);
			request.setAttribute("pageHelper", result);
//			System.out.println("result---"+result);
			// 将用户查询的值返回给界面显示
			request.getSession().setAttribute("chengshi", chengshi);
			request.getSession().setAttribute("pinpai", pinpai);
			request.getSession().setAttribute("zhuangui", zhuangui);
			request.getSession().setAttribute("begintime", begintime);
			request.getSession().setAttribute("overtime", overtime);
		}
		request.getRequestDispatcher("/guke.jsp").forward(request, response);

//		sus.getAllPingjiajiluOfGuKeChaXun(page, rows);
//		request.setAttribute("pageHelper", result);
//		request.getRequestDispatcher("/guke.jsp").forward(request, response);
//		String resultJson = JSONUtil.toJson(result);
//		System.out.println(resultJson);
//		PrintWriter out = response.getWriter();
//		out.write(resultJson);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
