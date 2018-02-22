package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Console;
import es.salesianos.repository.ConsoleRepository;

@Service
public class ConsoleService {

	@Autowired
	private ConsoleRepository repository = new ConsoleRepository();

	public void insert(Console console) {
		repository.insert(console);
	}
	public void delete(Console console) {
		repository.delete(console);
	}
	public List<Console> listAll() {
		return repository.listAll();
	}

	public List<Console> listAllByCompany() {
		return repository.listAllByCompany();
	}
	public ConsoleRepository getRepository() {
		return repository;
	}

	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}
}
