package application;

import java.sql.*;

public class mainApp {
	
	public static void main(String[] args) {
		
		Connection connection;
		
		try {
			
			String url = "jdbc:mysql://localhost/TestJDBC?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "";
			
			connection = DriverManager.getConnection(url, user, password);
			Statement statement = connection.createStatement();
			
			Statement build = connection.createStatement();
			
			connection.setAutoCommit(false);
			
			build.execute("DROP TABLE IF EXISTS Filière");
			
			build.execute("CREATE TABLE IF NOT EXISTS Filière ("
					+ "IdFilière VARCHAR(10) PRIMARY KEY,"
					+ "Nom VARCHAR(50),"
					+ "NombreMaxEtudiant INT,"
					+ "Lieu VARCHAR(50))");
			
			build.execute("INSERT INTO Filière VALUES"
					+ "('CDA', 'Formation à distance', 15, 'Maison'),"
					+ "('Lift', 'Gros bras et Biceps', 45, 'HardnThick Gym'),"
					+ "('JV', 'Pixels & Cie', 2500, 'Online Hell Café')");
			
			build.execute("ALTER TABLE Etudiants ADD CONSTRAINT FK_Filière_Id FOREIGN KEY(Filière) REFERENCES Filière(IdFilière)");
			
			connection.commit();
			
			ResultSet result = statement.executeQuery("SELECT * FROM Etudiants");
			ResultSet result2 = build.executeQuery("SELECT * FROM Filière");
			
			while(result.next()) {
				int id = result.getInt("Id");
				String nom = result.getString("Nom");
				String prenom = result.getString("Prénom");
				String filiere = result.getString("Filière");
				
				System.out.println("Etudiant n°: " + id + ": " + nom.toUpperCase() + " " + prenom + " - " + filiere);
			}
			
			while(result2.next()) {
				String id2 = result2.getString("IdFilière");
				String nom2 = result2.getString("Nom");
				String nombre = result2.getString("NombreMaxEtudiant");
				String lieu = result2.getString("Lieu");
				
				System.out.println("Filière " + id2 + ": " + nom2 + ", " + nombre + " étudiants maximum, localisée à " + lieu + ".");
			}
			
		} catch (Exception e) {
			System.out.println("FAILED : " + e.getLocalizedMessage());
		}
	}

}
