package controller;

import java.io.IOException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logTime.timeReturn;
@WebServlet("/product_update")
public class product_update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #p_update.1 product_update 매핑됨");
		//전처리
		req.setCharacterEncoding("utf-8");
		String save = req.getServletContext().getRealPath("resources\\images");
		String realFolder = save;
		int maxSize = 5*1024*1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		if(multi == null) {
			System.out.println(timeReturn.getTime()+" #p_update MultipartRequest 생성 실패");
		}
		System.out.println(timeReturn.getTime()+" #p_update.2 MultipartRequest 생성");
		String bookId = multi.getParameter("bookId");
		String name = multi.getParameter("name");
		String unitPrice = multi.getParameter("unitPrice");
		String author = multi.getParameter("author");
		String publisher = multi.getParameter("publisher");
		String releaseDate = multi.getParameter("releaseDate");
		String description = multi.getParameter("description");
		String category = multi.getParameter("category");
		String unitsInStock = multi.getParameter("unitsInStock");
		String condition = multi.getParameter("condition");
		String fileName = multi.getFilesystemName("BookImage");
		
		//유효성 검사
		Integer Price=0;
		
		if(unitPrice.isEmpty())
				Price =0;
		else
			Price = Integer.valueOf(unitPrice);
		
		long stock=0;
		
		if(unitsInStock.isEmpty())
			Price =0;
		else
			stock = Long.valueOf(unitsInStock);
		
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
		//모델이동
		BookRepository br = BookRepository.getRepository();
		br.updateBook(newBook);
		System.out.println(timeReturn.getTime()+" #p_update.3 updateBook return Succ");
		//뷰이동
		resp.sendRedirect("products");
	}

}
