package com.atguigu.java;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	//这里讲ServletConfig设置为一个全局的常量;用它来获取ServletContext,然后获得web.xml中的初始化参数
	private ServletConfig serletConfig;
	@Override
	public void init(ServletConfig serletConfig) throws ServletException {
		this.serletConfig = serletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//通过request来得到 login.html的参数
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		//在通过ServletConfig 的到ServletContext();
		ServletContext servletContext = serletConfig.getServletContext();
		//这里得到是web.xml中的初始化的参数
		String use = servletContext.getInitParameter("user");
		String initPassword = servletContext.getInitParameter("password");
		//使用响应信息获得一个printWriter的输出
		PrintWriter out = response.getWriter();
		//进行一个盘判断
		if("root".equals(use)&&"123".equals(initPassword)){
			out.print("Hello:"+use);
		}else{
			out.print("sorry:"+use);
		}
		
	}

}
