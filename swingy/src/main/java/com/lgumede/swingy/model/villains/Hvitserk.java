package com.lgumede.swingy.model.villains;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class Hvitserk implements EvilVills {
	private String name = "Hvitserk";
	private final int attack = 26;
	private final int experienceGain = 1300;

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
