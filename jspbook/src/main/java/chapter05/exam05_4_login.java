package chapter05;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class exam05_4_login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("연결!");
		
		//전처리
		//데이터를 받기 전에 손실, 왜곡되지 않게 하기 위해 utf-8로 포장
		req.setCharacterEncoding("utf-8");
		String userid = req.getParameter("id");
		String password = req.getParameter("passwd");
		//모델
		
		//이동
		if(userid.equals("관리자") && password.equals("1234")){
			resp.sendRedirect("chapter05/response01_sucess.jsp");
		}else{
			resp.sendRedirect("chapter05/response01_failed.jsp");
		}
	}

}
