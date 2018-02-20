package es.salesianos.model.assembler;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Company;

public class CompanyAssembler {

	public static Company assembleCompanyFrom(HttpServletRequest req) {

		Company company = new Company();
		company.setCompanyId(Integer.parseInt(req.getParameter("id")));
		company.setName(req.getParameter("name"));
		company.setCreationDate(Date.valueOf(req.getParameter("creationDate")));
		return company;
	}
}