package com.lgumede.swingy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.lgumede.swingy.model.DB.DBConnection;
import com.lgumede.swingy.view.Terminal;

public class Console {
    static int choice = 37;
    static Scanner input = new Scanner(System.in);
    static Swingy gui = new Swingy();

    public static void main(String[] args) {
        
        DBConnection.insertHero("Lightning Rod", "HR", 2, 45, 60);
		//new Terminal().menu(args);
    
    }
}