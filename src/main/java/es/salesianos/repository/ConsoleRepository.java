package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Console;

public class ConsoleRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Console search(Console consoleForm) {
		Console consoleInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Consoles WHERE name = ?");
			preparedStatement.setString(1, consoleForm.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompanyId(resultSet.getInt(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return consoleInDatabase;
	}
	public void delete(Console consoleForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM Consoles WHERE name=?");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void insert(Console consoleForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Consoles (name,companyId)" + "VALUES (?, ?)");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setInt(2, consoleForm.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void update(Console consoleForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE Consoles SET (?,?)");
			preparedStatement.setString(1, consoleForm.getName());
			preparedStatement.setInt(2, consoleForm.getCompanyId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(conn);
		}
	}

	public List<Console> searchAll() {
		List<Console> listConsole = new ArrayList<Console>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Consoles");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Console consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompanyId(resultSet.getInt(2));
				listConsole.add(consoleInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listConsole;
	}

	public List<Console> searchAllByCompany(int id) {
		List<Console> listConsole = new ArrayList<Console>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Consoles WHERE companyId=" + id);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Console consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompanyId(resultSet.getInt(2));
				listConsole.add(consoleInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listConsole;
	}

}
