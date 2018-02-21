package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Console;
import es.salesianos.model.assembler.ConsoleAssembler;
import es.salesianos.repository.ConsoleRepository;

public class ConsoleService {


	private ConsoleRepository repository = new ConsoleRepository();

	public Console assembleUserFromRequest(HttpServletRequest req) {
		return ConsoleAssembler.assembleConsoleFrom(req);
	}

	public void insertOrUpdateConsole(Console consoleForm) {
		Console consoleInDatabase = repository.search(consoleForm);
		if(null == consoleInDatabase){
			repository.insert(consoleForm);
		}else{
			repository.update(consoleForm);
		}
	}
	public void deleteConsole(Console console){
		repository.delete(console);
	}
	public List<Console> listAllConsoles() {
		return repository.searchAll();
	}
	public List<Console> listAllConsolesByCompany(int id) {
		return repository.searchAllByCompany(id);
	}

	public ConsoleRepository getConsoleRepository() {
		return repository;
	}

	public void setRepository(ConsoleRepository repository) {
		this.repository = repository;
	}




}
