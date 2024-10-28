package chapter16;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/db_connect")
public class exam16_1_db extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = null;
			String database ="jdbc:mysql://localhost:3306/jspbook";
			String id ="root";
			String password="1234";
			conn = DriverManager.getConnection(database, id, password);
			
			String msg= "데이터베이스 연결 성공!";
			System.out.println(msg);
			req.setAttribute("msg", msg);
		}catch(Exception e) {
			String msg= "데이터베이스 연결 실패...";
			String msg2 = e.getMessage();
			req.setAttribute("msg", msg);
			System.out.println(msg);
			req.setAttribute("msg2", msg2);
		}finally {
			RequestDispatcher ds = req.getRequestDispatcher("chapter16/exam16_1_result.jsp");
			ds.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
