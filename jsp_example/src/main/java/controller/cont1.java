package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// contoller를 만드는 방법을 순서대로 확인해보자
// Step 1 : HttpServlet 클래스를 상속
// Step 2 : overriding 실시 ( doGet(), doPost() )
// Step 3 : 서블릿매핑 ( class 위에 @WebServlet() 작성 )

@WebServlet("/first")
public class cont1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet 실행");
		RequestDispatcher ds = req.getRequestDispatcher("first.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 실행");
	}
	
}
