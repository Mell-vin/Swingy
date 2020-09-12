package com.lgumede.swingy.model.heroes;

import javax.swing.ImageIcon;

public class LightningRod extends Heroes {
	private int experience = 0;
	private int attack = 12;
	private int defense = 12;
	private int hitPoints = 10;
	private String file = "C:\\Users\\gumed\\Desktop\\CodeWorld_hehehe_\\Swingy\\swingy\\src\\main\\resources\\images\\heroes\\lightingRod.jpg";
    private ImageIcon hero = new ImageIcon(file);

	public int getExperience() {
		return experience;
	}
	public LightningRod(String name, String heroClass) {
		super(name, heroClass);
		// TODO Auto-generated constructor stub
	}
	public void setExperience(int experience) {
		this.experience = experience;
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
		this.defense = defense;
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
}
