package chapter11;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/exam11_4_controller")
public class exam11_4_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		int numInt1 = Integer.parseInt(num1);
		int numInt2 = Integer.parseInt(num2);
		
		Exception e = new Exception();
		try {
			int result = numInt1/numInt2;
			req.setAttribute("num1", num1);
			req.setAttribute("num2", num2);
			req.setAttribute("result", String.valueOf(result));
			
			RequestDispatcher ds = req.getRequestDispatcher("chapter11/exam11_4_result.jsp");
			ds.forward(req, resp);
		}catch(Exception exc) {
			
			String toStr = exc.toString();
			String clas = exc.getClass().getName();
			String msg = exc.getMessage();

			req.setAttribute("toStr", toStr);
			req.setAttribute("clas", clas);
			req.setAttribute("msg", msg);
			RequestDispatcher ds = req.getRequestDispatcher("chapter11/errorCode_error.jsp");
			ds.forward(req, resp);
		}
	}

}
