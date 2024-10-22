package chapter12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class InitParamFilter implements Filter{

	private FilterConfig filterConfig=null;
	
	@Override
	public void destroy() {
		System.out.println("exam12_2 해제..");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fltc) throws IOException, ServletException {
		System.out.println("exam12_2 수행..");
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		System.out.println("전처리 완료");
		String param1 = filterConfig.getInitParameter("param1");
		String param2 = filterConfig.getInitParameter("param2");
		System.out.println("파라미터 수신 완료");
		String message;
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html charset=UTF-8");
		System.out.println("resp 세팅 완료");
		
		PrintWriter writer = resp.getWriter();
		System.out.println("writer 생성완료");
		System.out.println("파라미터 출력"+param1+":"+param2);
		
		if(id.equals(param1) && passwd.equals(param2)) {
			message="로그인 성공했습니다.";
		}else { 
			message="로그인 실패했습니다.";
		}
		
		System.out.println(message);
		
		writer.println(message);
//		writer.println(message);
		req.setAttribute("msg", message);
		fltc.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("exam12_2 초기화..");
		this.filterConfig = filterConfig;
	}

}
