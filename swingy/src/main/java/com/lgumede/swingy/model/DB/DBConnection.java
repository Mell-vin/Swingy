package com.lgumede.swingy.model.DB;

//import org.sqlite.*;
import java.sql.*;
import java.util.ArrayList;

import com.lgumede.swingy.model.heroes.Filler;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class DBConnection {
    static Connection conn = null;

    public static void connect() {

        final String ffs = "org.sqlite.JDBC";
        try {
            Class.forName(ffs);
            DBConnection.conn = DriverManager.getConnection("jdbc:sqlite:SwingyHeroes.db");
            //System.out.println("Connected boii");
        } catch (final Exception e) {
            System.out.println("Eish " + e);
        }
    }

    public static void insertHero(final String name, final String heroClass, final int level, final int attack,final int defense, final int hitPoints){
        if(DBConnection.conn == null){
            DBConnection.connect();
        }
        PreparedStatement ps = null;
        try {
            final String sql = "INSERT INTO swingyHeroes (name, heroClass, level, attack, defense, hitPoints)VALUES  (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, heroClass);
            ps.setInt(3, level);
            ps.setInt(4, attack);
            ps.setInt(5, defense);
            ps.setInt(6, hitPoints);
            ps.execute();
            System.out.println("Hero Saved!");
        } catch (final Exception e) {
            System.out.println(e.toString());
        }
    }

    public static void updateHero(final FightReady hero) {
        if (DBConnection.conn == null){
            DBConnection.connect();
        }
        PreparedStatement ps = null;
        ResultSet rs = null;

        if (hero != null){
            try {
                final String sql = "UPDATE swingyHeroes set level = ?, attack = ?, defense = ?, hitPoints = ? WHERE ID = ?";
                final String sql2 = "SELECT name from swingyHeroes WHERE ID = ?";
    
                ps = DBConnection.conn.prepareStatement(sql2);
                ps.setInt(1, hero.getID());
                rs = ps.executeQuery();
                if (rs.getFetchSize() == 0) {
                    DBConnection.insertHero(hero.getName(), hero.getHeroClass(), hero.getLevel(), hero.getAttack(),
                            hero.getDefense(), hero.getHitPoints());
                } else {
                    ps = DBConnection.conn.prepareStatement(sql);
                    ps.setInt(1, hero.getLevel());
                    ps.setInt(2, hero.getAttack());
                    ps.setInt(3, hero.getDefense());
                    ps.setInt(4, hero.getHitPoints());
                    ps.setInt(5, hero.getID());
                    ps.execute();
                    System.out.println("Hero updated");
                }
            } catch (final Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public static ArrayList<FightReady> fetchHeroes() {
        final ArrayList<FightReady> heroList= new ArrayList<FightReady>();
        FightReady hero = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int x, y = 0;
        if (DBConnection.conn == null){
            DBConnection.connect();
        }
        final Filler fl = new Filler();
        
        try {
            final String sql = "SELECT * FROM swingyHeroes";
            ps = DBConnection.conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                //System.out.println("Hero is " + rs.getString("name")+ " " + rs.getString("heroClass"));
                hero = fl.newHero(rs.getString("name"), rs.getString("heroClass"));
                hero.setLevel(rs.getInt("level"));
                hero.heroLimit(hero.getLevel());
                x = (int) Math.ceil(hero.getLimit() / 2);
                y = (int) Math.ceil(hero.getLimit() / 2);
                //System.out.println("x y " + x + " " + y);
                hero.resetRowCol(x, y);
                hero.resetAttack(rs.getInt("attack"));
                hero.resetHitPoints(rs.getInt("hitPoints"));
                hero.resetDefense(rs.getInt("defense"));
                hero.setID(rs.getInt("ID"));
                heroList.add(hero);
            }
            return heroList;
        } catch (final Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
