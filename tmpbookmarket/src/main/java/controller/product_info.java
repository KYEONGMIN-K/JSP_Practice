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
import logTime.timeReturn;

@WebServlet("/productinfo")
public class product_info extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #p_info.1 productinfo 매핑됨");
		//전처리
		String bookid = req.getParameter("id");
		

		//모델
		BookRepository br = BookRepository.getRepository();
		if(br == null) {
			System.out.println(timeReturn.getTime()+" #p_info BookRepository return Fail");
		}
		Book book = br.readOneBook(bookid);
		if(book == null) {
			System.out.println(timeReturn.getTime()+" #p_info readOneBook return Fail");
		}
		System.out.println(timeReturn.getTime()+" #p_info.2 readOneBook return Succ");
		//이동
		req.setAttribute("book", book);
		RequestDispatcher ds = req.getRequestDispatcher("book.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
