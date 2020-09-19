package com.lgumede.swingy.view;

import java.util.Scanner;

import com.lgumede.swingy.Swingy;
import com.lgumede.swingy.model.heroCnsl.HeroFactoryTmnl;
import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class Terminal {
    FightReady hero;
    EvilVills villain;
    static int choice = 37;
    static Swingy gui = new Swingy();
    static GUI notGUI = new GUI();
    HeroFactoryTmnl HFT = new HeroFactoryTmnl();
    static Scanner input = new Scanner(System.in);

    public void menu(String[] args){
        System.out.println("Welcome to swingy. please choose and option");

        while(choice != 0) {
            System.out.println("1) For a new character\n"
                            + "2) For a saved character\n"
                            + "3) to open the gui\n"
                            + "0) to FOH :) \n");
            choice = Integer.parseInt(input.nextLine());

            if (choice == 0){
                System.out.println("Good bye");
            }else if (choice == 1){
                hero = HFT.heroMaker();
                Terminal.notGUI.consoleGame(hero, villain);
            }else if (choice == 2){
                System.out.println("Choose your saved hero");
            } else if (choice == 3){                
                Swingy.main(args);
            } else {
                System.out.println("invalid choice. try again");
            }
        }
    }
}
