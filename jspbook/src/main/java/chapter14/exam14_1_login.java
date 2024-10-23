package chapter14;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/exam14_1_login")
public class exam14_1_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		if(id.equals("admin")&&pw.equals("1234")) {
			Cookie cookie_id = new Cookie("id", id);
			Cookie cookie_pw = new Cookie("pw", pw);
			resp.addCookie(cookie_id);
			resp.addCookie(cookie_pw);
			req.setAttribute("cid", cookie_id);
			req.setAttribute("cpw", cookie_pw);
		}
		
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter14/exam14_1_result.jsp");
		ds.forward(req, resp);
	}

}
