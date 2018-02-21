package es.salesianos.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Videogame;
import es.salesianos.model.Videogame;

public class VideogameRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Videogame search(Videogame videogameForm) {
		Videogame videogameInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Videogames WHERE name = ?");
			prepareStatement.setString(1, videogameForm.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				videogameForm = new Videogame();
				videogameForm.setName(resultSet.getString(1));
				videogameForm.setRecommendedAge(resultSet.getString(2));
				videogameForm.setReleaseDate(resultSet.getDate(3));
				videogameForm.setCompanyId(resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return videogameInDatabase;
	}

	private void close(PreparedStatement prepareStatement) {
		try {
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public void delete(Videogame videogameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM Videogames WHERE name=?");
			preparedStatement.setString(1, videogameForm.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
	}
	public void insert(Videogame videogameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Videogames (name,recommendedAge, releaseDate, companyId)" + "VALUES (?, ?,?,?)");
			preparedStatement.setString(1, videogameForm.getName());
			preparedStatement.setString(2, videogameForm.getRecommendedAge());
			preparedStatement.setDate(3,videogameForm.getReleaseDate());
			preparedStatement.setInt(4,videogameForm.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
	}

	public void update(Videogame videogameForm) {
		Connection conn = manager.open(jdbcUrl);
		// codigo sql que  inserta un usuario
		manager.close(conn);
	}

	public List<Videogame> searchAll() {
		List<Videogame> listVideogames= new ArrayList<Videogame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Videogames");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setName(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setCompanyId(resultSet.getInt(4));
				listVideogames.add(videogameInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}


		manager.close(conn);
		return listVideogames;
	}
	public List<Videogame> searchAllByCompany(int id) {
		List<Videogame> listVideogames= new ArrayList<Videogame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Videogames WHERE companyId="+id);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setName(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setCompanyId(resultSet.getInt(4));
				listVideogames.add(videogameInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}


		manager.close(conn);
		return listVideogames;
	}

}
