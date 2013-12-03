package at.hammer.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) {
		
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?", username, password);
			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			
			statement.executeQuery("use chinook");
			
			ResultSet rsl = statement.executeQuery("SELECT * FROM ARTIST");
			while(rsl.next()) {
				System.out.println(rsl.getString("name"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
