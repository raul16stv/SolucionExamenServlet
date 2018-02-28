package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

@Repository
public class CompanyRepository {

	@Autowired
	private JdbcTemplate template;
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Company company) {
		String sql = "INSERT INTO Companies (id, name, creationDate)" + "VALUES (:id, :name,:creationDate)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", company.getId());
		params.addValue("name", company.getName());
		params.addValue("creationDate", company.getCreationDate());
		namedJdbcTemplate.update(sql, params);
	}

	public void delete(Company company) {
		String sql = "DELETE FROM Companies WHERE (id)=(:id)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", company.getId());
		namedJdbcTemplate.update(sql, params);
	}

	public List<Company> listAll() {
		String sql = "SELECT * FROM Companies";
		List<Company> companies = template.query(sql, new BeanPropertyRowMapper(Company.class));
		return companies;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

}
