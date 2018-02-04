package es.salesianos.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Consola;
import es.salesianos.model.assembler.ConsolaAssembler;
import es.salesianos.service.Service;


public class AltaConsola extends HttpServlet{

	private Service service = new Service();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Consola user = service.assembleUserFromRequest(req);
		service.insertOrUpdateConsole(user);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AltaConsola.jsp");
		dispatcher.forward(req,resp);
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}



}
