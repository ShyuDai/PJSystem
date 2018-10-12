package com.pj.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pj.entity.Renyuan;

/**
 * Servlet Filter implementation class SessionFilter
 */

public class SessionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public SessionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest r2 = (HttpServletRequest) request;
		r2.setCharacterEncoding("UTF-8");
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = r2.getSession();
		Renyuan renyuan = (Renyuan) session.getAttribute("renyuan");
		// 获取请求路径
		String url = r2.getRequestURI();
		if (url.endsWith(".css") || url.endsWith(".js") || url.endsWith(".jpg") || url.endsWith(".gif")
				|| url.endsWith(".png") || url.endsWith("/index.jsp") || url.endsWith("/LoginServlet")
				|| url.endsWith("/login.html")) {
//			System.out.println(url + "---静态资源和指定路径不拦截！");
			chain.doFilter(request, response);
		} else {
			//对于非静态资源和非指定路径的过滤器配置
			if (renyuan == null) {
//				System.out.println("是非静态资源和非指定路径，且不存在session,不拦截！");
				request.getRequestDispatcher("login.html").forward(request, response);
			} else {
//				System.out.println("是非静态资源和非指定路径，但存在session,不拦截！");
				chain.doFilter(request, response);// 这句话本身表示以前是什么路径现在就执行什么路径，大意是放行
			}
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
