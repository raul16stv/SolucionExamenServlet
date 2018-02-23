package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.service.ConsoleService;

public class ListConsoleByCompany extends HttpServlet {

	private ConsoleService service = new ConsoleService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("selectedCompany"));
		List<Console> listAllConsolesByCompany = service.listAllConsolesByCompany(id);
		req.setAttribute("listAllConsolesByCompany", listAllConsolesByCompany);
		redirect(req, resp);

	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListConsoleByCompany.jsp");
		dispatcher.forward(req, resp);
	}
}
