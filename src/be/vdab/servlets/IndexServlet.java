package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.entities.Adres;
import be.vdab.entities.Begroeting;
import be.vdab.entities.Gemeente;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = "/index.htm", name = "indexservlet") 
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setAttribute("telefoonNummerHelpDesk",this.getServletContext().getInitParameter("telefoonHelpDesk"));
		request.setAttribute("begroeting", new Begroeting());
		request.setAttribute("adres", new Adres("Martelarenlaan", "61", new Gemeente(3010, "Kessel-lo")));
		request.getRequestDispatcher(VIEW).forward(request, response);
	}
}