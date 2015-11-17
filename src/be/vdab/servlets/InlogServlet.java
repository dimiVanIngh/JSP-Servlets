package be.vdab.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.entities.ZoekDeFrietSpel;

@WebServlet("/inloggen.htm")
public class InlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/inloggen.jsp";
	private static final String REDIRECT_URL = "%s/gastenboek.htm";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if( request.getSession().getAttribute("ingelogd") != null){
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
		} else
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!this.getServletContext().getInitParameter("wachtwoord").equals(request.getParameter("wachtwoord"))) {
			request.setAttribute("fout", "verkeerd");
			request.getRequestDispatcher(VIEW).forward(request, response);
		} else {
			request.getSession().setAttribute("ingelogd", true);
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
		}
	}
}
