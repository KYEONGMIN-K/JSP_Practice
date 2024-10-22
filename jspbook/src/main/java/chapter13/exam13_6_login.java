package chapter13;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/exam13_6_login")
public class exam13_6_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		session.setAttribute("id", id);
		session.setAttribute("pw", pw);
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_6_result.jsp");
		ds.forward(req, resp);
	}

}
