package com.pj.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pj.entity.Power;
import com.pj.entity.Renyuan;
import com.pj.service.GangweiService;
import com.pj.service.SystemUserService;
import com.pj.service.impl.GangweiServiceImpl;
import com.pj.service.impl.SystemUserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username= request.getParameter("username");
		String password= request.getParameter("password");
//		System.out.println(username +"  "+password);
		
		SystemUserService service = new SystemUserServiceImpl();
		Renyuan renyuan = service.getRenYuanByUsernameAndPassword(username, password);
//		System.out.println(renyuan);
		
		if (renyuan!=null) {
			GangweiService s= new GangweiServiceImpl();
			List<Power> powers = s.getPowerByGangweiId(renyuan.getGangweiId());
			//将用户信息存入Session
			request.getSession().setAttribute("powers", powers);
			request.getSession().setAttribute("renyuan", renyuan);
			//去首页
			request.getRequestDispatcher("/framest.html").forward(request, response);
		}else {
			//登录失败，返回登录界面
			request.getRequestDispatcher("/login.html").forward(request, response);
		}
		
		
	}

}
