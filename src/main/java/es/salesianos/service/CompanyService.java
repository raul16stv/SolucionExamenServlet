package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.repository.CompanyRepository;
import es.salesianos.repository.ConsoleRepository;
import es.salesianos.repository.VideogameRepository;
@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository = new CompanyRepository();

	public void insert(Company company) {
		repository.insert(company);
	}
	public void delete(Company company) {
		repository.delete(company);
	}
	public List<Company> listAll() {
		return repository.listAll();
	}

	public CompanyRepository getRepository() {
		return repository;
	}

	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}
}
