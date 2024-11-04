package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/phone")
public class phone_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher ds = req.getRequestDispatcher("phone.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String phoneNum = req.getParameter("phone_num");
		
		String result = string.strPractice.formatPhoneNumber(phoneNum);
		//모델이동
		
		//뷰이동
		req.setAttribute("result", result);
		RequestDispatcher ds = req.getRequestDispatcher("phone_result.jsp");
		ds.forward(req, resp);
	}

}
