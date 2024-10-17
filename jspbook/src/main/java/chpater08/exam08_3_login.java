package chpater08;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login_8_3")
public class exam08_3_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = (String)req.getAttribute("id");
		String pw = (String)req.getAttribute("passwd");
		
		
		req.setAttribute("id", id);
		req.setAttribute("pw", pw);
		//모델
		RequestDispatcher ds = req.getRequestDispatcher("chapter08/exam8_3_result.jsp");
		ds.forward(req, resp);
		//이동
	}

}
