package com.lgumede.swingy.model.villains;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class Ivar implements EvilVills {
	private String name = "Ivar";
	private final int attack = 7;
	private final int experienceGain = 1000;

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
