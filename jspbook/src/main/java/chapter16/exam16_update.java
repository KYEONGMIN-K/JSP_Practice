package chapter16;

import java.io.IOException;

import dao.test_repository;
import dto.test_dto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class exam16_update extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		System.out.println("update btn after : "+id+" "+pw+" "+name);
		
		test_dto dto  = new test_dto();
		dto.setId(id);
		dto.setName(name);
		dto.setPw(pw);
		
		test_repository rsp = test_repository.getInstance();
		rsp.test_update(dto);
		
		resp.sendRedirect("readall");
	}

}
