package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    //Conectamos la BD y se devuelve objeto Conecction
    private Connection connect() {
        //SQLite connection string
        String url = "jdbc:sqlite:C:\\Users\\Sebastián Fernández\\OneDrive - Universidad de Las Palmas de Gran Canaria\\Informatica_2021_2022\\IS2\\Kata5P1\\KATA5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void selectAll(){
        String sql = "SELECT * FROM PEOPLE";
        
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            //Bucle sobre el conjunto de registros 
            
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + 
                                   rs.getString("Name") +  "\t" +
                                   rs.getString("Apellidos") +  "\t" +
                                   rs.getString("Departamento") +  "\t");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
