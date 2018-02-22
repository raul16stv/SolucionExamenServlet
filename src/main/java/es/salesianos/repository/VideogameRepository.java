package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
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
import es.salesianos.model.Videogame;
@Repository
public class VideogameRepository {

	@Autowired
	private JdbcTemplate template;
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public void insert(Videogame videogame) {
		String sql = "INSERT INTO Videogames (name,recommendedAge , releaseDate,companyId)" + "VALUES ( :name,:recommendedAge,:releaseDate,:companyId)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", videogame.getName());
		params.addValue("recommendedAge", videogame.getRecommendedAge());
		params.addValue("releaseDate", videogame.getReleaseDate());
		params.addValue("companyId", videogame.getCompanyId());
		namedJdbcTemplate.update(sql, params);

	}
	public List<Videogame> listAllOrderedByDate() {
		String sql = "SELECT * FROM Videogames ORDER BY releaseDate ASC";
		List<Videogame> videogames = template.query(sql, new BeanPropertyRowMapper(Videogame.class));
		return videogames;
	}
	public List<Videogame> listAllOrderedAlphabetical() {
		String sql = "SELECT * FROM Videogames ORDER BY name";
		List<Videogame> videogames = template.query(sql, new BeanPropertyRowMapper(Videogame.class));
		return videogames;
	}

	public void delete(Videogame videogame) {
		String sql = "DELETE FROM Videogames WHERE (name)=(:name)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", videogame.getName());
		namedJdbcTemplate.update(sql, params);

	}

	public List<Videogame> listAll() {
		String sql = "SELECT * FROM Videogames";
		List<Videogame> videogames = template.query(sql, new BeanPropertyRowMapper(Videogame.class));
		return videogames;
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
