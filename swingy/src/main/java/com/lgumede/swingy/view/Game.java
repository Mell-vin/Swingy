package com.lgumede.swingy.view;

import javax.swing.ImageIcon;

import org.hibernate.annotations.Parent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame implements ActionListener {
    // components
    private Image img;
    private Container playArea = new Container();
    private Color clr = Color.BLACK;
    private int W_H = 9;
    private int h = 800 / W_H + 1;
    private int w = 750 / W_H + 1;
    private String file = "C:\\Users\\gumed\\Desktop\\CodeWorld_hehehe_\\Swingy\\swingy\\src\\main\\resources\\images\\heroes\\allPower.png";
    private ImageIcon hero = new ImageIcon(file);
    private JButton[] gameBtns = new JButton[7];
    private String[] btnNames = {"North", "South", "East", "West", "Fight!", "Run!", "Restart"};

    
    /*
    method to move the hero around the bored
    */
    public void moveHero(JPanel panel, int action) {
        for (int i = 0; i < panel.getComponentCount(); i++){
            Component com = panel.getComponent(i);
            System.out.println(com.getName());
        }
    }

    public JPanel gameBtns(JPanel panel){
        int x = 630;
        int y = 20;
        final int width = 90;
        final int height = 30;
        
        for (int i = 0; i < 7; i++){
            this.gameBtns[i] = new JButton(this.btnNames[i]);
            this.gameBtns[i].setBounds(x, y, width, height);
            this.gameBtns[i].addActionListener(this);
            y += height + 5;
        }
        return panel;
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 7; i++) {
            if(e.getSource() == this.gameBtns[2]){
                
                System.out.println("yeses");
                break;
            }
        }
    }
}
