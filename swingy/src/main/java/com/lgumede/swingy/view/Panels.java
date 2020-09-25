package com.lgumede.swingy.view;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lgumede.swingy.controller.ControllerClass;
import com.lgumede.swingy.model.DB.DBConnection;
import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;
import com.lgumede.swingy.model.villains.Filler;

import java.awt.*;


public class Panels extends JFrame {
    public JPanel panel = new JPanel();
    private Container playArea;
    public static int borderReached = 0;
    private Color clr = Color.BLACK;
    private int btnH = 30;
    private int btnW = 90;
    public  JLabel alert = new JLabel("");
    public JButton[] allBtns = null;
    public JButton[] prevHeroes = null;
    public  JButton[][] grid = null;
     Filler F = new Filler();
    ControllerClass CC = new ControllerClass();

    private   String[] btnNames = {"New hero",
            "Prev hero",
            "Lighting Rod", 
            "Water Flush",
            "Rock Roller",
            "Mud Slide",
            "All Power",
            "North",
            "South",
            "East",
            "West",
            "Fight!",
            "Run!",
            "Restart",
            "next game",
            "console"
    };
    
    public void startView(JPanel panel) {
        if (panel != null ) {
            panel.setLayout(null);
            panel.add(this.allBtns[0]);
            panel.add(this.allBtns[1]);
            //panel.add(this.allBtns[15]);
            return;
        }
        return;
    }

    public JPanel scndView(JPanel panel, Panels viewPanel) {
        if (panel != null && viewPanel != null) {
            panel.removeAll();
            panel.add(this.allBtns[2]);
            panel.add(this.allBtns[3]);
            panel.add(this.allBtns[4]);
            panel.add(this.allBtns[5]);
            panel.add(this.allBtns[6]);
            panel.add(this.allBtns[15]);
            panel.revalidate();
            panel.repaint();
            return (panel);
        }
        return null;
    }
    /*
        creates the game grid as well as the game button
    */

    public ArrayList<FightReady> previousHero(JPanel panel){
        ArrayList<FightReady> lst = DBConnection.fetchHeroes();
        //System.out.println(lst.size());
        int count = lst.size();
        int strtBtn = 300;
        int chsBtn = 40;
        if (count > 0){
            this.prevHeroes = new JButton[count];
            panel.removeAll();
            for(int i = 0; i < count; i++){
            this.prevHeroes[i] = new JButton();
            this.prevHeroes[i].setBounds(strtBtn, chsBtn, 250, 30);
            chsBtn += 40;
            this.prevHeroes[i].setText(lst.get(i).getID() + " " + lst.get(i).getName());
            panel.add(this.prevHeroes[i]);
        }
        }else {
            this.startView(panel);
            alert.setBounds(630, 245, 150, 400);
            this.alert.setText("No saved heroes");
            panel.add(this.alert);
            panel.revalidate();
            panel.repaint();
            return null;
        }
        panel.revalidate();
        panel.repaint();
        return lst;
    }

    public static void heroStats (FightReady hero, JPanel panel) {
        JLabel stats = new JLabel();
        JLabel headings = new JLabel();

        headings.setBounds(10, 675, 500, 10);
        stats.setBounds(10, 685, 500, 15);
        headings.setText("Name | HeroClass | Attack | Defense | HitPoints | Level");
        System.out.println("Name | HeroClass | Attack | Defense | HitPoints | Level");

        stats.setText(hero.getName()
                + "   |   " + hero.getHeroClass()
                + "   |   " + hero.getAttack()
                + "   |   " + hero.getDefense()
                + "   |   " + hero.getHitPoints()
                + "   |   " + hero.getLevel()
        );

        System.out.println(hero.getName()
                + " | " + hero.getHeroClass()
                + " | " + hero.getAttack()
                + " | " + hero.getDefense()
                + " | " + hero.getHitPoints()
                + " | " + hero.getLevel()
                + "\n");
        panel.add(headings);
        panel.add(stats);
    }

    public void gameView(JPanel panel, Panels viewPanel, FightReady hero, EvilVills villain) {
        if (panel != null && viewPanel != null) {
            int level = hero.getLevel();
            this.setPlayGrid(level);
            int part1 = (level - 1) * 5;
            int part2 = 10 - (level % 2);
            int dims = part1 + part2;
            System.out.println("Grid size is " + dims + " x " + dims + "\n");
            if (level == 5) {
                System.out.println("Max level reached.");
                this.alert.setText("Max level reached.");
            }
            playArea = new Container();
            playArea.setLayout(null);
            playArea.setLayout(new GridLayout(dims, dims));
            for (int i = 0; i < dims; i++) {
                for (int j = 0; j < dims; j++){
                    if (i % 2 == 0) {
                        if (j % 2 == 1) {
                            if ((new Random()).nextInt(2) == 1){
                                villain = F.newVillain(i, level);
                            //this.grid[i][j].setBackground(Color.BLUE);
                            this.grid[i][j].setText(villain.getName());
                            //this.grid[i][j].setForeground(clr);
                            }
                        }
                    } else if ( i % 2 == 1){
                        if (j % 2 == 0) {
                            if ((new Random()).nextInt(2) == 1) {
                                villain = F.newVillain(i, level);
                            //this.grid[i][j].setBackground(Color.BLUE);
                            this.grid[i][j].setText(villain.getName());
                            //this.grid[i][j].setForeground(clr);
                            }
                        }
                    }
                    playArea.add(grid[i][j]);
                }
            }
            playArea.setBounds(20, 20, 600, 650);
            this.grid[(int) Math.ceil(dims / 2)][(int) Math.ceil(dims / 2)].setIcon(hero.getHero());
            panel.removeAll();
            Panels.heroStats(hero, panel);
            panel.add(playArea);
            panel.add(this.alert);
            panel.add(this.allBtns[7]);
            panel.add(this.allBtns[8]);
            panel.add(this.allBtns[9]);
            panel.add(this.allBtns[10]);
            panel.add(this.allBtns[11]);
            panel.add(this.allBtns[12]);
            panel.add(this.allBtns[15]);
            panel.revalidate();
            panel.repaint();
            return;
        }
        return;
    }

    public void moveHero(JPanel panel, int num, FightReady hero, JButton[] btn) {
        this.CC.moveHero(panel, num, hero, this.grid, this.alert, this.allBtns);
    }

    public void setBtns () {
        int x = 630;
        int y = 20;
        int strtBtn = 200;
        int chsBtn = 40;
        allBtns = new JButton[16];

        for (int i = 0; i < this.allBtns.length; i++){
            this.allBtns[i] = new JButton(this.btnNames[i]);
            if (i >= 0 && i < 2) {
                this.allBtns[i].setBounds(strtBtn, 300, 150, 30);
                strtBtn += 200;
            } else if (i >= 2 && i < 7) {
                strtBtn = 325;
                this.allBtns[i].setBounds(strtBtn, chsBtn, 150, 30);
                chsBtn += 40;
            } else {
                this.allBtns[i].setBounds(x, y, btnW, btnH);
                y += btnH + 5;
            }
        }
        this.allBtns[15].setBounds(x, 650, btnW, btnH);
    }

    public void setPlayGrid(int W_H) {
        int part1 = (W_H - 1) * 5;
        int part2 = 10 - (W_H % 2);
        int dims = part1 + part2;
        this.grid = null;
        this.grid = new JButton[dims][dims];
        for (int i = 0; i < dims; i++) {
            for (int j = 0; j < dims; j++){
                //System.out.println("i and dims and j: " + i + " "  + dims  + " " + j);
                this.grid[i][j] = new JButton();
                this.grid[i][j].setBackground(clr);
            }
        }
    }
}
