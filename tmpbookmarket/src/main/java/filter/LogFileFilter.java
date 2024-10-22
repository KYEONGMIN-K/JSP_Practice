package filter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LogFileFilter implements Filter{
	PrintWriter writer;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fltc)
			throws IOException, ServletException {
		writer.println("접속한 클라이언트 IP : " + req.getRemoteAddr());
		long start = System.currentTimeMillis();
		writer.println("접근한 URL 경로 : "+getURLPath(req));
		writer.println("요청 처리 시작 시각 : "+getCurrentTime());
		
		fltc.doFilter(req, resp);
		
		long end = System.currentTimeMillis();
		writer.println("요청 처리 종료 시각 : "+getCurrentTime());
		writer.println("요청 처리 소요 시각 : "+(end-start)+"ms");
		writer.println("=====================================");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//초기화하는 곳. 
		System.out.println("BookMarket 초기화..");
		//web.xml에 입력된 파라미터를 읽어 저장한다.
		String filename = filterConfig.getInitParameter("filename");
		
		//만약 파라미터가 null값이면 exception 생성
		if(filename == null) {
			throw new ServletException("로그 파일의 이름을 찾을 수 없습니다.");
		}
		
		try {
			//printwriter를 생성하며 file에 출력하기 위한 준비
			writer = new PrintWriter(new FileWriter(filename, true), true);
		}catch(Exception e) {
			throw new ServletException("로그 파일을 열 수 없습니다.");
		}
	}
	
	//URL 경로를 return하는 함수
	private String getURLPath(ServletRequest request) {
		HttpServletRequest req;
		String currentPath = "";
		String queryString = "";
		//request가 ServletRequest가 같은 타입 or 부모자식 관계이면 true 
		if(request instanceof ServletRequest) {
			req = (HttpServletRequest)request;
			currentPath = req.getRequestURI();
			queryString = req.getQueryString();
			queryString = queryString == null ? "" : "?" + queryString;
		}
		return currentPath + queryString;
	}
	
	//현재 시간을 return하는 함수
	private String getCurrentTime() {
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());
		return formatter.format(calendar.getTime());
	}
}
