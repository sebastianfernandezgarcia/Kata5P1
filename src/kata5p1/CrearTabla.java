package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
    public static void createNewTable() {
        //Cadena de conexion SQLite
         String url = "jdbc:sqlite:C:\\Users\\Sebastián Fernández\\OneDrive - Universidad de Las Palmas de Gran Canaria\\Informatica_2021_2022\\IS2\\Kata5P1\\mail.db";
         
         //Instruccion SQL para crear nueva tabla
         String sql = "CREATE TABLE IF NOT EXISTS direcc_email (\n"
                 + " id integer PRIMARY KEY AUTOINCREMENT, \n"
                 + " direccion text NOT NULL);";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             //Se crea la nueva tabla
             stmt.execute(sql);
             System.out.println("Tabla creada");
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         } 
    }
}
