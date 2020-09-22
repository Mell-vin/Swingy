package com.lgumede.swingy.model.DB;

//import org.sqlite.*;
import java.sql.*;
import java.util.ArrayList;

import com.lgumede.swingy.model.heroes.Filler;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class DBConnection {
    static Connection conn = null;

    public static Connection connect() {

        String ffs = "org.sqlite.JDBC";
        try {
            Class.forName(ffs);
            conn = DriverManager.getConnection("jdbc:sqlite:SwingyHeroes.db");
            //System.out.println("Connected boii");
        } catch (Exception e) {
            System.out.println("Eish " + e);
        }
        return conn;
    }

    public static void insertHero(String name, String heroClass, int level, int attack,int defense, int hitPoints){
        conn = DBConnection.connect();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO swingyHeroes (name, heroClass, level, attack, defense, hitPoints)VALUES  (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, heroClass);
            ps.setInt(3, level);
            ps.setInt(4, attack);
            ps.setInt(5, defense);
            ps.setInt(6, hitPoints);
            ps.execute();
            System.out.println("Hero Saved!");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static ArrayList<FightReady> fetchHeroes() {
        ArrayList<FightReady> heroList= new ArrayList<FightReady>();
        FightReady hero = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        conn = DBConnection.connect();
        Filler fl = new Filler();
        
        try {
            String sql = "SELECT * FROM swingyHeroes";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                System.out.println("Hero is " + rs.getString("name")+ " " + rs.getString("heroClass"));
                hero = fl.newHero(rs.getString("name"), rs.getString("heroClass"));
                hero.setLevel(rs.getInt("level"));
                hero.setAttack(rs.getInt("attack"));
                hero.setHitPoints(rs.getInt("hitPoints"));
                hero.setDefense(rs.getInt("defense"));
                hero.setID(rs.getInt("ID"));
                heroList.add(hero);
            }
            return heroList;
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
