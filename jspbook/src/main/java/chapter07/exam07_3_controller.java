package chapter07;

import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/oldupload")
public class exam07_3_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("oldupload controller connect");
		String save = req.getServletContext().getRealPath("img");
		//전처리
		String fileUploadPath = save;
		DiskFileUpload upload = new DiskFileUpload();
		
		List items;
		try {
			items = upload.parseRequest(req);
			Iterator params = items.iterator();
			while(params.hasNext()) {
				FileItem fileitem = (FileItem)params.next();
				if(!fileitem.isFormField()) {
					String fileName = fileitem.getName();
					fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
					File file = new File(fileUploadPath + "/"+fileName);
					req.setAttribute("filename", fileName);
					try {
						fileitem.write(file);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//모델
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/exam7_3_result.jsp");
		ds.forward(req, resp);
	}

}
