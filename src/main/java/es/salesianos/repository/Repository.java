package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Consola;

public class Repository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Consola search(Consola consolaFormulario) {
		Consola consolaInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Consolas WHERE nombre = ?");
			prepareStatement.setString(1, consolaFormulario.getNombre());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				consolaInDatabase = new Consola();
				consolaInDatabase.setNombre(resultSet.getString(1));
				consolaInDatabase.setEmpresa(resultSet.getString(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);

		}
		manager.close(conn);
		return consolaInDatabase;
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
	public void delete(Consola consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM Consolas WHERE nombre=?");
			preparedStatement.setString(1, consolaFormulario.getNombre());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
	}
	public void filtrarMarcas(Consola consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Consolas WHERE empresa=? ");
			preparedStatement.setString(1, consolaFormulario.getEmpresa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
	}
	public void insert(Consola consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Consolas (nombre,empresa)" + "VALUES (?, ?)");
			preparedStatement.setString(1, consolaFormulario.getNombre());
			preparedStatement.setString(2, consolaFormulario.getEmpresa());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(preparedStatement);
		}


		manager.close(conn);
	}

	public void update(Consola consolaFormulario) {
		Connection conn = manager.open(jdbcUrl);
		// codigo sql que  inserta un usuario
		manager.close(conn);
	}

	public List<Consola> searchAll() {
		List<Consola> listConsolas= new ArrayList<Consola>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Consolas");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Consola consolaInDatabase = new Consola();
				consolaInDatabase.setNombre(resultSet.getString(1));
				consolaInDatabase.setEmpresa(resultSet.getString(2));

				listConsolas.add(consolaInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}


		manager.close(conn);
		return listConsolas;
	}
	public List<Consola> filtrado() {
		List<Consola> listConsolas= new ArrayList<Consola>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = conn.prepareStatement("SELECT * FROM Consolas WHERE empresa=?");
			resultSet = prepareStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			close(resultSet);
			close(prepareStatement);
		}


		manager.close(conn);
		return listConsolas;
	}


}
