package com.lgumede.swingy.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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

    
}
// 🤣🤣🤣🤣🤣