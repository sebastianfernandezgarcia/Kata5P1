package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;        
import java.util.*;

public class Kata5P1 {

    public static void main(String[] args) {
        SelectApp app = new SelectApp();
        app.selectAll();
        
        //Version 2
        CrearTabla.createNewTable();
        
        
        //Version 3
        String email = "C:\\Users\\Sebastián Fernández\\OneDrive - Universidad de Las Palmas de Gran Canaria\\Informatica_2021_2022\\IS2\\Kata5P1\\email.txt";
        
        List<String> list = MailListReader.read(email);
        
        
        InsertarDatosTabla insertador = new InsertarDatosTabla();
        
     for (String mail : list) {
         insertador.insert(mail);
        }        
        System.out.println("DataBase Creada");
    }     
}       
    