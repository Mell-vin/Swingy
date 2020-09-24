package com.lgumede.swingy.model.villains;

import java.awt.Color;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class FreizaGold implements EvilVills {
	private String name = "Freiza Gold";
	private   int attack = 65;
	private   int experienceGain = 2000;
	
	public String getName() {
		return this.name;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getExperienceGain() {
		return this.experienceGain;
	}
}
