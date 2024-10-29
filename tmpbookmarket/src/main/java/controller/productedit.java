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
@WebServlet("/productsedit")
public class productedit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		BookRepository br = BookRepository.getRepository();
		ArrayList<Book> arr = br.readAllbook();
			
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("booksedit.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
