package com.lgumede.swingy.model.DB;

//import org.sqlite.*;
import java.sql.*;

public class DBConnection {
    static Connection conn = null;

    public static Connection connect() {

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

    public static void insertHero(String name, String heroClass, int level, int attack, int hitPoints){
        conn = DBConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO swingyHeroes (name, heroClass, level, attack, hitPoints)VALUES  (?,?,?,?,?)";
            ps =conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, heroClass);
            ps.setInt(3, level);
            ps.setInt(4, attack);
            ps.setInt(5, hitPoints);
            ps.execute();
            System.out.println("Hero Saved!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
