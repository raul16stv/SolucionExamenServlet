package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.VideogameService;

public class VideogameDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VideogameService service = new VideogameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Videogame videogame = service.assembleVideogameFromRequest(req);
		service.deleteVideogame(videogame);
		loginRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("name", req.getParameter("name"));
		confirmationRedirect(req, resp);
	}

	protected void confirmationRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ConfirmationDeleteVideogame.jsp");
		dispatcher.forward(req, resp);
	}

	protected void loginRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ListVideogame.jsp");
		dispatcher.forward(req, resp);
	}
}