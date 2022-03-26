package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.Value;

import dao.DAOContent;
import logincookie.CookieUtils;

import model.Content;

@WebServlet("/ViewContent")
public class ViewContent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idmember= Integer.parseInt(CookieUtils.get("idmember",request)) ;
		String start = request.getParameter("start");
		
		if (start == null) {
			start = "0";
		}

		DAOContent dao = new DAOContent();
		List<Content> list = dao.getAllContent(idmember);
		
		int end = list.size();
		
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("listcontent", list);
	}

}
