package es.salesianos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Console;
import es.salesianos.service.ConsoleService;

@Controller
public class ConsoleController extends HttpServlet{

	@Autowired
	private ConsoleService service;

	@GetMapping("/ListConsole")
	public ModelAndView ListConsole() {
		ModelAndView modelAndView = new ModelAndView("ListConsole", "command", new Console());
		modelAndView.addObject("ListConsole", service.listAll());
		return modelAndView;
	}
	@PostMapping("/ListConsole")
	public ModelAndView List() {
		ModelAndView modelAndView = new ModelAndView("ListConsole", "command", new Console());
		modelAndView.addObject("ListConsole", service.listAll());
		return modelAndView;
	}
	@GetMapping("/ConsoleInsert")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("CreateConsole", "command", new Console());
		return modelAndView;
	}
	@PostMapping("/ConsoleInsert")
	public ModelAndView insert(@ModelAttribute("console") Console console) {
		service.insert(console);
		return new ModelAndView("CreateConsole", "command", new Console());
	}
	@GetMapping("/ConsoleDelete")
	public ModelAndView delete(@ModelAttribute("Console") Console console) {
		return new ModelAndView("ListConsole", "command", new Console());
	}
	@PostMapping("/ConsoleDelete")
	public ModelAndView deleteConsole(@ModelAttribute("Console") Console console) {
		service.delete(console);
		return new ModelAndView("ListConsole", "command", new Console());
	}
}
