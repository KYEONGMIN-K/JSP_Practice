package controller;

import java.io.IOException;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/product_add")
public class product_add extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String save = req.getServletContext().getRealPath("resources\\images");
		String filename="";
		String realFolder=save;
		int maxSize=5*1024*1024;
		String encType="utf-8";
	
		MultipartRequest multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
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
		
		
		
		//모델
		BookRepository dao = BookRepository.getRepository();
		//이동
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
		dao.addBook(newBook);
		
		resp.sendRedirect("products?id=b");
	}
	
}
