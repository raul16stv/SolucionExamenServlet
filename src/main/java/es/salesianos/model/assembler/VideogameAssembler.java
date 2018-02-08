package es.salesianos.model.assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public class VideogameAssembler {

	public static Videogame assembleVideogameFrom(HttpServletRequest req) {

		Videogame videogame = new Videogame();
		videogame.setName(req.getParameter("name"));
		videogame.setRecommendedAge(req.getParameter("recommendedAge"));
		videogame.setReleaseDate(Date.valueOf((req.getParameter("releaseDate"))));

		return videogame;
	}
}