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
@WebServlet("/exam13_5_login")
public class exam13_5_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		session.setAttribute(name[0], value[0]);
		session.setAttribute(name[1], value[1]);
//		session.setAttribute("id", name[0]);	//"id"
//		session.setAttribute("value1", value[0]);	//"admin"
//		session.setAttribute("pw", name[1]);	//"pw"
//		session.setAttribute("value2", value[1]);	//"1234"
//		System.out.println("name[0] : "+name[0]+"\n");
//		System.out.println("name[1] : "+name[1]+"\n");
//		System.out.println("value[0] : "+value[0]+"\n");
//		System.out.println("value[1] : "+value[1]+"\n");
		
		RequestDispatcher ds = req.getRequestDispatcher("chapter13/exam13_5_result.jsp");
		ds.forward(req, resp);
	}

}
