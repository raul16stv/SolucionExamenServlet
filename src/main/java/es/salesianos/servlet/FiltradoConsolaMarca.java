package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Consola;
import es.salesianos.service.Service;


public class FiltradoConsolaMarca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Service service = new Service();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Consola> listAllFiltrado = service.listAllFiltrado();
		req.setAttribute("listaAllFiltrado", listAllFiltrado);
		listadoRedirect(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("empresa", req.getParameter("empresa"));

	}
	protected void listadoRedirect(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("ListadoConsola.jsp");
		dispatcher.forward(req, resp);
	}
}