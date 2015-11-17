package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.vdab.entities.GastenboekBericht;

public class GastenboekDAO extends AbstractDAO {
	private static final String FIND_ALL_SQL = "select berichtnr,naam, bericht, tijd " + "from berichten " + "order by tijd desc";
	private static final String INSERT_SQL = "insert into berichten(naam,bericht) values (?,?)";
	private static final String DELETE_SQL = "delete from berichten where berichtnr in (";

	public List<GastenboekBericht> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL)) {
			List<GastenboekBericht> berichten = new ArrayList<>();
			while (resultSet.next()) {
				berichten.add(resultSetNaarBericht(resultSet));
			}
			return berichten;
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}

	private GastenboekBericht resultSetNaarBericht(ResultSet resultSet) throws SQLException {
		return new GastenboekBericht(resultSet.getLong("berichtnr"),resultSet.getString("naam"), resultSet.getString("bericht"),
				resultSet.getTimestamp("tijd"));
	}

	public void addBericht(GastenboekBericht geldigBericht) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_SQL)){
			statement.setString(1, geldigBericht.getNaam());
			statement.setString(2, geldigBericht.getBericht());
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}
	
	public void delete(List<Long> ids) {
		  StringBuilder deleteSQL = new StringBuilder(DELETE_SQL);
		  for (@SuppressWarnings("unused") long id : ids) {
		    deleteSQL.append("?,");
		  }
		  deleteSQL.deleteCharAt(deleteSQL.length()-1);
		  deleteSQL.append(')');
		  try (Connection connection = dataSource.getConnection();
		       PreparedStatement statement = 
		         connection.prepareStatement(deleteSQL.toString())) {
		    int index=1;
		    for (long id : ids) {
		      statement.setLong(index++, id);
		    }
		    statement.executeUpdate();
		  } catch (SQLException ex) {
		    throw new DAOException(ex);
		  }
		}

}
