package chapter13;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/13_l")
public class login_controller2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		System.out.println(session.getId());
		System.out.println(req);
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/login2.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		if(id.equals("admin") && pw.equals("1234")) {
			// getSession(true) 혹은 getSession()은 현재 세선 객체가 있으면 그냥 사용하고 없으면 새로 생성한다.
			// getSession(false)는 현재 세션 객체가 있으면 그냥 사용하고 없으면 null을 반환한다.
			HttpSession session = req.getSession(true);  //세션생성
			
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
			
			RequestDispatcher ds = req.getRequestDispatcher("chapter13/printer.jsp");
			ds.forward(req, resp);
			
		}else {
			
		}
		//모델
		
		//이동
	}

}
