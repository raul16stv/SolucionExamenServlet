package es.salesianos.model.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public class ConsoleAssembler {

	public static Console assembleConsoleFrom(HttpServletRequest req) {

		Console console = new Console();
		console.setName(req.getParameter("name"));
		console.setCompanyId(Integer.parseInt(req.getParameter("companyId")));
		return console;
	}
}