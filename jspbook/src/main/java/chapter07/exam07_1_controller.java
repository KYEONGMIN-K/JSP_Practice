package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/upload")
public class exam07_1_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String save = req.getServletContext().getRealPath("img");
		req.setCharacterEncoding("utf-8");
		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		int i=0;
		Enumeration params = multi.getParameterNames();
		String namet[] = new String[2];
		String value[] = new String[2];
		 
		while(params.hasMoreElements()) {
			System.out.println(i);
			namet[i] = (String)params.nextElement();
			value[i] = multi.getParameter(namet[i]);
			i++;
			
		}
		System.out.println(i);
		
		String namef = null;
		String filename = null;
		String original = null;
		String type = null;
		File file = null;
		
		Enumeration files= multi.getFileNames();
		while(files.hasMoreElements()) {
			
			namef = (String)files.nextElement();
			
			filename = multi.getFilesystemName(namef);
			original = multi.getOriginalFileName(namef);
			type = multi.getContentType(namef);
			file = multi.getFile(namef);
			System.out.println();
		}
		//텍스트
		req.setAttribute("namet", namet);
		req.setAttribute("value", value);
		//파일
		req.setAttribute("namef", namef);
		req.setAttribute("filename", filename);
		req.setAttribute("original", original);
		req.setAttribute("type", type);
		req.setAttribute("file", file);
		
		
		//모델
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/exam7_1_result.jsp");
		ds.forward(req, resp);
	}

}
