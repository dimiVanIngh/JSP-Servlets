package be.vdab.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import be.vdab.dao.GastenboekDAO;
import be.vdab.entities.GastenboekBericht;

@WebServlet("/gastenboek.htm")
public class GastenboekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/gastenboek.jsp";
	private static final String REDIRECT_URL = "%s/gastenboek.htm";
	private final transient GastenboekDAO gastenboekDAO = new GastenboekDAO();

	@Resource(name = GastenboekDAO.JNDI_NAME)
	void setDataSource(DataSource dataSource) {
		gastenboekDAO.setDataSource(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("berichten", gastenboekDAO.findAll());
		if(request.getParameter("uitloggen") != null){
			request.getSession().removeAttribute("ingelogd");
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
		}else
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("toevoegen") != null) {
			toevoegen(request, response);
		} else if (request.getParameter("uitloggen") != null) {
			uitloggen(request, response);
		} else if (request.getParameter("verwijderen") != null) {
			verwijderen(request, response);
		}
	}

	private void verwijderen(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Long> ids = new ArrayList<>();
		if (request.getParameterValues("id") != null) {		
			for (String id : request.getParameterValues("id")) {
				ids.add(Long.parseLong(id));
			}
		}
		if (!ids.isEmpty()) {
			gastenboekDAO.delete(ids);
		}
		response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
	}

	private void uitloggen(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("ingelogd");
		response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
	}

	private void toevoegen(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> fouten = new HashMap<>();
		String naam = request.getParameter("naam");
		if (!GastenboekBericht.isNaamValid(naam)) {
			fouten.put("naam", "naam is verplicht");
		}
		String bericht = request.getParameter("bericht");
		if (!GastenboekBericht.isBerichtValid(bericht)) {
			fouten.put("bericht", "een bericht moet tussen 1 en 255 tekens bevatten");
		}
		if (fouten.isEmpty()) {
			gastenboekDAO.addBericht(new GastenboekBericht(naam, bericht));
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
