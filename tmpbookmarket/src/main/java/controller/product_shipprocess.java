package controller;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/product_shippingProcess")
public class product_shipprocess extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전처리
				req.setCharacterEncoding("utf-8");
				Cookie cartId = new Cookie("shipping_cartId", URLEncoder.encode(req.getParameter("cartId"),"utf-8"));
				Cookie name = new Cookie("shipping_name", URLEncoder.encode(req.getParameter("name"),"utf-8"));
				Cookie shippingDate = new Cookie("shipping_shippingDate", URLEncoder.encode(req.getParameter("shippingDate"),"utf-8"));
				Cookie country = new Cookie("shipping_country", URLEncoder.encode(req.getParameter("country"),"utf-8"));
				Cookie zipCode = new Cookie("shipping_zipCode", URLEncoder.encode(req.getParameter("zipCode"),"utf-8"));
				Cookie addressName = new Cookie("shipping_addressName", URLEncoder.encode(req.getParameter("addressName"),"utf-8"));
				System.out.println("전처리 완료");
				
				cartId.setMaxAge(24*60*60);
				name.setMaxAge(24*60*60);
				shippingDate.setMaxAge(24*60*60);
				country.setMaxAge(24*60*60);
				zipCode.setMaxAge(24*60*60);
				addressName.setMaxAge(24*60*60);
				
				resp.addCookie(cartId);
				resp.addCookie(name);
				resp.addCookie(shippingDate);
				resp.addCookie(country);
				resp.addCookie(zipCode);
				resp.addCookie(addressName);
				
				resp.sendRedirect("orderConfirmation.jsp");
	}

}
