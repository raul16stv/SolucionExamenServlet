
package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.ConnectionH2;
import es.salesianos.connection.ConnectionManager;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public class CompanyRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test";
	ConnectionManager manager = new ConnectionH2();

	public Company search(Company companyForm) {
		Company companyInDatabase = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Companies WHERE name = ?");
			preparedStatement.setString(1, companyForm.getName());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				companyInDatabase = new Company();
				companyInDatabase.setName(resultSet.getString(1));
				companyInDatabase.setCreationDate(resultSet.getDate(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return companyInDatabase;
	}
	public void delete(Company companyForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("DELETE FROM Companies WHERE name=?");
			preparedStatement.setString(1, companyForm.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void insert(Company companyForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO Companies (name,creationDate)" + "VALUES (?,?)");
			preparedStatement.setString(1, companyForm.getName());
			preparedStatement.setDate(2, companyForm.getCreationDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public void update(Company companyForm) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("UPDATE Companies SET (?,?)");
			preparedStatement.setString(1, companyForm.getName());
			preparedStatement.setDate(2, companyForm.getCreationDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public List<Company> searchAll() {
		List<Company> listCompany = new ArrayList<Company>();
		Connection conn = manager.open(jdbcUrl);
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM Companies");
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Company companyInDatabase = new Company();
				companyInDatabase.setName(resultSet.getString(1));
				companyInDatabase.setCreationDate(resultSet.getDate(2));
				listCompany.add(companyInDatabase);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(resultSet);
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return listCompany;
	}

}
