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
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.VideogameService;



public class CreateVideogame extends HttpServlet{

	private VideogameService service = new VideogameService();

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Videogame videogame = service.assembleVideogameFromRequest(req);
		service.insertOrUpdateVideogame(videogame);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CreateVideogame.jsp");
		dispatcher.forward(req,resp);
	}

	public VideogameService getService() {
		return service;
	}

	public void setVideogameService(VideogameService service) {
		this.service = service;
	}



}
