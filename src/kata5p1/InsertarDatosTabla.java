
package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class InsertarDatosTabla {

    private Connection connect() {
        String url = "jdbc:sqlite:C:\\Users\\Sebastián Fernández\\OneDrive - Universidad de Las Palmas de Gran Canaria\\Informatica_2021_2022\\IS2\\Kata5P1\\mail.db";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
    
    public void insert(String email) {
        String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
        try (Connection connection = this.connect();
                PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setString(1, email);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

