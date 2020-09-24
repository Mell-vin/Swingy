package com.lgumede.swingy.model.villains;

import java.awt.Color;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class Bane implements EvilVills {
	private String name = "Bane";
	private   int attack = 105;
	private   int experienceGain = 3500;

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
