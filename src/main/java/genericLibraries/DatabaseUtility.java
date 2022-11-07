package genericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains methods related to database
 * @author Hp
 *
 */
public class DatabaseUtility {
	Connection connection;
	/**
	 * This method is used to establishes the connection to database 
	 * @param database 
	 * @param databaseurl 
	 * @param dbname 
	 * @param password 
	 * @throws SQLException 
	 */
	public void openDatabaseConnection( String databaseurl, String dbname, String password) throws SQLException
	{
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver);
	    connection = DriverManager.getConnection(databaseurl,dbname,password);
		
	}
	/**
	 * 
	 * @param query 
	 * @param columnName1 
	 * @param columnName2 
	 * @return
	 * @throws SQLException 
	 */
	public List<String> fetchDataFromDatabase(String query, String columnName1, String columnName2) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list= new ArrayList<>();
		//List<Integer> list2=new ArrayList<>();
		while(result.next())
		{
			list.add(result.getString(columnName1));
			//list2.add(result.getInt(columnName2));
		}
		return list;
	}
	/**
	 * This method is used to modify the database
	 * @param query 
	 * @throws SQLException 
	 */
	public int modifyDatabase(String query) throws SQLException
	{
		Statement statement = connection.createStatement();
		int result = statement.executeUpdate(query);
		return result;
	}
	/**
	 * This method is used to close the database
	 * @throws SQLException
	 */
	
	public void closeDatabase() throws SQLException
	{
		connection.close();
	}

}
