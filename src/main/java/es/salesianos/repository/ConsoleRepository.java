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

import es.salesianos.model.Console;

@Repository
public class ConsoleRepository {

	@Autowired
	private JdbcTemplate template;
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Console console) {
		String sql = "INSERT INTO Consoles (name, companyId)" + "VALUES ( :name,:companyId)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		params.addValue("companyId", console.getCompanyId());
		namedJdbcTemplate.update(sql, params);
	}
	public void delete(Console console) {
		String sql = "DELETE FROM Consoles WHERE(name)=(:name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		namedJdbcTemplate.update(sql, params);
	}

	public List<Console> listAll() {
		String sql = "SELECT * FROM Consoles";
		List<Console> consoles = template.query(sql, new BeanPropertyRowMapper(Console.class));
		return consoles;
	}
	public List<Console> listAllByCompany() {
		String sql = "SELECT * FROM Consoles WHERE (companyId)=(:companyId)";
		List<Console> consoles = template.query(sql, new BeanPropertyRowMapper(Console.class));
		return consoles;
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
