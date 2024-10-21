package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AuthenFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filch)
			throws IOException, ServletException {
		System.out.println("exam12 수행");
		String name = req.getParameter("name");
		
		if(name == null || name.equals("")) {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset = UTF-8");
			PrintWriter writer = resp.getWriter();
			String message = "입력된 name은 null입니다.";
			writer.println(message);
			return;
		}
		filch.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
		System.out.println("exam12 초기화...");
	}

}
