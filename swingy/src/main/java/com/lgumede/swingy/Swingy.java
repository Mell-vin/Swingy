package com.lgumede.swingy;

import com.lgumede.swingy.view.GUI;
import com.lgumede.swingy.view.Terminal;

public class Swingy {

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("GUI")){
                GUI gui = new GUI();
                gui.SetWindow();
            } else if(args[0].equals("console")){
                new Terminal().menu();
            } else {
                System.out.println("Invalid choice");
            }
        } else {
            System.out.println("nothing selected");
        }
    }
}
