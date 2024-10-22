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
@WebServlet("/exam13_4_print")
public class exam13_4_print extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name;
		String value;
		int i=0;
		
		HttpSession session = req.getSession();
		name = req.getParameter("id");
		value = req.getParameter("passwd");
		
		session.setAttribute("name", name);
		session.setAttribute("value", value);
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_4_result.jsp");
		ds.forward(req, resp);
	}

}
