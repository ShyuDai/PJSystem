package com.pj.web.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.Renyuan;
import com.pj.service.SystemUserService;
import com.pj.service.impl.SystemUserServiceImpl;

/**
 * Servlet implementation class GetPingJiaServlet
 */
@WebServlet("/GetPingJiaServlet")
public class GetPingJiaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPingJiaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chengshi=request.getParameter("chengshi");
		String pinpai=request.getParameter("pinpai");
		String zhuangui=request.getParameter("zhuangui");
		String guwen=request.getParameter("guwen");
		String manyishu=request.getParameter("manyishu");
//		System.out.println("chengshi---"+chengshi);
//		System.out.println("pinpai---"+pinpai);
//		System.out.println("zhuangui---"+zhuangui);
//		System.out.println("guwen---"+guwen);
//		System.out.println("manyishu---"+manyishu);
		//1.根据顾问人员的id去renyuan表获取它的chengShi、pinPai、zhuanGui、renYuanId、name
		int guwenid=Integer.parseInt(guwen);
		SystemUserService sus=new SystemUserServiceImpl();
		String sql="select chengShi,pinPai,zhuanGui,renYuanId,name from renyuan where renYuanId="+guwenid;
//		System.out.println(sql);
		Renyuan renyuan=sus.getRenyuanByRenyuanid(sql);
		//2.开始写入pingjiajilu表
		//openId、chengShi、pinPai、zhuanGui、renYuanId、renYuanMC、jingDu、weiDu、leiXing（默认为： 1 ）、createTime
		String openid=UUID.randomUUID().toString();//模拟生成openid
		String jingDu="104.002";
		String weiDu="30.002";
		int leixing=1;
//		Date createTime=new Date("yyyy-MM-dd");
		String createTime="2018-09-14";
//		System.out.println(createTime);
		String sql2="insert into pingjiajilu(openId,chengShi,pinPai,zhuanGui,renYuanId,renYuanMC,jingDu,weiDu,leiXing,createTime) "
				+ "values('"+openid+"','"+renyuan.getChengshi()+"','"+renyuan.getPinpai()+"','"+renyuan.getZhuangui()
				+"','"+renyuan.getRenyuanid()+"','"+renyuan.getName()+"','"+jingDu+"','"+weiDu+"',"+leixing+",'"+createTime+"')";
//		System.out.println(sql2);
		int result=sus.addPingJiaJiLu(sql2);
		if(result>0) {
			response.sendRedirect("PingJiaSuccess.jsp");
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
