package es.salesianos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.VideogameService;

@Controller
public class VideogameController extends HttpServlet {
	@Autowired
	private VideogameService service;

	@GetMapping("/Videogame")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("ListVideogame", "command", new Videogame());
		modelAndView.addObject("ListVideogame", service.listAll());
		return modelAndView;
	}

	@GetMapping("/VideogameByDate")
	public ModelAndView listOrderedByDate() {
		ModelAndView modelAndView = new ModelAndView("ListVideogameDate", "command", new Videogame());
		modelAndView.addObject("VideogameByDate", service.listAllOrderedByDate());
		return modelAndView;
	}

	@GetMapping("/VideogameOrderedAlphabetical")
	public ModelAndView listOrderedAlphabetical() {
		ModelAndView modelAndView = new ModelAndView("ListVideogameAlphabetical", "command", new Videogame());
		modelAndView.addObject("ListVideogameAlphabetical", service.listAllOrderedByAlphabetical());
		return modelAndView;
	}

	@GetMapping("/VideogameInsert")
	public ModelAndView create() {
		return new ModelAndView("CreateVideogame", "command", new Videogame());
	}

	@PostMapping("/VideogameInsert")
	public ModelAndView create(@ModelAttribute("Videogame") Videogame videogame) {
		service.insert(videogame);
		return new ModelAndView("CreateVideogame", "command", new Videogame());
	}

	@GetMapping("/VideogameDelete")
	public ModelAndView delete(@ModelAttribute("Videogame") Videogame videogame) {
		return new ModelAndView("CreateVideogame", "command", new Videogame());
	}

	@PostMapping("/VideogameDelete")
	public ModelAndView deleteVideogame(@ModelAttribute("Videogame") Videogame videogame) {
		service.delete(videogame);
		return new ModelAndView("CreateVideogame", "command", new Videogame());
	}
}
