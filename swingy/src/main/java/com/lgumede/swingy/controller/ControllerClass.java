package com.lgumede.swingy.controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;
import com.lgumede.swingy.model.villains.Bane;
import com.lgumede.swingy.model.villains.FreizaGold;
import com.lgumede.swingy.model.villains.Hvitserk;
import com.lgumede.swingy.model.villains.Ivar;
import com.lgumede.swingy.model.villains.Thanos;
import com.lgumede.swingy.view.Panels;

public class ControllerClass {

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
            alert.setText("you must fight/run");
            panel.add(alert);
        } else {
            if (x == (limit - 1) || y == (limit - 1) || x == 0 || y == 0){
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
                    alert.setText("YOU must fight " + villainName);
                    panel.add(alert);
                } else {
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
                viewPanel.alert.setText("No villain here!");
                panel.add(viewPanel.alert);
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
                    viewPanel.alert.setText("Weak. Game over");
                    panel.add(viewPanel.allBtns[13]);
                    panel.add(viewPanel.alert);
                } else if (heroDef == villainAttack) {
                    if (rand == heroLvl){
                        viewPanel.alert.setText("You Win!");
                        panel.add(viewPanel.allBtns[14]);
                        panel.add(viewPanel.alert);
                        hero.upgradeHero(villainAttack, panel, viewPanel, villain);
                    } else {
                        viewPanel.alert.setText("Bad luck. Game over");
                        panel.add(viewPanel.allBtns[13]);
                        panel.add(viewPanel.alert);
                    }
                } else if (heroDef > villainAttack) {
                    viewPanel.alert.setText("You Win!");
                        panel.add(viewPanel.allBtns[14]);
                        panel.add(viewPanel.alert);
                        hero.upgradeHero(villainAttack, panel, viewPanel, villain);
                }
        }
            panel.remove(viewPanel.allBtns[7]);
            panel.remove(viewPanel.allBtns[8]);
            panel.remove(viewPanel.allBtns[9]);
            panel.remove(viewPanel.allBtns[10]);
            panel.revalidate();
            panel.repaint();
        }
        return;
    }

    /*
    Run method, if player chooses to run
     */

     public void runAway(JPanel panel, FightReady hero, JButton[][] grid, JLabel alert){
        int x;
        int y;

        //if ((new Random()).nextInt(4) == 1){
            x = hero.getRow();
            y = hero.getCol();
            grid[x][y].setIcon(null);
            x = hero.getPrevRow();
            y = hero.getPrevCol();
            grid[x][y].setIcon(hero.getHero());
            hero.resetRowCol(x, y);
            alert.setText("Chicken!");
            panel.add(alert);
            panel.revalidate();
            panel.repaint();
       // }
     }
}
