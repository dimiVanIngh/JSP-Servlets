package be.vdab.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.vdab.dao.SausDAO;
import be.vdab.entities.SausRadenSpel;

@WebServlet("/sausraden.htm")
public class SausRadenServlet extends HttpServlet { 
  private static final long serialVersionUID = 1L;
  private static final String VIEW = "/WEB-INF/JSP/sausraden.jsp";
  private static final String SPEL = "sausRadenSpel";
  private final SausDAO sausDAO = new SausDAO();
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (session.getAttribute(SPEL) == null) {
      session.setAttribute(SPEL, new SausRadenSpel(sausDAO.getRandomSaus().getNaam()));
    }
    request.getRequestDispatcher(VIEW).forward(request, response);
  } 
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession();
    if (request.getParameter("nieuwSpel") != null) {
      session.removeAttribute(SPEL);
    } else {
      String gok = request.getParameter("gok").trim();
      SausRadenSpel spel = (SausRadenSpel) session.getAttribute(SPEL);
      if (spel != null) {
    	  if(spel != null && gok != null && !gok.isEmpty() && !spel.isVerloren() && !spel.isGewonnen()){
    		  spel.doeGok(gok.charAt(0));
    	  }
        session.setAttribute(SPEL, spel);
      }
    }
    response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
  }
}
