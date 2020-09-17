package com.lgumede.swingy.model.villains;

import com.lgumede.swingy.model.modelInterfaces.EvilVills;

public class Thanos implements EvilVills {
	private String name = "Thanosy";
	private final int attack = 46;
	private final int experienceGain = 1400;

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
