package com.lgumede.swingy.view;

import java.util.Scanner;

import com.lgumede.swingy.Swingy;
import com.lgumede.swingy.model.DB.DBConnection;
import com.lgumede.swingy.model.heroCnsl.HeroFactoryTmnl;
import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class Terminal {
    FightReady hero = null;
    EvilVills villain;
    static int choice = 37;
    static Swingy gui = new Swingy();
    static GUI notGUI = new GUI();
    HeroFactoryTmnl HFT = new HeroFactoryTmnl();
    static Scanner input = new Scanner(System.in);

    public void menu(){
        System.out.println("Welcome to swingy. please choose and option");

        while(choice != 0) {
            System.out.println("1) For a new character\n"
                            + "2) For a saved character\n"
                            + "3) to open the gui\n"
                            + "0) to FOH :) \n");
                            System.out.println("_______________________________________________________\n");
            choice = Integer.parseInt(input.nextLine());

            if (choice == 0){
                DBConnection.updateHero(hero);
                System.out.println("Good bye");
            }else if (choice == 1){
                hero = HFT.heroMaker();
                if (hero == null){
                    System.out.println("...");
                }  else {
                    Terminal.notGUI.consoleGame(hero, villain);
                }
            }else if (choice == 2){
                hero = HFT.prevHero();
                if (hero != null) {
                    Terminal.notGUI.consoleGame(hero, villain);
                }
            } else if (choice == 3){                
                GUI gui = new GUI();
                gui.SetWindow();
            } else {
                System.out.println("invalid choice. try again");
            }
            System.out.println("_______________________________________________________\n");
        }
    }
}
