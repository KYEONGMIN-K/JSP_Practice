package chapter06;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/result_form")
public class exam06_1_result extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
				req.setCharacterEncoding("utf-8");
				String id = req.getParameter("id");
				String pw = req.getParameter("passwd");
				String name = req.getParameter("name");
				String phoneNum1 = req.getParameter("phone1");
				String phoneNum2 = req.getParameter("phone2");
				String phoneNum3 = req.getParameter("phone3");
				String gender = req.getParameter("sex");
				String hobby[] = req.getParameterValues("hobby");
				String comment = req.getParameter("comment");
				//모델

				
				//이동
				req.setAttribute("id", id);
				req.setAttribute("passwd", pw);
				req.setAttribute("name", name);
				req.setAttribute("phoneNum1", phoneNum1);
				req.setAttribute("phoneNum2", phoneNum2);
				req.setAttribute("phoneNum3", phoneNum3);
				req.setAttribute("gender", gender);
				req.setAttribute("hobby", hobby);
				req.setAttribute("comment", comment);
				RequestDispatcher ds = req.getRequestDispatcher("chapter06/result_form.jsp");
				ds.forward(req, resp);
	}

}
