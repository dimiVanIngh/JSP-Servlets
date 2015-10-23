package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.vdab.dao.SausDAO;

/**
 * Servlet implementation class SauzenVerwijderenServlet
 */
@WebServlet("/sauzen/verwijderen.htm")
public class SauzenVerwijderenServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String REDIRECT_URL = "%s/sauzen.htm";
	private final SausDAO sausDAO = new SausDAO();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		if (request.getParameterValues("id") != null) {
			for (String longAsString : request.getParameterValues("id")) {
				sausDAO.delete(Long.parseLong(longAsString));
			}
		}
		response.sendRedirect(String.format(REDIRECT_URL, request.getContextPath()));
	}
}
