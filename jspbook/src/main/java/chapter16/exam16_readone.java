package chapter16;

import java.io.IOException;

import dao.test_repository;
import dto.test_dto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/readone")
public class exam16_readone extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//read one
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		
		test_repository rsp = test_repository.getInstance();
		test_dto dto = new test_dto(); 
		dto = rsp.test_readone(id);
		
		req.setAttribute("dto", dto);
		RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_update.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
