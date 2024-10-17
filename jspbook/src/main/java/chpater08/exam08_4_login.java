package chpater08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login_8_4")
public class exam08_4_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		System.out.println("login_8_4 ");
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("passwd");
		System.out.println(id+":"+pw);
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		//모델
		RequestDispatcher ds = req.getRequestDispatcher("chapter08/exam8_4_result.jsp");
		ds.forward(req, resp);
		//이동
	}

}
