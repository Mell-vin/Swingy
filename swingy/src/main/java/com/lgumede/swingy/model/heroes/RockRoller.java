package com.lgumede.swingy.model.heroes;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;
import com.lgumede.swingy.view.Panels;

public class RockRoller extends Heroes implements FightReady{
	public RockRoller(String name, int level, String heroClass) {
		super(name, heroClass);
		// TODO Auto-generated constructor stub
	}
	private int experience = 0;
	private int attack = 12;
	private int defense = 12;
	private int hitPoints = 10;
	private String file = "C:\\Users\\gumed\\Desktop\\CodeWorld_hehehe_\\Swingy\\swingy\\src\\main\\resources\\images\\heroes\\rockman.png";
	private ImageIcon hero = new ImageIcon(file);

	public RockRoller(String name, String heroClass) {
		super(name, heroClass);
	}
	
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience += experience;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense += defense;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public ImageIcon getHero() {
		return this.hero;
	}

	public void upgradeHero(int villainAttack, JPanel panel, Panels viewPanel, EvilVills villain) {
		int tmp = this.getLevel();
		this.setExperience(villain.getExperienceGain());
		this.setDefense(villain.getAttack());
		int tmp2 = this.getExperience();
		if (tmp2 >= 12200){
			this.setLevel(5);
		} else if (tmp2 >= 8050){
			this.setLevel(4);
		} else if (tmp2 >= 4800){
			this.setLevel(3);
		} else if (tmp2 >= 2450){
			this.setLevel(2);
		} else if (tmp2 >= 1000){
			this.setLevel(1);
		}
		this.heroLimit(this.getLevel());
		if (this.getLevel() > tmp) {
			viewPanel.alert.setText("Level up! " + this.getLevel());
			panel.add(viewPanel.alert);
			panel.revalidate();
			panel.repaint();
		}
	}
}
