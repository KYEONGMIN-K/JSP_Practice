package chapter07;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/uploadold")
public class exam07_4_controller extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
		String save = req.getServletContext().getRealPath("img");
		req.setCharacterEncoding("utf-8");
//		MultipartRequest multi = new MultipartRequest(req, save, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		DiskFileUpload upload = new DiskFileUpload();
		upload.setSizeMax(1000000);
		upload.setSizeThreshold(4096);
		upload.setRepositoryPath(save);
		Iterator params=null;
		List items;
		try {
			items = upload.parseRequest(req);
			params = items.iterator();
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String name[]=new String[2];
		String value[]=new String[2];
		String fileFieldName=new String();
		String fileName=new String();
		String contentType=new String();
		long fileSize=0;
		File file;
		int i=0;
		
		while(params.hasNext()) {
			FileItem item = (FileItem)params.next();
			
			if(item.isFormField()) {
				name[i] = item.getFieldName();
				value[i] = item.getString("utf-8");
			}else {
				fileFieldName = item.getFieldName();
				fileName = item.getName();
				contentType = item.getContentType();
				
				fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
				fileSize = item.getSize();
				
				file = new File(save + "/"+ fileName);
				try {
					item.write(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			i++;
		}
		//텍스트
		req.setAttribute("name", name);
		req.setAttribute("value", value);
		//파일
		req.setAttribute("fileFieldName", fileFieldName);
		req.setAttribute("fileName", fileName);
		req.setAttribute("contentType", contentType);
		req.setAttribute("fileSize", fileSize);
		
		
		//모델
		
		//이동
		RequestDispatcher ds = req.getRequestDispatcher("chapter07/exam7_4_result.jsp");
		ds.forward(req, resp);
	}

}
