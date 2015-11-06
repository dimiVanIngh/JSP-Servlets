package be.vdab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inloggen.htm")
public class InlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/inloggen.jsp";
	private static final String REDIRECT_URL = "%s/gastenboek.htm";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(VIEW).forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("telefoonNummerHelpDesk",this.getServletContext().getInitParameter("telefoonHelpDesk"));
	}

}
