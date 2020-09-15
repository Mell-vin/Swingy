package com.lgumede.swingy.model.villains;

import java.awt.Color;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class FreizaGold implements EvilVills {
	private String name = "Freiza Gold";
	private final int attack = 17;
	private final int experienceGain = 2200;
	
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
