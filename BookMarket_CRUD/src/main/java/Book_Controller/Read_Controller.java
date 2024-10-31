package Book_Controller;

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

@WebServlet("/books")
public class Read_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		//모델이동
		BookRepository br = BookRepository.getRepository();
		ArrayList<Book> arr = br.readAllbook();
		//뷰이동
		req.setAttribute("arr", arr);
		RequestDispatcher ds = req.getRequestDispatcher("books.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
