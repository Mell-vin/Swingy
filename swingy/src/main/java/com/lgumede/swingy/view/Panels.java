package com.lgumede.swingy.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


public class Panels extends JFrame {
    static JPanel panel = new JPanel();
    private Container playArea = new Container();
    private Color clr = Color.BLACK;
    private int btnH = 30;
    private int btnW = 90;
    JLabel alert = new JLabel("");
    public JButton[] allBtns;
    public JButton[][] grid;

    private final String[] btnNames = {"New hero",
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
            "Restart"
    };
    
    public JPanel startView(JPanel panel, Panels viewPanel) {
        if (panel != null && viewPanel != null) {
            panel.setLayout(null);
            panel.add(this.allBtns[0]);
            panel.add(this.allBtns[1]);
            return (panel);
        }
        return null;
    }

    public JPanel scndView(JPanel panel, Panels viewPanel) {
        if (panel != null && viewPanel != null) {
            panel.removeAll();
            panel.add(this.allBtns[2]);
            panel.add(this.allBtns[3]);
            panel.add(this.allBtns[4]);
            panel.add(this.allBtns[5]);
            panel.add(this.allBtns[6]);
            panel.revalidate();
            panel.repaint();
            return (panel);
        }
        return null;
    }

    public JPanel gameView(JPanel panel, Panels viewPanel, ImageIcon img, int W_H) {
        if (panel != null && viewPanel != null) {
            int part1 = (W_H - 1) * 5;
            int part2 = 10 - (W_H % 2);
            int dims = part1 + part2;

            playArea = getContentPane();
            playArea.setLayout(new GridLayout(dims, dims));
            for (int i = 0; i < dims; i++) {
                for (int j = 0; j < dims; j++){
                    playArea.add(grid[i][j]);
                }
            }
            playArea.setBounds(20, 20, 600, 650);
            this.grid[(int) Math.ceil(dims / 2)][(int) Math.ceil(dims / 2)].setIcon(img);
            panel.removeAll();
            panel.add(playArea);
            panel.add(this.allBtns[7]);
            panel.add(this.allBtns[8]);
            panel.add(this.allBtns[9]);
            panel.add(this.allBtns[10]);
            panel.add(this.allBtns[11]);
            panel.add(this.allBtns[12]);
            panel.add(this.allBtns[13]);
            panel.revalidate();
            panel.repaint();
            return (panel);
        }
        return null;
    }

    public void moveHero(JPanel panel, int num, ImageIcon img, int W_H) {
        int part1 = (W_H - 1) * 5;
        int part2 = 10 - (W_H % 2);
        int dims = part1 + part2;
        int x = (int) Math.ceil(dims / 2);
        int y = (int) Math.ceil(dims / 2);
        System.out.println("x and dims and y " + x + " " + dims + " " + y);
        if (num == 1) {
            this.grid[x][y + 1].setIcon(img);
        } else if (num == 2) {
            this.grid[x][y - 1].setIcon(img);
        } else if (num == 3) {
            this.grid[x + 1][y].setIcon(img);
        } else if (num == 4) {
            this.grid[x - 1][y].setIcon(img);
        }
        panel.revalidate();
        panel.repaint();
    }

    public void setBtns () {
        int x = 630;
        int y = 20;
        int strtBtn = 200;
        int chsBtn = 40;
        allBtns = new JButton[14];

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
            //this.allBtns[i].addActionListener(new GUI() {});
        }
    }

    public void setPlayGrid(int W_H) {
        int part1 = (W_H - 1) * 5;
        int part2 = 10 - (W_H % 2);
        int dims = part1 + part2;
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
