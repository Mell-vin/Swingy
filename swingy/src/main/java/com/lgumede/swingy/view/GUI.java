package com.lgumede.swingy.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewPanels.allBtns[0]) {
            GUI.panel = viewPanels.scndView(panel, viewPanels);

        } else if (e.getSource() == viewPanels.allBtns[1]) {
            System.out.println("Prev");

        }  else if (e.getSource() == viewPanels.allBtns[2]) {
            hero = new LightningRod("Lightning Rod", "LR");
            GUI.panel = viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[3]) {
            hero = new WaterFlush("Water Flush",  "WF");
            GUI.panel = viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[4]) {
            hero = new RockRoller("Rock Roller", "RR");
            GUI.panel = viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[5]) {
            hero = new MudSlide("Mud slide", "MS");
            this.viewPanels.setPlayGrid(hero.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[6]) {
            hero = new AllPower("All power", "AP");
            GUI.panel = viewPanels.gameView(panel, viewPanels, hero, villain);

        }  else if (e.getSource() == viewPanels.allBtns[7]) {
            this.viewPanels.moveHero(panel, 1, hero);
        }  else if (e.getSource() == viewPanels.allBtns[8]) {
            this.viewPanels.moveHero(panel, 2, hero);
        }  else if (e.getSource() == viewPanels.allBtns[9]) {
            this.viewPanels.moveHero(panel, 3, hero);
        }  else if (e.getSource() == viewPanels.allBtns[10]) {
            this.viewPanels.moveHero(panel, 4, hero);
        }  else if (e.getSource() == viewPanels.allBtns[11]) {
            this.viewPanels.CC.fight(panel, this.viewPanels, hero, this.viewPanels.grid);
        }  else if (e.getSource() == viewPanels.allBtns[12]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[13]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[14]) {
            //System.out.println("hero level is " + hero.getLevel());
            //this.viewPanels.setPlayGrid(hero.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, hero, villain);
        }
    }
}
// 🤣🤣🤣🤣🤣