package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Modelo.Consola;
import Modelo.Videojuego;
import Repositorio.ConsolaRepository;


public class OrderServlet extends HttpServlet {

	ConsolaRepository consolaRepo = new ConsolaRepository();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videojuego> OrderAllVideojuego = consolaRepo.OrdenarVideojuegosFecha();
		req.getSession().setAttribute("consola", OrderAllVideojuego);
		redirect(req, resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("VideojuegosOrdered.jsp");
		dispatcher.forward(req, resp);
	}
}

