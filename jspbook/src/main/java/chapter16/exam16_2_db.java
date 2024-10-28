package chapter16;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dto.test_dto;
import dao.test_repository;
@WebServlet("/join_test")
public class exam16_2_db extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		
		test_dto dto = new test_dto();
		dto.setId(id);
		dto.setName(name);
		dto.setPw(pw);
		//모델
		test_repository rsp = test_repository.getInstance();
		rsp.test_insert(dto);
		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = null;
//			String dburl = "jdbc:mysql://localhost:3306/jspbook";
//			String dbid = "root";
//			String dbpw = "1234";
//			conn = DriverManager.getConnection(dburl, dbid, dbpw);
//			
//			Statement stmt = conn.createStatement();
//			String sql = "insert into exam values('"+dto.getId()+"','"+dto.getPw()+"','"+dto.getName()+"')";
//			stmt.executeUpdate(sql);
//			
//			String msg = "DB 데이터 삽입 성공!";
//			req.setAttribute("msg", msg);
//			RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_2_result.jsp");
//			ds.forward(req, resp);
//		}catch(Exception e) {
//			String msg = "DB 데이터 삽입 실패...";
//			String msg2 = e.getMessage();
//			req.setAttribute("msg", msg);
//			req.setAttribute("msg2", msg2);
//			RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_2_result.jsp");
//			ds.forward(req, resp);
//		}
		
		//이동
		resp.sendRedirect("readall");
	}

}
