package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.model.assembler.ConsoleAssembler;
import es.salesianos.model.assembler.VideogameAssembler;
import es.salesianos.repository.ConsoleRepository;
import es.salesianos.repository.VideogameRepository;

public class VideogameService {


	private VideogameRepository repository = new VideogameRepository();

	public Videogame assembleVideogameFromRequest(HttpServletRequest req) {
		return VideogameAssembler.assembleVideogameFrom(req);
	}

	public void insertOrUpdateVideogame(Videogame videogameForm) {
		Videogame videogameInDatabase = repository.search(videogameForm);
		if(null == videogameInDatabase){
			repository.insert(videogameForm);
		}else{
			repository.update(videogameForm);
		}
	}
	public void deleteVideogame(Videogame videogame){
		repository.delete(videogame);
	}
	public List<Videogame> listAllVideogames() {
		return repository.searchAll();
	}

	public VideogameRepository getVideogameRepository() {
		return repository;
	}

	public void setVideogameRepository(VideogameRepository repository) {
		this.repository = repository;
	}




}
