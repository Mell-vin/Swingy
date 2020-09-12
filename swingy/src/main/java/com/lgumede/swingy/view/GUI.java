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

public class GUI implements ActionListener {
	static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();
    static JLabel alerts = new JLabel("");
    Panels viewPanels = new Panels();
    LightningRod lr = new LightningRod("Lightning Rod", "LR");

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

    public void registerButtons(JButton[] btnArr, JButton[][] playGrid) {
        
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewPanels.allBtns[0]) {
            GUI.panel = viewPanels.scndView(panel, viewPanels);
        } else if (e.getSource() == viewPanels.allBtns[1]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[2]) {
            
            this.viewPanels.setPlayGrid(lr.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, lr.getHero(), lr.getLevel());
        }  else if (e.getSource() == viewPanels.allBtns[3]) {
            WaterFlush wf = new WaterFlush("Water Flush",  "WF");
            this.viewPanels.setPlayGrid(wf.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, wf.getHero(), wf.getLevel());
        }  else if (e.getSource() == viewPanels.allBtns[4]) {
            RockRoller rr = new RockRoller("Rock Roller", "RR");
            this.viewPanels.setPlayGrid(rr.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, rr.getHero(), rr.getLevel());
        }  else if (e.getSource() == viewPanels.allBtns[5]) {
            MudSlide ms = new MudSlide("Mud slide", "MS");
            this.viewPanels.setPlayGrid(ms.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, ms.getHero(), ms.getLevel());
        }  else if (e.getSource() == viewPanels.allBtns[6]) {
            AllPower ap = new AllPower("All power", "AP");
            this.viewPanels.setPlayGrid(ap.getLevel());
            GUI.panel = viewPanels.gameView(panel, viewPanels, ap.getHero(), ap.getLevel());
        }  else if (e.getSource() == viewPanels.allBtns[7]) {
            this.viewPanels.moveHero(panel, 1, lr.getHero(), lr.getLevel());
            
        }  else if (e.getSource() == viewPanels.allBtns[8]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[9]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[10]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[11]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[12]) {
            System.out.println("Prev");
        }  else if (e.getSource() == viewPanels.allBtns[13]) {
            System.out.println("Prev");
        }
    }
}
// 🤣🤣🤣🤣🤣