package com.lgumede.swingy.model.heroes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;
import com.lgumede.swingy.model.modelInterfaces.FightReady;
import com.lgumede.swingy.view.Panels;

public class LightningRod extends Heroes implements FightReady{
	private int experience = 0;
	private int attack = 12;
	private int defense = 12;
	private String artifact = "";
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
		this.experience += experience;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack += attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense += defense;
	}

	public void resetAttack(int num) {
		this.attack = num;
	}

	public void resetDefense(int num) {
		this.defense = num;
	}

	public void resetHitPoints(int num) {
		this.hitPoints = num;
	}

	public void setArtifact(String artifactName, int num){
		this.artifact = artifactName;
		if (artifactName.equals("Weapon")){
			this.setAttack(num);
		} else if (artifactName.equals("Armor")){
			this.setDefense(num);
		} else if (artifactName.equals("Helm")){
			this.setHitPoints(num);
		}
	}

	public String getArtifactName() {
		return this.artifact;
	}
	
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints += hitPoints;
	}
	public ImageIcon getHero() {
		return this.hero;
	}

	public void borderReached(int xpGain, JLabel alert, JPanel panel) {
		int tmp = this.getLevel();
		this.setExperience(xpGain);
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
			System.out.println(".+ 500 xp. Level up! " + this.getLevel());
			alert.setText(".+ 500 xp. Level up! " + this.getLevel());
		} else {
			System.out.println(".YOU WIN!!");
			alert.setText(".YOU WIN!!");
		}
		panel.add(alert);
		this.setDefense(7 + tmp);
		panel.revalidate();
		panel.repaint();
		System.out.println("_______________________________________________________\n");
		//this.resetRowCol((int) Math.ceil(dims / 2));
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
			System.out.println(".Level up! " + this.getLevel());
			viewPanel.alert.setText(".Level up! " + this.getLevel());
			panel.add(viewPanel.alert);
			panel.revalidate();
			panel.repaint();
		}
		System.out.println("_______________________________________________________\n");
		//this.resetRowCol((int) Math.ceil(dims / 2));
	}
}
