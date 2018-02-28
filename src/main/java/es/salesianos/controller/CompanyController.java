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

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.CompanyService;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.VideogameService;

@Controller
public class CompanyController extends HttpServlet {
	@Autowired
	private CompanyService service;

	@GetMapping("/Company")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("ListCompany", "command", new Company());
		modelAndView.addObject("ListCompany", service.listAll());
		return modelAndView;
	}

	@GetMapping("/CompanyInsert")
	public ModelAndView create() {
		return new ModelAndView("CreateCompany", "command", new Company());
	}

	@PostMapping("/CompanyInsert")
	public ModelAndView insert(@ModelAttribute("Company") Company company) {
		service.insert(company);
		return new ModelAndView("CreateCompany", "command", new Company());
	}

	@GetMapping("/CompanyDelete")
	public ModelAndView delete(@ModelAttribute("Company") Company company) {
		return new ModelAndView("ListCompany", "command", new Company());
	}

	@PostMapping("/CompanyDelete")
	public ModelAndView deleteCompany(@ModelAttribute("Company") Company company) {
		service.delete(company);
		return new ModelAndView("ListCompany", "command", new Company());
	}
}
