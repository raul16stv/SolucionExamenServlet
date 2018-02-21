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
		Console consoleInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Consoles WHERE name = ?");
			prepareStatement.setString(1, consoleForm.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompanyId(resultSet.getInt(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return consoleInDatabase;
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
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
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
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
	}

	public void update(Console consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		// codigo sql que  inserta un usuario
		manager.close(conn);
	}

	public List<Console> searchAll() {
		List<Console> listConsoles= new ArrayList<Console>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Consoles");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompanyId(resultSet.getInt(2));

				listConsoles.add(consoleInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}


		manager.close(conn);
		return listConsoles;
	}
	public List<Console> searchAllByCompany(int id) {
		List<Console> listConsoles= new ArrayList<Console>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Consoles WHERE companyId="+id);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console consoleInDatabase = new Console();
				consoleInDatabase.setName(resultSet.getString(1));
				consoleInDatabase.setCompanyId(resultSet.getInt(2));

				listConsoles.add(consoleInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}


		manager.close(conn);
		return listConsoles;
	}


}
