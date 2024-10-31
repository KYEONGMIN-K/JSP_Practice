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
import logTime.timeReturn;
import dao.BookRepository;
import dto.Book;
@WebServlet("/productsedit")
public class productedit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #p_edit.1 productsedit 매핑됨");
		
		BookRepository br = BookRepository.getRepository();
		if(br==null) {
			System.out.println(timeReturn.getTime()+" #p_edit BookRepository return Fail");
		}
		ArrayList<Book> arr = br.readAllbook();
		if(br==null) {
			System.out.println(timeReturn.getTime()+" #p_edit readAllbook return Fail");
		}
		System.out.println(timeReturn.getTime()+" #p_edit.2 readAllbook return Succ");
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("booksedit.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
