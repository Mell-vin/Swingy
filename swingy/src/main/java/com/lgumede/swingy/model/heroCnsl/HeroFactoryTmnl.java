package com.lgumede.swingy.model.heroCnsl;

import java.util.ArrayList;
import java.util.Scanner;

import com.lgumede.swingy.model.DB.DBConnection;
import com.lgumede.swingy.model.heroes.AllPower;
import com.lgumede.swingy.model.heroes.Heroes;
import com.lgumede.swingy.model.heroes.LightningRod;
import com.lgumede.swingy.model.heroes.MudSlide;
import com.lgumede.swingy.model.heroes.RockRoller;
import com.lgumede.swingy.model.heroes.WaterFlush;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class HeroFactoryTmnl {
    FightReady hero;
    Scanner input = new Scanner(System.in);

    public FightReady heroMaker() {
        int choice = 37;

        System.out.println("Choose a hero");

        while(choice != 2345) {
            System.out.println("1) For Lightning Rod\n"
                            + "2) For Water Flush\n"
                            + "3) For Rock Roller\n"
                            + "4) For Mud Slide\n"
                            + "5) For All power\n");

            choice = Integer.parseInt(input.nextLine());
            if(choice != 37){
                if (choice == 1){
                    hero = new LightningRod("Lightning Rod", "LR");
                    choice = 2345;
                } else if (choice == 2){
                    hero = new WaterFlush("Water Flush",  "WF");
                    choice = 2345;
                } else if (choice == 3){
                    hero = new RockRoller("Rock Roller", "RR");
                    choice = 2345;
                } else if (choice == 4){
                    hero = new MudSlide("Mud slide", "MS");
                    choice = 2345;
                } else if (choice == 5){
                    hero = new AllPower("All power", "AP");
                    choice = 2345;
                } else {
                    System.out.println("Invalid choice ('' - )...");
                }
                if (Heroes.validatorr(hero) == 0) {
                    return null;
                }
            }
        }
        return hero;
    }

    public FightReady prevHero() {
        ArrayList<FightReady> heroList;
        int choice = -1;

        heroList = DBConnection.fetchHeroes();
        System.out.println(heroList.size());
        if(heroList.size() > 0) {
            while (choice < heroList.size() || choice >= heroList.size()) {
                System.out.println("Choose a hero");
                for(int i = 0; i < heroList.size(); i++) {
                    System.out.println(i + 1 + ") " + heroList.get(i).getID() + " " + heroList.get(i).getName());
                }
                System.out.println("_______________________________________________________\n");
                choice = Integer.parseInt(input.nextLine());
                for(int i = 0; i < heroList.size(); i++) {
                    if ((choice - 1) == i){
                        return heroList.get(i);
                    } else if (choice < 0 || choice > heroList.size()){
                        System.out.println("No such option. choose again");
                        break;
                    }
                }
            }
            
        } else {
            System.out.println("No saved heroes");
        }
        return null;
    }
}
