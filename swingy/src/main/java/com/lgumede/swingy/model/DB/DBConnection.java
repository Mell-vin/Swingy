package com.lgumede.swingy.model.DB;

//import org.sqlite.*;
import java.sql.*;

public class DBConnection {
    public static Connection connect(){
        Connection conn = null;
        String ffs = "org.sqlite.JDBC";
        try {
            Class.forName(ffs);
            conn = DriverManager.getConnection("jdbc:sqlite:SwingyHeroes.db");
            System.out.println("Connected boii");
        } catch (Exception e) {
            System.out.println("Eish " + e);
        }
        return conn;
    }
}
