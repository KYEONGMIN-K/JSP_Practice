package Board_Controller;

import logTime.*;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import dao.BoardRepository;
import dao.BookRepository;
import dto.Board;
import dto.Book;
import dto.Member;
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
		      RequestDispatcher rs=null;
		      System.out.println(session);
		      if(session == null) {
		         rs = req.getRequestDispatcher("member_login");
		      }
		      else if(session != null)
		      {
		         Member mb = (Member)session.getAttribute("member");
		         if(session.getAttribute("member") == null) {
		            System.out.println("세션존재 멤버 없음 이동한다");
		            rs = req.getRequestDispatcher("member_login");
		         }
		         else {
		            rs = req.getRequestDispatcher("writeForm.jsp");            
		         }
		      }

		//모델
		      
		//뷰	
		rs.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #b_create.1 Create_Controller doPost()매핑됨");
		//전처리
		HttpSession session = req.getSession(false);
		Member mb = (Member)session.getAttribute("member");
		String id = mb.getId();
		String name = req.getParameter("name");
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		Date currentDatetime = new Date(System.currentTimeMillis());
		Date sqlDate = new Date(currentDatetime.getTime());
		Timestamp timestamp = new Timestamp(currentDatetime.getTime());
		
//		LocalDateTime tm = LocalDateTime.now();
//		System.out.println(tm);
//		String tm2 = tm.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
//		String tm2 = tm.format(DateTimeFormatter.ofPattern("MM-dd"));
		
		int hit = 0;
		String ip = req.getRemoteAddr();
		//데이터 묶기
		Board board = new Board();
		board.setId(id);
		board.setName(name);
		board.setSubject(subject);
		board.setContent(content);
		board.setRegist_day(timestamp);
		board.setHit(hit);
		board.setIp(ip);
		
		//모델이동
		BoardRepository br = BoardRepository.getInstance();
		br.create(board);
		
		//뷰이동
		resp.sendRedirect("BoardListAction");
	}
	
}
