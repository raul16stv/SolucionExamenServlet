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


public class Service {


	private Repository repository = new Repository();

	public Consola assembleUserFromRequest(HttpServletRequest req) {
		return ConsolaAssembler.assembleUserFrom(req);
	}

	public void insertOrUpdateConsole(Consola userFormulario) {
		Consola userInDatabase = repository.search(userFormulario);
		if(null == userInDatabase){
			repository.insert(userFormulario);
		}else{
			repository.update(userFormulario);
		}
	}
	public void deleteConsola(Consola consola){
		repository.filtrarMarcas(consola);
	}
	public void filtrarConsola(Consola consola){
		repository.delete(consola);
	}
	public List<Consola> listAllUsers() {
		return repository.searchAll();
	}

	public List<Consola> listAllFiltrado() {
		return repository.filtrado();
	}



	public Repository getRepository() {
		return repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}




}
