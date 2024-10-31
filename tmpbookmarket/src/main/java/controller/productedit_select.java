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
@WebServlet("/productsedit_select")
public class productedit_select extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #p_select.1 productsedit_select 매핑됨");
		//전처리
		String id = req.getParameter("id");
		String edit = req.getParameter("edit");
		if(edit == null) {
			System.out.println(timeReturn.getTime()+" #p_select edit null");
		}
		if(edit.equals("update")) {
			//모델
			BookRepository br = BookRepository.getRepository();
			if(br==null) {
				System.out.println(timeReturn.getTime()+" #p_select BookRepository return Fail");
			}
			Book book = br.readOneBook(id);
			
			System.out.println(timeReturn.getTime()+" #p_select_up.1 readOneBook return Succ");
			//이동
			req.setAttribute("book", book);
			RequestDispatcher ds = req.getRequestDispatcher("booksediting.jsp");
			ds.forward(req, resp);
		}else if(edit.equals("delete")) {
			//모델이동
			BookRepository br = BookRepository.getRepository();
			if(br==null) {
				System.out.println(timeReturn.getTime()+" #p_select BookRepository return Fail");
			}
			br.deleteBook(id);
			System.out.println(timeReturn.getTime()+" #p_select_del.1 readOneBook return Succ");
			//뷰이동
			resp.sendRedirect("products");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
