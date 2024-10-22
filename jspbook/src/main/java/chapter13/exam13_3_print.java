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
@WebServlet("/exam13_3_print")
public class exam13_3_print extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("연결됐니");
		String name[];
		String value[];
		int i=0;
		
		HttpSession session = req.getSession();
		
		System.out.println(session);
		name= new String[2];
		value = new String[2];
		
		Enumeration en = req.getParameterNames();
		while(en.hasMoreElements()) {
			name[i]= en.nextElement().toString();
			System.out.println(name[i]);
			value[i] = req.getParameter(name[i]).toString();
			System.out.println(value[i]);
			i++;
		}
		
		session.setAttribute("name", name);
		session.setAttribute("value", value);
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_3_result.jsp");
		ds.forward(req, resp);
	}

}
