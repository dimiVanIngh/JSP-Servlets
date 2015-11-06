package be.vdab.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
		request.getRequestDispatcher(VIEW).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
			GastenboekBericht geldigBericht = new GastenboekBericht(naam, bericht);
			gastenboekDAO.addBericht(geldigBericht);
			response.sendRedirect(response.encodeRedirectURL(String.format(REDIRECT_URL, request.getContextPath())));
		} else {
			request.setAttribute("fouten", fouten);
			request.getRequestDispatcher(VIEW).forward(request, response);
		}
	}

}
