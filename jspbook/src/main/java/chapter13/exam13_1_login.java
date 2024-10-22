package chapter13;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.jasper.tagplugins.jstl.core.Out;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/exam13_1_login")
public class exam13_1_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("로그인 완료\n");
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("passwd"));
		
		HttpSession session = req.getSession(true);
		String id = (String) req.getParameter("id");
		String pw = (String) req.getParameter("passwd");
		
		if(id.equals("admin")&&pw.equals("1234")) {
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_1_result.jsp");
			ds.forward(req, resp);
		}else {
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html; charset = UTF-8");
			PrintWriter writer = resp.getWriter();
			writer.println("세션 설정이 실패했습니다.");
			return;
		}
	}

}
