package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BookRepository;
import dto.Book;
@WebServlet("/productsedit_s")
public class productedit_select extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String id = req.getParameter("id");
		
		//모델
		BookRepository br = BookRepository.getRepository();
		Book book = br.readOneBook(id);
		
		//이동
		req.setAttribute("book", book);
		RequestDispatcher ds = req.getRequestDispatcher("booksediting.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
