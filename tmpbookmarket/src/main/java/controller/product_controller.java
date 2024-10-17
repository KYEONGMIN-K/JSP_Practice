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

@WebServlet("/products")
public class product_controller extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Verify Step 1 : 콘솔을 찍어서 잘 매핑이 되는지 확인
		System.out.println("/product 매핑됨");
		//전처리
		// 데이터를 잡아 저장하는 것.
		req.setCharacterEncoding("utf-8");
		String language = req.getParameter("language");	
		System.out.println(language);
		//모델
		BookRepository br = BookRepository.getRepository();
		ArrayList<Book> arr = BookRepository.getAllBooks();
		
		//이동
		// 데이터 보낼때           키  , 값
			req.setAttribute("arry", arr);
			RequestDispatcher ds = req.getRequestDispatcher("books.jsp");
			ds.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
