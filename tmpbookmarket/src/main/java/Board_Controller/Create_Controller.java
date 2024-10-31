package Board_Controller;

import logTime.*;
import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/BoardWriteForm")
public class Create_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.sendRedirect("member_login");
			return;
		}
		//모델
		RequestDispatcher ds = req.getRequestDispatcher("writeForm.jsp");
		ds.forward(req, resp);
		//뷰	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #p_create.1 product_add 매핑됨");
		//전처리
		String save = req.getServletContext().getRealPath("resources\\images");
		String realFolder=save;
		int maxSize=5*1024*1024;
		String encType="utf-8";

		//전처리 : 파라미터 수신
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		System.out.println(timeReturn.getTime()+" #p_create.2 MultiP 생성");
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String condition = multi.getParameter("condition");
		//정수로 처리되어야 하는 데이터
		String unitPrice = multi.getParameter("unitPrice");
		String unitsInStock = multi.getParameter("unitsInStock");
		//저장된 이미지의 이름을 변수에 저장
		String fileName = multi.getFilesystemName("BookImage");
		
//		System.out.println(bookId+"/"+fileName);
		System.out.println(timeReturn.getTime()+" #p_create.3 MultiP Param get Succ");
		//유효성 검사
		int Price=0;
		//unitPrice이 null일 수 있기 때문에 검사
		if(unitPrice.isEmpty()) {
				Price =0;
		}else{//null이 아니면 String을 int로 바꿔 넣기.
			Price = Integer.valueOf(unitPrice);
		}
		long stock=0;
		//unitPrice이 null일 수 있기 때문에 검사
		if(unitsInStock.isEmpty()) {
			Price =0;
		}else{//null이 아니면 String을 int로 바꿔 넣기.
			stock = Long.valueOf(unitsInStock);
		}
		
		
		//데이터 묶기
		Book newBook = new Book();
		newBook.setBookId(bookId);
		newBook.setName(name);
		newBook.setUnitPrice(Price);
		newBook.setAuthor(author);
		newBook.setPublisher(publisher);
		newBook.setReleaseDate(releaseDate);
		newBook.setDescription(description);
		newBook.setCategory(category);
		newBook.setUnitsInStock(stock);
		newBook.setCondition(condition);
		newBook.setFilename(fileName);		
		
		System.out.println(timeReturn.getTime()+" #p_create.3 DTO set Succ");
		//모델이동
		BookRepository br = BookRepository.getRepository();
		br.addBook(newBook);
		
		//뷰이동
		resp.sendRedirect("products");
	}
	
}
