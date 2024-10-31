package Board_Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/BoardListAction")
public class Read_Controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//한 페이지에 출력할 글의 개수를 제한
		int Limit = 5;
		
		//전처리
		req.setCharacterEncoding("utf-8");
		int pageNum = Integer.parseInt(req.getParameter("pageNum"));
		//모델
		BoardRepository br = BoardRepository.getInstance();
		ArrayList<Board> arr = br.getAllBoard();
		int total_record = br.getTotalCount();
		int total_page=0;
		if(total_record % Limit == 0) {
			total_page = total_record / Limit;	//딱 맞게 떨어지는 페이지
		}else {
			total_page = (total_record / Limit)+1;	//추가로 필요한 페이지 +1
		}
		
		//뷰이동
		req.setAttribute("total_page", total_page);
		req.setAttribute("arr", arr); //전체글을 담은 객체
		req.setAttribute("pageNum", pageNum); //전체 페이지 번호
		req.setAttribute("total_record", total_record); //전체글의 개수
		RequestDispatcher ds = req.getRequestDispatcher("list.jsp");
		ds.forward(req, resp);
	
		//이동
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
