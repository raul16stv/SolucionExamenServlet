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
		Videogame videogameInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Videogames WHERE name = ?");
			preparedStatement.setString(1, videogameForm.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				videogameForm = new Videogame();
				videogameForm.setName(resultSet.getString(1));
				videogameForm.setRecommendedAge(resultSet.getString(2));
				videogameForm.setReleaseDate(resultSet.getDate(3));
				videogameForm.setCompanyId(resultSet.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return videogameInDatabase;
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
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void insert(Videogame videogameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Videogames (name,recommendedAge, releaseDate, companyId)" + "VALUES (?, ?,?,?)");
			preparedStatement.setString(1, videogameForm.getName());
			preparedStatement.setString(2, videogameForm.getRecommendedAge());
			preparedStatement.setDate(3, videogameForm.getReleaseDate());
			preparedStatement.setInt(4, videogameForm.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void update(Videogame videogameForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE Videogames SET (?, ?, ?, ?)");
			preparedStatement.setString(1, videogameForm.getName());
			preparedStatement.setString(2, videogameForm.getRecommendedAge());
			preparedStatement.setDate(3, videogameForm.getReleaseDate());
			preparedStatement.setInt(4, videogameForm.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public List<Videogame> searchAll() {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Videogames");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setName(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setCompanyId(resultSet.getInt(4));
				listVideogame.add(videogameInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listVideogame;
	}

	public List<Videogame> searchAllByCompany(int id) {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Videogames WHERE companyId=" + id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setName(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setCompanyId(resultSet.getInt(4));
				listVideogame.add(videogameInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listVideogame;
	}

	public List<Videogame> searchAllOrderedAlphabetical() {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Videogames ORDER BY name ASC");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setName(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setCompanyId(resultSet.getInt(4));
				listVideogame.add(videogameInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listVideogame;
	}

	public List<Videogame> searchAllOrderedDate() {
		List<Videogame> listVideogame = new ArrayList<Videogame>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Videogames ORDER BY releaseDate ASC");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setName(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setCompanyId(resultSet.getInt(4));
				listVideogame.add(videogameInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listVideogame;
	}

}
