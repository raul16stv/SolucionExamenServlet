package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.VideogameService;

public class ListVideogameAlphabetical extends HttpServlet {

	private VideogameService service= new  VideogameService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videogame> listAllVideogamesAlp = service.listAllVideogamesOrderedAlphabetical();
		req.setAttribute("listAllVideogamesAlp", listAllVideogamesAlp);
		redirect(req,resp);
	}


	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideogameAlphabetical.jsp");
		dispatcher.forward(req,resp);
	}
}
