package be.vdab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import be.vdab.entities.Saus;

public class SausDAO extends AbstractDAO {
	  private static final String FIND_ALL_SQL = 
	    "select sauzen.id, sauzen.naam as sausnaam," +
	    " ingrediënten.naam as ingredientnaam" +
	    " from sauzen left join ingrediënten_in_saus" +
	    " on sauzen.id=ingrediënten_in_saus.sauzen_id" +
	    " left join ingrediënten " +
	    " on ingrediënten_in_saus.ingrediënten_id=ingrediënten.id" +
	    " order by sauzen.naam"; 
	  
	  private static final String FIND_BY_INGREDIENT_SQL =
	    "select sauzen.id, sauzen.naam as sausnaam" +
	    " from sauzen inner join ingrediënten_in_saus " + 
	    " on sauzen.id=ingrediënten_in_saus.sauzen_id" +
	    " inner join ingrediënten" +
	    " on ingrediënten_in_saus.ingrediënten_id=ingrediënten.id" +
	    " where ingrediënten.naam = ?" + " order by sauzen.naam"; 
	  
	  private static final String DELETE_SAUS = "delete from sauzen where id=?";
	  
	  public List<Saus> findAll() { 
	    try(Connection connection = dataSource.getConnection();
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(FIND_ALL_SQL)) {
	      List<Saus> sauzen = new ArrayList<>();
	      for (long vorigeId = 0; resultSet.next();) {
	        long id = resultSet.getLong("id");
	        if (id != vorigeId) {
	          sauzen.add(resultSetRijNaarSausZonderIngredienten(resultSet));
	          vorigeId = id;
	        }
	        sauzen.get(sauzen.size() - 1).addIngredient(
	          resultSet.getString("ingredientnaam"));
	      }
	      return sauzen;
	    } catch (SQLException ex) {
	      throw new DAOException(ex);
	    }
	  } 

	  public List<Saus> findByIngredient(String ingredient) {
	    try (Connection connection = dataSource.getConnection();
	         PreparedStatement statement = connection.prepareStatement(
	           FIND_BY_INGREDIENT_SQL)) {
	      statement.setString(1, ingredient);
	      List<Saus> sauzen = new ArrayList<>();
	      try (ResultSet resultSet = statement.executeQuery()) {
	        while (resultSet.next()) {
	          sauzen.add(resultSetRijNaarSausZonderIngredienten(resultSet));
	        }
	        return sauzen;
	       }
	    } catch (SQLException ex) {
	        throw new DAOException(ex);
	    }
	  } 
	  
	  private Saus resultSetRijNaarSausZonderIngredienten(ResultSet resultSet)
	    throws SQLException {
	    return new Saus(resultSet.getLong("id"), resultSet.getString("sausnaam"),new ArrayList<String>());
	  }

	public void delete(long id) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_SAUS)) {
			statement.setLong(1, id);
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new DAOException(ex);
		}
	}
	
}
