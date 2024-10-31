package chapter17;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/17_controller")
public class exam17_2_ctrl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String number = req.getParameter("number");
		
		//모델
		
		//뷰이동
		req.setAttribute("number", number);
		RequestDispatcher ds = req.getRequestDispatcher("chapter17/exam17_2_result.jsp");
		ds.forward(req, resp);
	}

}
