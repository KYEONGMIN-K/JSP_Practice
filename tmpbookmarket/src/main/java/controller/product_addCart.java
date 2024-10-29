package controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dto.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/product_addCart")
public class product_addCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		//변수 생성 및 파라미터 수신
		
		HttpSession session = req.getSession(true);
		String  id = req.getParameter("id");
		//파라미터 수신 유효성 검사
		if(id == null || id.trim().equals("")) {
			resp.sendRedirect("products");
		}
		System.out.println("addcart 파라미터 수신완료");
	//모델
		//dao 생성
		BookRepository dao = BookRepository.getRepository();
		//id값으로 dao 내 특정 book 가져오기 
//		Book book = dao.getBookById(id);
		//제대로 가져왔는지 유효성검사
//		if(book == null) {
//			resp.sendRedirect("exceptionNoBookId.jsp");
//		}
		System.out.println("addcart 모델 유휴성 통과");
		//제대로 가져왔다면 전체 book 가져오기
		ArrayList<Book> goodsList = dao.readAllbook();
		//원본 데이터 조작방지를 위해 복사본 생성
		Book goods = new Book();
		for(int i=0; i<goodsList.size(); i++) {
			//전체 책 리스트 중 하나씩 옮겨담기
			goods = goodsList.get(i);
			//만약 옮겨담은 책의 아이디가 찾으려는 특정 책의 id와 같으면 더 찾을 필요가 없으므로 반복중지 
			if(goods.getBookId().equals(id)) {
				break;
			}
		}
		
		//장바구니 리스트를 만들기 위해 dto를 담을 리스트 생성 후 session에 저장된 cartlist를 가져온다.
		ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("cartlist");
		//만약 session에 cartlist 속성이 비어있다면 새로운 AryList를 생성하고 session에 set
		if(list == null) {
			list = new ArrayList<Book>();
			session.setAttribute("cartlist", list);
		}
		
		int cnt = 0;
		Book goodsQnt = new Book();
		for(int i=0; i<list.size(); i++) {
			goodsQnt = list.get(i);
			if(goodsQnt.getBookId().equals(id)) {
				cnt++;
				int orderQnt = goodsQnt.getQuantity()+1;
				goodsQnt.setQuantity(orderQnt);
			}
		}
		
		if(cnt==0) {
			goods.setQuantity(1);
			list.add(goods);
		}
		System.out.println("addcart 모델 처리 전부 통과");
	//이동
		resp.sendRedirect("productinfo?id="+id);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
