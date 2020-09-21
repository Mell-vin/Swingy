package com.lgumede.swingy;

import com.lgumede.swingy.model.DB.DBConnection;
import com.lgumede.swingy.view.GUI;

public class Swingy {

    public static void main(String[] args) {
        new DBConnection().connect();
        System.out.println("Hau, and den");
        GUI gui = new GUI();
        gui.SetWindow();
    }
}
