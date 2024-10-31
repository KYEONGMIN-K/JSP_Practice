package Memeber_Controller;

import java.io.IOException;
import java.util.Date;

import dao.MemberRepository;
import dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/member_add")
public class Create_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(logTime.timeReturn.getTime()+" #m_create_get conncect");
		//전처리
		
		//모델이동
		
		//뷰이동
		RequestDispatcher ds = req.getRequestDispatcher("addMember.jsp");
		ds.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(logTime.timeReturn.getTime()+" #m_create_post.1 conncect");
		//전처리
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		String year = request.getParameter("birthyy");
		String month = request.getParameterValues("birthmm")[0];
		String day = request.getParameter("birthdd");
		String birth = year + "/" + month + "/" + day;
		
		String mail1 = request.getParameter("mail1");
		String mail2 = request.getParameterValues("mail2")[0];
		String mail = mail1 + "@" + mail2;
		
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		//현재 시간
		Date currentDatetime = new Date(System.currentTimeMillis());
		java.sql.Date sqlDate = new java.sql.Date(currentDatetime.getTime());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(currentDatetime.getTime());
		
		Member mb = new Member();
		mb.setId(id);
		mb.setPassword(password);
		mb.setName(name);
		mb.setGender(gender);
		mb.setBirth(birth);
		mb.setMail(mail);
		mb.setPhone(phone);
		mb.setAddress(address);
		mb.setRegist_day(timestamp);
		
		//모델이동
		MemberRepository mr = MemberRepository.getMr();
		mr.create(mb);
		//뷰이동
//		HttpSession session = request.getSession(true);
//		session.setAttribute("sessionId",mb.getId());
		resp.sendRedirect("/tmpbookmarket");
	}

}
