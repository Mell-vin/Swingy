package com.lgumede.swingy.model.heroes;

public abstract class Heroes {
	private String name = "";
	private int level = 0;
	private String heroClass = "";
	//artifact;
	
	public Heroes (String name, String heroClass) {
		this.name = name;
		this.heroClass = heroClass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getHeroClass() {
		return this.heroClass;
	}

	public void setHeroClass(String heroClass) {
		this.heroClass = heroClass;
	}
}
