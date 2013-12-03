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
			//Einbinden des Oracle MySqlConnectors in java
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//Aufbau der Verbindung zur Datenbank
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?", username, password);
			con.setAutoCommit(false);
			
			//Ausführen verschiedener Statements
			Statement statement = con.createStatement();
			statement.executeQuery("use chinook");
			
			//Ausgabe der Namen aller Künstler aus der Tabelle ARTIST
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
