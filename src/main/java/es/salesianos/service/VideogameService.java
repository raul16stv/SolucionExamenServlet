package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.repository.ConsoleRepository;
import es.salesianos.repository.VideogameRepository;

@Service
public class VideogameService {

	@Autowired
	private VideogameRepository repository = new VideogameRepository();

	public void insert(Videogame videogame) {
		repository.insert(videogame);
	}

	public void delete(Videogame videogame) {
		repository.delete(videogame);
	}

	public List<Videogame> listAll() {
		return repository.listAll();
	}

	public List<Videogame> listAllOrderedByDate() {
		return repository.listAllOrderedByDate();
	}

	public List<Videogame> listAllOrderedByAlphabetical() {
		return repository.listAllOrderedAlphabetical();
	}

	public VideogameRepository getRepository() {
		return repository;
	}

	public void setRepository(VideogameRepository repository) {
		this.repository = repository;
	}
}
