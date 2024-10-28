package chapter16;

import java.io.IOException;
import java.util.ArrayList;

import dao.test_repository;
import dto.test_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/readall")
public class exam16_read extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리 x
		//모델
		test_repository rsp = test_repository.getInstance();
		ArrayList<test_dto> arr = rsp.test_read();
		
		System.out.println("arr : "+ arr.get(0).getId());
		//뷰이동
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_readall.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
