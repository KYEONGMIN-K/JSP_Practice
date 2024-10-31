package controller;

import java.io.IOException;

import dao.BookRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class product_delete_notUse extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		
		//모델이동
		BookRepository br = BookRepository.getRepository();
		br.deleteBook(id);
		
		//뷰이동
		resp.sendRedirect("products");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
