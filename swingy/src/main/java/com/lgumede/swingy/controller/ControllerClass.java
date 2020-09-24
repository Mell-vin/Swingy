package com.lgumede.swingy.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lgumede.swingy.model.artifacts.Artifacts;
import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;
import com.lgumede.swingy.model.villains.Bane;
import com.lgumede.swingy.model.villains.FreizaGold;
import com.lgumede.swingy.model.villains.Hvitserk;
import com.lgumede.swingy.model.villains.Ivar;
import com.lgumede.swingy.model.villains.Thanos;
import com.lgumede.swingy.view.Panels;

public class ControllerClass {

    Artifacts artifact = new Artifacts();
    /*
    Move hero around the board
    */
    public void moveHero(JPanel panel, int num, FightReady hero, JButton[][] grid, JLabel alert, JButton[] allbtns) {
        int x = hero.getRow();
        int y = hero.getCol();
        hero.setPrev(x, y);
        int limit = hero.getLimit();
        String villainName = "";

        //System.out.println("x and y " + x + " " + " " + y);
        
        if (!(grid[x][y].getText().isEmpty())){
            alert.setBounds(630, 245, 150, 400);
            System.out.println("you must fight/run\n");
            alert.setText("you must fight/run");
            panel.add(alert);
        } else {
            if (x == (limit - 1) || y == (limit - 1) || x == 0 || y == 0){
                Panels.borderReached = 1;
                hero.borderReached(500, alert, panel);
                panel.add(allbtns[14]);
                panel.remove(allbtns[7]);
                panel.remove(allbtns[8]);
                panel.remove(allbtns[9]);
                panel.remove(allbtns[10]);
                alert.setBounds(630, 245, 150, 400);
                panel.add(alert);
            } else if (x > 0 && x < limit && y > 0 &&  y < limit) {
                grid[x][y].setIcon(null);
                //System.out.println("x and y " + x + " " + " " + y);
                if (num == 1) {
                    villainName = grid[x - 1][y].getText();
                    grid[x - 1][y].setIcon(hero.getHero());
                    hero.setRow(-1);
                    //System.out.println("Limit, x and y: "  + limit + " " + (x) + " " + y);
                } else if (num == 2) {
                    villainName = grid[x + 1][y].getText();
                    grid[x + 1][y].setIcon(hero.getHero());
                    hero.setRow(1);
                    //System.out.println("Limit, x and y: "  + limit + " " + (x) + " " + y);
                } else if (num == 3) {
                    villainName = grid[x][y + 1].getText();
                    grid[x][y + 1].setIcon(hero.getHero());
                    hero.setCol(1);
                    //System.out.println("Limit, x and y: "  + limit + " " + x + " " + (y));
                } else if (num == 4) {
                    villainName = grid[x][y - 1].getText();
                    grid[x][y - 1].setIcon(hero.getHero());
                    hero.setCol(-1);
                    //System.out.println("Limit, x and y: "  + limit + " " + x + " " + (y));
                }
                if(!(villainName.isEmpty())){
                    alert.setBounds(630, 245, 250, 400);
                    System.out.println("YOU must fight " + villainName + "\n");
                    System.out.println("_______________________________________________________\n");
                    alert.setText("YOU must fight " + villainName);
                    panel.add(alert);
                } else {
                    System.out.println("\nNo villian to fight\n");
                    System.out.println("_______________________________________________________\n");
                    alert.setBounds(630, 245, 250, 400);
                    alert.setText(null);
                    panel.add(alert);
                }
            }
            panel.revalidate();
            panel.repaint();
        }
    }

    /*
    Fight function. puts hero against villain
     */
    public void fight(JPanel panel, Panels viewPanel, FightReady hero, JButton[][] grid) {
        int i = hero.getRow();
        int j = hero.getCol();
        String name;
        EvilVills villain;
        int heroDef = hero.getDefense();
        int heroLvl = hero.getLevel();
        int villainAttack;
        int rand = new Random().nextInt(hero.getLevel() + 3);

        if (grid != null){
            name = grid[i][j].getText();
            if (name.isEmpty()){
                System.out.println("No villain here");
                System.out.println("_______________________________________________________\n");
                viewPanel.alert.setText("No villain here!");
                panel.add(viewPanel.alert);
                panel.revalidate();
                panel.repaint();
                return;
            } else {
                if (name.equals("Bane")){
                    villain = new Bane();
                } else if (name.equals("Freiza Gold")){
                    villain = new FreizaGold();
                } else if (name.equals("Hvitserk")){
                    villain = new Hvitserk();
                } else if (name.equals("Ivar")){
                    villain = new Ivar();
                } else if (name.equals("Thanosy")){
                    villain = new Thanos();
                } else {
                    return;
                }
                // viewPanel.alert.setText(name);
                // panel.add(viewPanel.alert);
                villainAttack = villain.getAttack();
                if (heroDef < villainAttack) {
                    System.out.println("Weak. Game over\n");
                    viewPanel.alert.setText("Weak. Game over");
                    panel.add(viewPanel.allBtns[13]);
                    panel.add(viewPanel.alert);
                } else if (heroDef == villainAttack) {
                    if (rand == heroLvl){
                        artifact.addArtifact(hero, villain);
                        viewPanel.alert.setText("You won a " + hero.getArtifactName() + "\n");
                        panel.add(viewPanel.allBtns[14]);
                        panel.add(viewPanel.alert);
                        panel.remove(viewPanel.allBtns[7]);
                        panel.remove(viewPanel.allBtns[8]);
                        panel.remove(viewPanel.allBtns[9]);
                        panel.remove(viewPanel.allBtns[10]);
                        hero.upgradeHero(villainAttack, panel, viewPanel, villain);
                    } else {
                        System.out.println("Bad luck. Game over\n");
                        viewPanel.alert.setText("Bad luck. Game over");
                        panel.add(viewPanel.allBtns[13]);
                        panel.add(viewPanel.alert);
                    }
                } else if (heroDef > villainAttack) {
                    if (new Random().nextInt(3) == 1){
                        artifact.addArtifact(hero, villain);
                        viewPanel.alert.setText("nice! won a " + hero.getArtifactName() + "\n");
                        panel.remove(viewPanel.allBtns[7]);
                        panel.remove(viewPanel.allBtns[8]);
                        panel.remove(viewPanel.allBtns[9]);
                        panel.remove(viewPanel.allBtns[10]);
                    } else {
                        System.out.println("You Win!\n");
                        viewPanel.alert.setText("You Win!");
                        panel.remove(viewPanel.allBtns[7]);
                        panel.remove(viewPanel.allBtns[8]);
                        panel.remove(viewPanel.allBtns[9]);
                        panel.remove(viewPanel.allBtns[10]);
                    }
                        panel.add(viewPanel.allBtns[14]);
                        panel.add(viewPanel.alert);
                        hero.upgradeHero(villainAttack, panel, viewPanel, villain);
                }
        }
        System.out.println("_______________________________________________________\n");
            panel.revalidate();
            panel.repaint();
        }
    }

    /*
    Run method, if player chooses to run
     */

     public void runAway(JPanel panel, FightReady hero, JButton[][] grid, JLabel alert){
        int x;
        int y;
        String name = null;

        
            x = hero.getRow();
            y = hero.getCol();
            name = grid[x][y].getText();
            if (name.isEmpty()){
                System.out.println("No villain here");
                System.out.println("_______________________________________________________\n");
                alert.setText("No villain here!");
                panel.add(alert);
            } else {
                grid[x][y].setIcon(null);
                x = hero.getPrevRow();
                y = hero.getPrevCol();
                grid[x][y].setIcon(hero.getHero());
                hero.resetRowCol(x, y);
                System.out.println("Chicken!");
                System.out.println("_______________________________________________________\n");
                alert.setText("Chicken!");
                panel.add(alert);
                panel.revalidate();
                panel.repaint();
            }
     }
}
