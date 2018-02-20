package es.salesianos.model;

import java.sql.Date;

public class Company {

	private String name;
	private Date creationDate;
	private int id;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getCompanyId() {
		return id;
	}
	public void setCompanyId(int id) {
		this.id = id;
	}

}
