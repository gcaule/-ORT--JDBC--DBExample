package application;

import java.sql.*;

public class mainApp {
	
	public static void main(String[] args) {
		
		try {
			
			String url = "jdbc:mysql://localhost/TestJDBC?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "";
			
			Connection connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM Etudiants");
			
			while(result.next()) {
				int id = result.getInt("id");
				String nom = result.getString("Nom");
				String prenom = result.getString("Prénom");
				String filiere = result.getString("Filière");
				
				System.out.println("Etudiant n°: " + id + ": " + nom.toUpperCase() + " " + prenom + " - " + filiere);
			}
		} catch (Exception e) {
			System.out.println("FAILED : " + e.getLocalizedMessage());
		}
	}

}
