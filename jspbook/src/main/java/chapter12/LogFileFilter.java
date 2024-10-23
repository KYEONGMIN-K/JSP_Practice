package chapter12;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.*;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class LogFileFilter implements Filter{
	
	PrintWriter writer;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
		writer.close();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fltc)
			throws IOException, ServletException {
		writer.printf("현재 일시: %s %n",getCurrentTime());
		String clientAddr=req.getRemoteAddr();
		writer.printf("클라이언트 주소 : %s %n", clientAddr);
		
		fltc.doFilter(req, resp);
		
		String contentType = resp.getContentType();
		writer.printf("문서의 콘텐츠 유형 : %s %n", contentType);
		writer.println("-----------------------------------");
				
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filename = filterConfig.getInitParameter("filename");
		if(filename==null) throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		
		try {
			writer = new PrintWriter(new FileWriter(filename,true), true);
		}catch(Exception e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
	
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}

}
