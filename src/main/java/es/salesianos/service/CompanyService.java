package es.salesianos.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.model.assembler.CompanyAssembler;
import es.salesianos.model.assembler.ConsoleAssembler;
import es.salesianos.repository.CompanyRepository;
import es.salesianos.repository.ConsoleRepository;

public class CompanyService {

	private CompanyRepository repository = new CompanyRepository();

	public Company assembleUserFromRequest(HttpServletRequest req) {
		return CompanyAssembler.assembleCompanyFrom(req);
	}
	public void insertOrUpdateCompany(Company companyForm) {
		Company companyInDatabase = repository.search(companyForm);
		if(null == companyInDatabase){
			repository.insert(companyForm);
		}else{
			repository.update(companyForm);
		}
	}
	public void createNewCompanyFromRequest(Company companyForm) {
			repository.insert(companyForm);
	}
	public List<Company> listAllCompany() {
		return repository.searchAll();
	}
	public CompanyRepository getRepository() {
		return repository;
	}
	public void setRepository(CompanyRepository repository) {
		this.repository = repository;
	}


}
