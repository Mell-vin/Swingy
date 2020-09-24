package com.lgumede.swingy.model.villains;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class Hvitserk implements EvilVills {
	private String name = "Hvitserk";
	private   int attack = 26;
	private   int experienceGain = 1300;

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
