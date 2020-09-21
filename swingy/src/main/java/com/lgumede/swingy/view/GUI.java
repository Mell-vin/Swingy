package com.lgumede.swingy.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.lgumede.swingy.Console;
import com.lgumede.swingy.model.heroes.AllPower;
import com.lgumede.swingy.model.heroes.LightningRod;
import com.lgumede.swingy.model.heroes.MudSlide;
import com.lgumede.swingy.model.heroes.RockRoller;
import com.lgumede.swingy.model.heroes.WaterFlush;
import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;

public class GUI implements ActionListener {
	static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel alerts = new JLabel("");
    static Console cnsl = new Console();
    Panels viewPanels = new Panels();
    FightReady hero;
    EvilVills villain;

    public void SetWindow() {
        // configuring our window
    	frame.setSize(800, 750); // set the si--,.. duuh
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPanels.setBtns();
        for(int i = 0; i < this.viewPanels.allBtns.length; i++){
            this.viewPanels.allBtns[i].addActionListener(this);
        }
        GUI.panel = viewPanels.startView(GUI.panel, viewPanels);
        frame.add(panel);
        frame.setVisible(true); //duuh
    }

    public void consoleGame(FightReady hero, EvilVills villain) {
        int choice = 37;
        Scanner input = new Scanner(System.in);
        viewPanels.setBtns();
        viewPanels.gameView(panel, viewPanels, hero, villain);

        while(choice != 0) {
            System.out.println("8) to move up the grid\n"
                            + "2) to move down the grid\n"
                            + "4) to move to the left of the grid\n"
                            + "6) to move to the right of the grid\n"
                            + "1) to run\n"
                            + "3) to fight\n"
                            + "7) to restart\n"
                            + "9) for next level\n"
                            + "5) to start GUI\n"
                            + "0) to return to start\n");
            System.out.println("_______________________________________________________\n");
            choice = Integer.parseInt(input.nextLine());

            if (choice == 0){
                System.out.println("Good bye");
                return;
            }else if (choice == 2){
                System.out.println("\nmoving down\n");
                this.viewPanels.moveHero(panel, 2, hero, viewPanels.allBtns);
            }else if (choice == 4){
                System.out.println("\nmoving left\n");
                this.viewPanels.moveHero(panel, 4, hero, viewPanels.allBtns);
            } else if (choice == 6){      
                System.out.println("\nmoving right\n");          
                this.viewPanels.moveHero(panel, 3, hero, viewPanels.allBtns);
            } else if (choice == 8){
                System.out.println("\nmoving up\n");
                this.viewPanels.moveHero(panel, 1, hero, viewPanels.allBtns);
            } else if (choice == 1){                
                if ((new Random()).nextInt(4) == 1){
                    this.viewPanels.CC.runAway(panel, hero, this.viewPanels.grid, this.viewPanels.alert);
                } else {
                    this.viewPanels.CC.fight(panel, this.viewPanels, hero, this.viewPanels.grid);
                }
            } else if (choice == 5){                
                //
            } else if (choice == 7 || choice == 9){                
                viewPanels.alert.setText(" ");
                hero.resetRowCol((int) Math.ceil(hero.getLimit()/ 2), hero.getLimit()/ 2);
                viewPanels.gameView(panel, viewPanels, hero, villain);
            }
            System.out.println("_______________________________________________________\n");
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewPanels.allBtns[0]) {
            GUI.panel = viewPanels.scndView(panel, viewPanels);

        } else if (e.getSource() == viewPanels.allBtns[1]) {
            System.out.println("Prev");

        }  else if (e.getSource() == viewPanels.allBtns[2]) {
            hero = new LightningRod("Lightning Rod", "LR");
            viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[3]) {
            hero = new WaterFlush("Water Flush",  "WF");
            viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[4]) {
            hero = new RockRoller("Rock Roller", "RR");
            viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[5]) {
            hero = new MudSlide("Mud slide", "MS");
            this.viewPanels.setPlayGrid(hero.getLevel());
            viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[6]) {
            hero = new AllPower("All power", "AP");
            viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[7]) {
            this.viewPanels.moveHero(panel, 1, hero, viewPanels.allBtns);
        }  else if (e.getSource() == viewPanels.allBtns[8]) {
            this.viewPanels.moveHero(panel, 2, hero, viewPanels.allBtns);
        }  else if (e.getSource() == viewPanels.allBtns[9]) {
            this.viewPanels.moveHero(panel, 3, hero, viewPanels.allBtns);
        }  else if (e.getSource() == viewPanels.allBtns[10]) {
            this.viewPanels.moveHero(panel, 4, hero, viewPanels.allBtns);
        }  else if (e.getSource() == viewPanels.allBtns[11]) {
            this.viewPanels.CC.fight(panel, this.viewPanels, hero, this.viewPanels.grid);
        }  else if (e.getSource() == viewPanels.allBtns[12]) {
            if ((new Random()).nextInt(4) == 1){
                this.viewPanels.CC.runAway(panel, hero, this.viewPanels.grid, this.viewPanels.alert);
            } else {
                this.viewPanels.CC.fight(panel, this.viewPanels, hero, this.viewPanels.grid);
            }
        }  else if (e.getSource() == viewPanels.allBtns[14] || e.getSource() == viewPanels.allBtns[13]) {
            viewPanels.alert.setText(" ");
            hero.resetRowCol((int) Math.ceil(hero.getLimit()/ 2), hero.getLimit()/ 2);
            viewPanels.gameView(panel, viewPanels, hero, villain);
        }   else if (e.getSource() == viewPanels.allBtns[15]) {
            //Console.main(null);
        }
    }
}
// 🤣🤣🤣🤣🤣