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
@WebServlet("/productsadd")
public class productsadd extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("utf-8");
		String language = req.getParameter("language");
		//모델
//		BookRepository br = BookRepository.getRepository();
//		ArrayList<Book> arr = BookRepository.getAllBooks();
		
		//이동
//		req.setAttribute("arry", arr);
		req.setAttribute("language", language);
		RequestDispatcher ds = req.getRequestDispatcher("addBook.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
