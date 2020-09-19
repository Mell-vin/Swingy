package com.lgumede.swingy.model.heroCnsl;

import java.util.Scanner;

import com.lgumede.swingy.model.heroes.AllPower;
import com.lgumede.swingy.model.heroes.LightningRod;
import com.lgumede.swingy.model.heroes.MudSlide;
import com.lgumede.swingy.model.heroes.RockRoller;
import com.lgumede.swingy.model.heroes.WaterFlush;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class HeroFactoryTmnl {
    FightReady hero;
    public FightReady heroMaker() {
        int choice = 37;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose a hero");

        while(choice != 0) {
            System.out.println("1) For Lightning Rod\n"
                            + "2) For Water Flush\n"
                            + "3) For Rock Roller\n"
                            + "4) For Mud Slide\n"
                            + "5) For All power\n");

            choice = Integer.parseInt(input.nextLine());
            if(choice != 37){
                if (choice == 1){
                    hero = new LightningRod("Lightning Rod", "LR");
                    choice = 0;
                } else if (choice == 2){
                    hero = new WaterFlush("Water Flush",  "WF");
                    choice = 0;
                } else if (choice == 3){
                    hero = new RockRoller("Rock Roller", "RR");
                    choice = 0;
                } else if (choice == 4){
                    hero = new MudSlide("Mud slide", "MS");
                    choice = 0;
                } else if (choice == 5){
                    hero = new AllPower("All power", "AP");
                    choice = 0;
                } else {
                    System.out.println("Invalid choice ('' - )...");
                }
            }
        }
        return hero;
    }
}
