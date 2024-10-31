package Memeber_Controller;

import java.io.IOException;
import java.util.ArrayList;

import dao.BookRepository;
import dao.MemberRepository;
import dto.Book;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logTime.timeReturn;

@WebServlet("/member_login")
public class member_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher ds = req.getRequestDispatcher("login.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(timeReturn.getTime()+" #m_login.1 /member_login 매핑됨");
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("password");
		
		//모델이동
		MemberRepository mr = MemberRepository.getMr();
		Member mb = mr.getUser(id, pw);
		
		if(mb != null) {	//DTO가 존재하므로 회원이 맞음
			//세션 생성
			HttpSession session = req.getSession(true);
			session.setAttribute("member", mb);
			System.out.println("ctrl in : " + mb.getName());
			RequestDispatcher ds = req.getRequestDispatcher("resultMember.jsp?msg=2");
			ds.forward(req, resp);
		}else {
			resp.sendRedirect("member_login?error=1");
		}
		//뷰이동
		
	}

}
