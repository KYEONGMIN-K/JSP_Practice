package chapter05;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login2")
public class exam05_8_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		//가져온 값을 다시 request에 넘긴다. request의 생명주기를 잘 알아야.
		req.setAttribute("uid", id);
		req.setAttribute("upw", pw);
		//모델
		
		//이동		
		RequestDispatcher ds = req.getRequestDispatcher("chapter05/out02_process.jsp");
		ds.forward(req, resp);
	}

}
