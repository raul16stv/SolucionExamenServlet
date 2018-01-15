package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Consola;
import es.salesianos.model.assembler.ConsolaAssembler;
import es.salesianos.repository.Repository;
import es.salesianos.utils.DateConverter;

public class Service {
	
	
	private Repository repository = new Repository();
	private DateConverter converter = new DateConverter();
	
	
	public Consola assembleUserFromRequest(HttpServletRequest req) {
		return ConsolaAssembler.assembleUserFrom(req);
	}

	public void insertOrUpdate(Consola userFormulario) {
		Consola userInDatabase = repository.search(userFormulario);
		if(null == userInDatabase){
			repository.insert(userFormulario);
		}else{
			repository.update(userFormulario);
		}
	}


	
	
	public List<Consola> listAllUsers() {
		return repository.searchAll();
	}
	
	
	public DateConverter getConverter() {
		return converter;
	}
	public void setConverter(DateConverter converter) {
		this.converter = converter;
	}

	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}
	
	
	

}
