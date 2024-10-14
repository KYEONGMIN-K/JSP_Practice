package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productinfo")
public class product_info extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("연결!");
		//전처리
		String bookid = req.getParameter("id");
		BookRepository bookRepo = BookRepository.getRepository();
		req.setAttribute("id", bookid);
		req.setAttribute("bookrepo", bookRepo);
		//모델
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("book.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
